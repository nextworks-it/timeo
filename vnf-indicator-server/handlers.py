from json import loads, dumps
from typing import Dict

from tornado.httputil import HTTPServerRequest
from tornado.web import RequestHandler
from yattag import Doc


# noinspection PyAbstractClass
from log import get_logger


# noinspection PyAbstractClass
class HelpHandler(RequestHandler):

    log = get_logger('HelpHandler')

    # noinspection PyAttributeOutsideInit
    def initialize(self) -> None:
        self.doc: Doc = Doc()
        self.nesting_level = 0
        self.f_nesting = 0
        self.footer: Doc = Doc()
        self.footnote_counter = 1
        self.footer.stag('hr')
        self.footer.nl()

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
            line('title', 'General purpose VNF indicator server')
            request: HTTPServerRequest = self.request
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
            text("This is a general-purpose HTTP server serving VNF indicator")
            fn(
                "<a href=https://www.etsi.org/deliver/etsi_gs/nfv-ifa/"
                "001_099/011/03.01.01_60/gs_nfv-ifa011v030101p.pdf> "
                "https://www.etsi.org/deliver/etsi_gs/nfv-ifa/"
                "001_099/011/03.01.01_60/gs_nfv-ifa011v030101p.pdf</a> "
                "- paragraph 7.1.11.2"
            )
            text(" information. It offers several simple APIs to store data and an ETSI IFA 008 compliant")
            fn(
                "<a href=https://www.etsi.org/deliver/etsi_gs/NFV-IFA/"
                "001_099/008/03.01.01_60/gs_nfv-ifa008v030101p.pdf> "
                "https://www.etsi.org/deliver/etsi_gs/NFV-IFA/"
                "001_099/008/03.01.01_60/gs_nfv-ifa008v030101p.pdf</a>"
                "- paragraph 6.3.4"
            )
            text(" NBI.")
            self.go_out()
        self.nl()

    def nbi(self):
        tag, text, line = self.doc.tag, self.doc.text, self.line
        line('h3', id='nbi', text_content='North bound interface')
        with tag('p'):
            self.go_in()
            text('To retrieve VNF indicator values from this server, perform an HTTP GET request to ')

            request: HTTPServerRequest = self.request
            uri = request.protocol + '://' + request.host + '/vnfind/v1'
            line('a', uri, href=uri)
            text('.')
            self.go_out()
        self.nl()
        line('p', 'The format is as follows:')
        self.format_example()

    def format_example(self):
        ex = """{
  "indicatorInformation": [ 
    {
      "vnfInstanceId": "VNF_1",
      "indicatorId": "firstParameter",
      "indicatorValue": "123321"
      "indicatorName": "firstParameter"
    },
    {
      "vnfInstanceId": "VNF_1",
      "indicatorId": "secondParameter",
      "indicatorValue": "true"
      "indicatorName": "secondParameter"
    }
  ]
}"""

        ex = ex.replace('\n', '<br>')

        with self.doc.tag('pre'):
            self.doc.asis(ex)
        self.nl()

    def sbi(self):
        line = self.line
        tag = self.doc.tag
        text = self.doc.text
        line('h3', 'South bound interface')
        with tag('p'):
            self.go_in()
            text('To set the VNF indicator values returned by the server, send a POST request to ')

            request: HTTPServerRequest = self.request
            uri = request.protocol + '://' + request.host + '/vnfind/v1/<indicator-id>'
            line('a', uri, href=uri)
            text('.')
            self.go_out()
        self.nl()
        line('p', 'The format is as follows:')
        self.sbi_example()
        line('p', 'In case the "indicatorId" field is present, it MUST be equal to'
                  'the ID provided as a path parameter.')
        line('p', 'The other optional fields are ignored: they are just accepted in order to'
                  'allow the exact same format of the response to be a valid input.')

    def sbi_example(self):
        ex = """{
  "vnfInstanceId": "VNF_1",          // Optional
  "indicatorId": "firstParameter",   // Optional
  "indicatorValue": "123321",
  "indicatorName": "firstParameter"  // Optional
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
            self.sbi()
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
        self.write(doc.getvalue() + '\n' + self.footer.getvalue())


class IndicatorRepo(object):

    def __init__(self):
        self.data = {}

    def get_indicator(self, indicator_id: str) -> str:
        return self.data.get(indicator_id, '')

    def put_indicator(self, indicator_id: str, value: str) -> None:
        self.data[indicator_id] = value

    def get_all_indicators(self) -> Dict[str, str]:
        return self.data


# noinspection PyAbstractClass
class VnfOneIndicatorHandler(RequestHandler):

    log = get_logger('VnfOneIndicatorHandler')

    # noinspection PyMethodOverriding,PyAttributeOutsideInit
    def initialize(self, repo: IndicatorRepo):
        self.repo = repo

    def post(self, indicator_id):
        self.log.debug('Got POST for "{}".', indicator_id)
        request: HTTPServerRequest = self.request
        d_body = loads(request.body)
        ind_id = d_body.get('indicatorId', None)
        if ind_id is not None and ind_id != indicator_id:
            self.log.warning("Indicator Id in path different from payload: '{}' vs '{}'", indicator_id, ind_id)
            self.clear()
            self.set_status(400)
            self.finish(
                dumps(
                    {
                        'code': 400,
                        'message': 'Indicator ID provided in path '
                                   'is different from that in the payload'
                    }
                )
            )
            return
        value = str(d_body['indicatorValue'])
        self.log.info("Storing KV pair: '{}' -> '{}'", indicator_id, value)
        self.repo.put_indicator(indicator_id, value)


# noinspection PyAbstractClass
class VnfIndicatorHandler(RequestHandler):

    log = get_logger('VnfIndicatorHandler')

    # noinspection PyMethodOverriding,PyAttributeOutsideInit
    def initialize(self, repo: IndicatorRepo, vnf_name: str):
        self.repo = repo
        self.vnf_name = self.application.settings.get('vnf_name')

    def put(self):
        self.log.debug('Got PUT all.')
        # {
        #     "indicatorInformation": [
        #         {
        #             "vnfInstanceId": "VNF_1",
        #             "indicatorId": "firstParameter",
        #             "indicatorValue": "123321",
        #             "indicatorName": "firstParameter"
        #         },
        #         {
        #             "vnfInstanceId": "VNF_1",
        #             "indicatorId": "secondParameter",
        #             "indicatorValue": "true",
        #             "indicatorName": "secondParameter"
        #         }
        #     ]
        # }
        request: HTTPServerRequest = self.request
        d_body = loads(request.body)
        print(d_body)
        for block in d_body['indicatorInformation']:
            key, value = str(block['indicatorId']), str(block['indicatorValue'])
            self.log.info("Storing KV pair: '{}' -> '{}'", key, value)
            self.repo.put_indicator(key, value)

    def post(self):
        self.log.debug('Got GetIndicatorValue request.')
        request: HTTPServerRequest = self.request
        d_body = loads(request.body)
        if d_body['filter'] is not None:
            self.set_status(501)
            self.clear()
            self.finish(
                dumps(
                    {
                        'code': 501,
                        'message': 'Non-null filter not supported'
                    }
                )
            )
        inds = self.repo.get_all_indicators()
        ind_info_content = [
            {
                "vnfInstanceId": self.vnf_name,
                "indicatorId": name,
                "indicatorValue": value,
                "indicatorName": name
            }
            for name, value in inds.items()
        ]
        self.log.debug('Returning {} indicator values', len(ind_info_content))
        self.write({"indicatorInformation": ind_info_content})
