#!/bin/bash

set -e 
curl -v -X POST -d @cu_pnfd.json http://localhost:8081/nfvo/nsdManagement/pnfd --header "Content-Type:application/json" || { echo "CU not loaded!"; exit 1; }

curl -v -X POST -d @du_pnfd.json http://localhost:8081/nfvo/nsdManagement/pnfd --header "Content-Type:application/json" || { echo "DU not loaded!"; exit 1; }

curl -v -X POST -d @gw_pnfd.json http://localhost:8081/nfvo/nsdManagement/pnfd --header "Content-Type:application/json" || { echo "DU not loaded!"; exit 1; }
