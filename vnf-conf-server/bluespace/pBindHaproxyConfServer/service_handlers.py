from log import get_logger
import shlex
from subprocess import Popen, PIPE, STDOUT
from shutil import copyfile

class BindHandler:

    __instance = None

    nsupdate_create_template = '''\nserver {0}\nupdate add {1} {2} A {3}\nsend\n'''
    nsupdate_create_ptr = '''\nupdate add {0} {1} PTR {2}\nsend\n'''
    nsupdate_delete_template = '''\nserver {0}\nupdate delete {1} A\nsend\n'''


    def __init__(self):
        if BindHandler.__instance is None:
            self.logger = get_logger(__name__)
            self.nameserver = "127.0.0.1"
            self.sig_key="/etc/bind/rndc.key"
            self.nsupdate_command = "nsupdate"
            self.last_update = "/tmp/last_update"
            self.default_ttl = 8640
            self.zone_hosts = {}
            BindHandler.__instance = self
        else:
            raise Exception("This class is a singleton!")

    @staticmethod
    def get_instance():
        """ Static access method. """
        if BindHandler.__instance is None:
            BindHandler()
        return BindHandler.__instance

    def __nsupdate(self, update_msg):
        cmd = ["%s -k %s" % (self.nsupdate_command,self.sig_key )]
        self.logger.debug("update_cmd: %s"%cmd)
        last_update = open(self.last_update, "w")
        last_update.write(update_msg)
        self.logger.debug("update_msg: %s"%update_msg)
        last_update.close()
        last_update = open(self.last_update)
        p = Popen(cmd, stdout=PIPE, stdin=last_update, stderr=STDOUT, shell=True)
        stdout = p.communicate(input=update_msg)[0]
        return p.returncode, stdout.decode()

    def remove_host(self, host, zone):
        self.logger.debug("remove_host")
        host_fqdn = "%s.%s"%(host,zone)
        update_msg = BindHandler.nsupdate_delete_template.format(self.nameserver,host_fqdn)
        r_code, msg = self.__nsupdate(update_msg)
        if r_code == 0:

            if zone in self.zone_hosts and host in self.zone_hosts[zone]:
                self.zone_hosts[zone].remove(host)
            else:
                self.logger.warning("host not registered")
        else:

            self.logger.error(msg)
            raise Exception(msg)

    def add_host(self, host, zone, address):
        self.logger.debug("add_host")
        host_fqdn = "%s.%s"%(host,zone)
        update_msg = BindHandler.nsupdate_create_template.format(self.nameserver,host_fqdn,self.default_ttl,address)
        r_code, msg = self.__nsupdate(update_msg)
        if r_code == 0:
            total_zone = []
            if zone in self.zone_hosts:
                total_zone = self.zone_hosts[zone]
            total_zone.append(host)
            self.zone_hosts[zone] = total_zone
        else:

            self.logger.error(msg)
            raise Exception(msg)

    def add_zone(self, zone):
        self.zone_hosts[zone]=[]

    def flush_zone(self, zone):
        self.logger.debug("flush_zone")
        for host in self.zone_hosts[zone]:
            self.remove_host(host,zone)

    def process(self, parameters):
        self.logger.debug("process")
        if "uservnf.origin_fqdn" in parameters:
            zone=parameters["uservnf.origin_fqdn"]
        else:
            raise Exception("missing uservnf.origin_fqdn")

        if zone in self.zone_hosts:
            self.flush_zone(zone)

        self.add_zone(zone)
        to_add_hosts={}
        to_add_adds = {}
        for key, value in parameters.iteritems():
            key_split = key.split(".")
            if key_split[-1]=="hostname":
                vdu = key_split[1]
                to_add_hosts[vdu]=value
            elif key_split[-1]=="floating":
                vdu = key_split[1]
                to_add_adds[vdu]=value

        for vdu, hostname in to_add_hosts.iteritems():
            if vdu in to_add_adds:
                addr = to_add_adds[vdu]
                self.add_host(hostname, zone, addr)
            else:
                raise Exception("Missing host address")



