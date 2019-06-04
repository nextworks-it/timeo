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


from logging import DEBUG, LoggerAdapter, Formatter, StreamHandler, basicConfig, getLogger, ERROR

import sys
import re


APPLICATION_NAME = 'vnfConfServer'


class BracesAdapter(LoggerAdapter):
    BRACES_PATTERN = re.compile(r'{([a-zA-Z0-9]+)?(:[ +]?\d*(\.\d+)?[df])?}')

    @staticmethod
    def substitute(m):
        output = '%'
        if m.group(1) is not None:
            output += '(' + m.group(1) + ')'
        if m.group(2) is not None:
            output += m.group(2).lstrip(':')
        else:
            output += 's'
        return output

    def setLevel(self, level):
        self.logger.setLevel(level)


    def process(self, msg, kwargs):
        new_msg = self.BRACES_PATTERN.sub(self.substitute, msg)
        return new_msg, kwargs


class ShortFormatter(Formatter):
    """The logging.Formatter subclass"""

    level_name_table = {
        'CRITICAL': 'CRT',
        'ERROR': 'ERR',
        'WARNING': 'WRN',
        'INFO': 'INF',
        'DEBUG': 'DBG'
    }

    def __init__(self):
        super(ShortFormatter, self).__init__(
            fmt='%(asctime)s | %(levelname)3.3s | '
                '%(name)11.11s | %(message)s',
            datefmt='%H:%M:%S')

    def format(self, record):
        record.name = record.name.split('.')[-1]
        record.levelname = self.level_name_table[record.levelname]
        return super(ShortFormatter, self).format(record)


handler = StreamHandler(sys.stdout)
handler.setLevel(DEBUG)
formatter = ShortFormatter()
handler.setFormatter(formatter)
basicConfig(handlers=[handler], level=DEBUG)
getLogger('').setLevel(ERROR)

_logger = getLogger(APPLICATION_NAME)

root_log = BracesAdapter(_logger, extra={})

root_log.setLevel(DEBUG)


def get_logger(name, extra=None):
    # type: (str, dict) -> LoggerAdapter
    if extra is None:
        extra = {}
    return BracesAdapter(_logger.getChild(name), extra=extra)
