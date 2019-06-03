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

function fillPNFICounter(elemId, data, resId) {
	var countDiv = document.getElementById(elemId);
	
	var pnfis = data;
	
	countDiv.innerHTML = pnfis.length;
}

function readPNFInstances(elemId) {
	var callback = createPNFIsTable;
	var resId = 'response';
	getPNFInstances(elemId, resId, callback);
}

function readPNFInstance(tableId, resId) {
	var pnfiId = getURLParameter('pnfiId').split('|')[0];	
	var params = [resId];
	var callback = createPNFIsTable;
	var uri = 'http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/pnfInstanceManagement/pnf/' + pnfiId;
	getJsonFromURL(uri, tableId, callback, params, null, null);
}

function getPNFInstances(elemId, resId, callback) {
	var params = [resId];
	var uri = 'http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/pnfInstanceManagement/pnfs';
	getJsonFromURL(uri, elemId, callback, params, null, null);
}

function createPNFIsTable(tableId, data, params) { // Callback after readPNFInstances
	
	var resId = params[0];

	var table = document.getElementById(tableId);
	if (!table) {
		console.error("wrong table id passed to createPNFIsTable");
		return;
	}
	if (!(data instanceof Array)) {
		data = [data];
	}
	if (!data || data.length < 1) {
		table.innerHTML = '<tr>No PNF Instance stored in database</tr>';
		return;
	}
	
	console.log(JSON.stringify(data, null, 4));

	var btnFlag = true;
	var header = createTableHeaderByValues(['Id', 'Description', 'PNFD Id', 'Ports'], btnFlag, false);
	
	table.innerHTML = header;
	
	var cbacks = [
		'pnfi_details.html?pnfiId=', 
		'terminatePNFInstance'
	];
	var names = [
		'View',
		'Remove'
	];
    var columns = [['pnfInstanceId'], ['description'], ['pnfdId'], ['ports']];
	var pnfInstances = data;
	table.innerHTML += '<tbody>';
	
	for (var i in pnfInstances) {
		createPNFIsTableContents(table, pnfInstances[i], btnFlag, resId, names, cbacks, columns);
	}
	table.innerHTML += '</tbody>';
}

function createPNFIsTableContents(table, data, btnFlag, resId, names, cbacks, columns) {
	var btnText = '';
	var text = '';
	if (btnFlag) {
		var val = '';
		if (data.hasOwnProperty('pnfInstanceId')) {
			val += data['pnfInstanceId'];
		}
		if (data.hasOwnProperty('description')) {
			val += '|' + encodeURI(data['description']);
		}
		if (data.hasOwnProperty('pnfdId')) {
			val += '|' + data['pnfdId'];
		}
		
		btnText += createActionButton(val, resId, names, cbacks);
		text += btnText;
	}
			
	for (var key in columns) {
		var vals = [];
		getValuesFromKeyPath(data, columns[key], vals);
		if (vals.length == 0) {
			console.error("Could not retrieve " + columns[key] + " from data.");
			console.log("Data:\n" + JSON.stringify(data, null, 4));
			return;
		}
		if (vals.length > 1) {
			console.error("Too many values of " + columns[key] + " from data.");
			console.log("Data:\n" + JSON.stringify(data, null, 4));
			return;
		}

		var subText = '<td>';
		if (columns[key].includes('ports')) {
			subText += '<table class="table table-borderless">';
			subText += '<thead><tr><th>Port ID</th><th>MAC address</th><th>IP address</th><th>Management</th></tr></thead>';
			var portData;
			for (var i in vals[0]) {
				portData = vals[0][i];
				subText += '<tr>';
				subText += '<td><b>' + portData['portId'] + '</b></td>';
				subText += '<td>' + portData.addresses['MAC_ADDRESS'] + '</td>';
				subText += '<td>' + portData.addresses['IP_ADDRESS'] + '</td>';
				subText += '<td>' + (portData.management ? 'YES' : 'NO') + '</td>';
				subText += '</tr>';
			}
			subText += '</table>';
		} else if (
			columns[key].includes("nsInstanceId") 
				|| columns[key].includes("pnfInstanceId")
				|| columns[key].includes("pnfdId")
				|| columns[key].includes("description")
			){
			subText += vals[0];
		}
		subText += '</td>';
		text += subText;
	}
	
	table.innerHTML += text;
}

function terminatePNFInstance(ids, resId) {
	var pnfiId = ids.split('|')[0];
	
	deleteRequestToURL(
		'http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/pnfInstanceManagement/pnf/' + pnfiId,
		resId, 
		'PNF instance successfully terminated', 
		'Unable to terminate PNF instance',
		showResultMessage
	);
}

