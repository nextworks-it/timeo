#!/bin/bash

PWD=`pwd`

while getopts ':hd:' option; do
	case "${option}" in
		d) PWD=$OPTARG
		   ;;
		h) echo "USAGE: ./install_nfv_lib.sh [-d DIR_LIBS]"
		   echo "       DIR_LIBS: Directory where libs are stored. In case parameter is missing, DIR_LIBS=PWD"
		   exit
		   ;;
	esac
done

DIR_LIBS=${PWD}

DIR_LIBS_COMMON=tapi-common/
DIR_LIBS_TOPOLOGY=tapi-topology-client/
DIR_LIBS_CS=tapi-cs-client/
DIR_LIBS_PC=tapi-pc-client/
DIR_LIBS_SDM=tapi-sdm-client/

mvn_install() {
	cd "$1"
	mvn clean install
	if [ "$?" -ne 0 ]; then
		echo "Failed $2 installation!"
		exit 1
	else
		echo "Installed $2"
	fi
}

echo "Starting installation"

cd $DIR_LIBS

mvn_install $DIR_LIBS_COMMON "TAPI common"
cd ..
mvn_install $DIR_LIBS_TOPOLOGY "TAPI topology service"
cd ..
mvn_install $DIR_LIBS_CS "TAPI connectivity service"
cd ..
mvn_install $DIR_LIBS_PC "TAPI path computation service"
cd ..
mvn_install $DIR_LIBS_SDM "TAPI SDM extensions"

echo "All TAPI libs installed!"

exit #

