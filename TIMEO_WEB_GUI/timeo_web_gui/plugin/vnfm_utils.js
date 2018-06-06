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

function fillVNFMCounter(elemId, data, resId) {
	var countDiv = document.getElementById(elemId);
		
	countDiv.innerHTML = data.length;
}

function uploadVNFMFromForm(formIds, resId) {
	var jsonObj = JSON.parse('{}');
	jsonObj['type'] = document.getElementById(formIds[0]).value;
	jsonObj['name'] = document.getElementById(formIds[1]).value;
	var json = JSON.stringify(jsonObj, null, 4);
	postVNFM(json, resId, 'VNFM have been successfully uploaded','Error while uploading VNFM', showResultMessage);	
}

function postVNFM(data, resId, okMsg, errMsg, callback) {
    postJsonToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vnfmManagement/vnfm', data, resId, okMsg, errMsg, callback);
}

function readVNFMs(tableId, resId) {
	getVNFMs(tableId, resId , createVNFMTable);
}

function readVNFM(tableId, resId) {
	getVNFM(tableId, resId, createVNFMDetailsTable);
}

function getVNFMs(elemId, resId, callback) {
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vnfmManagement/vnfms', elemId, callback, resId, null, null);
}

function getVNFM(elemId, resId, callback) {
	var param = getURLParameter('vnfmName');
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vnfmManagement/vnfm/' + param, elemId, callback, resId, null, null);
}

function deleteVNFM(elemId, resId) {
	var name = elemId.split('|')[0];
	deleteRequestToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vnfmManagement/vnfm/' + name, resId, "VNFM successfully deleted", "Unable to delete VNFM", showResultMessage);
}

function createVNFMTable(tableId, data, resId) {
//	console.log("VIMs: " + JSON.stringify(data,null,4));
    var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data.length < 1) {
		console.log('No VNFM');
		table.innerHTML = '<tr>No VNFM stored in database</tr>';
		return;
	}
//  console.log(JSON.stringify(data, null, 4));
	var btnFlag = true;
	var header = createTableHeaderByValues(['Type', 'Name'], btnFlag, false);
	var cbacks = ['deleteVNFM'];
	var names = ['Delete'];
    var columns = [['type'], ['name']];
	var conts = '<tbody>';
	
	for (var i in data) {
		conts += createVNFMTableContents(data[i], btnFlag, resId, names, cbacks, columns);
	}
	
	table.innerHTML = header + conts + '</tbody>';
}

function createVNFMTableContents(data, btnFlag, resId, names, cbacks, columns) {
	var btnText = '';
	if (btnFlag) {
		var btnText = createActionButton(data['name'], resId, names, cbacks);
	}
	var text = '<tr>' + btnText;
	
	for (var i in columns) {
		var values = [];
		getValuesFromKeyPath(data, columns[i], values);
		
//		console.log(values);
		
		var subText = '';
		var subTable = '<td><table class="table table-borderless">';
		if (values[0] instanceof Array) {
			for (var j in values[0]) {
				subTable += '<tr><td>' + values[0][j] + '</td></tr>';
			}
			subText += subTable + '</table></td>';
		} else {
			if (values.length > 1) {
				for (var h in values) {
					subTable += '<tr><td>' + values[h] + '</td></tr>';
				}
				subText += subTable + '</table></td>';
			} else {
				subText += '<td>' + values[0] + '</td>';
			}
		}
		text += subText;
	}
	text += '</tr>';
	
	return text;
}