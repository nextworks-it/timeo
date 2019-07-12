/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

function fillNSICounter(elemId, data, resId) {
	var countDiv = document.getElementById(elemId);
	
	var nsis = data['queryNsResult'];
	
	countDiv.innerHTML = nsis.length;
}

function readNSInstances(tableId, resId) {
	getNSIsWithTenants(tableId, resId, getNSIs);
}

function readNSInstance(tableId, resId) {
	var ids = getURLParameter('nsiId');
	var nsId = ids.split('|')[0];
	getNSI(nsId, tableId, resId, createNSIDetailsTable);
//	getNSI(nsId, tableId, resId, getNSDWithOnlyId);
}

function terminateNSInstance(ids, resId) {
	var nsId = ids.split('|')[0];
	
	var jsonObj = {};
	jsonObj['nsInstanceId'] = nsId;
	var currentDate = new Date();
	jsonObj['terminateTime'] = currentDate.getTime();
	
	var jsonData = JSON.stringify(jsonObj, null, 4);
	putJsonToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsLifecycle/ns/' + nsId + '/terminate', jsonData, resId, 'NS instance successfully terminated', 'Unable to terminate NS instance', showResultMessage);
}

function deleteNSInstance(ids, resId) {
	var nsId = ids.split('|')[0];
	
	deleteRequestToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsLifecycle/ns/' + nsId, resId, 'NS instance successfully deleted', 'Unable to delete NS instance', showResultMessage);
}

function getNSInstances(elemId, resId, callback) {
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsLifecycle/ns', elemId, callback, resId, null, null);
}

function getNSIs(elemId, tenants, resId) {
	var params = [resId, tenants];
	var callback = createNSITable;
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsLifecycle/ns', elemId, callback, params, null, null);
}

function getNSIsWithTenants(elemId, resId, callback) {
	getTenants(elemId, resId, callback);
}

function getNSI(nsId, elemId, resId, callback) {
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsLifecycle/ns/' + nsId, elemId, callback, resId, null, null);
}

function getVNFInfo(nsInstId, vnfInstId, elemId, resId, callback) {
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vnfmLcm/ns/' + nsInstId + '/vnf/' + vnfInstId, elemId, callback, resId, null, null);
}

function getNSDWithOnlyId(elemId, data, resId) {
	var callback = createNSIDetailsTable;
	var params = [resId, data];
	
    var jsonObj = JSON.parse('{}');
	var filter = JSON.parse('{}');
	var parameters = JSON.parse('{}');
	parameters['NSD_INFO_ID'] = data['queryNsResult'][0]['nsdId'];
	filter['parameters'] = parameters;
	jsonObj['filter'] = filter;
	var attributeSelector = [];
	jsonObj['attributeSelector'] = attributeSelector;
	var jsonData = JSON.stringify(jsonObj, null, 4);
//	console.log('Query NSD: ' + jsonData);
	postJsonToURLWithResponseData('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsdManagement/nsd/query', jsonData, elemId, params, callback);
}

function createNSITable(tableId, data, params) {
	var resId = params[0];
	var tenants = params[1];
	
	var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data['queryNsResult'].length < 1) {
		console.log('No NS Instance');
		table.innerHTML = '<tr>No NS Instance stored in database</tr>';
		return;
	}
	
//	console.log(JSON.stringify(data, null, 4));

	var btnFlag = true;
	var header = createTableHeaderByValues(['Id', 'Name', 'Description', 'NSD Id', 'Tenant', 'Instantiation State', 'IL'], btnFlag, false);
	
	table.innerHTML = header;
	
	var cbacks = ['nsi_details.html?nsiId=', 'terminateNSInstance'];
	var names = ['View','Terminate'];
    var columns = [['nsInstanceId'], ['nsName'], ['description'], ['nsdId'], ['tenantId'], ['nsState'],['nsScaleStatus','nsScaleLevelId']];
	var nsInfos = data['queryNsResult'];
	table.innerHTML += '<tbody>';
	
	for (var i in nsInfos) {
		createNSITableContents(table, nsInfos[i], btnFlag, resId, names, cbacks, columns, tenants, false);
	}
	table.innerHTML += '</tbody>';
}

