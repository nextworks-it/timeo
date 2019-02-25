from argparse import ArgumentParser

from tornado.ioloop import IOLoop
from tornado.web import Application, StaticFileHandler

from oaps.handlers import HelpHandler, IndicatorRepo, VnfIndicatorHandler, VnfOneIndicatorHandler


def make_app(vnf_name: str = "VNF") -> Application:
    repo = IndicatorRepo()
    return Application([
        (r'/', HelpHandler),
        (r'/help', HelpHandler),
        (r'/home', HelpHandler),
        (r'/home.html', HelpHandler),
        (r'/index', HelpHandler),
        (r'/index.html', HelpHandler),
        (r'/vnfind/v1', VnfIndicatorHandler, {"repo": repo, "vnf_name": vnf_name}),
        (r'/vnfind/v1/([0-9a-zA-Z-_]+)', VnfOneIndicatorHandler, {"repo": repo}),
        (r'/(favicon\.png)', StaticFileHandler, {'path': ''}),
    ],
        debug=True,
        vnf_name=vnf_name
    )


def main(port: int, vnf_name: str = "VNF"):
    app = make_app(vnf_name)
    app.listen(port)
    print("Listening on port {}.".format(port))
    try:
        IOLoop.current().start()
    except KeyboardInterrupt:
        print('Interrupted.')


if __name__ == '__main__':
    description = "HTTP server replying to requests for 'VnfIndicators'"
    epilog = "\u00a9 2019 Marco Capitani <m.capitani@nextworks.it>"

    parser = ArgumentParser(description=description, epilog=epilog)

    parser.add_argument('-P', '--port', type=int, help='Port number to listen to.', default=8888)
    parser.add_argument('-N', '--vnf-name', type=str, help='Name the VNF should advertise itself as.', default="VNF")
    args = parser.parse_args()
    main(args.port, args.vnf_name)
