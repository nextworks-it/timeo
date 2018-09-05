#!/bin/bash

curl -v -X POST -d @createOriginServerVnfd.json http://localhost:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json"

curl -v -X POST -d @createCache1Vnfd.json http://localhost:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json"

curl -v -X POST -d @createCache2Vnfd.json http://localhost:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json"

curl -v -X POST -d @createFrontEndVnfd.json http://localhost:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json"

curl -v -X POST -d @createCdnNsd.json http://localhost:8081/nfvo/nsdManagement/nsd --header "Content-Type:application/json"
