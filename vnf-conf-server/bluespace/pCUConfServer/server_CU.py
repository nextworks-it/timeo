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
import settings

logging.basicConfig(filename=settings.PATH + settings.LOG_FILENAME, level=logging.DEBUG)

class AvailableAPI(tornado.web.RequestHandler):
    def get(self):
        self.write('GET /  \n\tTo get this menu\n\nPATCH pnfCUactivation/v1/configuration\n\tTo modify configuration\n')


class ModifyConfiguration(tornado.web.RequestHandler):
    def patch(self):
        data = json.loads(self.request.body.decode('utf-8'))
        result = checkParameters(data)
        if result == 1:
            self.set_status(200)
            self.set_header("Access-Control-Allow-Origin", "*")
            self.set_header('Content-Type', 'application/json')
            executeConfigurationScript(data.get('pnfActivationData').get('pnfSpecificData'))
            response={
                "pnfActivationData": {
                    "cpConfiguration": [],
                    "dhcpServer": "null",
                    "pnfSpecificData": data.get('pnfActivationData').get('pnfSpecificData')
                },
                "pnfaActivationData": []
            }
            print (response)
            self.write(response)
        else:
            self.set_status(400)
            self.set_header("Access-Control-Allow-Origin", "*")
            self.set_header('Content-Type', 'application/json')


application = tornado.web.Application([
    (r"/", AvailableAPI),
    (r"/pnfCUactivation/v1/configuration", ModifyConfiguration)
])


def executeConfigurationScript(data):
    for element in data:
        if element['key'] == "pnf.remote.cu":
            remote_cu=element['value']
    p = subprocess.Popen(["/bin/bash", settings.PATH+settings.StartStopCU['config_file'], remote_cu])

def checkParameters(json):
    paramList = settings.StartStopCU['params']

    data = json.get('pnfActivationData').get('pnfSpecificData')


    if len(data) != len(paramList):
        return 0
    else:
        for element in data:
            if element['key'] not in paramList:
                return 0
        return 1


if __name__ == "__main__":
    try:
        application.listen('8888')
        print ("Starting Central Unit server at port 8888")
        tornado.ioloop.IOLoop.instance().start()
    except KeyboardInterrupt:
        tornado.ioloop.IOLoop.instance().stop()