function createNSIDetailsTable(tableId, data, resId) {
	var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data['queryNsResult'].length < 1) {
		console.log('No NS Instance');
		table.innerHTML = '<tr>No NS Instance stored in database</tr>';
		return;
	}
	
//	console.log(JSON.stringify(data, null, 4));
	
	var btnFlag = false;
	var headers;
	if (!data.queryNsResult[0].pnfInfo || data.queryNsResult[0].pnfInfo.length < 1) {
		headers = ['Id', 'NSD', 'VNF Info', 'NS Virtual Link', 'SAP Info'];
	} else {
		headers = ['Id', 'NSD', 'VNF Info', 'PNF Info', 'IL', 'NS Virtual Link', 'SAP Info'];
	}

	table.innerHTML = '<table>';

	var header = createTableHeaderByValues(headers, btnFlag, false);
	
	table.innerHTML += header;
	
	var cbacks = [];
	var names = [];
	var columns = [['nsInstanceId'], ['nsdId'], ['vnfInfoId'], ['pnfInfo'], ['virtualLinkInfo'], ['sapInfo']];
	if (!data.queryNsResult[0].pnfInfo || data.queryNsResult[0].pnfInfo.length < 1) {
		columns = [['nsInstanceId'], ['nsdId'], ['vnfInfoId'], ['virtualLinkInfo'], ['sapInfo']];
	} else {
		columns = [['nsInstanceId'], ['nsdId'], ['vnfInfoId'], ['pnfInfo'], ['virtualLinkInfo'], ['sapInfo']];
	}
	var nsInfo = data['queryNsResult'][0];
	
	table.innerHTML += '<tbody>';
	createNSITableContents(table, nsInfo, btnFlag, resId, names, cbacks, columns, null, true);
	table.innerHTML += '</tbody>';

	table.innerHTML += '</table>';
}

