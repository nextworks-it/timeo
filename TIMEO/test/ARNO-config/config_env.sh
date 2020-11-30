#!/bin/bash

curl -v -X POST -d @createVIM.json http://localhost:8081/nfvo/vimManagement/vim --header "Content-Type:application/json"

#curl -v -X POST -d @createSDN.json http://localhost:8081/nfvo/vimManagement/sdn --header "Content-Type:application/json"

curl -v -X POST -d @createVNFM.json http://localhost:8081/nfvo/vnfmManagement/vnfm --header "Content-Type:application/json"

curl -v -X POST -d @createTenant.json http://localhost:8081/nfvo/tenantManagement/tenant --header "Content-Type:application/json"
