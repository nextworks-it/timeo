
function fillSDNCCounter(elemId, data, resId) {
	var countDiv = document.getElementById(elemId);
		
	countDiv.innerHTML = data.length;
}

function uploadSDNFromForm(formIds, resId) {
	var jsonObj = JSON.parse('{}');
	jsonObj['sdnControllerId'] = document.getElementById(formIds[0]).value;
	jsonObj['sdnControllerType'] = document.getElementById(formIds[1]).value;
	jsonObj['url'] = document.getElementById(formIds[2]).value;
	jsonObj['username'] = document.getElementById(formIds[3]).value;
	jsonObj['password'] = document.getElementById(formIds[4]).value;
	jsonObj['vimId'] = document.getElementById(formIds[5]).value;
	var json = JSON.stringify(jsonObj, null, 4);
	postSDN(json, resId, 'SDN have been successfully uploaded','Error while uploading SDN', showResultMessage);
}

function postSDN(data, resId, okMsg, errMsg, callback) {
    postJsonToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vimManagement/sdn', data, resId, okMsg, errMsg, callback);
}

function readSDNs(tableId, resId) {
	getSDNs(tableId, resId , createSDNTable);
}

function readSDN(tableId, resId) {
	getSDN(tableId, resId, createSDNDetailsTable);
}

function getSDNs(elemId, resId, callback) {
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vimManagement/sdn/', elemId, callback, resId, null, null);
}

function getSDN(elemId, resId, callback) {
	var param = getURLParameter('sdnId');
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vimManagement/sdn/' + param, elemId, callback, resId, null, null);
}

function deleteSDNController(sdnId, resId) {
	var id = sdnId.split('|')[0];
	deleteRequestToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/vimManagement/sdn/' + id, resId, "SDN Controller successfully deleted", "Unable to delete SDN Controller", showResultMessage);
}

function createSDNTable(tableId, data, resId) {
//	console.log("NSDs: " + JSON.stringify(data,null,4));
    var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data.length < 1) {
		console.log('No SDN Controller');
		table.innerHTML = '<tr>No SDN Controller stored in database</tr>';
		return;
	}
//  console.log(JSON.stringify(data, null, 4));
	var btnFlag = true;
	var header = createTableHeaderByValues(['Id', 'Type', 'Url', 'Vim'], btnFlag, false);
	var cbacks = ['deleteSDNController'];
	var names = ['Delete'];
    var columns = [['sdnControllerId'], ['sdnControllerType'], ['url'], ['vimId']];
	var conts = '<tbody>';
	
	for (var i in data) {
		conts += createSDNTableContents(data[i], btnFlag, resId, names, cbacks, columns);
	}
	
	table.innerHTML = header + conts + '</tbody>';
}

function createSDNTableContents(data, btnFlag, resId, names, cbacks, columns) {
	var btnText = '';
	if (btnFlag) {
		var btnText = createActionButton(data['sdnControllerId'], resId, names, cbacks);
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