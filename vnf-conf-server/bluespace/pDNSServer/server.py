# import uuid
# import re
import json
import subprocess
# from wsgiref import headers
# from tornado.httpclient import AsyncHTTPClient
# from tornado.httpclient import HTTPRequest
# from tornado.stack_context import ExceptionStackContext
import tornado.web
import logging
import requests
import sys
import re




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
            print result
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
            execute_configuration_script(result)
            self.set_status(200)
            self.write(response)
        except Exception as e:
            print "ERROR"+str(e)
            self.set_status(400)
            self.set_header('Content-Type', 'application/json')
            self.write(str(e))
            return




application = tornado.web.Application([
    (r"/", AvailableAPI),
    (r"/vnfconfig/v1/configuration", ModifyConfiguration),
])



def extract_parameters(payload):
    output = []
    try:
        data = payload.get('vnfConfigurationData').get('vnfSpecificData')
        data_dict = {x['key']: x['value'] for x in data}
        return data_dict
    except KeyError as e:
        logger.warning('Error: {}', e)
        logger.debug('Details:', exc_info=e)
        raise ValueError('Property not found: {}'.format(e))
    except Exception as e:
        logger.warning('Error: {}', e)
        logger.debug('Details:', exc_info=e)
        raise ValueError(str(e))
    return output


def execute_configuration_script(data, rest_url=None):
    print "execute_configuration"
    vnfdid_hostname= {}
    vnfdid_floating ={}
    headers = {"Content-Type": "application/json", "X-Api-Key": "secret"}
    url = "http://localhost:9999/dns" if rest_url is None else rest_url
    for key, value in data.iteritems():
        #keys should be vnf.<vnfdId>.vdu.<vdu>.extcp.<cpId>.floating and vnf.<vnfdId>.vdu.<vdu>.hostname",
        key_split = key.split(".")

        if key_split[0]=="vnf" and key_split[-1]=="hostname":
            vnfdid_hostname[key_split[1]]= re.sub(r'[^a-zA-Z0-9]','', value)
        elif key_split[0]=="vnf" and key_split[-1]=="floating":
            vnfdid_floating[key_split[1]]=value

    for vnfdid, hostname in vnfdid_hostname.iteritems():
        full_hostname= hostname+"."+data["uservnf.origin_fqdn"]
        request_data = {"hostname": full_hostname, "ip":vnfdid_floating[vnfdid]}
        response=requests.post(url, headers=headers, data=json.dumps(request_data))
        print "hostname:%s ip:%s"%(full_hostname, vnfdid_floating[vnfdid])
        print response.json()
        if response.status_code != 200:
            raise Exception(response.json)



def test():
    data = {"vnf.vCacheEdge_1_01.vdu.vCacheEdge_1_vdu.extcp.vCacheEdge_1_users_ext.floating": "10.0.5.15", "vnf.vCacheEdge_1_01.vdu.vCacheEdge_1_vdu.hostname":"vcacheedge_451",
            "uservnf.origin_fqdn":"bluespace.lab"}
    execute_configuration_script(data, rest_url="http://10.0.6.22:9999/dns")


if __name__ == "__main__":
    try:
        if len(sys.argv) > 1 and sys.argv[1] == "-d":
            test()
        else:
            application.listen('8888')
            print "Staring server at port 8888"
            tornado.ioloop.IOLoop.instance().start()
            print "Server started"
	#execute_configuration_script({"juan":"test1", "test": "test2"})
    except KeyboardInterrupt:
        tornado.ioloop.IOLoop.instance().stop()
