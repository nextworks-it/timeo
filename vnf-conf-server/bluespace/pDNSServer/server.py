import json
import tornado.web
import logging
import requests
import re

# This agent interfaces TIMEO with the bind-rest API server.
# @Author: j.brenes
# uservnf.add_dns_hosts / uservnf.rm_dns_hosts are required to identify the desired actions

# usage: curl -X PATCH \
#   http://10.0.8.42:8888/vnfconfig/v1/configuration \
#   -H 'Content-Type: application/json' \
#   -H 'Postman-Token: 359cf56a-c732-4030-8757-7b6fdcac4777' \
#   -H 'cache-control: no-cache' \
#   -d '{
# 	"vnfConfigurationData": {
# 		"cpConfiguration": [],
# 		"dhcpServer": "null",
# 		"vnfSpecificData": [
# 			{
# 				"key": "uservnf.origin_fqdn",
# 				"value": "bluespace.lab"
# 			},{
# 				"key": "vnf.vCacheEdge_1_01.vdu.vCacheEdge_1_vdu.hostname",
# 				"value": "vCacheEdge_1492"
# 			},{
# 				"key": "vnf.vCacheEdge_1_01.vdu.vCacheEdge_1_vdu.extcp.vCacheEdge_1_users_ext.floating",
# 				"value": "10.0.6.21"
# 			},{
# 				"key": "uservnf.add_dns_hosts",
# 				"value": "true"
# 			},{
# 				"key": "uservnf.rm_dns_hosts",
# 				"value": "true"
# 			}
#
#
# 		]
# 	},
# 	"vnfcConfigurationData": [],
# 	"vnfInstanceId": "553"
# }'
#
#


class AvailableAPI(tornado.web.RequestHandler):

    def get(self):
        self.write('GET /  \n\tTo get this menu'
                   '\n\nPATCH vnfconfig/v1/configuration\n\tTo modify the configuration')


class ModifyConfiguration(tornado.web.RequestHandler):

    def patch(self):
        try:
            body = self.request.body.decode('utf-8')
            data = json.loads(body)
            result = extract_parameters(data)
            logging.debug(result)
            response = {
                "vnfConfigurationData": {
                    "cpConfiguration": [],
                    "dhcpServer": "null",
                    "vnfSpecificData": data['vnfConfigurationData']['vnfSpecificData']
                },
                "vnfcConfigurationData": []
            }
            self.set_header("Access-Control-Allow-Origin", "*")
            self.set_header('Content-Type', 'application/json')
            if "uservnf.rm_dns_hosts" in result:
                rm_hosts()
            if "uservnf.add_dns_hosts" in result:
                add_hosts(result)

            if not ("uservnf.rm_dns_hosts" in result or "uservnf.add_dns_hosts" in result):
                raise Exception("Unidentified method request")

            self.set_status(200)
            self.write(response)
        except Exception as e:
            logging.error( "ERROR"+str(e))
            self.set_status(400)
            self.set_header('Content-Type', 'application/json')
            self.write(str(e))
            return


def extract_parameters(payload):

    try:
        data = payload.get('vnfConfigurationData').get('vnfSpecificData')
        data_dict = {x['key']: x['value'] for x in data}
        return data_dict
    except KeyError as e:
        logging.warning('Error: {}', e)
        logging.debug('Details:', exc_info=e)
        raise ValueError('Property not found: {}'.format(e))
    except Exception as e:
        logging.warning('Error: {}', e)
        logging.debug('Details:', exc_info=e)
        raise ValueError(str(e))


def rm_hosts(rest_url=None):
    global added_hosts
    logging.debug("rm hosts")
    headers = {"Content-Type": "application/json", "X-Api-Key": "secret"}
    url = "http://localhost:9999/dns" if rest_url is None else rest_url
    hosts_not_removed = []
    for host in added_hosts:
        logging.debug( "rm host %s"%host)
        delete_data = {"hostname": host}
        response=requests.delete(url, headers=headers, data=json.dumps(delete_data))
        if response.status_code!=200:
            hosts_not_removed.append(host)
            raise Exception(response.json)

    added_hosts=hosts_not_removed


def add_hosts(data, rest_url=None):

    logging.debug("add_hosts")
    vnfdid_hostname= {}
    vnfdid_floating ={}
    headers = {"Content-Type": "application/json", "X-Api-Key": "secret"}
    url = "http://localhost:9999/dns" if rest_url is None else rest_url
    for key, value in data.iteritems():
        # keys should be vnf.<vnfdId>.vdu.<vdu>.extcp.<cpId>.floating and vnf.<vnfdId>.vdu.<vdu>.hostname",
        key_split = key.split(".")

        if key_split[0] == "vnf" and key_split[-1] == "hostname":
            vnfdid_hostname[key_split[1]]= re.sub(r'[^a-zA-Z0-9]','', value)
        elif key_split[0] == "vnf" and key_split[-1] == "floating":
            vnfdid_floating[key_split[1]]=value

    for vnfdid, hostname in vnfdid_hostname.iteritems():
        full_hostname= hostname+"."+data["uservnf.origin_fqdn"]
        request_data = {"hostname": full_hostname, "ip":vnfdid_floating[vnfdid]}
        response=requests.post(url, headers=headers, data=json.dumps(request_data))
        logging.debug("hostname:%s ip:%s"%(full_hostname, vnfdid_floating[vnfdid]))
        logging.debug(response.json())
        if response.status_code == 200:
            added_hosts.append(full_hostname)
        else:
            raise Exception(response.json)


# Store the hosts to be flushed when instantiating a new service.
added_hosts = []

application = tornado.web.Application([
    (r"/", AvailableAPI),
    (r"/vnfconfig/v1/configuration", ModifyConfiguration),
])

if __name__ == "__main__":

    logging.basicConfig(filename='/var/log/VnfServer/server.log',level=logging.DEBUG)
    application.listen('8888')
    logging.debug("Staring server at port 8888")
    tornado.ioloop.IOLoop.instance().start()
    logging.debug("Server started")
