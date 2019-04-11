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
	except Exception as e:
            print "ERROR"+str(e)
	    self.set_status(400)
            self.set_header('Content-Type', 'application/json')
            self.write(str(e))
            return

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
        try:
            execute_configuration_script(result)
            self.set_status(200)
            self.write(response)
        except CalledProcessError as e:
            message = "Error while configuring: {}".format(str(e))
            logger.error(message)
            self.set_status(500)
            self.write(message)
            self.set_header("Access-Control-Allow-Origin", "*")
            self.set_header('Content-Type', 'application/json')


application = tornado.web.Application([
    (r"/", AvailableAPI),
    (r"/vnfconfig/v1/configuration", ModifyConfiguration),
])



def extract_parameters(payload):
    output = []
    try:
        data = payload.get('vnfConfigurationData').get('vnfSpecificData')
        data_dict = {x['key'].replace(".","_"): x['value'] for x in data}
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


def execute_configuration_script(data):
    print "execute_configuration"
    return subprocess.check_call(["/opt/vCacheConfServer/configureCache.sh"], env=data)



if __name__ == "__main__":
    try:
        application.listen('8888')
        print "Staring server at port 8888"
        tornado.ioloop.IOLoop.instance().start()
        print "Server started"
	#execute_configuration_script({"juan":"test1", "test": "test2"})
    except KeyboardInterrupt:
        tornado.ioloop.IOLoop.instance().stop()
