#!/bin/bash
PORT=`netstat -ntopl | grep 8888`

if [ -z /var/log/VnfServer ]; then
        mkdir /var/log/VnfServer
fi

if [ -z "${PORT}" ]; then
        python /opt/vCacheConfServer/server.py &
        echo "Running server.py on " `date` >> /var/log/VnfServer/server.py.log
fi
exit 0
