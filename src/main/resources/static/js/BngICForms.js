

// Validate SiteSurvey
function ValidateSiteSurveyForm() {
	
	var siteSurveyStatusDDValue = $('#siteSurveyStatusDD :selected').val();
	var clDate = document.getElementById("siteSurCloseDate").value;
	var tgDate = document.getElementById("siteSurTargetDate").value;
	$( "#errorDiv" ).find( "span" ).remove();
	if ($("#ssRemark1" ).val() == '') {
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Add Remark</span>';
		$("#errorDiv" ).append(errorMsg);
		
	}else if (siteSurveyStatusDDValue == 'In Progress' && tgDate == '') {
		$("#errorDiv").show();
		  var errorMsg = '<span class="errorMsg">Please Select Proper Target Date</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'Closed' && clDate == '') {
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Select Proper Close Date </span>';
		$("#errorDiv" ).append( errorMsg );
	}
	else{
		document.getElementById("siteSurveyForm").submit();
	}
	
}
//changeSiteSurStatus
function changeSiteSurStatus() {
	var value = $('#siteSurveyStatusDD :selected').val();
	if(value == 'Pending'){
	
	}else if(value == 'In Progress'){
		$( "#siteSurTargetDate" ).prop( "disabled", false );
		$( "#siteSurCloseDate" ).prop( "disabled", true );
	}else if(value == 'Closed'){
		var tgDate = document.getElementById("siteSurTargetDate").value;
		console.log( tgDate );
		$( "#siteSurCloseDate" ).prop( "disabled", false );
		$( "#siteSurTargetDate" ).prop( "disabled", true );
		
	}
}

//Validate site ready
function ValidateSiteReadyForm() {
	
	var siteSurveyStatusDDValue = $('#siteReadyStatusDD :selected').val();
	var clDate = document.getElementById("siteReadyCloseDate").value;
	var tgDate = document.getElementById("siteReadyTargetDate").value;
	$( "#errorDiv" ).find( "span" ).remove();
	if ($("#ssRemark2" ).val() == '') {
	    
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Add Remark</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'In Progress' && tgDate == '') {
		$("#errorDiv").show();
		  var errorMsg = '<span class="errorMsg">Please Select Proper Target Date</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'Closed' && clDate == '') {
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Select Proper Close Date </span>';
		$("#errorDiv" ).append( errorMsg );
	}
	else{
		document.getElementById("siteReadyForm").submit();
	}
	
}
//changeSiteReadyStatus
function changeSiteReadyStatus() {
	var value = $('#siteReadyStatusDD :selected').val();
	if(value == 'Pending'){
	
	}else if(value == 'In Progress'){
		$( "#siteReadyTargetDate" ).prop( "disabled", false );
		$( "#siteReadyCloseDate" ).prop( "disabled", true );
	}else if(value == 'Closed'){
		var tgDate = document.getElementById("siteReadyTargetDate").value;
		console.log( tgDate );
		$( "#siteReadyCloseDate" ).prop( "disabled", false );
		$( "#siteReadyTargetDate" ).prop( "disabled", true );
		
	}
}

//Validate MD
function ValidateMDForm() {
	
	var siteSurveyStatusDDValue = $('#MDStatusDD :selected').val();
	var clDate = document.getElementById("MDCloseDate").value;
	var tgDate = document.getElementById("MDTargetDate").value;
	$( "#errorDiv" ).find( "span" ).remove();
	if ($("#ssRemark3" ).val() == '') {
	    
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Add Remark</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'In Progress' && tgDate == '') {
		$("#errorDiv").show();
		  var errorMsg = '<span class="errorMsg">Please Select Proper Target Date</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'Closed' && clDate == '') {
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Select Proper Close Date </span>';
		$("#errorDiv" ).append( errorMsg );
	}
	else{
		document.getElementById("MDForm").submit();
	}
	
}
//change MD STATUS
function changeMDStatus() {
	var value = $('#MDStatusDD :selected').val();
	if(value == 'Pending'){
	
	}else if(value == 'In Progress'){
		$( "#MDTargetDate" ).prop( "disabled", false );
		$( "#MDCloseDate" ).prop( "disabled", true );
	}else if(value == 'Closed'){
		var tgDate = document.getElementById("MDTargetDate").value;
	//	console.log( tgDate );
		$( "#MDCloseDate" ).prop( "disabled", false );
		$( "#MDTargetDate" ).prop( "disabled", true );
		
	}
}
 
