#!/bin/bash

SOURCE="${BASH_SOURCE[0]}"
while [ -h "$SOURCE" ]; do # resolve $SOURCE until the file is no longer a symlink
  DIR="$( cd -P "$( dirname "$SOURCE" )" && pwd )"
  SOURCE="$(readlink "$SOURCE")"
  [[ $SOURCE != /* ]] && SOURCE="$DIR/$SOURCE" # if $SOURCE was a relative symlink, we need to resolve it relative to the path where the symlink file was located
done
DIR="$( cd -P "$( dirname "$SOURCE" )" && pwd )"

cd "$DIR"

# Check timestamp
./deploy_tars.sh


curl -v -X POST -d @createSpr1Vnfd.json http://localhost:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json"  || { echo "SPR1 not loaded!"; exit 1; }

curl -v -X POST -d @createSpr21Vnfd.json http://localhost:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json" || { echo "SPR21 not loaded!"; exit 1; }

curl -v -X POST -d @createSpr22Vnfd.json http://localhost:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json" || { echo "SPR22 not loaded!"; exit 1; }

curl -v -X POST -d @createWebServerVnfd.json http://localhost:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json" || { echo "WS not loaded!"; exit 1; }

curl -v -X POST -d @CDN_all_NSD_0_2.json http://localhost:8081/nfvo/nsdManagement/nsd --header "Content-Type:application/json" || { echo "CDN_NSD not loaded!"; exit 1; }
