#!/bin/bash

remote_cu=$1

echo `date` ": Starting CU" > /opt/vEPCConfServer/configuration.log

if [ $remote_cu != "" ]; then

	echo "Starting Central Unit"

	#/home/demo/openairinterface5g/targets/bin/lte-softmodem.Rel14 -O ../P
	ip link delete vxlan1
	ip link add vxlan1 type vxlan id 2 dstport 0 remote $remote_cu
    ifconfig vxlan1 10.255.255.2 netmask 255.255.255.0 up



fi