#!/bin/bash
curl -v -X POST -d @createTenant.json http://localhost:8081/nfvo/tenantManagement/tenant --header "Content-Type:application/json"