function createNSITableContents(table, data, btnFlag, resId, names, cbacks, columns, tenants, vnfFlag) {
	var btnText = '';
	var text = '';
	if (btnFlag) {
		var val = '';
		if (data.hasOwnProperty('nsInstanceId')) {
			val += data['nsInstanceId'];
		}
		if (data.hasOwnProperty('nsName')) {
			val += '|' + data['nsName'];
		}
		if (data.hasOwnProperty('nsdId')) {
			val += '|' + data['nsdId'];
		}
		
		if (data.hasOwnProperty('nsState') && data['nsState'] === 'NOT_INSTANTIATED') {
			btnText += createActionButton(val, resId, ['Delete'], ['deleteNSInstance']);
		} else {
			btnText += createActionButton(val, resId, names, cbacks);
		}
		text += btnText;
	}
	
	var tenant;
	if (tenants) {
		tenant = findNSTenant(tenants, data['nsInstanceId']);
	}
		
	for (var key in columns) {
		var subText = '<td>';
		var vals = [];
		getValuesFromKeyPath(data, columns[key], vals);
		if (vals[0]) {
			var wroteHeader = false;
			if (columns[key].includes('virtualLinkInfo')) {
				var subTable = '<table class="table table-borderless">';
				for (var v in vals[0]) {
					if (!wroteHeader) {
						subTable += '<thead><tr><th>Descriptor ID</th><th>Instance ID</th></tr></thead>';
						wroteHeader = true;
					}
					subTable += '<tr>';
					subTable += '<td><b>' + vals[0][v]['nsVirtualLinkDescId'] + '</b></td>';
					subTable += '<td>' + vals[0][v]['resourceHandle'][0]['resourceId'] + '</td>';
					subTable += '</tr>';
				}
				subTable += '</table>';
				subText += subTable;
			} else if (columns[key].includes('sapInfo')) {
				var subTable = '<table class="table table-borderless">';
				for (var v in vals[0]) {
					if (!wroteHeader) {
						subTable += '<thead><tr><th>Descriptor ID</th><th>Instance ID</th><th>IP Address</th></tr></thead>';
						wroteHeader = true;
					}
					subTable += '<tr>';
					subTable += '<td><b>' + vals[0][v]['sapdId'] + '</b></td></tr>';
					subTable += '<tr><td>' + vals[0][v]['sapInstanceId'] + '</td></tr>';
					subTable += '<tr><td>' +"userAccessInfo" in vals[0][v] ? vals[0][v]["userAccessInfo"][0]["address"] : "" + '</td>';
					subTable += '</tr>';
				}
				subTable += '</table>';
				subText += subTable;
			} else if (columns[key].includes('vnfInfoId')) {
				var subTable = '<table class="table table-borderless"><tbody>';
				for (var v in vals[0]) {
					subTable += 
						'<tr><td><button id="VNFbtn_' 
						+ vals[0][v] 
						+ '" type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#modal_VNFInfo_' 
						+ vals[0][v] 
						+ '" data-id="' 
						+ vals[0][v] 
						+ '"style="width: 100px">' 
						+ vals[0][v] 
						+ ' - ' 
						+ '</button></td></tr>';
				}
				subTable += '</tbody></table>';
				subText += subTable;
			} else if (columns[key].includes('pnfInfo')) {
				var subTable = '<table class="table table-borderless"><tbody>';
				var pnf;
				for (var v in vals[0]) {
					pnf = vals[0][v];
					subTable += '<tr><td>';
					subTable += '<'
					subTable += 'button id="PNFbtn_' + pnf.pnfId + '" ';
					subTable += 'type="button" ';
					subTable += 'class="btn btn-info btn-sm btn-block" ';
					subTable += 'onclick="location.href=\'../pnf/pnfi_details.html?pnfiId=' + pnf.pnfId + '\'" ';
					subTable += '>';
					subTable += pnf.pnfId;
					subTable += '</button>';
					subTable += '</td></tr>';
				}
				subTable += '</tbody></table>';
				subText += subTable;
			} else if (
				columns[key].includes("nsInstanceId") 
					|| columns[key].includes("nsdId")
					|| columns[key].includes("nsName")
					|| columns[key].includes("description")
					|| columns[key].includes("nsState")
					|| columns[key].includes("nsScaleStatus")	
				){
				subText += vals[0];
			} else if (columns[key].includes('tenantId')) {
				subText += tenant;
			}
			subText += '</td>';
		} else {
			console.error("data for " + columns[key] + " unavailable.");
		}
		text += subText;
	}
	
	table.innerHTML += text;
	
	if (vnfFlag) {
		for (var vnf in data['vnfInfoId']) {
			getVNFInfo(
				data['nsInstanceId'],
				data['vnfInfoId'][vnf],
				'VNFbtn_' + data['vnfInfoId'][vnf],
				resId,
				createVNFInfoModalDialog
			);
		}
	}
}

function findNSTenant(tenants, nsInstId) {
	if (tenants) {
//		console.log(JSON.stringify(tenants, null, 4));
		
		for (var i in tenants) {
			var nsIds = tenants[i]['nsId'];
			for (var j in nsIds) {
				if (nsInstId === nsIds[j]) {
//					console.log(tenants[i]['tenantId']);
					return tenants[i]['tenantId'];
				}
			}
		}
	}
	return null;
}