//power on
//Validate powerOn
function ValidatepowerOnForm() {
	
	var siteSurveyStatusDDValue = $('#powerOnStatusDD :selected').val();
	var clDate = document.getElementById("powerOnCloseDate").value;
	var tgDate = document.getElementById("powerOnTargetDate").value;
	$( "#errorDiv" ).find( "span" ).remove();
	
	if ($("#ssRemark4" ).val() == '') {
	    
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Add Remark</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'In Progress' && tgDate == '') {
		$("#errorDiv").show();
		  var errorMsg = '<span class="errorMsg">Please Select Proper Target Date</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'Closed' && clDate == '') {
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Select Proper Close Date </span>';
		$("#errorDiv" ).append( errorMsg );
	}
	else{
		document.getElementById("powerOnForm").submit();
	}
	
}
//change powerOn STATUS
function changepowerOnStatus() {
	var value = $('#powerOnStatusDD :selected').val();
	if(value == 'Pending'){
	
	}else if(value == 'In Progress'){
		$( "#powerOnTargetDate" ).prop( "disabled", false );
		$( "#powerOnCloseDate" ).prop( "disabled", true );
	}else if(value == 'Closed'){
		var tgDate = document.getElementById("powerOnTargetDate").value;
	//	console.log( tgDate );
		$( "#powerOnCloseDate" ).prop( "disabled", false );
		$( "#powerOnTargetDate" ).prop( "disabled", true );
		
	}
}

//Validate NWI
function ValidateNWIForm() {
	
	var siteSurveyStatusDDValue = $('#NWIStatusDD :selected').val();
	var clDate = document.getElementById("NWICloseDate").value;
	var tgDate = document.getElementById("NWITargetDate").value;
	$( "#errorDiv" ).find( "span" ).remove();
	
	if ($("#ssRemark5" ).val() == '') {
	    
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Add Remark</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'In Progress' && tgDate == '') {
		$("#errorDiv").show();
		  var errorMsg = '<span class="errorMsg">Please Select Proper Target Date</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'Closed' && clDate == '') {
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Select Proper Close Date </span>';
		$("#errorDiv" ).append( errorMsg );
	}
	else{
		document.getElementById("NWIForm").submit();
	}
	
}
//change NWI STATUS
function changeNWIStatus() {
	var value = $('#NWIStatusDD :selected').val();
	if(value == 'Pending'){
	
	}else if(value == 'In Progress'){
		$( "#NWITargetDate" ).prop( "disabled", false );
		$( "#NWICloseDate" ).prop( "disabled", true );
	}else if(value == 'Closed'){
		var tgDate = document.getElementById("NWITargetDate").value;
	//	console.log( tgDate );
		$( "#NWICloseDate" ).prop( "disabled", false );
		$( "#NWITargetDate" ).prop( "disabled", true );
		
	}
}

