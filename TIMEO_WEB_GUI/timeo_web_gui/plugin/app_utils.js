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

function fillAppPCounter(elemId, data, resId) {
	var countDiv = document.getElementById(elemId);
	
	var appds = data.queryResult;
	
	//console.log(JSON.stringify(data, null, 4));
	
	countDiv.innerHTML = appds.length;
}

function uploadAppDFromForm(formIds, resId) {
	var jsonObj = JSON.parse('{}');
	jsonObj['name'] = document.getElementById(formIds[0]).value;
	jsonObj['version'] = document.getElementById(formIds[1]).value;
	jsonObj['provider'] = document.getElementById(formIds[2]).value;
	jsonObj['checksum'] = document.getElementById(formIds[3]).value;
	jsonObj['appPackagePath'] = document.getElementById(formIds[4]).value;
	var json = JSON.stringify(jsonObj, null, 4);
	postAppD(json, resId, 'AppD have been successfully uploaded','Error while uploading AppD', showResultMessage);	
}

function postAppD(jsonData, resId, okMsg, errMsg, callback) {
	var jsonObj = JSON.parse(jsonData);
	var appdId = jsonObj['name'];
	console.log('appdId: ' + jsonObj['name']);
	postJsonToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/appdManagement/appd', jsonData, resId, okMsg, errMsg, callback);
}

function readAppDs(tableId, resId) {
	getAppDs(tableId, resId , createAppDTable);
}

function readAppD(tableId, resId) {
	getAppD(tableId, resId, createAppDDetailsTable);
}

// TODO check payload, empty filter not supported
function getAppDs(elemId, resId, callback) {
    var jsonObj = JSON.parse('{}');
	var filter = JSON.parse('{}');
	jsonObj['filter'] = filter;
	var attributeSelector = [];
	jsonObj['attributeSelector'] = attributeSelector;
	var jsonData = JSON.stringify(jsonObj, null, 4);
	postJsonToURLWithResponseData('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/appdManagement/appd/query', jsonData, elemId, resId, callback);
}

// TODO check payload
function getAppD(elemId, resId, callback) {
	var params = getURLParameter('appdId').split('|');
	var appPkgInfoId = params[2];
    var jsonObj = JSON.parse('{}');
	var filter = JSON.parse('{}');
	var parameters = JSON.parse('{}');
	// TODO write proper parameters from url
	parameters['APP_PACKAGE_ID'] = appPkgInfoId;
	filter['parameters'] = parameters;
	jsonObj['filter'] = filter;
	var attributeSelector = [];
	jsonObj['attributeSelector'] = attributeSelector;
	var jsonData = JSON.stringify(jsonObj, null, 4);
	console.log('Json payload for AppD query: ' + jsonData);
	postJsonToURLWithResponseData('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/appdManagement/appd/query', jsonData, elemId, resId, callback);
}

function deleteAppDescriptor(appdId, resId) {
	putToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/appdManagement/appd/' + appdId.split('|')[2] + '/delete', resId, null, null, showResultMessage);
}

function enableAppDescriptor(appdId, resId) {
	putToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/appdManagement/appd/' + vnfdId.split('|')[2] + '/enable', resId, null, null, showResultMessage);
}

function disableAppDescriptor(appdId, resId) {
	putToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/appdManagement/appd/' + vnfdId.split('|')[2] + '/disable', resId, null, null, showResultMessage);
}

function createAppDTable(tableId, data, resId) {
//	console.log("AppDs: " + JSON.stringify(data,null,4));
    var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data.length < 1) {
		console.log('No AppD');
		table.innerHTML = '<tr>No AppD stored in database</tr>';
		return;
	}
