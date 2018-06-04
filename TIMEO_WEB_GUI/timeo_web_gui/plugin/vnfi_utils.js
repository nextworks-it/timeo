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

function fillVNFICounter(elemId, data, resId) {
	var countDiv = document.getElementById(elemId);

	countDiv.innerHTML = data.length;
}

function readVNFIs(tableId, resId) {
	getVNFIs(tableId, resId, createVNFInstancesTable);
}

function getVNFIs(elemId, resId, callback){
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vnfmLcm/nss/vnfs/', elemId, callback, resId, null, null);
}

function createVNFInstancesTable(tableId, data, resId) {
	
	var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data.length < 1) {
		console.log('No VNF Instance');
		table.innerHTML = '<tr>No VNF Instance stored in database</tr>';
		return;
	}
	
	console.log(JSON.stringify(data, null, 4));
	
	var names = ['Id', 'Name', 'VNFD', 'Version', 'Ext. Cpd', 'Ext. Virtual Link', 'VNFC', 'Instantiation State', 'Operational State'];
	var columns = [['vnfInstanceId'], ['vnfInstanceName'], ['vnfdId'], ['vnfdVersion'], ['instantiatedVnfInfo', 'extCpInfo'], ['instantiatedVnfInfo', 'extVirtualLinkInfo'], ['instantiatedVnfInfo', 'vnfcResourceInfo'], ['instantiationState'], ['instantiatedVnfInfo', 'vnfState']];
	
	var header = createTableHeaderByValues(names, false, false);
	
	var conts = '<table class="hidable-table table table-hover" style="display:table">' + header + '<tbody>'

	var text = '';
	for (var vnf in data) {
		text += '<tr>';
		for (var i in columns) {
			var values = [];
			getValuesFromKeyPath(data[vnf], columns[i], values);
			
	//		console.log(values);
			var subText = '';
			var subTable = '<td><table class="table table-borderless">';
			if (values[0] instanceof Array) {
				for (var v in values[0]) {
					if (columns[i].indexOf('vnfcResourceInfo') >= 0) {
						subTable += '<tr><td><b>' + values[0][v]['vduId'] + '</b></td></tr>';
						subTable += '<tr><td>' + values[0][v]['vnfcInstanceId'] + '</td></tr>';
					} else if (columns[i].indexOf('extCpInfo') >= 0) {
						subTable += '<tr><td><b>' + values[0][v]['cpdId'] + '</b></td></tr>';
						subTable += '<tr><td>' + values[0][v]['cpInstanceId'] + '</td></tr>';
					} else if (columns[i].indexOf('extVirtualLinkInfo') >= 0) {
						subTable += '<tr><td><b>' + values[0][v]['extVirtualLinkId'] + '</b></td></tr>';
						subTable += '<tr><td>' + values[0][v]['resourceHandle']['resourceId'] + '</td></tr>';
					}
				}
				subText += subTable + '</table></td>';
			} else {
				if (values.length > 1) {
					for (var j in values) {
						if (columns[i].indexOf('vnfState') >= 0) {
							subTable += '<tr><td>' + values[j] + '</td></tr>';
						} else {
							subTable += '<tr><td>' + values[j] + '</td></tr>';
						}
					}
					subText += subTable + '</table></td>';
				} else {
					subText += '<td>' + values[0] + '</td>';
				}
			}
			text += subText;
		}
		text += '</tr>';
	}
	
	conts += text + '</tbody></table>';
	table.innerHTML += conts;
}