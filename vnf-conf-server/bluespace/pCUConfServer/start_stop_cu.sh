#!/bin/bash

remote_cu=$1

echo `date` ": Starting CU" > /opt/VnfServer/configuration.log

if [ $remote_cu -eq "1" ]; then

	echo "Starting Central Unit"

	#/home/demo/openairinterface5g/targets/bin/lte-softmodem.Rel14 -O ../P
	sudo -E /home/demo/openairinterface5g/targets/bin/lte-softmodem.Rel14 -O /home/demo/openairinterface5g/targets/PROJECTS/GENERIC-LTE-EPC/CONF/nextworks/rcc.band7.tm1.if4p5.25PRB.usrpb210.conf
else
	echo "Stopping Central Unit"
	sudo killall lte-softmodem.Rel14
fi
