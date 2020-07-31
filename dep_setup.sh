#!/bin/bash

# Check if the first argument contains the second
function contains {
	version=$1	
	length=${#2}
	substring=$(echo "${version:0:$length}")
	echo Available version: $substring
	if [ "$substring" = "$2" ]; then
		return 0
	else
		echo $1 != $2
		return 1
	fi
}

# Check if the first argument is the latest version
function is-latest {
        if [[ -z $1 || -z $2 ]]; then
            return 255
        fi
        max=($(sort-ver "$1" "$2"))
        if [[ "${max[0]}" == "$1" ]]; then
            return 0
        else
            return 1
        fi
}

# Sort a list (as args) of version numbers
function sort-ver {
    a="";
    for i in "$@"; do
        a+=$(printf "\n%s" "$i")
    done
    printf "%s" "$a" | sort -V -r
}

# Acquire sudo
sudo -v || (echo "Super user capabilities required."; exit 1)

# Install deps

# Java
if ! type javac > /dev/null; then
    echo "Installing JDK"
    sudo apt-get install openjdk-8-jdk -y
else
    javac_version=$(javac -version 2>&1 | cut -d" " -f2)
    if contains "$javac_version" 1.8; then
	echo "JDK already installed"
    else
    	echo "JDK is present, but in a version different than 8 ($java_version)."
        echo "Only JDK 8 is officially supported. Please install Java 8 manually and configure it accordingly."
	echo "Installation can not continue"
	exit -1
    fi
fi
if ! type java > /dev/null; then
    echo "Installing JRE"
    sudo apt-get install openjdk-8-jre -y
else
    jre_version=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}')
    if contains "$jre_version" 1.8; then
        echo "JRE already installed"
    else
        echo "JRE is present, but in a version different than 8 ($jre_version)."
        echo "Only JRE 8 is officially supported. Please install Java 8 manually and configure it accordingly."
        echo "Installation can not continue"
        exit -1
    fi
fi


if ! type rabbitmq-server 2> /dev/null; then
    echo "Installing rabbitmq"
    sudo apt-get install rabbitmq-server=3.6.10-1 -y
else
    echo "Rabbitmq already present."
    rabbit_version=$(sudo rabbitmqctl status | grep "\{rabbit,\"RabbitMQ\"" | tr -dc '[:digit:].\n')
    if contains "$rabbit_version" 3.6; then
	    echo "Rabbit already present"
    else
	    echo "Rabbit is present, but in a version different than 3.6"
	    echo "Only Rabbit 3.6 is officially supported."
    fi
fi

if ! locate bin/postgres 2>/dev/null; then
    echo "Installing postgresql"
    sudo apt-get install postgresql-10=10.12-0ubuntu0.18.04.1 -y
else

    
    if ! type psql 2>/dev/null; then
	    echo Installing psql client
    	sudo apt install postgresql-client-10=10.12-0ubuntu0.18.04.1
    fi
		
postgres_version=$(sudo -u postgres psql -c "select version();" | grep PostgreSQL | cut -d" " -f3)
    	if contains "$postgres_version" 10; then
	    echo "postgresql already present."
    	else
	    echo "Postgres is present, but in a version different than 10 ($postgres_version)"
            echo "Only Postgres 10 is officially supported."
    	fi
     
	
fi
if ! type mvn 2> /dev/null; then
    echo "Installing maven"
    sudo apt-get install maven=3.6.0-1~18.04.1 -y
else
    maven_version=$(mvn --version | grep "Apache Maven" | cut -d" " -f3)
    if contains "$maven_version" 3.6; then
	    
    	echo "Maven already present."
    else
            echo "Maven is present, but in a version different than 3.6 ($maven_version)"
            echo "Only Maven 3.6 is officially supported."
    fi
fi

# Start rabbit
sudo service rabbitmq-server start || true

# Configure & start postgres
sudo service postgresql start || true
sudo -u postgres bash -c 'psql -c "ALTER USER postgres PASSWORD '"'postgres'"';"
                          psql -c "CREATE DATABASE timeo;"' 2>/dev/null

echo "****************"
echo "Please run './install_libs.sh <FOLDER>' to complete the installation"
echo "****************"