class HAProxyHandler:
    __instance = None

    def __init__(self):
        if HAProxyHandler.__instance is None:
            self.zone_hosts = {}
            self.logger = get_logger(__name__)
            self.config_file = "/etc/haproxy/haproxy.cfg"
            self.base_config_file = "/opt/pBindHaproxyConfServer/haproxy.cfg_template"
            self.host_ports = {}
            self.max_port = 8836
            HAProxyHandler.__instance = self
        else:
            raise Exception("This class is a singleton!")

    @staticmethod
    def get_instance():
        """ Static access method. """
        if HAProxyHandler.__instance is None:
            HAProxyHandler()
        return HAProxyHandler.__instance

    def get_zone_name(self,zone):
        return zone.replace(".", "_")

    def get_frontend_conf(self):
        front_end_conf = "frontend uhd_vcdn_service\n"
        front_end_conf += "\t\tbind 0.0.0.0:80\n"
        front_end_conf += "\t\toption forwardfor\n"

        for zone in self.zone_hosts.keys():

            front_end_conf += "\t\tacl acl_%s hdr(host) -i cdn-uhd.%s\n"%(self.get_zone_name(zone), zone)

        for zone in self.zone_hosts.keys():
            front_end_conf += "\t\tuse_backend %s_internal_redirect if acl_%s\n"%(self.get_zone_name(zone),self.get_zone_name(zone))

        #front_end_conf += "\t\tdefault_backend %s_internal_redirect\n" % self.get_zone_name(zone)
        return front_end_conf

    def get_host_frontend(self,host):
        frontend_conf = "frontend host_%s\n"%host.replace(".","_")
        frontend_conf += "\t\tbind 0.0.0.0:%i\n"%self.host_ports[host]
        frontend_conf += "\t\toption forwardfor\n"
        frontend_conf += "\t\thttp-request redirect location http://%s:8080/web\n" % host
        return frontend_conf

    def get_zone_backend(self, zone):

        back_end_conf = "backend %s_internal_redirect\n"%self.get_zone_name(zone)
        for host in self.zone_hosts[zone]:
            back_end_conf += "\t\tserver %s 0.0.0.0:%i check\n" % (host, self.host_ports[host])
        back_end_conf += "\t\tbalance roundrobin\n"
        back_end_conf += "\t\toption forwardfor\n"
        return back_end_conf

    def remove_host(self, host):
        if host in self.host_ports:
            del self.host_ports[host]

    def remove_zone(self, zone):
        if zone in self.zone_hosts:
            for host in self.zone_hosts:
                self.remove_host(host)
            del self.zone_hosts[zone]

    def add_host(self, host, zone, port):
        self.logger.debug("add_host_to_backend")
        total_hosts = []
        if zone in self.zone_hosts:
            total_hosts = self.zone_hosts[zone]

        total_hosts.append(host)
        self.zone_hosts[zone]=total_hosts
        self.host_ports[host]=port

    def add_zone(self, zone):
        self.logger.debug("add_host_to_backend")
        if zone not in self.zone_hosts:
            self.zone_hosts[zone]=[]

    def __create_config(self):
        self.logger.debug("create_config")
        copyfile(self.base_config_file, self.config_file)
        config_file = open(self.config_file, "a+")
        config_file.write("\n")
        config_file.write(self.get_frontend_conf())
        config_file.write("\n")
        for zone in self.zone_hosts.keys():

            for host in self.zone_hosts[zone]:
                config_file.write(self.get_host_frontend(host))
                config_file.write("\n")

            config_file.write(self.get_zone_backend(zone))
            config_file.write("\n")
        config_file.close()

    def __restart_service(self):
        self.logger.debug("service restart")
        p = Popen("service haproxy restart", stdout=PIPE, stdin=PIPE, stderr=STDOUT, shell=True)
        stdout = p.communicate()[0]
        if p.returncode != 0:
            raise Exception(stdout.decode())

    def process(self, parameters):
        self.logger.debug("process")

        if "uservnf.origin_fqdn" in parameters:
            zone=parameters["uservnf.origin_fqdn"]
        else:
            raise Exception("missing uservnf.origin_fqdn")
        if zone in self.zone_hosts:
            self.remove_zone(zone)
        self.add_zone(zone)
        for key, value in parameters.iteritems():
            key_split = key.split(".")
            if key_split[-1]=="hostname":
                self.add_host("%s.%s"%(value, zone), zone, self.max_port)
                self.max_port+=1

        self.__create_config()
        self.__restart_service()





