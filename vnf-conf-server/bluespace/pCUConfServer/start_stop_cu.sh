#!/bin/bash

remote_cu=$1

echo `date` ": Starting CU" > /opt/pCUConfServer/configuration.log

if [ $remote_cu != "" ]; then

	echo "Starting Central Unit"

	#/home/demo/openairinterface5g/targets/bin/lte-softmodem.Rel14 -O ../P
	echo vxlan delete >> /opt/pCUConfServer/configuration.log
	ip link delete vxlan1 >> /opt/pCUConfServer/configuration.log
	echo vxlan creation >> /opt/pCUConfServer/configuration.log
	ip link add vxlan1 type vxlan id 2 dstport 0 remote $remote_cu >> /opt/pCUConfServer/configuration.log
    	echo vxlan ip configuration >> /opt/pCUConfServer/configuration.log
	ifconfig vxlan1 10.255.255.1 netmask 255.255.255.0 up
	echo starting screen >> /opt/pCUConfServer/configuration.log

	screen -X -S du quit
	screen -X -S cu quit
	screen -wipe
    	screen -S du -dm bash -c "ssh -t demo@10.100.30.102 /home/demo/run_demo_nxw.sh"
	sleep 5
	screen -S cu -dm bash -c "/home/demo/openairinterface5g/targets/bin/lte-softmodem.Rel14 -O /home/demo/openairinterface5g/targets/PROJECTS/GENERIC-LTE-EPC/CONF/nextworks/rcc.band7.tm1.if4p5.25PRB.usrpb210.conf"

else
	echo "Stopping Central Unit"
	sudo killall lte-softmodem.Rel14
fi
