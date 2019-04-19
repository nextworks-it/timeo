#!/bin/bash

export origin_fqdn=${uservnf_origin_fqdn}
export origin_port=${uservnf_origin_port}
export origin_address=${uservnf_origin_address}
export remap_fqdn=origin.${origin_fqdn}
#Dns hosts do not allow '_'
cache_host=$(hostname | sed -r 's/[^[:alnum:]]//g' | sed -e 's/\(.*\)/\L\1/')
date > /tmp/cache.log
env >> /tmp/cache.log
template_folder=/opt/vCacheConfServer/templates
conf_folder=/opt/ats/etc/trafficserver

if [ -v vnf_vCacheMid_01_vdu_vCacheMid_vdu_hostname ]
then
	#This is a vCacheEdge

	echo configuring edge		
	export mid_cache_host=${vnf_vCacheMid_01_vdu_vCacheMid_vdu_hostname}
	export mid_cache_address=${vnf_vCacheMid_01_vdu_vCacheMid_vdu_intcp_vCacheMid_cache_int_address}
	export edge_fqdn=${cache_host}.${origin_fqdn}
	envsubst < ${template_folder}/edge/parent.config > ${conf_folder}/parent.config
	envsubst < ${template_folder}/edge/cache.config > ${conf_folder}/cache.config
	envsubst < ${template_folder}/edge/records.config > ${conf_folder}/records.config
	envsubst < ${template_folder}/edge/remap.config > ${conf_folder}/remap.config
	envsubst < ${template_folder}/edge/storage.config > ${conf_folder}/storage.config
	sudo /bin/bash -c "echo ${mid_cache_address} ${mid_cache_host}.${origin_fqdn} >> /etc/hosts"
else
	echo configuring mid
	export mid_fqdn=${cache_host}.${origin_fqdn}
	envsubst < ${template_folder}/mid/parent.config > ${conf_folder}/parent.config
	envsubst < ${template_folder}/mid/cache.config > ${conf_folder}/cache.config
	envsubst < ${template_folder}/mid/remap.config > ${conf_folder}/remap.config
	envsubst < ${template_folder}/mid/storage.config > ${conf_folder}/storage.config


fi
envsubst < ${template_folder}/hosts > /opt/ats/hosts
sudo /bin/bash -c "echo ${origin_address} ${remap_fqdn} >> /etc/hosts"
sudo /opt/ats/bin/trafficserver restart &

