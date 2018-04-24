
function fillVIMCounter(elemId, data, resId) {
	var countDiv = document.getElementById(elemId);
		
	countDiv.innerHTML = data.length;
}

function uploadVIMFromForm(formIds, resId) {
	var jsonObj = JSON.parse('{}');
	jsonObj['vimId'] = document.getElementById(formIds[0]).value;
	jsonObj['type'] = document.getElementById(formIds[1]).value;
	jsonObj['tenant'] = document.getElementById(formIds[2]).value;
	jsonObj['url'] = document.getElementById(formIds[3]).value;
	jsonObj['domain'] = document.getElementById(formIds[4]).value;
	jsonObj['username'] = document.getElementById(formIds[5]).value;
	jsonObj['password'] = document.getElementById(formIds[6]).value;
	jsonObj['defaultExternalNetworkId'] = document.getElementById(formIds[7]).value;
	jsonObj['defaultExternalRouterId'] = document.getElementById(formIds[8]).value;
	jsonObj['providerId'] = document.getElementById(formIds[9]).value;
	jsonObj['networkNodeMacAddress'] = document.getElementById(formIds[10]).value;
	jsonObj['wrapperIp'] = document.getElementById(formIds[11]).value;
	jsonObj['wrapperPort'] = document.getElementById(formIds[12]).value;
	
	var physnet = document.getElementById(formIds[13]).value;
	if (physnet !== null && physnet !== undefined) {
		jsonObj['physnet'] = physnet;
	} else {
		jsonObj['physnet'] = "";
	}
	
	var keyPair = document.getElementById(formIds[14]).value;
	if (keyPair !== null && keyPair !== undefined) {
		jsonObj['keyPair'] = keyPair;
	}
	
	var json = JSON.stringify(jsonObj, null, 4);
	postVIM(json, resId, 'VIM have been successfully uploaded','Error while uploading VIM', showResultMessage);
		
}

function postVIM(data, resId, okMsg, errMsg, callback) {
    postJsonToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vimManagement/vim', data, resId, okMsg, errMsg, callback);
}

function readVIMs(tableId, resId) {
	getVIMs(tableId, resId , createVIMTable);
}

function readVIM(tableId, resId) {
	getVIM(tableId, resId, createVIMDetailsTable);
}

function getVIMs(elemId, resId, callback) {
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vimManagement/vim/', elemId, callback, resId, null, null);
}

function getVIM(elemId, resId, callback) {
	var param = getURLParameter('vimId');
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vimManagement/vim/' + param, elemId, callback, resId, null, null);
}

function deleteVIM(vimId, resId) {
	var id = vimId.split('|')[0];
	deleteRequestToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vimManagement/vim/' + id, resId, "VIM successfully deleted", "Unable to delete VIM", showResultMessage);
}

function createVIMTable(tableId, data, resId) {
//	console.log("VIMs: " + JSON.stringify(data,null,4));
    var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data.length < 1) {
		console.log('No VIM');
		table.innerHTML = '<tr>No VIM stored in database</tr>';
		return;
	}
//  console.log(JSON.stringify(data, null, 4));
	var btnFlag = true;
	var header = createTableHeaderByValues(['Id', 'Type', 'Tenant', 'Url', 'Domain', 'External Network', 'External Router', 'Provider'], btnFlag, false);
	var cbacks = ['deleteVIM'];
	var names = ['Delete'];
    var columns = [['vimId'], ['type'], ['tenant'], ['url'], ['domain'], ['defaultExternalNetworkId'], ['defaultExternalRouterId'], ['providerId']];
	var conts = '<tbody>';
	for (var i in data) {
		conts += createVIMTableContents(data[i], btnFlag, resId, names, cbacks, columns);
	}
	table.innerHTML = header + conts + '<tbody>';
}

function createVIMTableContents(data, btnFlag, resId, names, cbacks, columns) {
	var btnText = '';
	if (btnFlag) {
		var btnText = createActionButton(data['vimId'], resId, names, cbacks);
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