//Validate AT
function ValidateATForm() {
	
	var siteSurveyStatusDDValue = $('#ATStatusDD :selected').val();
	var clDate = document.getElementById("ATCloseDate").value;
	var tgDate = document.getElementById("ATTargetDate").value;
	$( "#errorDiv" ).find( "span" ).remove();
	if ($("#ssRemark6" ).val() == '') {
	    
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Add Remark</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'In Progress' && tgDate == '') {
		$("#errorDiv").show();
		  var errorMsg = '<span class="errorMsg">Please Select Proper Target Date</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'Closed' && clDate == '') {
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Select Proper Close Date </span>';
		$("#errorDiv" ).append( errorMsg );
	}
	else{
		document.getElementById("ATForm").submit();
	}
	
}
//change AT STATUS
function changeATStatus() {
	var value = $('#ATStatusDD :selected').val();
	if(value == 'Pending'){
	
	}else if(value == 'In Progress'){
		$( "#ATTargetDate" ).prop( "disabled", false );
		$( "#ATCloseDate" ).prop( "disabled", true );
	}else if(value == 'Closed'){
		var tgDate = document.getElementById("ATTargetDate").value;
	//	console.log( tgDate );
		$( "#ATCloseDate" ).prop( "disabled", false );
		$( "#ATTargetDate" ).prop( "disabled", true );
		
	}
}


//Validate commissioning
function ValidatecommissioningForm() {
	
	var siteSurveyStatusDDValue = $('#commissioningStatusDD :selected').val();
	var clDate = document.getElementById("commissioningCloseDate").value;
	var tgDate = document.getElementById("commissioningTargetDate").value;
	$( "#errorDiv" ).find( "span" ).remove();
	if ($("#ssRemark7" ).val() == '') {
	    
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Add Remark</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'In Progress' && tgDate == '') {
		$("#errorDiv").show();
		  var errorMsg = '<span class="errorMsg">Please Select Proper Target Date</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'Closed' && clDate == '') {
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Select Proper Close Date </span>';
		$("#errorDiv" ).append( errorMsg );
	}
	else{
		document.getElementById("commissioningForm").submit();
	}
	
}
//change commissioning STATUS
function changecommissioningStatus() {
	var value = $('#commissioningStatusDD :selected').val();
	if(value == 'Pending'){
	
	}else if(value == 'In Progress'){
		$( "#commissioningTargetDate" ).prop( "disabled", false );
		$( "#commissioningCloseDate" ).prop( "disabled", true );
	}else if(value == 'Closed'){
		var tgDate = document.getElementById("commissioningTargetDate").value;
	//	console.log( tgDate );
		$( "#commissioningCloseDate" ).prop( "disabled", false );
		$( "#commissioningTargetDate" ).prop( "disabled", true );
		
	}
}

//Validate ATC
function ValidateATCForm() {
	
	var siteSurveyStatusDDValue = $('#ATCStatusDD :selected').val();
	var clDate = document.getElementById("ATCCloseDate").value;
	var tgDate = document.getElementById("ATCTargetDate").value;
	$( "#errorDiv" ).find( "span" ).remove();
	if ($("#ssRemark8" ).val() == '') {
	    
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Add Remark</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'In Progress' && tgDate == '') {
		$("#errorDiv").show();
		  var errorMsg = '<span class="errorMsg">Please Select Proper Target Date</span>';
		$("#errorDiv" ).append(errorMsg);
	}else if (siteSurveyStatusDDValue == 'Closed' && clDate == '') {
		$("#errorDiv").show();
		var errorMsg = '<span class="errorMsg">Please Select Proper Close Date </span>';
		$("#errorDiv" ).append( errorMsg );
	}
	else{
		document.getElementById("ATCForm").submit();
	}
	
}
//change ATC STATCUS
function changeATCStatus() {
	var value = $('#ATCStatusDD :selected').val();
	if(value == 'Pending'){
	
	}else if(value == 'In Progress'){
		$( "#ATCTargetDate" ).prop( "disabled", false );
		$( "#ATCCloseDate" ).prop( "disabled", true );
	}else if(value == 'Closed'){
		var tgDate = document.getElementById("ATCTargetDate").value;
	//	console.log( tgDate );
		$( "#ATCCloseDate" ).prop( "disabled", false );
		$( "#ATCTargetDate" ).prop( "disabled", true );
		
	}
}


$(".close").click(function(){
	$( "#errorDiv" ).find( "span" ).remove();
	$( "#errorDiv" ).hide();
});

