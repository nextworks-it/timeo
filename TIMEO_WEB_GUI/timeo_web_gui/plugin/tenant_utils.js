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

function fillTenantCounter(elemId, data, resId) {
	var countDiv = document.getElementById(elemId);
			
	countDiv.innerHTML = data.length;
}

function uploadTenantFromForm(formIds, resId) {
	var jsonObj = JSON.parse('{}');
	jsonObj['tenantId'] = document.getElementById(formIds[0]).value;
	jsonObj['userName'] = document.getElementById(formIds[0]).value;
	jsonObj['password'] = document.getElementById(formIds[1]).value;
	var json = JSON.stringify(jsonObj, null, 4);
	postTenant(json, resId, 'Tenant have been successfully created','Error while creating Tenant', showResultMessage);
		
}

function postTenant(data, resId, okMsg, errMsg, callback) {
    postJsonToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/tenantManagement/tenant', data, resId, okMsg, errMsg, callback);
}

function readTenants(tableId, resId) {
	getTenants(tableId, resId , createTenantTable);
}

function getTenants(elemId, resId, callback) {
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/tenantManagement/tenants', elemId, callback, resId, null, null);
}

function deleteTenant(tenantId, resId) {
	var id = tenantId.split('|')[0];
	deleteRequestToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/tenantManagement/tenant/' + id, resId, "Tenant successfully deleted", "Unable to delete Tenant", showResultMessage);
}

function createTenantTable(tableId, data, resId) {
    var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data.length < 1) {
		console.log('No Tenant');
		table.innerHTML = '<tr>No Tenant stored in database</tr>';
		return;
	}
  console.log(JSON.stringify(data, null, 4));
	var btnFlag = true;
	var header = createTableHeaderByValues(['Id', 'Username', 'Network Service'], btnFlag, false);
	var cbacks = ['deleteTenant'];
	var names = ['Delete'];
    var columns = [['tenantId'], ['userName'], ['nsId']];
	var conts = createTenantTableContents(data, btnFlag, resId, names, cbacks, columns);
	table.innerHTML = header + conts;
}

function createTenantTableContents(data, btnFlag, resId, names, cbacks, columns) {	
	var text = '<tbody>';
	
	for (var j in data) {
		
		var btnText = '';
		if (btnFlag) {
			btnText += createActionButton(data[j]['tenantId'], resId, names, cbacks);
		}
		
		text += '<tr>' + btnText;
		for (var i in columns) {
			var values = [];
			getValuesFromKeyPath(data[j], columns[i], values);
			console.log(values);
			
			var subText = '<td>';
			var subTable = '<table class="table table-borderless">';
			
			if (data[j].hasOwnProperty(columns[i][0])) {
				if(values[0] instanceof Array) {
					for (var v in values[0]) {
						subTable += '<tr><td>' + values[0][v] + '</td><tr>';
					}
				subText += subTable + '</table>';
				} else {
					subText += values[0];
				}
			}			
			subText += '</td>';
			text += subText;
		}
		text += '</tr>';
	}
	
	text += '</tbody>';
	return text;
}