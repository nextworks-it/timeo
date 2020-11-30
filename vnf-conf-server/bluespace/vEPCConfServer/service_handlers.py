from log import get_logger
import netifaces
from subprocess import Popen, PIPE, STDOUT
import os

class EpcHandler:

    __instance = None

    def __init__(self):
        if EpcHandler.__instance is None:
            self.logger = get_logger(__name__)
            self.vxlan_remote = ""
            EpcHandler.__instance = self
        else:
            raise Exception("This class is a singleton!")

    @staticmethod
    def get_instance():
        """ Static access method. """
        if EpcHandler.__instance is None:
            EpcHandler()
        return EpcHandler.__instance

    def get_interface_from_ip(self, ip):
        for iface in netifaces.interfaces():
            iface_ip = netifaces.ifaddresses(iface)[netifaces.AF_INET][0]["addr"]
            if iface_ip == ip:
                return iface

    def get_interface_ip(self, iface):
        return netifaces.ifaddresses(iface)[netifaces.AF_INET][0]["addr"]

    def __start_stop_vxlan(self, vxlan_address):
        self.logger.debug("service restart")

        p = Popen("/opt/vEPCConfServer/start_stop_vxlan.sh %s"%vxlan_address, stdout=PIPE, stdin=PIPE, stderr=STDOUT, shell=True)
        stdout = p.communicate()[0]
        if p.returncode != 0:
            raise Exception(stdout.decode())

    def process(self, parameters):
        self.logger.debug("process")
        #Values to be replaced in the mme template configuration

        mme_config={}
        spgw_config={}
        cu_interface = None
        dns_server= None
        pgw_interface =None
        for key, value in parameters.iteritems():
            key_split = key.split(".")
            if key_split[-1]=="cu_interface" and value !="":
                cu_interface=value
                self.logger.debug("received cu_interface:%s"%value)

            if key_split[-1]=="internet_interface" and value !="":
                self.logger.debug("received interface_interface:%s"%value)
                pgw_interface=value

            if key_split[-1]=="hostname":
                os.system('hostname %s' % value)

            if key_split[-1]=="floating":
               self.__start_stop_vxlan(value)


        if cu_interface is None:
            self.logger.debug("using default CU interface: vxlan1")
            cu_interface="vxlan1"

        if pgw_interface is None:
            pgw_interface="ens3"
            self.logger.debug("using default PGW interface: %s"%pgw_interface)

        if "pnf.pDNS_v01.cp.dns_users.address" in parameters:
            dns_server=parameters["pnf.pDNS_v01.cp.dns_users.address"]
            self.logger.debug("received dns_server: %s"%dns_server)
        else:
            dns_server="8.8.8.8"
            self.logger.debug("using default dns_server: %s"%dns_server)

        spgw_config["PGW_INTERFACE_NAME_FOR_SGI"]=pgw_interface
        cu_ip = self.get_interface_ip(cu_interface)
        mme_config["MME_INTERFACE_NAME_FOR_S1_MME"]=cu_interface
        mme_config["MME_INTERFACE_NAME_FOR_S11_MME"]=cu_interface
        spgw_config["SGW_INTERFACE_NAME_FOR_S1U_S12_S4_UP"]=cu_interface
        mme_config["MME_IPV4_ADDRESS_FOR_S1_MME"]=cu_ip
        mme_config["MME_IPV4_ADDRESS_FOR_S11_MME"]=cu_ip
        spgw_config["SGW_IPV4_ADDRESS_FOR_S1U_S12_S4_UP"]=cu_ip
        spgw_config["DEFAULT_DNS_IPV4_ADDRESS"]=dns_server

        with open("/opt/vEPCConfServer/mme.conf_template") as f:
            mme_setup = f.read()
            for key, value in mme_config.iteritems():
                mme_setup=mme_setup.replace('#{%s}'%key, value)

        with open("/usr/local/etc/oai/mme.conf", "w") as f:
            f.write(mme_setup)


        with open("/opt/vEPCConfServer/spgw.conf_template") as f:
            spgw_setup = f.read()
            for key, value in spgw_config.iteritems():
                spgw_setup=spgw_setup.replace('#{%s}'%key, value)

        with open("/usr/local/etc/oai/spgw.conf", "w") as f:
            f.write(spgw_setup)

        self.__restart_service()


    def __restart_service(self):

        p = Popen("service hss restart", stdout=PIPE, stdin=PIPE, stderr=STDOUT, shell=True)
        stdout = p.communicate()[0]
        if p.returncode != 0:
            raise Exception(stdout.decode())

        p = Popen("service mme restart", stdout=PIPE, stdin=PIPE, stderr=STDOUT, shell=True)
        stdout = p.communicate()[0]
        if p.returncode != 0:
            raise Exception(stdout.decode())

        p = Popen("service spgw restart", stdout=PIPE, stdin=PIPE, stderr=STDOUT, shell=True)
        stdout = p.communicate()[0]
        if p.returncode != 0:
            raise Exception(stdout.decode())




