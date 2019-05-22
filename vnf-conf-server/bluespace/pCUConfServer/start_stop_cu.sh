#!/bin/bash

remote_cu=$1

echo `date` ": Starting CU" > /opt/VnfServer/configuration.log

if [ $remote_cu != "" ]; then

	echo "Starting Central Unit"

	#/home/demo/openairinterface5g/targets/bin/lte-softmodem.Rel14 -O ../P
	ip link add vxlan1 type vxlan id 2 dstport 0 remote $remote_cu
    ifconfig vxlan1 10.255.255.1 netmask 255.255.255.0 up

    sleep 2
	screen -S cu -dm bash -c "/home/demo/openairinterface5g/targets/bin/lte-softmodem.Rel14 -O /home/demo/openairinterface5g/targets/PROJECTS/GENERIC-LTE-EPC/CONF/nextworks/rcc.band7.tm1.if4p5.25PRB.usrpb210.conf"
else
	echo "Stopping Central Unit"
	sudo killall lte-softmodem.Rel14
fi
