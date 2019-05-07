#
# Copyright 2019 Nextworks s.r.l.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#


import json
import subprocess
from json import load
from os.path import dirname, join
from subprocess import CalledProcessError

import tornado.web

from tornado.ioloop import IOLoop

from help_handler import HelpHandler
from log import get_logger
from service_handlers import HAProxyHandler
from service_handlers import BindHandler

logger = get_logger(__name__)


class ModifyConfiguration(tornado.web.RequestHandler):
    def patch(self):
        try:
            body = self.request.body.decode('utf-8')
            data = json.loads(body)
            result = extract_parameters(data)
        except Exception as e:
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


def load_settings(filename=None):
    if filename is None:
        filename = 'settings.json'
    if not filename.startswith('/'):
        base_path = dirname(__file__)
        filename = join(base_path, filename)
    with open(filename, 'r') as f:
        output = load(f)
    for item, tp in [('port', int), ('script', unicode), ('params', list)]:
        if item not in output:
            raise ValueError("Invalid configuration: parameter {} missing".format(item))
        if not isinstance(output[item], tp):
            raise ValueError("Invalid configuration: parameter {} not of type {}".format(item, tp))
    return output


application = tornado.web.Application([
    (r"/", HelpHandler),
    (r"/vnfconfig/v1/configuration", ModifyConfiguration)
], debug=True)


def execute_configuration_script(arg_map):
    bind_handler = BindHandler.get_instance()
    bind_handler.process(arg_map)
    hap_handler = HAProxyHandler.get_instance()
    hap_handler.process(arg_map)


    # return subprocess.check_call(
    #     [
    #         settings['script']
    #     ] + arg_list
    # )


def extract_parameters(payload):
    param_list = settings['params']
    #output = []
    try:
        data = payload.get('vnfConfigurationData').get('vnfSpecificData')
        data_dict = {x['key']: x['value'] for x in data}
        return data_dict
        #for param in param_list:
        #    output.append(data_dict[param])
    except KeyError as e:
        logger.warning('Error: {}', e)
        logger.debug('Details:', exc_info=e)
        raise ValueError('Property not found: {}'.format(e))
    except Exception as e:
        logger.warning('Error: {}', e)
        logger.debug('Details:', exc_info=e)
        raise ValueError(str(e))
    return {}


if __name__ == "__main__":
    try:
        settings = load_settings()
        application.listen(settings['port'])
        print("Staring server at port {}.".format(settings['port']))
        IOLoop.current().start()
    except KeyboardInterrupt:
        IOLoop.current().stop()