function createVNFInfoModalDialog(elemId, data, resId) {
	
//	console.log(JSON.stringify(data, null, 4));
//	console.log(elemId);
	
	var vnfBtn = document.getElementById(elemId);
	vnfBtn.innerHTML += data['vnfdId'];
	
	var names = ['Id', 'Name', 'VNFD', 'VNFC', 'Instantiation State', 'Operational State'];
	var columns = [['vnfInstanceId'], ['vnfInstanceName'], ['vnfdId'], ['instantiatedVnfInfo', 'vnfcResourceInfo'], ['instantiationState'], ['instantiatedVnfInfo', 'vnfState']];
	
	var header = createTableHeaderByValues(names, false, false);
	var conts = '<table class="hidable-table table table-hover" style="display:table">' + header + '<tbody>';
	
	var text = '<tr>';
	for (var i in columns) {
		var vals = [];
		getValuesFromKeyPath(data, columns[i], vals);
		
//		console.log(vals);
		
		var subText = '';
		var subTable = '<td><table class="table table-borderless">';
		if (vals[0] instanceof Array) {
			for (var v in vals[0]) {
				if (columns[i].indexOf('vnfcResourceInfo') >= 0 && data['instantiationState'] === 'INSTANTIATED') {
					subTable += '<tr><td><b>' + vals[0][v]['vduId'] + '</b></td></tr>';
					subTable += '<tr><td>' + vals[0][v]['vnfcInstanceId'] + '</td></tr>';
				} 
			}
			subText += subTable + '</table></td>';
		} else {
			if(vals.length > 1) {
				for (var j in vals) {
					if (columns[i].indexOf('vnfState') >= 0 && data['instantiationState'] === 'INSTANTIATED') {
						subTable += '<tr><td>' + vals[j] + '</td></tr>';
					} else {
						subTable += '<tr><td>' + vals[j] + '</td></tr>';
					}
				}
				subText += subTable + '</table></td>';
			} else {
				subText += '<td>' + vals[0] + '</td>';
			}
		}
		text += subText;
	}
	text += '</tr>';
	
	conts += text + '</tbody></table>';
	
	var newConts ='';
	if (data['instantiationState'] === 'INSTANTIATED') {
		// TODO: add further info
		var addInfo = data['instantiatedVnfInfo'];
		var newNames = ['Ext. Cp', 'Ext. Virtual Link'];
		var newColumns = [['extCpInfo'], ['extVirtualLinkInfo']];
		
		var newHeader = createTableHeaderByValues(newNames, false, false);
		
		newConts += '<table class="hidable-table table table-hover" style="display:table">' + newHeader + '<tbody><tr>';
		
		for (var k in newColumns) {
			var vals = [];
			getValuesFromKeyPath(addInfo, newColumns[k], vals);
			
//			console.log(vals);
			
			var newSubTable = '<td><table class="table table-borderless">';
			if (vals[0] instanceof Array) {
				for (var h in vals[0]) {
					if (newColumns[k].indexOf('extCpInfo') >= 0) {
						newSubTable += '<tr><td><b>' + vals[0][h]['cpdId'] + '</b></td></tr>';
						newSubTable += '<tr><td>' + vals[0][h]['cpInstanceId'] + '</td></tr>';
					} else if (newColumns[k].indexOf('extVirtualLinkInfo') >= 0) {
						newSubTable += '<tr><td><b>' + vals[0][h]['extVirtualLinkId'] + '</b></td></tr>';
						newSubTable += '<tr><td>' + vals[0][h]['resourceHandle']['resourceId'] + '</td></tr>';
					}
				}
			} else {
				for (var l in vals) {
					newSubTable += '<tr><td>' + vals[l] + '</td></tr>';
				}
			}
			
			newSubTable += '</table></td>';
			newConts += newSubTable;
			
		}
		newConts += '</tr><tbody></table>';
	}
	
	conts += newConts;
	
	var modal = '<div id="modal_VNFInfo_' + data['vnfInstanceId'] + '" class="modal fade bs-example-modal-md in" tabindex="-1" role="dialog" aria-hidden="true">\
              <div class="modal-dialog modal-md">\
                <div class="modal-content">\
                  <div class="modal-header">\
                    <button type="button" class="close" data-dismiss="modal" aria-label="Cancel"><span aria-hidden="true">×</span>\
                    </button>\
                    <h4 class="modal-title" id="myModalLabel">VNF Info - ' + data['vnfInstanceName'] + ' - ' + data['vnfInstanceId'] + ':</h4>\
                  </div>\
                  <div class="modal-body">';
		modal += conts;
		modal += '</div>\
                  <div class="modal-footer">\
					<button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
                  </div>\
                </div>\
              </div>\
            </div>';
		
	var div = document.getElementById("VNFInfosModals");
	div.innerHTML += modal;
}
