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


function fillNSDCounter(elemId, data, resId) {
	var countDiv = document.getElementById(elemId);
	
	var nsds = data['queryResult'];
	
	countDiv.innerHTML = nsds.length;
}

function uploadNSDFromForm(formId, resId) {
	try {
		var div = document.getElementById(formId);
		var json = div.textContent;
		var id = div.id;
//		console.log("json: " + json);
		if(id.indexOf('script')<0) {
			postNSD(json, resId, 'NSD have been successfully uploaded','Error while uploading NSD', showResultMessage);
		} else {
			postScript(json, resId, 'NSD have been successfully uploaded','Error while uploading NSD', showResultMessage);
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

function loadNSDFromFileIntoForm(evt, elementId, resId) {
	var type = 'JSON';
	loadFromFile(type, evt, elementId, resId);
}

function fillNSDInfoIdInCreateNSDIdForm(inputId) {
	var input = document.getElementById(inputId);
	var params = getURLParameter('nsdId');
	input.value = params.split('|')[2];
	input.readonly = true;
}

function createNSDId(formIds, elemId, resId) {
	var jsonObj = JSON.parse('{}');
	jsonObj['nsdId'] = document.getElementById(formIds[0]).value;
	jsonObj['nsName'] = document.getElementById(formIds[1]).value;
	jsonObj['tenantId'] = document.getElementById(formIds[2]).value;
	jsonObj['nsDescription'] = document.getElementById(formIds[3]).value;
	var json = JSON.stringify(jsonObj, null, 4);
	postNSDId(json, elemId, resId, showInstantiateNSModal);
}

function instantiateNSD(formIds, resId, nsdInfoId) {
	var jsonObj = JSON.parse('{}');
	var nsdId = document.getElementById(formIds[0]).value
	jsonObj['nsInstanceId'] = nsdId;
	var flavourId = document.getElementById(formIds[1]).value;
	jsonObj['flavourId'] = flavourId;
	jsonObj['nsInstantiationLevelId'] = document.getElementById('instLev-' + flavourId + '-' + nsdInfoId).value;
	
	var sapDivs = $('#' + formIds[2]).children('.sap-form-groups');
//	console.log(sapDivs.length);
	var jsonSaps = [];
	
	for (var i=0; i < sapDivs.length; i++) {
//		console.log(sapDivs[i].id);
		var sap = JSON.parse('{}');
		sap['sapdId'] = document.getElementById('sapId-' + sapDivs[i].id).value;
		sap['sapName'] = document.getElementById('sapName-' + sapDivs[i].id).value;
		sap['description'] = document.getElementById('sapDesc-' + sapDivs[i].id).value;
		
		jsonSaps.push(sap);
	}
	jsonObj['sapData'] = jsonSaps;
	
	var paramsDivs = $('#' + formIds[3]).children('.userParam-form-groups');
	
	var jsonUserParams = [];
	for (var j=0; j < paramsDivs.length; j ++) {
		var mapPair = (document.getElementById('mapPair-' + paramsDivs[j].id)).innerHTML.split('|');
		var profile = mapPair[1];
		var key = mapPair[0];
		var value = document.getElementById('input-' + paramsDivs[j].id).value;
		
		var found = false;
		for (var l in jsonUserParams) {
			if (jsonUserParams[l]['vnfProfileId'] == profile) {
				var tempMap = jsonUserParams[l]['additionalParam'];
				tempMap[key] = value;
				jsonUserParams[l]['additionalParam'] = tempMap;
				found = true;
			}
		}
		if (!found) {
			var jsonParam = {};
			jsonParam['vnfProfileId'] = profile;		
			var paramsMap = {};	
			paramsMap[key] = value;		
			jsonParam['additionalParam'] = paramsMap;
			
			jsonUserParams.push(jsonParam);
		}
	}
	
	jsonObj['additionalParamForVnf'] = jsonUserParams;
	
	var jsonData = JSON.stringify(jsonObj, null, 4);
	console.log(jsonData);
	clearForms("instantiateNSDWithIdForm_" + nsdInfoId, true);
	putJsonToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsLifecycle/ns/' + nsdId + '/instantiate', jsonData, resId, "NS successfully instantiated", "Unable to instantiate NS", showResultMessage);
}

function postNSD(data, resId, okMsg, errMsg, callback) {
    postJsonToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsdManagement/nsd', data, resId, okMsg, errMsg, callback);
}

function postNSDId(jsonData, elemId, resId, callback) {
	postJsonToURLWithResponseData('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsLifecycle/ns', jsonData, elemId, resId, callback);
}

function readNSDs(tableId, resId) {
	getNSDs(tableId, resId, createNSDTable);
}

function readNSD(tableId, resId) {
	getNSD(tableId, resId, createNSDDetailsTable);
}

function getNSDs(elemId, resId, callback) {
    var jsonObj = JSON.parse('{}');
	var filter = JSON.parse('{}');
	jsonObj['filter'] = filter;
	var attributeSelector = [];
	jsonObj['attributeSelector'] = attributeSelector;
	var jsonData = JSON.stringify(jsonObj, null, 4);
	postJsonToURLWithResponseData('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsdManagement/nsd/query', jsonData, elemId, resId, callback);
}

function getNSD(elemId, resId, callback) {
	var params = getURLParameter('nsdId').split('|');
    var jsonObj = JSON.parse('{}');
	var filter = JSON.parse('{}');
	var parameters = JSON.parse('{}');
	parameters['NSD_ID'] = params[0];
	parameters['NSD_VERSION'] = params[1];
	filter['parameters'] = parameters;
	jsonObj['filter'] = filter;
	var attributeSelector = [];
	jsonObj['attributeSelector'] = attributeSelector;
	var jsonData = JSON.stringify(jsonObj, null, 4);
//	console.log('Query NSD: ' + jsonData);
	postJsonToURLWithResponseData('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsdManagement/nsd/query', jsonData, elemId, resId, callback);
}

function deleteNSDescriptor(nsdId, resId) {
	var ids = nsdId.split('|');
	var jsonObj = JSON.parse('{}');
	var nsdInfoId = [];
	nsdInfoId.push(ids[2]);
	jsonObj['nsdInfoId'] = nsdInfoId;
	var jsonData = JSON.stringify(jsonObj, null, 4);
	postJsonToURLWithResponseData('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsdManagement/nsd/delete', jsonData, null, resId, showResultMessage);
}

function enableNSDescriptor(nsdId, resId) {
	putToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsdManagement/nsdInfo/' + nsdId.split('|')[2] + '/enable', resId, null, null, showResultMessage);
}

function disableNSDescriptor(nsdId, resId) {
	putToURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsdManagement/nsdInfo/' + nsdId.split('|')[2] + '/disable', resId, null, null, showResultMessage);
}

function updateNSDescriptor(nsdId, resId) {
	var id = nsdId.split('|')[2];
	var jsonObj = JSON.parse('{}');
	var jsonData = JSON.stringify(jsonObj, null, 4);
	// TODO create json for update request
	postJsonToURLWithResponseData('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsdManagement/nsdInfo/subscription', jsonData, null, resId, showResultMessage);
}

function getVNFsUserParameters(nsdId, callback, param) {
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsdManagement/nsd/' + nsdId + '/internal/vnfsuserparameters', nsdId, callback, param, null, null);
}

function getNSUserParameters(nsdId, callback, param) {
	getJsonFromURL('http://' + nfvoAddr + ':' + nfvoPort + '/nfvo/nsdManagement/nsd/' + nsdId + '/internal/nsuserparameters', nsdId, callback, param, null, null);
}

function createNSDTable(tableId, data, resId) {
//	console.log("NSDs: " + JSON.stringify(data,null,4));
    var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data['queryResult'].length < 1) {
		console.log('No NSD');
		table.innerHTML = '<tr>No NS Descriptor stored in database</tr>';
		return;
	}
//  console.log(JSON.stringify(data, null, 4));
	var btnFlag = true;
	var header = createTableHeaderByValues(['Id', 'Name', 'Operational State', 'Usage State', 'Designer', 'Version'], btnFlag, false);
	var cbacks = ['ns_details.html?nsdId=', 'instantiateNSDForm', 'deleteNSDescriptor', 'enableNSDescriptor', 'disableNSDescriptor', 'updateNSDescriptor'];
	var names = ['View','Instantiate', 'Delete', 'Enable', 'Disable', 'Update'];
    var columns = [['nsdId'], ['name'], ['operationalState'], ['usageState'], ['designer'], ['version']];
	var nsds = data['queryResult'];
	var conts = '<tbody>';
	for  (var i in nsds) {
		conts += createNSDDetailsTableContents(nsds[i], btnFlag, resId, names, cbacks, columns);
	}
	table.innerHTML = header + conts + '</tbody>';
}

function createNSDDetailsTable(tableId, data, resId) {
	//console.log("NSD: " + JSON.stringify(data,null,4));
	var table = document.getElementById(tableId);
	if (!table) {
		return;
	}
	if (!data || data['queryResult'].length < 1) {
		console.log('No NSD');
		table.innerHTML = '<tr>No NS Descriptor stored in database</tr>';
		return;
	}
	
	//var selectElem = document.getElementById('flavourSelect');
	//selectElem.innerHTML = '';
	
	var depFlavourTable = document.getElementById('depFlavourDivId');
	depFlavourTable.innerHTML = '';
	
	var depFlvs = data['queryResult'][0]['nsd']['nsDf'];
    for (var i in depFlvs) {
		//selectElem.innerHTML += '<option>' + depFlvs[i]['nsDfId'] + '</option>';
//		console.log(JSON.stringify(depFlvs[i], null, 4));
        var conts = createNSDFlavourTable(data, depFlvs[i], i);
        depFlavourTable.innerHTML += conts;
	}
	
//  console.log(JSON.stringify(data, null, 4));
	var btnFlag = false;
	var header = createTableHeaderByValues(['Id', 'Name', 'VNFD', 'SAP', 'Virtual Link', 'Deployment Flavour'], btnFlag, false);
	var cbacks = [];
	var names = [];
    var columns = [['nsdId'], ['name'], ['nsd', 'vnfdId'], ['nsd', 'sapd', 'cpdId'], ['nsd', 'virtualLinkDesc', 'virtualLinkDescId'], ['nsd', 'nsDf', 'nsDfId']];
	var conts = createNSDDetailsTableContents(data['queryResult'], btnFlag, resId, names, cbacks, columns);
	table.innerHTML = header + conts;
	
	//PASS NSDINFOID
	fillNSInstantiationForm(data['queryResult'], ['instantiateNSD-dflvs', 'instantiateNSD-instLevs', 'instantiateNSD-sap_modalForm_', 'instantiateNSD-userParams_modalForm_'], ''); //data['queryResult'][0]['nsdInfoId']
	createNSTopology(data['queryResult'][0]);
}

function createNSDDetailsTableContents(data, btnFlag, resId, names, cbacks, columns) {
	
//	console.log(JSON.stringify(data,null,4));
	
	var btnText = '';
	var text = '<tr>';
	if (btnFlag) {
		var val = '';
		if (data.hasOwnProperty('nsdId')) {
			val += data['nsdId'];
		}
		if (data.hasOwnProperty('version')) {
			val += '|' + data['version'];
		}
		if (data.hasOwnProperty('nsdInfoId')) {
			val += '|' + data['nsdInfoId'];
		}
		btnText += createActionButton(val, resId, names, cbacks);
		text += btnText;
		
		createNSInstantiateModalDialogs(data['nsdInfoId'], data);
	}
	for (var key in columns) {
		var subText = '<td>';
		var values = [];
		getValuesFromKeyPath(data, columns[key], values);
//		console.log('key: ' + columns[key] + ' values: ' + values);
		if (typeof(values[0]) == 'object') {
			var subTable = '<table class="table table-borderless">';
			for (var v in values[0]) {
//				console.log('key: ' + columns[key] + ' value: ' + values[0]);
				if (columns[key].indexOf('nsDfId') >= 0) {
					subTable += '<tr><td><button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#modal_df_' + values[0][v] + '" data-id="' + values[0][v] + '">' + values[0][v] + '</button></td></tr>';
				} else {
					subTable += '<tr><td>' + values[0][v] + '</td></tr>';
				}
			}
			subTable += '</table>';
			subText += subTable + '</td>';
//			console.log("subTable: ", + subText);
		} else if (values.length > 1) {
			var subTable = '<table class="table table-borderless">';
			for (var v in values) {
//				console.log('key: ' + columns[key] + ' value: ' + values[v]);
				if (columns[key].indexOf('nsDfId') >= 0) {
					subTable += '<tr><td><button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#modal_df_' + values[v] + '" data-id="' + values[v] + '">' + values[v] + '</button></td></tr>';
				} else {
					subTable += '<tr><td>' + values[v] + '</td></tr>';
				}
			}
			subTable += '</table>';
			subText += subTable + '</td>';
//			console.log("subTable: ", + subText);
		} else if (values.length != 0) {
			if (columns[key].indexOf('nsDfId') >= 0) {
				subText += '<button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#modal_df_' + values[0] + '" data-id="' + values[0] + '">' + values[0] + '</button></td>';
			} else {
				subText += values[0] + '</td>';
			}
		} else {
			subText += '</td>';
		}
		text += subText;
	}
	text += '</tr>';
	return text;
}

function createNSInstantiateModalDialogs(nsdInfoId, data) {
	var createNSId_modal = ' <div id="instantiateNSDForm_' + nsdInfoId + '" class="modal fade bs-example-modal-md in" tabindex="-1" role="dialog" aria-hidden="true">\
              <div class="modal-dialog modal-md">\
                <div class="modal-content">\
                  <div class="modal-header">\
                    <button type="button" class="close" data-dismiss="modal" aria-label="Cancel"><span aria-hidden="true">×</span>\
                    </button>\
                    <h4 class="modal-title" id="myModalLabel">Create NS Id</h4>\
                  </div>\
                  <div class="modal-body">\
                    <div class="form-group">\
                      <form id="createNSDIdForm" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="">\
                          <div class="form-group">\
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Id <!-- span class="required">*</span -->\
                            </label>\
                            <div class="col-md-6 col-sm-6 col-xs-12">\
                              <input type="text" id="createNSDId-id_' + nsdInfoId + '" required="required" class="form-control col-md-7 col-xs-12" value="' + nsdInfoId + '" readonly>\
                            </div>\
                          </div>\
                          <div class="form-group">\
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Name <!-- span class="required">*</span -->\
                            </label>\
                            <div class="col-md-6 col-sm-6 col-xs-12">\
                              <input type="text" id="createNSDId-name_' + nsdInfoId + '" name="last-name" required="required" class="form-control col-md-7 col-xs-12">\
                            </div>\
                          </div>\
                          <div class="form-group">\
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Tenant Id <!-- span class="required">*</span -->\
                            </label>\
                            <div class="col-md-6 col-sm-6 col-xs-12">\
                              <input type="text" id="createNSDId-tenantId_' + nsdInfoId + '" name="last-name" required="required" class="form-control col-md-7 col-xs-12">\
                            </div>\
                          </div>\
                          <div class="form-group">\
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Description <!-- span class="required">*</span -->\
                            </label>\
                            <div class="col-md-6 col-sm-6 col-xs-12">\
                              <input type="text" id="createNSDId-description_' + nsdInfoId + '" name="last-name" required="required" class="form-control col-md-7 col-xs-12">\
                            </div>\
                          </div>\
                        </form>\
                    </div>\
                  </div>\
                  <div class="modal-footer">\
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal" onclick=clearForms("instantiateNSDForm_' + nsdInfoId + '")>Cancel</button>\
                    <button type="submit" class="btn btn-info" data-dismiss="modal"\
                            onclick=createNSDId(["createNSDId-id_' + nsdInfoId + '","createNSDId-name_' + nsdInfoId + '","createNSDId-tenantId_' + nsdInfoId + '","createNSDId-description_' + nsdInfoId + '"],["instantiateNSDWithIdForm_' + nsdInfoId + '","instantiateNSD-id_' + nsdInfoId + '"],"response")>Submit</button>\
                  </div>\
                </div>\
              </div>\
            </div>';
				  
	var instantiateNSWithId_modal = '<div id="instantiateNSDWithIdForm_' + nsdInfoId + '" class="modal fade bs-example-modal-md in" tabindex="-1" role="dialog" aria-hidden="true">\
              <div class="modal-dialog modal-md">\
                <div class="modal-content">\
                  <div class="modal-header">\
                    <button type="button" class="close" data-dismiss="modal" aria-label="Cancel" onclick=clearForms("instantiateNSDWithIdForm_' + nsdInfoId + '",true)><span aria-hidden="true">×</span>\
                    </button>\
                    <h4 class="modal-title" id="myModalLabel">Instantiate NS</h4>\
                  </div>\
                  <div class="modal-body" id="instantiateNSD-modalbody">\
                    <div class="form-group">\
                      <form id="instantiateNSDWithIdForm" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="">\
                        <div class="form-group">\
                          <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Id <!-- span class="required">*</span -->\
                          </label>\
                          <div class="col-md-6 col-sm-6 col-xs-12">\
                            <input type="text" id="instantiateNSD-id_' + nsdInfoId + '" required="required" class="form-control col-md-7 col-xs-12" readonly>\
                          </div>\
                        </div>\
                        <div class="form-group">\
                          <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Deployment Flavour <!-- span class="required">*</span -->\
                          </label>\
                          <div class="col-md-6 col-sm-6 col-xs-12">\
                            <select id="instantiateNSD-dflvs_' + nsdInfoId + '" autocomplete="off" name="input-flavour" class="form-control col-md-7 col-xs-12" onchange=showDfInstantiationLevel("instantiateNSD-dflvs","instantiateNSD-instLevs")>\
                            </select>\
                          </div>\
                        </div>\
                        <div class="form-group">\
                          <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Instantiation Level <!-- span class="required">*</span -->\
                          </label>\
                          <div class="col-md-6 col-sm-6 col-xs-12" id="instantiateNSD-instLevs_' + nsdInfoId + '">\
                          </div>\
                        </div>\
						<div id="instantiateNSD-sap_modalForm_' + nsdInfoId + '">\
						  <h4 class="modal-title" id="myModalLabel">SAP</h4>\
						</div>\
						<div id="instantiateNSD-userParams_modalForm_' + nsdInfoId + '">\
						  <h4 class="modal-title" id="myModalLabel">VNFs Parameters</h4>\
						</div>\

                      </form>\
                    </div>\
                  </div>\
                  <div class="modal-footer">\
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal" onclick=clearForms("instantiateNSDWithIdForm_' + nsdInfoId + '",true)>Cancel</button>\
                    <button type="submit" class="btn btn-info" data-dismiss="modal"\
                            onclick=instantiateNSD(["instantiateNSD-id_' + nsdInfoId + '","instantiateNSD-dflvs_' + nsdInfoId + '","instantiateNSD-sap_modalForm_' + nsdInfoId + '","instantiateNSD-userParams_modalForm_' + nsdInfoId + '"],"response","' + nsdInfoId + '")>Submit</button>\
                  </div>\
                </div>\
              </div>\
            </div>';
				  
	var instantiateModalDiv = document.getElementById('instantiateModalDiv');
	instantiateModalDiv.innerHTML += createNSId_modal;
	instantiateModalDiv.innerHTML += instantiateNSWithId_modal;
		
	fillNSInstantiationForm(data, ['instantiateNSD-dflvs_' + nsdInfoId, 'instantiateNSD-instLevs_' + nsdInfoId, 'instantiateNSD-sap_modalForm_' + nsdInfoId, 'instantiateNSD-userParams_modalForm_' + nsdInfoId], nsdInfoId);
}

function createNSDFlavourTable(data, depFlv, firstRow) {
	var names = ['Flavour Key', 'Instantiation Level', 'Default Instantiation Level'];
	var values = ['flavourKey', 'nsInstantiationLevel', ['defaultNsInstantiationLevelId']];
	var text = '';
	if (firstRow == 0)
		text = '<table id="' + depFlv['nsDfId'] + '" class="hidable-table table table-hover" style="display:table">';
	else
		text = '<table id="' + depFlv['nsDfId'] + '" class="hidable-table table table-hover" style="display:none">';
//	console.log(JSON.stringify(data, null, 4));

	var conts = '<thead></thead><tbody>';
	
	var keyColumn = ['Key'];
	var keyHeader = createTableHeaderByValues(keyColumn, false, false);
	
	var iLevColumn = ['Level Id', 'Description']; //, 'Level Mapping'
	var iLevHeader = createTableHeaderByValues(iLevColumn, false, false);
	var iLevValues = [['nsLevelId'], ['description']]; //, ['nsToLevelMapping']
	
	var defILevColumn = ['Level Id'];
	var defILevHeader = createTableHeaderByValues(defILevColumn, false, false);

	for (var i in values) {
		conts += '<tr><td><b>' + names[i] + '</b></td><td>';
		if (values[i].indexOf('lavourKey') >= 0) {
			conts += fillFlavourTableRow(keyHeader, null, depFlv[values[i]]);
		} else if (values[i].indexOf('nsInstantiationLevel') >= 0) {
			conts += fillFlavourTableRow(iLevHeader, iLevValues, depFlv[values[i]]);
		} else if (values[i].indexOf('defaultNsInstantiationLevelId') >= 0) {
			conts += fillFlavourTableRow(defILevHeader, null, depFlv[values[i]]);
		}
		
		conts += '</td></tr>';
	}
	
	text += conts + '</tbody></table>';
	
	var modal = '<div id="modal_df_' + depFlv['nsDfId'] + '" class="modal fade bs-example-modal-md in" tabindex="-1" role="dialog" aria-hidden="true">\
              <div class="modal-dialog modal-md">\
                <div class="modal-content">\
                  <div class="modal-header">\
                    <button type="button" class="close" data-dismiss="modal" aria-label="Cancel"><span aria-hidden="true">×</span>\
                    </button>\
                    <h4 class="modal-title" id="myModalLabel">Deployment Flavour - ' + depFlv['nsDfId'] + ':</h4>\
                  </div>\
                  <div class="modal-body">';
		modal += text;
		modal += '</div>\
                  <div class="modal-footer">\
					<button type="button" class="btn btn-default pull-right" data-dismiss="modal">Close</button>\
                  </div>\
                </div>\
              </div>\
            </div>';
    
	return modal;
}

function fillNSInstantiationForm(data, formIds, nsdInfoId) {
//	console.log('nsd: ' + JSON.stringify(data, null, 4));
//	console.log('formIds: ' + formIds[0] + ' - ' + formIds[1]);
	var depFlvs;
	if (data[0] === null || data[0] === undefined) {
		depFlvs = data['nsd']['nsDf'];
	} else {
		depFlvs = data[0]['nsd']['nsDf'];
	}
//	console.log('depFlv: ' + JSON.stringify(depFlvs, null, 4));
	var depFlvsSelect = document.getElementById(formIds[0]);
	depFlvsSelect.innerHTML = '';
	
//	console.log(formIds[1]);
	var instLevDiv = document.getElementById(formIds[1]);
	instLevDiv.innerHTML = '';
	
	for (var i in depFlvs) {
		depFlvsSelect.innerHTML += '<option>' + depFlvs[i]['nsDfId'] + '</option>';
		
		var instLevs = depFlvs[i]['nsInstantiationLevel'];
		
		var select = '';
		if (i == 0) {
			select = '<select id="instLev-' + depFlvs[i]['nsDfId'] + '-' + nsdInfoId + '" autocomplete="off" name="input-instLev" class="flv-inst-lev form-control col-md-7 col-xs-12" >';
		} else {
			select = '<select id="instLev-' + depFlvs[i]['nsDfId'] + '-' + nsdInfoId + '" autocomplete="off" name="input-instLev" class="flv-inst-lev form-control col-md-7 col-xs-12" style="display:none">';
		}
		
		var defaultInstLev = '';
		if(depFlvs[i].hasOwnProperty('defaultNsInstantiationLevelId')) {
			defaultInstLev = depFlvs[i]['defaultNsInstantiationLevelId'];
//			console.log('Default instatiation level: ' + defaultInstLev);
			select += '<option id="defaultNSInstantiationLevel" class="defaultNSInstantiationLevel" value="'+ defaultInstLev + '" defaultSelected>' + defaultInstLev + '</option>';
		}
		for (var j in instLevs) {
			if(instLevs[j]['nsLevelId'] != defaultInstLev) {
				select += '<option value="' + instLevs[j]['nsLevelId'] + '">' + instLevs[j]['nsLevelId'] + '</option>';
			} else {
//				console.log('Skipping already inserted instantiation level: ' + instLevs[j]['nsLevelId']);
			}
		}
		
		instLevDiv.innerHTML += select + '</select>';
	}
	
//	console.log(formIds[2])
	var sap_modalForm = document.getElementById(formIds[2]);
	
	var saps;
	if (data[0] === null || data[0] === undefined) {
		saps = data['nsd']['sapd'];
	} else {
		saps = data[0]['nsd']['sapd'];
	}
	
	for (var j in saps) {
		sap_modalForm.innerHTML += '<div class="sap-form-groups" id="' + saps[j]['cpdId'] + '-' + nsdInfoId + '"><div class="form-group">\
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Id <!-- span class="required">*</span -->\
							</label>\
							<div class="col-md-6 col-sm-6 col-xs-12">\
							  <input type="text" id="sapId-'+ saps[j]['cpdId'] + '-' + nsdInfoId + '" required="required" class="form-control col-md-7 col-xs-12 sapId" value="' + saps[j]['cpdId'] + '" readonly>\
							</div>\
						  </div>\
						  <div class="form-group">\
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Name <!-- span class="required">*</span -->\
							</label>\
							<div class="col-md-6 col-sm-6 col-xs-12">\
							  <input type="text" id="sapName-'+ saps[j]['cpdId'] + '-' + nsdInfoId + '" required="required" class="form-control col-md-7 col-xs-12 sapName">\
							</div>\
						  </div>\
						  <div class="form-group">\
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Description <!-- span class="required">*</span -->\
							</label>\
							<div class="col-md-6 col-sm-6 col-xs-12">\
							  <input type="text" id="sapDesc-'+ saps[j]['cpdId'] + '-' + nsdInfoId + '" required="required" class="form-control col-md-7 col-xs-12 sapDesc">\
							</div>\
						</div></div>';
	}
	
	if (data[0] === null || data[0] === undefined) {
		getNSUserParameters(data['nsdInfoId'], fillNSInstantiationForm_step2, formIds[3]);
	} else {
		getNSUserParameters(data[0]['nsdInfoId'], fillNSInstantiationForm_step2, formIds[3]);
	}
}

function fillNSInstantiationForm_step2(nsdInfoId, data, param) {
	//console.log(JSON.stringify(data, null, 4));
	//data = {'user.hss.aaa.bbb.domain':'OAI', 'user.spgw.ccc.ddd.boh':'OAI'};
	var userParams_modalForm = document.getElementById(param);
	var found = false;
	$.each(data, function (key, val)  {
		if (key.indexOf('user') == 0) {
			found = true;
			var field = key.split('.');
			userParams_modalForm.innerHTML += '<div class="userParam-form-groups" id="' + key + '-' + nsdInfoId + '"><div class="form-group">\
							<label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">' + field[field.length - 1].charAt(0).toUpperCase() + field[field.length - 1].slice(1) + '<!-- span class="required">*</span -->\
							</label>\
							<div class="col-md-6 col-sm-6 col-xs-12">\
							  <input type="text" id="input-' + key + '-' + nsdInfoId + '" required="required" class="form-control col-md-7 col-xs-12 userParam">\
							</div>\
							<div id="mapPair-' + key + '-' + nsdInfoId + '" style="display:none">' + key + '|' + val + '</div>\
						  </div></div>';
		}
	});
	
	if (!found) {
		var title = document.getElementById('instantiateNSD-userParams_modalForm_' + nsdInfoId);
		
		if (title) {
			title.style.display = 'none';
		} else {
			title = document.getElementById('instantiateNSD-userParams_modalForm_');
			if (title) {
				title.style.display = 'none';
			}
		}
		
	}
}

function showDfInstantiationLevel(selectId, elemId) {
	var depFlv = document.getElementById(selectId).value;
	
	var selects = $('#' + elemId).children('.flv-inst-lev');
	
	for (var i in selects) {
//		console.log('select: ' + selects[i].id);
		if (selects[i].id != depFlv) {
			selects[i].style = 'display:none';
		} else {
			selects[i].style = '';			
			var options = selects[i].options;
//			console.log(options);
			for (var j in options) {
				if(options[j].id == 'defaultNSInstantiationLevel') {
//					console.log('Showing default NS instantiation level... ');
					options[j].selected = true;
					options[j].defaultSelected = true;
				}
			}
		}
	}
}

function showInstantiateNSModal(elemIds, data, resId) {
	if (data) {
		var nsdId = data;
		var nsdInput = document.getElementById(elemIds[1]);
		nsdInput.value = nsdId;
		var modalDiv = document.getElementById(elemIds[0]);
		modalDiv.style = 'display:block';
	} else {
		showResultMessage(false, resId, 'Unable to create NSD Id');
	}
}

function createNSTopology(data) {
	console.log(JSON.stringify(data, null, 4));
	
	var nodes = [];
	var edges = [];
	
	var vLinks = data['nsd']['virtualLinkDesc'];
	var vlIds = [];
	getValuesFromKeyPath(vLinks, ['virtualLinkDescId'], vlIds);
	
	var saps = data['nsd']['sapd'];
	
	var vnfs = data['nsd']['vnfdId'];
	var vnfProfiles = data['nsd']['nsDf'][0]['vnfProfile'];
	var pnfs = data['nsd']['pnfdId'];
	var pnfProfiles = data['nsd']['nsDf'][0]['pnfProfile'];
	var vlProfiles = data['nsd']['nsDf'][0]['virtualLinkProfile'];
		
	for (var k in vlIds) {
//		console.log(sapIds[j]);
		//cy.add({ group: 'nodes', data: { id: vlIds[k], name: 'VLink - ' + vlIds[k], weight: 10, faveColor: '#EDA1ED', faveShape: 'ellipse' }});
		nodes.push({ group: 'nodes', data: { id: vlIds[k], name: 'VLink - ' + vlIds[k], label: 'VLink - ' + vlIds[k], weight: 50, faveColor: '#fff', faveShape: 'ellipse' }, classes: 'bottom-center net'});
	}
	for (var p in pnfs) {
//		console.log(vnfs[i]);
		nodes.push({ group: 'nodes', data: { id: pnfs[p], name: 'PNF - ' + pnfs[p], label: 'PNF - ' + pnfs[p], weight: 70, faveColor: '#fff', faveShape: 'ellipse' }, classes: 'bottom-center pnf'});
		for (var l in pnfProfiles) {
			if (pnfProfiles[l]['pnfdId'].indexOf(pnfs[p]) >= 0) {
//				console.log(pnfProfiles[h]['pnfdId']);
				var pnf_vlConns = [];
				getValuesFromKeyPath(pnfProfiles[l], ['pnfVirtualLinkConnectivity', 'virtualLinkProfileId'], pnf_vlConns);
//				console.log(pnf_vlConns);
				for (var m in pnf_vlConns) {
					for (var n in vlProfiles) {
						if (pnf_vlConns[m] === vlProfiles[n]['virtualLinkProfileId']) {
							//TODO: add link
							var targetId = vlProfiles[n]['virtualLinkDescId'];
//							console.log(targetId);
							//cy.add({ group: 'edges', data: { source: pnfs[p], target: targetId, faveColor: '#6FB1FC', strength: 30 }});
							edges.push({ group: 'edges', data: { source: pnfs[p], target: targetId, faveColor: '#706f6f', strength: 70 }});
							//edges.push({ group: 'edges', data: { source: targetId, target: pnfs[p], faveColor: '#6FB1FC', strength: 70 }});
						}
					}
				}
			}
		}		
	}
	for (var i in vnfs) {
//		console.log(vnfs[i]);
		nodes.push({ group: 'nodes', data: { id: vnfs[i], name: 'VNF - ' + vnfs[i], label: 'VNF - ' + vnfs[i], weight: 70, faveColor: '#fff', faveShape: 'ellipse' }, classes: 'bottom-center vnf'});
		for (var h in vnfProfiles) {
			if (vnfProfiles[h]['vnfdId'].indexOf(vnfs[i]) >= 0) {
//				console.log(vnfProfiles[h]['vnfdId']);
				var vlConns = [];
				getValuesFromKeyPath(vnfProfiles[h], ['nsVirtualLinkConnectivity', 'virtualLinkProfileId'], vlConns);
//				console.log(vlConns);
				for (var g in vlConns) {
					for (var f in vlProfiles) {
						if (vlConns[g] === vlProfiles[f]['virtualLinkProfileId']) {
							//TODO: add link
							var targetId = vlProfiles[f]['virtualLinkDescId'];
//							console.log(targetId);
							//cy.add({ group: 'edges', data: { source: vnfs[i], target: targetId, faveColor: '#6FB1FC', strength: 30 }});
							edges.push({ group: 'edges', data: { source: vnfs[i], target: targetId, faveColor: '#706f6f', strength: 70 }});
							//edges.push({ group: 'edges', data: { source: targetId, target: vnfs[i], faveColor: '#6FB1FC', strength: 70 }});
						}
					}
				}
			}
		}
	}
	for (var j in saps) {
//		console.log(sapIds[j]);
		//cy.add({ group: 'nodes', data: { id: saps[j]['cpdId'], name: 'SAP - ' + saps[j]['cpdId'], weight: 10, faveColor: '#86B342', faveShape: 'ellipse' }});
		//cy.add({ group: 'edges', data: { source: saps[j]['cpdId'], target: saps[j]['nsVirtualLinkDescId'], faveColor: '#F5A45D', strength: 30 }, classes: 'questionable'});
		nodes.push({ group: 'nodes', data: { id: saps[j]['cpdId'], name: 'SAP - ' + saps[j]['cpdId'], label: 'SAP - ' + saps[j]['cpdId'], weight: 50, faveColor: '#fff', faveShape: 'ellipse'}, classes: 'bottom-center sap'});
		edges.push({ group: 'edges', data: { source: saps[j]['cpdId'], target: saps[j]['nsVirtualLinkDescId'], faveColor: '#000', strength: 70 }, classes: 'questionable'});
	}
	
	var cy = cytoscape({
		container: document.getElementById('cy'),

		layout: {
			name: 'cose',
			padding: 10,
		},

		style: cytoscape.stylesheet()
			.selector('node')
				.css({
					'shape': 'data(faveShape)',
					'content': 'data(name)',
					'text-valign': 'center',
					'text-outline-width': 0,
					'text-width': 2,
					//'text-outline-color': '#000',
					'background-color': 'data(faveColor)',
					'color': '#000',
					'label': 'data(name)'
				})
			.selector(':selected')
				.css({
					'border-width': 3,
					'border-color': '#333'
				})
			.selector('edge')
				.css({
					'curve-style': 'bezier',
					'opacity': 0.666,
					'width': 'mapData(strength, 70, 100, 2, 6)',
					'target-arrow-shape': 'circle',
					'source-arrow-shape': 'circle',
					'line-color': 'data(faveColor)',
					'source-arrow-color': 'data(faveColor)',
					'target-arrow-color': 'data(faveColor)'
				})
			.selector('edge.questionable')
				.css({
					'line-style': 'dotted',
					'target-arrow-shape': 'diamond',
					'source-arrow-shape': 'diamond'
				})
			.selector('.vnf')
				.css({
					'background-image': '../../images/vnf_icon_80.png',
					'width': 80,//'mapData(weight, 40, 80, 20, 60)',
					'height': 80
				})
			.selector('.pnf')
				.css({
					'background-image': '../../images/pnf_icon_80.png',
					'width': 80,//'mapData(weight, 40, 80, 20, 60)',
					'height': 80
				})
			.selector('.net')
				.css({
					'background-image': '../../images/net_icon_50.png',
					'width': 50,//'mapData(weight, 40, 80, 20, 60)',
					'height': 50
				})
			.selector('.sap')
				.css({
					'background-image': '../../images/sap_icon_grey_50.png',
					'width': 50,//'mapData(weight, 40, 80, 20, 60)',
					'height': 50
				})
			.selector('.faded')
				.css({
					'opacity': 0.25,
					'text-opacity': 0
				})
			.selector('.top-left')
				.css({
					'text-valign': 'top',
					'text-halign': 'left'
				})
			.selector('.top-right')
				.css({
					'text-valign': 'top',
					'text-halign': 'right'
				})
			.selector('.bottom-center')
				.css({
					'text-valign': 'bottom',
					'text-halign': 'center'
				}),

		elements: {
		  nodes: nodes,
		  edges: edges
		},

		ready: function(){
		  window.cy = this;
		}
	});
	
	//cy.minZoom(0.8);
	cy.maxZoom(1.6);
}


