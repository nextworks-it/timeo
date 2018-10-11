set -e
curl -v -d @loadCu.json -X POST http://localhost:8081/nfvo/pnfInstanceManagement/pnf --header "Content-Type:application/json"

curl -v -d @loadGw.json -X POST http://localhost:8081/nfvo/pnfInstanceManagement/pnf --header "Content-Type:application/json"