function addFieldToForm() {
	var portsNo = document.getElementById('ports-button').getAttribute('data-ports-no');
	var currentPort = parseInt(portsNo, 10);
	document.getElementById('ports-button').setAttribute('data-ports-no', (currentPort + 1).toString());
	var fieldId = 'port' + currentPort;
	
	var label = document.createElement('label');
	label.className = 'col-lg-12 col-md-12 col-sm-12 col-xs-12';
	label.setAttribute('for', fieldId + '-group');
	label.innerHTML = 'Port ' + currentPort;
	label.setAttribute('text-align', 'center');

	var line = document.createElement('hr');

	var container = document.createElement('div');
	container.setAttribute('name', 'createPNFI-' + fieldId + '-group');
	container.className = 'panel panel-default';
	container.appendChild(label);
	populateContainer(container, fieldId);

	var fGroup  = document.getElementById('createPNFI-port-form');
	fGroup.appendChild(line);
	fGroup.appendChild(container);
}

function createPNFI(pnfdEl, pnfdVerEl, pnfiIdEl, descrEl, locationEl, resId) {
	var portData = retrievePortData();
	var pnfdId = document.getElementById(pnfdEl).value;
	var pnfdVer = document.getElementById(pnfdVerEl).value;
	var pnfiId = document.getElementById(pnfiIdEl).value;
	var descr = document.getElementById(descrEl).value;
	var location = document.getElementById(locationEl).value;
	var pnf = {
		"pnfInstanceId": pnfiId,
		"pnfdId": pnfdId,
		"pnfdVersion": pnfdVer,
		"description": descr,
		"location": location,
		"ports": portData
	};
	postJsonToURL(
		'http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/pnfInstanceManagement/pnf',
		JSON.stringify(pnf),
		resId,
		'PNF Instance successfully created.',
		'Error while creating PNF instance.',
		showResultMessage
	);
}

function retrievePortData() {
	var ports = [];
	var portsNo = document.getElementById('ports-button').getAttribute('data-ports-no')
	var currentPort;
	var prefix;
	var portIsValid;
	for (var i = 0; i < portsNo; i++) {
		currentPort = {};
		portIsValid = true;
		prefix = 'pnf-port' + i;
		currentPort.portId = document.getElementById(prefix).value;
		if (!currentPort.portId) {
			portIsValid = false;
		}
		currentPort.addresses = {
			"MAC_ADDRESS": document.getElementById(prefix + '-mac').value,
			"IP_ADDRESS": document.getElementById(prefix + '-ip').value
		};
		if (!currentPort.addresses['MAC_ADDRESS'] || !currentPort.addresses['IP_ADDRESS']) {
			portIsValid = false;
		}
		currentPort.management = document.getElementById(prefix + '-mgmt').checked
		if (portIsValid) {
			ports[i] = currentPort;
		}
	}
	return ports;
}

function makeGroupContainer(name) {
	var container = document.createElement('div');
	container.setAttribute('name', name + '-group');
	container.className = 'form-group';
	return container;
}

function makeGroup(name, inner, inputType) {

	var actualType = 'text';
	if (inputType != undefined) {
		actualType = inputType;
	}

	var group = makeGroupContainer(name);
	var label = makeLabel(name, inner);
	var input = makeInput(actualType, name);

	var inputContainer = document.createElement('div');
	inputContainer.className = 'col-lg-6 col-md-6 col-sm-6 col-xs-12';
	inputContainer.appendChild(input);

	group.appendChild(label);
	group.appendChild(inputContainer);

	return group;
}

function makeLabel(forAttr, inner, divWidth) {
	var label = document.createElement('label');
	var actualWidth = 3;
	if (divWidth != undefined) {
		actualWidth = divWidth;
	}
	label.className = 'control-label col-lg-' + actualWidth + ' col-md-' + actualWidth + ' col-sm-' + actualWidth + ' col-xs-' + actualWidth;
	label.setAttribute('for', forAttr);
	label.innerHTML = inner;
	return label;
}

function populateContainer(container, fieldId) {
	var prefix = 'pnf-' + fieldId;

	var groupId = makeGroup(prefix, 'Port ID');

	var groupMac = makeGroup(prefix + '-mac', 'MAC Address');

	var groupIp = makeGroup(prefix + '-ip', 'IP address');

	var groupMgt = makeGroup(prefix + '-mgmt', 'Management', 'checkbox');

	container.appendChild(groupId);
	container.appendChild(groupMac);
	container.appendChild(groupIp);
	container.appendChild(groupMgt);
}

function makeInput(type, name) {
	var input = document.createElement('input');

	input.setAttribute('type', type);
	input.setAttribute('id', name);
	input.setAttribute('name', name);
	if (type !== 'checkbox') {
		input.className = 'form-control';
	}

	return input;
}

function clearPNFIForm() {
	clearForms('instantiatePNFIForm', true);

	var fGroup  = document.getElementById('createPNFI-port-form');
	while (fGroup.firstChild) {
		fGroup.removeChild(fGroup.firstChild);
	}
	document.getElementById('ports-button').setAttribute('data-ports-no', '0');
}