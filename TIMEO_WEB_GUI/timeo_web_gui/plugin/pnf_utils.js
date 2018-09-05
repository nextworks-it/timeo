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

function fillPNFDCounter(elemId, data, resId) {
	var countDiv = document.getElementById(elemId);
	
	var pnfds = data.queryResult;
	
	countDiv.innerHTML = pnfds.length;
}

function uploadPNFDFromForm(formId, resId) {
	try {
		var div = document.getElementById(formId);
		var json = div.textContent;
		var id = div.id;
//		console.log("json: " + json);
		if(id.indexOf('script')<0) {
			postPNFD(json, resId, 'PNFD have been successfully uploaded','Error while uploading PNFD', showResultMessage);
		} else {
			postScript(json, resId, 'PNFD have been successfully uploaded','Error while uploading PNFD', showResultMessage);
		}
		$(document).ajaxStop(function () {			
		    // 0 === $.active			
			refresh(false);				
			//stopRefreshing = false;
		});
	} catch (e) {
		console.log(e);
	}
}

function loadPNFDFromFileIntoForm(evt, elementId, resId) {
	var type = 'JSON';
	loadFromFile(type, evt, elementId, resId);
}

function postPNFD(data, resId, okMsg, errMsg, callback) {
	postJsonToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsdManagement/pnfd', data, resId, okMsg, errMsg, callback);
}

function readPNFDs(tableId, resId) {
	getPNFDs(tableId, resId, createPNFDsTable);
}

function getPNFDs(elemId, resId, callback) {
    var jsonObj = JSON.parse('{}');
	var filter = JSON.parse('{}');
	jsonObj.filter = filter;
	var attributeSelector = [];
	jsonObj.attributeSelector = attributeSelector;
	var jsonData = JSON.stringify(jsonObj, null, 4);
	postJsonToURLWithResponseData('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsdManagement/pnfd/query', jsonData, elemId, resId, callback);
}

function deletePNFDescriptor(pnfdId, resId) {
	console.log(pnfdId);
	var jsonObj = JSON.parse('{}');
	var pnfdInfoIds = [];
	pnfdInfoIds.push(pnfdId);
	jsonObj.pnfdInfoId = pnfdInfoIds;
	var jsonData = JSON.stringify(jsonObj, null, 4);
	postJsonToURLWithResponseData('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsdManagement/pnfd/delete', jsonData, null, resId, showResultMessage);
}

function createPNFDsTable (tableId, data, resId) {
//  console.log("PNFDs: " + JSON.stringify(data,null,4));
    
    var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data.queryResult.length < 1) {
		console.log('No PNFDs');
		table.innerHTML = '<tr>No PNF Descriptors stored in database</tr>';
		return;
	}
//  console.log(JSON.stringify(data, null, 4));
	var btnFlag = true;
	var header = createTableHeaderByValues(['Id', 'Version', 'Provider', 'Ext. Cp'], btnFlag, false);
	var cbacks = [/*'pnf_details.html?pnfdId=',*/ 'deletePNFDescriptor', 'updatePNFDescriptor'];
	var names = [/*'View',*/ 'Delete', 'Update'];
    var columns = [['pnfdId'], ['version'], ['provider'], ['pnfd', 'pnfExtCp']];
	var pnfds = data.queryResult;
	var conts = '<tbody>';
	conts += createPNFDsTableContents(pnfds, btnFlag, resId, names, cbacks, columns);
	table.innerHTML = header + conts + '</tbody>';
}

function createPNFDsTableContents(data, btnFlag, resId, names, cbacks, columns) {
    console.log(JSON.stringify(data, null, 4));
    
	var text = '<tbody>';
	
	for (var j = 0; j < data.length; j++) {
		
		var btnText = '';
		if (btnFlag) {
			btnText += createActionButton(data[j].pnfdInfoId, resId, names, cbacks);
		}
		
		text += '<tr>' + btnText;
		for (var i = 0; i < columns.length; i++) {
			var values = [];
			getValuesFromKeyPath(data[j], columns[i], values);
			console.log(values);
			
			var subText = '<td>';
			var subTable = '<table class="table table-borderless">';
			
			if (data[j].hasOwnProperty(columns[i][0])) {
				if(values[0] instanceof Array) {
					for (var v = 0; v < values[0].length; v++) {
                        subTable += '<tr><td>' + values[0][v].cpdId + '</td><tr>';
					}
                    subText += subTable + '</table>';
				} else {
					if (values[0] instanceof Object){
						//console.log(JSON.stringify(values[0], null, 4));
						var value = values[0];
						$.each(value, function(key, val){
							subTable += '<tr><td><b>' + key + '</b></td><td>' + val + '</td><tr>';
						});
						subText += subTable + '</table>';
					} else {
						subText += values[0];
					}
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