//  console.log(JSON.stringify(data, null, 4));
	var btnFlag = true;
	var header = createTableHeaderByValues(['Id', 'Provider', 'Name', 'Software Version', 'AppD Version', 'Operational State', 'Usage State'], btnFlag, false);
	var cbacks = ['app_details.html?appdId=', 'deleteAppDescriptor', 'enableAppDescriptor', 'disableAppDescriptor'];
	var names = ['View', 'Delete', 'Enable', 'Disable'];
    var columns = [['appdId'], ['appProvider'], ['appProductName'], ['appSoftwareVersion'], ['appdVersion'], ['operationalState'], ['usageState']];
	var conts = '<tbody>';
	
	for (var i in data['queryResult']) {
		conts += createAppDTableContents(data['queryResult'][i], btnFlag, resId, names, cbacks, columns);
	}
	
	table.innerHTML = header + conts + '</tbody>';
}

function createAppDTableContents(data, btnFlag, resId, names, cbacks, columns) {
	var btnText = '';
	if (btnFlag) {
		var id = data['appdId'] + '|' + data['appdVersion'] + '|' + data['onboardedAppPkgInfoId'];
		var btnText = createActionButton(id, resId, names, cbacks);
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

function createAppDDetailsTable(tableId, data, resId) {
//	console.log("AppD: " + JSON.stringify(data,null,4));
	var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data['queryResult'].length < 1) {
		console.log('No AppD');
		table.innerHTML = '<tr>No App Descriptor stored in database</tr>';
		return;
	}
//  console.log(JSON.stringify(data['queryResult'][0]['appd'], null, 4));
	var btnFlag = false;
	var header = createTableHeaderByValues(['Id', 'Operational State', 'Usage State', 'VDU', 'Ext. Connection Point', 'AppD'], btnFlag, false);
	var cbacks = ['vdu_details.html?appPkgInfoId='];
	var names = ['View'];
    var columns = [['appdId'], ['operationalState'], ['usageState'], ['appd', 'vdu', 'vduId'], ['appd', 'appExtCpd', 'cpdId'], ['appdVersion']];
	var conts = createAppDDetailsTableContents(data['queryResult'][0], btnFlag, resId, names, cbacks, columns, data['queryResult'][0]['onboardedAppPkgInfoId']);
	table.innerHTML = header + conts;
}

function createAppDDetailsTableContents(data, btnFlag, resId, names, cbacks, columns, AppPckInfoId) {
	/*var selectElem = document.getElementById('flavourSelect');
	selectElem.innerHTML = '';
	
	var depFlavourTable = document.getElementById('depFlavourDivId');
	depFlavourTable.innerHTML = '';
	
	var depFlvs = data['deploymentFlavour'];
    for (var i in depFlvs) {
		selectElem.innerHTML += '<option>' + depFlvs[i]['flavourId'] + '</option>';
//		console.log(JSON.stringify(depFlvs[i], null, 4));
        var conts = createAppDFlavourTable(data, depFlvs[i], i);
        depFlavourTable.innerHTML += conts;
	}*/
		
	var btnText = '';
	if (btnFlag) {
		var btnText = createActionButton(appPckInfoId, resId, names, cbacks);
	}
	var text = '<tr>' + btnText;
	for (var key in columns) {
		var subText = '<td>';
		var values = [];
		getValuesFromKeyPath(data, columns[key], values);
//		console.log('key: ' + columns[key] + ' values: ' + values);
		if (typeof(values[0]) == 'object' && values[0].length > 1) {
			var subTable = '<table class="table table-borderless">';
			for (var v in values[0]) {
				subTable += '<tr><td>' + values[0][v] + '</td></tr>';
			}
			subTable += '</table>';
			subText += subTable + '</td>';
//			console.log("subTable: ", + subText);
		} else if (values.length != 0) {
			subText += values[0] + '</td>';
		} else {
			subText += '</td>';
		}
		text += subText;
	}
	text += '</tr>';
	return text;
}

function createAppDFlavourTable(data, depFlv, firstRow) {
	var names = ['VDU Profile', 'VirtualLink Profile', 'Instantiation Level', 'Supported Operation', 'Affinity/Anti-Affinity Group', 'Monitoring Parameter', 'Scaling Aspect'];
	var values = ['vduProfile', 'virtualLinkProfile', 'instantiationLevel', 'supportedOperation', 'affinityOrAntiAffinityGroup', 'monitoringParameter', 'scalingAspect'];
	var text = '';
	if (i == 0) {
		text = '<table id="' + depFlv['flavourId'] + '" class="table table-hover" style:"display:table">';
	} else
		text = '<table id="' + depFlv['flavourId'] + '" class="table table-hover" style:"display:none">';
//	console.log(JSON.stringify(data, null, 4));
	
	var conts = '<thead></thead><tbody>';
	
	var vduColumn = ['Id', 'Min #', 'Max #', 'Local A/A-A Rule', 'A/A-A Group Id'];
	var vduHeader = createTableHeaderByValues(vduColumn, false, false);
	var vduValues = [['vduId'], ['minNumberOfInstances'], ['maxNumberOfInstances'], ['localAffinityOrAntiAffinityRule'], ['affinityOrAntiAffinityGroupId']];
	
	var vlinkColumn = ['Id', 'Descriptor Id', 'Local A/A-A Rule', 'A/A-A Group Id', 'Max Bitrate', 'Min Bitrate'];
	var vlinkHeader = createTableHeaderByValues(vlinkColumn, false, false);
	var vlinkValues = [['virtualLinkProfileId'], ['virtualLinkDescId'], ['localAffinityOrAntiAffinityRule'], ['affinityOrAntiAffinityGroupId'], ['maxBitrateRequirements'], ['minBitrateRequirements']];
	
	var iLevColumn = ['Id', 'VDU Level', 'Scale Info'];
	var iLevHeader = createTableHeaderByValues(iLevColumn, false, false);
	var iLevValues = [['levelId'], ['vduLevel'], ['scaleInfo']];
	
	var suppOpColumn = ['Operation'];
	var suppOpHeader = createTableHeaderByValues(suppOpColumn, false, false);
	
	var aaaColumn = ['Id', 'A/A-A', 'Scope'];
	var aaaHeader = createTableHeaderByValues(aaaColumn, false, false);
	var aaaValues = [['groupId'], ['affinityOrAntiAffinity'], ['scope']];
			
	var mparamColumn = ['Id', 'Name', 'Performance Metric'];
	var mparamHeader = createTableHeaderByValues(mparamColumn, false, false);
	var mparamValues = [['monitoringParamaterId'], ['name'], ['performanceMetric']];
	
	var saColumn = ['Id', 'Name', 'Associated Group', 'Max Scale Level'];
	var saHeader = createTableHeaderByValues(saColumn, false, false);
	var saValues = [['id'], ['name'], ['associatedGroup'], ['maxScaleLevel']];
	
	for (var i in names) {
		conts += '<tr><td><b>' + names[i] + '</b></td><td>';
		if (names[i].indexOf('VDU Profile') >= 0) {
			conts += fillFlavourTableRow(vduHeader, vduValues, depFlv[values[i]]);
		} else if (names[i].indexOf('VirtualLink Profile') >= 0) {
			conts += fillFlavourTableRow(vlinkHeader, vlinkValues, depFlv[values[i]]);
		} else if (names[i].indexOf('Instantiation Level') >= 0) {
			conts += fillFlavourTableRow(iLevHeader, iLevValues, depFlv[values[i]]);
		} else if (names[i].indexOf('Supported Operation') >= 0) {
			conts += fillFlavourTableRow(suppOpHeader, null, depFlv[values[i]]);
		} else if (names[i].indexOf('Affinity/Anti-Affinity Group') >= 0) {
			conts += fillFlavourTableRow(aaaHeader, aaaValues, depFlv[values[i]]);
		} else if (names[i].indexOf('Monitoring Parameter') >= 0) {
			conts += fillFlavourTableRow(mparamHeader, mparamValues, depFlv[values[i]]);
		} else if (names[i].indexOf('Scaling Aspect') >= 0) {
			conts += fillFlavourTableRow(saHeader, saValues, depFlv[values[i]]);
		} 
		conts += '</td></tr>';
	}
		
    text += conts + '</tbody></table>';
    
	return text;
}


