data='{
        "vnfConfigurationData": {
                "cpConfiguration": [],
                "dhcpServer": "null",
                "vnfSpecificData": [{
                                "key": "vnf.vEPC.vdu.vEPC_vdu.extcp.S1Ext.floating",
                                "value": "'"$1"'"
                        }

                ]
        },
        "vnfcConfigurationData": [],
        "vnfInstanceId": "553"
}
'
echo "$data"
curl -X PATCH \
  http://10.10.20.2:8888/vnfconfig/v1/configuration \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -d "$data"
printf "\n"