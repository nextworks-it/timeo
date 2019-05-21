from log import get_logger
import netifaces
from subprocess import Popen, PIPE, STDOUT
import os

class EpcHandler:

    __instance = None

    def __init__(self):
        if EpcHandler.__instance is None:
            self.logger = get_logger(__name__)
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

    def process(self, parameters):
        self.logger.debug("process")
        #Values to be replaced in the mme template configuration

        mme_config={}
        spgw_config={}

        for key, value in parameters.iteritems():
            key_split = key.split(".")
            if key_split[-1]=="cu_interface" and value !="":
                self.logger.debug("received cu_interface:%s"%value)
                mme_config["MME_INTERFACE_NAME_FOR_S1_MME"]=value
                mme_config["MME_INTERFACE_NAME_FOR_S11_MME"]=value
                spgw_config["SGW_INTERFACE_NAME_FOR_S1U_S12_S4_UP"]=value
                ip = self.get_interface_ip(value)
                mme_config["MME_IPV4_ADDRESS_FOR_S1_MME"]=ip
                mme_config["MME_IPV4_ADDRESS_FOR_S11_MME"]=ip
                spgw_config["SGW_IPV4_ADDRESS_FOR_S1U_S12_S4_UP"]=ip

            if key_split[-1]=="internet_interface" and value !="":
                self.logger.debug("received interface_interface:%s"%value)
                spgw_config["PGW_INTERFACE_NAME_FOR_SGI"]=value

            if key_split[-1]=="hostname":
                os.system('hostname %s' % value)

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
        self.logger.debug("service restart")
        p = Popen("service mme restart", stdout=PIPE, stdin=PIPE, stderr=STDOUT, shell=True)
        stdout = p.communicate()[0]
        if p.returncode != 0:
            raise Exception(stdout.decode())

        p = Popen("service spgw restart", stdout=PIPE, stdin=PIPE, stderr=STDOUT, shell=True)
        stdout = p.communicate()[0]
        if p.returncode != 0:
            raise Exception(stdout.decode())




