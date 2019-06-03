#!/bin/bash

export timeo=192.168.217.2
export timeo_user=jbrenes
export SCRIPTS_FOLDER=$(pwd)/scripts
export DESCRIPTORS_FOLDER=$(pwd)/descriptors
export VNF_PACKAGE_FOLDER=/home/ubuntu/guis/
generate_tar(){

    tar cvf ${DESCRIPTORS_FOLDER}/vnfd_vFW_v01.tar -C ${DESCRIPTORS_FOLDER} vnfd_vFW.json
    tar cvf ${DESCRIPTORS_FOLDER}/vnfd_vDNS_v01.tar -C ${DESCRIPTORS_FOLDER} vnfd_vDNS.json
    tar cvf ${DESCRIPTORS_FOLDER}/vnfd_vCacheMid_v01.tar -C ${DESCRIPTORS_FOLDER} vnfd_vCacheMid.json
    tar cvf ${DESCRIPTORS_FOLDER}/vnfd_vCacheEdge_1_v01.tar -C ${DESCRIPTORS_FOLDER} vnfd_vCacheEdge_1.json
    tar cvf ${DESCRIPTORS_FOLDER}/vnfd_vCacheEdge_2_v01.tar -C ${DESCRIPTORS_FOLDER} vnfd_vCacheEdge_2.json
}

copy_tar(){
    scp ${DESCRIPTORS_FOLDER}/*.tar jbrenes@$timeo:/home/jbrenes/vnfd/
    ssh ${timeo_user}@${timeo} chmod 744 /home/jbrenes/vnfd/*.tar
}

onboard_vnfds(){

    curl -v -X POST -d @${SCRIPTS_FOLDER}/req_onboard_vFW.json http://$timeo:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json"

    curl -v -X POST -d @${SCRIPTS_FOLDER}/req_onboard_vDNS.json http://$timeo:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json"

    curl -v -X POST -d @${SCRIPTS_FOLDER}/req_onboard_vCacheMid.json http://$timeo:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json"

    curl -v -X POST -d @${SCRIPTS_FOLDER}/req_onboard_vCacheEdge_1.json http://$timeo:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json"

    curl -v -X POST -d @${SCRIPTS_FOLDER}/req_onboard_vCacheEdge_2.json http://$timeo:8081/nfvo/vnfdManagement/vnfPackage --header "Content-Type:application/json"



}

onboard_nsd(){
    curl -v -X POST -d @${DESCRIPTORS_FOLDER}/nsd_vCDN.json http://$timeo:8081/nfvo/nsdManagement/nsd --header "Content-Type:application/json"
    export current_NSD=$(curl -v -X POST -d @${DESCRIPTORS_FOLDER}/nsd_vCDN_pnf.json http://$timeo:8081/nfvo/nsdManagement/nsd --header "Content-Type:application/json")
    echo current_NSD $current_NSD
}


onboard_pnfd(){
    curl -v -X POST -d @${DESCRIPTORS_FOLDER}/pnfd_pDNS.json http://$timeo:8081/nfvo/nsdManagement/pnfd --header "Content-Type:application/json" || { echo "DU not loaded!"; exit 1; }
    curl -v -X POST -d @${DESCRIPTORS_FOLDER}/pnfd_pOrigin.json http://$timeo:8081/nfvo/nsdManagement/pnfd --header "Content-Type:application/json" || { echo "DU not loaded!"; exit 1; }

}

onboard_vCDN(){
    onboard_vnfds
    onboard_pnfd
    onboard_nsd


}


create_pnf(){
    curl -v -d @${SCRIPTS_FOLDER}/req_create_pDNS.json -X POST http://$timeo:8081/nfvo/pnfInstanceManagement/pnf --header "Content-Type:application/json"
    curl -v -d @${SCRIPTS_FOLDER}/req_create_pOrigin.json -X POST http://$timeo:8081/nfvo/pnfInstanceManagement/pnf --header "Content-Type:application/json"

}
create_vim(){
    curl -v -X POST -d @${SCRIPTS_FOLDER}/req_create_VIM.json http://$timeo:8081/nfvo/vimManagement/vim --header "Content-Type:application/json"

}



create_tenant(){

    curl -v -X POST -d @${SCRIPTS_FOLDER}/req_create_Tenant.json http://$timeo:8081/nfvo/tenantManagement/tenant  --header "Content-Type:application/json"

}

create_vnfm(){
    curl -v -X POST -d @${SCRIPTS_FOLDER}/req_create_VNFM.json http://$timeo:8081/nfvo/vnfmManagement/vnfm --header "Content-Type:application/json"
}

create_vCDN_inf(){
    create_vnfm
    create_vim
    create_tenant
    create_pnf
}

create_nsi_id(){
    export NSD_ID=$1
    envsubst < ${SCRIPTS_FOLDER}/req_create_NSI_Id_template.json > ${SCRIPTS_FOLDER}/req_create_NSI_Id.json
    export NSI_ID=$(curl -v -X POST -d @${SCRIPTS_FOLDER}/req_create_NSI_Id.json http://$timeo:8081/nfvo/nsLifecycle/ns --header "Content-Type:application/json")
    echo $NSI_ID
}

instantiate_nsi(){
    envsubst < ${SCRIPTS_FOLDER}/req_instantiate_template.json > ${SCRIPTS_FOLDER}/req_instantiate.json
    curl -v -X PUT -d @${SCRIPTS_FOLDER}/req_instantiate.json http://$timeo:8081/nfvo/nsLifecycle/ns/${NSI_ID}/instantiate --header "Content-Type:application/json"

}

test_cdn(){
   onboard_vCDN
   create_vCDN_inf
   create_nsi_id $current_NSD
   instantiate_nsi


}
