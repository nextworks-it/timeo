
function fillVNFPCounter(elemId, data, resId) {
	var countDiv = document.getElementById(elemId);
	
	var vnfps = data['queryResult'];
	
	countDiv.innerHTML = vnfps.length;
}

function uploadVNFDFromForm(formIds, resId) {
	var jsonObj = JSON.parse('{}');
	jsonObj['name'] = document.getElementById(formIds[0]).value;
	jsonObj['version'] = document.getElementById(formIds[1]).value;
	jsonObj['provider'] = document.getElementById(formIds[2]).value;
	jsonObj['checksum'] = document.getElementById(formIds[3]).value;
	jsonObj['vnfPackagePath'] = document.getElementById(formIds[4]).value;
	var json = JSON.stringify(jsonObj, null, 4);
	postVNFD(json, resId, 'VNFD have been successfully uploaded','Error while uploading VNFD', showResultMessage);	
}

function postVNFD(jsonData, resId, okMsg, errMsg, callback) {
	var jsonObj = JSON.parse(jsonData);
	var vnfdId = jsonObj['name'];
	console.log('vnfdId: ' + jsonObj['name']);
	postJsonToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vnfdManagement/vnfPackage', jsonData, resId, okMsg, errMsg, callback);
}

function readVNFDs(tableId, resId) {
	getVNFDs(tableId, resId , createVNFDTable);
}

function readVNFD(tableId, resId) {
	getVNFD(tableId, resId, createVNFDDetailsTable);
}

// TODO check payload, empty filter not supported
function getVNFDs(elemId, resId, callback) {
    var jsonObj = JSON.parse('{}');
	var filter = JSON.parse('{}');
	jsonObj['filter'] = filter;
	var attributeSelector = [];
	jsonObj['attributeSelector'] = attributeSelector;
	var jsonData = JSON.stringify(jsonObj, null, 4);
	postJsonToURLWithResponseData('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vnfdManagement/vnfPackage/query', jsonData, elemId, resId, callback);
}

// TODO check payload
function getVNFD(elemId, resId, callback) {
	var params = getURLParameter('vnfdId').split('|');
	var vnfPkgInfoId = params[2];
    var jsonObj = JSON.parse('{}');
	var filter = JSON.parse('{}');
	var parameters = JSON.parse('{}');
	// TODO write proper parameters from url
	parameters['VNF_PACKAGE_ID'] = vnfPkgInfoId;
	filter['parameters'] = parameters;
	jsonObj['filter'] = filter;
	var attributeSelector = [];
	jsonObj['attributeSelector'] = attributeSelector;
	var jsonData = JSON.stringify(jsonObj, null, 4);
	console.log('Json payload for VNFD query: ' + jsonData);
	postJsonToURLWithResponseData('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vnfdManagement/vnfPackage/query', jsonData, elemId, resId, callback);
}

function deleteVNFDescriptor(vnfdId, resId) {
	putToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vnfdManagement/vnfPackage/' + vnfdId.split('|')[2] + '/delete', resId, null, null, showResultMessage);
}

function enableVNFDescriptor(vnfdId, resId) {
	putToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vnfdManagement/vnfPackage/' + vnfdId.split('|')[2] + '/enable', resId, null, null, showResultMessage);
}

function disableVNFDescriptor(vnfdId, resId) {
	putToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vnfdManagement/vnfPackage/' + vnfdId.split('|')[2] + '/disable', resId, null, null, showResultMessage);
}

function createVNFDTable(tableId, data, resId) {
//	console.log("VNFDs: " + JSON.stringify(data,null,4));
    var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data['queryResult'].length < 1) {
		console.log('No VNFD');
		table.innerHTML = '<tr>No VNF Package stored in database</tr>';
		return;
	}
//  console.log(JSON.stringify(data, null, 4));
	var btnFlag = true;
	var header = createTableHeaderByValues(['Id', 'Provider', 'Name', 'Software Version', 'VNFD Version', 'Operational State', 'Usage State'], btnFlag, false);
	var cbacks = ['vnf_details.html?vnfdId=', 'deleteVNFDescriptor', 'enableVNFDescriptor', 'disableVNFDescriptor'];
	var names = ['View', 'Delete', 'Enable', 'Disable'];
    var columns = [['vnfdId'], ['vnfProvider'], ['vnfProductName'], ['vnfSoftwareVersion'], ['vnfdVersion'], ['operationalState'], ['usageState']];
	var conts = '<tbody>';
	
	for (var i in data['queryResult']) {
		conts += createVNFDTableContents(data['queryResult'][i], btnFlag, resId, names, cbacks, columns);
	}
	
	table.innerHTML = header + conts + '</tbody>';
}

function createVNFDTableContents(data, btnFlag, resId, names, cbacks, columns) {
	var btnText = '';
	if (btnFlag) {
		var id = data['vnfdId'] + '|' + data['vnfdVersion'] + '|' + data['onboardedVnfPkgInfoId'];
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

function createVNFDDetailsTable(tableId, data, resId) {
//	console.log("VNFD: " + JSON.stringify(data,null,4));
	var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data['queryResult'].length < 1) {
		console.log('No VNFD');
		table.innerHTML = '<tr>No VNF Descriptor stored in database</tr>';
		return;
	}
//  console.log(JSON.stringify(data['queryResult'][0]['vnfd'], null, 4));
	var btnFlag = false;
	var header = createTableHeaderByValues(['Id', 'Operational State', 'Usage State', 'VDU', 'Ext. Connection Point', 'VNFD'], btnFlag, false);
	var cbacks = ['vdu_details.html?vnfPkgInfoId='];
	var names = ['View'];
    var columns = [['vnfdId'], ['operationalState'], ['usageState'], ['vnfd', 'vdu', 'vduId'], ['vnfd', 'vnfExtCpd', 'cpdId'], ['vnfdVersion']];
	var conts = createVNFDDetailsTableContents(data['queryResult'][0], btnFlag, resId, names, cbacks, columns, data['queryResult'][0]['onboardedVnfPkgInfoId']);
	table.innerHTML = header + conts;
}

function createVNFDDetailsTableContents(data, btnFlag, resId, names, cbacks, columns, vnfPckInfoId) {
	/*var selectElem = document.getElementById('flavourSelect');
	selectElem.innerHTML = '';
	
	var depFlavourTable = document.getElementById('depFlavourDivId');
	depFlavourTable.innerHTML = '';
	
	var depFlvs = data['deploymentFlavour'];
    for (var i in depFlvs) {
		selectElem.innerHTML += '<option>' + depFlvs[i]['flavourId'] + '</option>';
//		console.log(JSON.stringify(depFlvs[i], null, 4));
        var conts = createVNFDFlavourTable(data, depFlvs[i], i);
        depFlavourTable.innerHTML += conts;
	}*/
		
	var btnText = '';
	if (btnFlag) {
		var btnText = createActionButton(vnfPckInfoId, resId, names, cbacks);
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

function createVNFDFlavourTable(data, depFlv, firstRow) {
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


