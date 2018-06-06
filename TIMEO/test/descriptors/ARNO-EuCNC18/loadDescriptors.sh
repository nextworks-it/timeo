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

curl -v -X POST -d @create_vEPC.json http://localhost:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json" || { echo "vEPC not loaded!"; exit 1; }

curl -v -X POST -d @vEPC_NSD.json http://localhost:8081/nfvo/nsdManagement/nsd --header "Content-Type:application/json" || { echo "NSD not loaded!"; exit 1; }
