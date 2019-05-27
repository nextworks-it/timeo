from log import get_logger
import netifaces
from subprocess import Popen, PIPE, STDOUT
import os

class CUHandler:

    __instance = None

    def __init__(self):
        if CUHandler.__instance is None:
            self.logger = get_logger(__name__)
            CUHandler.__instance = self
            self.epc_address=""
        else:
            raise Exception("This class is a singleton!")

    @staticmethod
    def get_instance():
        """ Static access method. """
        if CUHandler.__instance is None:
            CUHandler()
        return CUHandler.__instance


    def process(self, parameters):

        self.logger.debug("process")
        self.epc_address = parameters["vnf.vEPC_01.vdu.vEPC_vdu.extcp.vEPC_users_ext.floating"]

        self.__restart_service()



    def __restart_service(self):
        self.logger.debug("service restart")
        p = Popen("/opt/pCUConfServer/start_stop_cu.sh %s" % self.epc_address, stdout=PIPE, stdin=PIPE, stderr=STDOUT, shell=True)
        stdout = p.communicate()[0]
        if p.returncode != 0:
            raise Exception(stdout.decode())






