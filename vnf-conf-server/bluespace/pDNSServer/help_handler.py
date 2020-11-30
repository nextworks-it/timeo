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


from tornado.httputil import HTTPServerRequest
from tornado.web import RequestHandler
from yattag import Doc

from log import get_logger


class HelpHandler(RequestHandler):

    log = get_logger('HelpHandler')

    # noinspection PyAttributeOutsideInit
    def initialize(self) -> None:
        self.doc = Doc()
        self.nesting_level = 0
        self.f_nesting = 2  # == <html><body>
        self.footer = Doc()
        self.footnote_counter = 1

        if self.application.settings.get('debug'):
            def nl(main=True):
                doc = self.doc if main else self.footer
                doc.nl()
                nest = self.nesting_level if main else self.f_nesting
                doc.text('  ' * nest)

            def go_in(main=True):
                doc = self.doc if main else self.footer
                doc.nl()
                if main:
                    self.nesting_level += 1
                    nest = self.nesting_level
                else:
                    self.f_nesting += 1
                    nest = self.f_nesting
                doc.text('  ' * nest)

            def go_out(main=True):
                doc = self.doc if main else self.footer
                if main:
                    self.nesting_level -= 1
                    nest = self.nesting_level
                else:
                    self.f_nesting -= 1
                    nest = self.f_nesting
                doc.nl()
                doc.text('  ' * nest)

            def line(tag_name, text_content, *args, **kwargs):
                self.doc.line(tag_name, text_content, *args, **kwargs)
                nl()

            def f_line(tag_name, text_content, *args, **kwargs):
                self.footer.line(tag_name, text_content, *args, **kwargs)
                nl(False)

            def stag(tag_name, *args, **kwargs):
                self.doc.stag(tag_name, *args, **kwargs)
                nl()
        else:
            def no_op(*_a, **_ka):
                pass
            nl = go_in = go_out = no_op
            line = self.doc.line
            f_line = self.footer.line
            stag = self.doc.stag
        self.nl = nl
        self.line = line
        self.f_line = f_line
        self.stag = stag
        self.go_in = go_in
        self.go_out = go_out
        # Prepare footer
        self.nl(False)
        self.footer.stag('hr')
        self.nl(False)

    def get_fc(self) -> str:
        temp = self.footnote_counter
        self.footnote_counter += 1
        return str(temp)

    def footnote(self, fn_text: str) -> None:
        c = self.get_fc()
        sup_id = 'ref' + c
        note_id = 'fn' + c
        tag = self.doc.tag
        text = self.doc.text
        line = self.line
        with tag('sup'):
            self.go_in()
            line(
                    'a',
                    href='#' + note_id,
                    id=sup_id,
                    text_content=c
            )
            self.go_out()
        self.nl()
        del tag
        del text
        del line

        f_tag = self.footer.tag
        f_text = self.footer.asis
        f_line = self.f_line
        with f_tag('p', id=note_id):
            self.go_in(False)
            with f_tag('small'):
                self.go_in(False)
                f_text(c + '. ')
                f_line(
                        'a',
                        href='#' + sup_id,
                        title='Go back',
                        text_content='^'
                )
                f_text(' ' + fn_text)
                self.go_out(False)
            self.nl(False)
            self.go_out(False)
        self.nl(False)

    def head(self):
        tag, line, stag = self.doc.tag, self.line, self.stag
        with tag('head'):
            self.go_in()
            stag(
                'link',
                rel="stylesheet",
                href="https://cdnjs.cloudflare.com/ajax/libs/mini.css/3.0.1/mini-default.min.css"
            )
            line('title', 'General purpose VNF configuration server')
            request = self.request  # type: HTTPServerRequest
            uri = request.protocol + '://' + request.host + '/favicon.png'
            stag(
                'link',
                rel="icon",
                href=uri,
                type="image.png"
            )
            self.go_out()
        self.nl()

    def description(self):
        tag, text, line, fn = self.doc.tag, self.doc.text, self.doc.line, self.footnote
        line('h3', id='description', text_content='Description')
        with tag('p'):
            self.go_in()
            text("This is a general-purpose HTTP server serving VNF")
            fn(
                "<a href=https://www.etsi.org/deliver/etsi_gs/nfv-ifa/"
                "001_099/011/03.01.01_60/gs_nfv-ifa011v030101p.pdf> "
                "https://www.etsi.org/deliver/etsi_gs/nfv-ifa/"
                "001_099/011/03.01.01_60/gs_nfv-ifa011v030101p.pdf</a>"
            )
            text(" configuration information. "
                 "It offers an ETSI IFA 008 compliant")
            fn(
                "<a href=https://www.etsi.org/deliver/etsi_gs/NFV-IFA/"
                "001_099/008/03.01.01_60/gs_nfv-ifa008v030101p.pdf> "
                "https://www.etsi.org/deliver/etsi_gs/NFV-IFA/"
                "001_099/008/03.01.01_60/gs_nfv-ifa008v030101p.pdf</a>"
                " - paragraph 6.2.3"
            )
            text(" NBI.")
            self.go_out()
        self.nl()

    def nbi(self):
        tag, text, line = self.doc.tag, self.doc.text, self.line
        line('h3', id='nbi', text_content='North bound interface')
        with tag('p'):
            self.go_in()
            text('To configure this VNF, perform an HTTP PATCH request to ')

            request = self.request  # type: HTTPServerRequest
            uri = request.protocol + '://' + request.host + '/vnfconfig/v1/configuration'
            line('a', uri, href=uri)
            text('.')
            self.go_out()
        self.nl()
        line('p', 'The format is as follows:')
        self.format_example()

    def format_example(self):
        ex = """{
    "vnfConfigurationData": {
        "vnfSpecificData": [
            {
                "key": "vnf.hss.vdu.hss_vdu.hostname",
                "value": "some-value",
            },
            {
                "key": "uservnf.hss.vdu.hss.domainname",
                "value": "some-other-value"
            }
        ]
    }
}"""

        ex = ex.replace('\n', '<br>')

        with self.doc.tag('pre'):
            self.doc.asis(ex)
        self.nl()

    def config(self):
        tag, text, line, fn, stag = self.doc.tag, self.doc.text, self.doc.line, self.footnote, self.stag
        line('h3', id='config', text_content='Configuration file')
        self.nl()
        line('p', "The configuration file (by default the 'settings.json' file "
             "in the same current working directory) is a json file "
             "following this format: ")
        self.nl()
        self.config_example()
        line('p', "where 'port' is the TCP port on on which the server should bind itself, "
             "'script' is the command which should be run to enforce the actual "
             "configuration, taking as arguments the parameter values, and "
             "'params' are the name of the parameters which are required for configuration.")
        self.nl()
        line('p', "For example, if there are two parameters configured with values '1' and 'stop' "
             "respectively, the command called will be ")
        self.nl()
        with tag('pre'):
            text('<script> 1 stop')
        self.go_out()
        self.nl()

    def config_example(self):
            ex = """{
    "port": 8080,
    "script": "/opt/VnfServer/hss.sh",
    "params": [
        "vnf.hss.vdu.hss_vdu.hostname",
        "uservnf.hss.vdu.hss.domainname"
    ]
}"""

            ex = ex.replace('\n', '<br>')

            with self.doc.tag('pre'):
                self.doc.asis(ex)
            self.nl()

    def body(self):
        doc, tag, text, line, fn = self.doc, self.doc.tag, self.doc.text, self.doc.line, self.footnote
        with tag('body'):
            self.go_in()
            line('h1', 'General purpose VNF indicator server')
            self.description()
            self.nbi()
            self.config()
            self.doc.asis(self.footer.getvalue())
            self.nl()
            self.go_out()
        self.nl()

    def get(self) -> None:
        self.log.debug('Received call')
        doc, tag, text, line, fn = self.doc, self.doc.tag, self.doc.text, self.doc.line, self.footnote
        with tag('html'):
            self.go_in()
            self.head()
            self.body()
            self.go_out()
        self.nl()
        self.write(doc.getvalue())
