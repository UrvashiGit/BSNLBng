<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>


<!-- java script for validate form details (code pending) -->

<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>BSNL-BNG Installation And Commissioning</title>

</head>

<body id="page-top">
<c:set var = "stageLimit" value = "8"/>
	<%@include file="header.jsp"%>
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">
			<div style="display: none;color: red;" id="errorDiv"></div>
			<div style="color: green;font-style: bold;font-size: 11px">Note: Stage Can not be Modified, once it is Completed. </div>
				<c:forEach var="entry" items="${singleMap}">
				
	<hr>

					<div id="siteSurvey">
						<c:if test="${'Site Survey' == entry.key}">
							<form method="post" action="updateSiteSurvey"
								id="siteSurveyForm">
								<b><u> Site Survey </u></b> </br> Status :
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
								<%-- ${entry.value.getStatus()} --%>
								<input type="hidden" name="Status" value="${entry.value.getStatus()}">
								<input type="hidden" name=bngid value="${entry.value.getBngid()}">
								<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
								
								<select name="Status" disabled="disabled">
									<option value="Completed"${entry.value.getStatus() == 'Completed' ? 'selected="selected"' : ''}">Completed
									</option>
									<option value="Pending"${entry.value.getStatus() == 'Pending' ? 'selected="selected"' : ''}">Pending
									</option>
									<option value="InProgress"${entry.value.getStatus() == 'InProgress'? 'selected="selected"' : ''}">InProgress
									</option>
								</select> </br>
								
								CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="siteSurCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>">
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="siteSurTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}" onchange="resetSiteSurveyCloseDate()" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>"> 
									</br> 
									
								<%--Survey Report :
								<a href="#"> <u> Details</u></a> </br>
							 <c:if test="${entry.value.currentBNGOrderId() == entry.value.getOrderId}">
								<input type="submit" value="update" <c:if test="{empty aaa}">disabled="disabled" </c:if>>
							</c:if> --%>
							Remarks <b style="color: red">*</b> &nbsp;&nbsp;&nbsp; : <input type="text" name="remark" maxlength="500" required="required" value="${entry.value.getRemark()}" id="siteSurRemark"
							 <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>" > 
							</br> 
							<c:if test="${entry.value.getStatus() != 'Completed'}">
								 <input type="button" value="update" onclick="ValidateSiteSurveyForm()" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
							</c:if>
							
							
							</form>
						</c:if>

					</div>


					<div id="siteReady">


						<c:if test="${'Site Ready' == entry.key}">
							<form method="post" action="updateSiteReady" name="" id="siteReadyForm">
							<input type="hidden" name="Status" value="${entry.value.getStatus()}">
								<input type="hidden" name=bngid value="${entry.value.getBngid()}">
								<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
								
								<b><u> Site Ready </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select  disabled="disabled">
									<option value="Completed"
										<c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="InProgress"
										<c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress
									</option>
								</select> </br> 
								
								CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" id="siteReadyCloseDate" name="closeDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>">
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="siteReadyTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>"> 
									</br> 
								 </br>
								
									Remarks &nbsp;&nbsp;&nbsp; : <input type="text" name="remark" maxlength="500" required="required" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>" > 
							</br>
									
								<c:if test="${entry.value.getStatus() != 'Completed'}">
									<input type="button" onclick="ValidateSiteReadyForm()" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit  && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
								</c:if>
								
								
							</form>
						</c:if>

					</div>


					<div id="matDelivery">


						<c:if test="${'Material Delivery' == entry.key}">
							<form method="post" action="updateMD" name="" id="MDForm">
								<input type="hidden" name="Status" value="${entry.value.getStatus()}">
								<input type="hidden" name=bngid value="${entry.value.getBngid()}">
								<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
								<b><u> Material Delivery </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select disabled="disabled">
									<option value="Completed"
										<c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="InProgress"
										<c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress
									</option>
								</select> </br> 
								
								CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="MDCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>">  
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="MDTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>">  
									</br> 
								<!-- </br> Challan
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : <a href="#"> <u>
										Details</u></a> </br> -->
											Remarks &nbsp;&nbsp;&nbsp; : <input type="text" name="remark" maxlength="500" required="required" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>" > 
							</br>
										
							<c:if test="${entry.value.getStatus() != 'Completed'}">
								<input type="button" onclick="ValidateMDForm()" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
								</c:if>
							</form>
						</c:if>

					</div>



					<div id="powerOn">


						<c:if test="${'Power On' == entry.key}">
							<form method="post" action="updatePowerOn" name="" id="powerOnForm">
								<input type="hidden" name="Status" value="${entry.value.getStatus()}">
								<input type="hidden" name=bngid value="${entry.value.getBngid()}">
								<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
								<b><u> Power On </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select disabled="disabled">
									<option value="Completed"
										<c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="InProgress"
										<c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress
									</option>
								</select> </br> 

								CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="powerOnCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>">  
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="powerOnTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>">  
									</br> 
								</br>
								Remarks &nbsp;&nbsp;&nbsp; : <input type="text" name="remark" maxlength="500" required="required" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>" > </br>
								<c:if test="${entry.value.getStatus() != 'Completed'}">
							<input type="button" onclick="ValidatePowerOnForm()" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit  && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
								</c:if>
								
							</form>
						</c:if>

					</div>


					<div id="nwIntegration">


						<c:if test="${'NW Integration' == entry.key}">
							<form method="post" action="updateNWI" name="" id="NWIForm">
								<input type="hidden" name="Status" value="${entry.value.getStatus()}">
								<input type="hidden" name=bngid value="${entry.value.getBngid()}">
								<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
								<b><u> NW Integration</u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select disabled="disabled">
									<option value="Completed"
										<c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="InProgress"
										<c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress
									</option>
								</select> </br> CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="NWIFormCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>">  
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="NWIFormTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>">  
									</br> 
									Remarks &nbsp;&nbsp;&nbsp; : <input type="text" name="remark" maxlength="500" required="required" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>" > <br>
							<c:if test="${entry.value.getStatus() != 'Completed'}">
							<input type="button" value="update" onclick="ValidateNWIForm()" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit  && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
								</c:if>
								
							</form>
						</c:if>

					</div>


					<div id="AT">


						<c:if test="${'AT' == entry.key}">
							<form method="post" action="updateAT" name="" id="ATForm">
								<input type="hidden" name="Status" value="${entry.value.getStatus()}">
								<input type="hidden" name=bngid value="${entry.value.getBngid()}">
								<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
								<b><u> AT </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select disabled="disabled">
									<option value="Completed"
										<c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="InProgress"
										<c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress
									</option>
								</select> </br> CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="ATFormCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>">  
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="ATFormTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>"> 
									</br> 
									Remarks &nbsp;&nbsp;&nbsp; : <input type="text" name="remark" maxlength="500" required="required" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>" > <br>
								
									<c:if test="${entry.value.getStatus() != 'Completed'}">
							<input type="button" onclick="ValidateATForm()" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit  && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
								</c:if>
								
							</form>
						</c:if>

					</div>


					<div id="commisioning">


						<c:if test="${'Commissinong' == entry.key}">
							<form method="post" action="updateCommissinong" name="" id="commissioningForm">
								<input type="hidden" name="Status" value="${entry.value.getStatus()}">
								<input type="hidden" name=bngid value="${entry.value.getBngid()}">
								<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
								<b><u> Commissioning </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select disabled="disabled">
									<option value="Completed"
										<c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="InProgress"
										<c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress
									</option>
								</select> </br> CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="commissioningCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>">  
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="commissioningTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>">  
									</br>  </br>
									Remarks &nbsp;&nbsp;&nbsp; : <input type="text" name="remark" maxlength="500" required="required" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>" > <br>
							<c:if test="${entry.value.getStatus() != 'Completed'}">
							<input type="button" value="update" onclick="ValidateCommissioningForm()"<c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit  && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
							</c:if>
							
							</form>
						</c:if>

					</div>


					<div id="ATC">


						<c:if test="${'ATC' == entry.key}">
							<form method="post" action="updateATC" name="" id="ATCForm">
								<input type="hidden" name="Status" value="${entry.value.getStatus()}">
								<input type="hidden" name=bngid value="${entry.value.getBngid()}">
								<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
								<b><u> ATC </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select disabled="disabled">
									<option value="Completed"
										<c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="InProgress"
										<c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress
									</option>
								</select> </br>CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="ATCCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>">  
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="ATCTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>"> 
									</br> <!-- </br> Certificate
								&nbsp;&nbsp;&nbsp; : <a href="#"> <u> Details</u></a> </br> -->
								Remarks &nbsp;&nbsp;&nbsp; : <input type="text" name="remark" maxlength="500" required="required" <c:if test="${entry.value.getStatus() == 'Completed'}">
								<c:out value="disabled='disabled'"/></c:if>" > <br>
							<c:if test="${entry.value.getStatus() != 'Completed'}">
							<input type="button" onclick="ValidateATCForm()" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit  && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
								</c:if>
								
							</form>
						</c:if>

					</div>



				</c:forEach>


			</div>
			</div>


			<%@include file="footer.jsp"%>

		</div>
</body>


<script type="text/javascript">
$( document ).ready(function() {
    console.log( "ready!" );
    
    var now = new Date(),
    minDateForAll = now.toISOString().substring(0,10);
	$('input[type="date"]').prop('min', minDateForAll);
	
	// Set Max close date value of all closedate  
	var tgDate = document.getElementById("siteSurTargetDate").value;
	console.log( tgDate );
	$("#siteSurCloseDate").prop('max', tgDate);
	

});


// Validate SiteSurvey
function ValidateSiteSurveyForm() {
	
	var clDate = document.getElementById("siteSurCloseDate").value;
	var tgDate = document.getElementById("siteSurTargetDate").value;
	var myTDate = new Date(tgDate);
	var myCDate = new Date(clDate);
	
	if(tgDate != '' /* && myTDate < myCDate */) {
		document.getElementById("siteSurveyForm").submit();
	}else{
		$("#errorDiv").show();
		 var now = new Date(),
		    minDateForAll = now.toISOString().substring(0,10);
			$('input[type="date"]').prop('min', minDateForAll);
		$("#errorDiv" ).text( "Please Select Proper Target Date");
	}
	
}
function ValidateSiteReadyForm() {
	
	var clDate = document.getElementById("siteReadyCloseDate").value;
	var tgDate = document.getElementById("siteReadyTargetDate").value;
	var myTDate = new Date(tgDate);
	var myCDate = new Date(clDate);
	
	if(tgDate != '') {
		document.getElementById("siteReadyForm").submit();
	}else{
		$("#errorDiv").show();
		 var now = new Date(),
		    minDateForAll = now.toISOString().substring(0,10);
			$('input[type="date"]').prop('min', minDateForAll);
		$("#errorDiv" ).text( "Please Select Proper Target Date");
	}
	
}
function ValidateMDForm() {
	
	var clDate = document.getElementById("MDCloseDate").value;
	var tgDate = document.getElementById("MDTargetDate").value;
	var myTDate = new Date(tgDate);
	var myCDate = new Date(clDate);
	
	if(tgDate != '') {
		document.getElementById("MDForm").submit();
	}else{
		$("#errorDiv").show();
		 var now = new Date(),
		    minDateForAll = now.toISOString().substring(0,10);
			$('input[type="date"]').prop('min', minDateForAll);
		$("#errorDiv" ).text( "Please Select Proper Target Date");
	}
	
}
function ValidatePowerOnForm() {
	
	var clDate = document.getElementById("powerOnCloseDate").value;
	var tgDate = document.getElementById("powerOnTargetDate").value;
	var myTDate = new Date(tgDate);
	var myCDate = new Date(clDate);
	
	if(tgDate != '') {
		document.getElementById("powerOnForm").submit();
	}else{
		$("#errorDiv").show();
		 var now = new Date(),
		    minDateForAll = now.toISOString().substring(0,10);
			$('input[type="date"]').prop('min', minDateForAll);
		$("#errorDiv" ).text( "Please Select Proper Target Date");
	}
	
}
function ValidateNWIForm() {
	
	var clDate = document.getElementById("NWIFormCloseDate").value;
	var tgDate = document.getElementById("NWIFormTargetDate").value;
	var myTDate = new Date(tgDate);
	var myCDate = new Date(clDate);
	
	if(tgDate != '') {
		document.getElementById("NWIForm").submit();
	}else{
		$("#errorDiv").show();
		 var now = new Date(),
		    minDateForAll = now.toISOString().substring(0,10);
			$('input[type="date"]').prop('min', minDateForAll);
		$("#errorDiv" ).text( "Please Select Proper Target Date");
	}
	
}
function ValidateATForm() {
	
	var clDate = document.getElementById("ATFormCloseDate").value;
	var tgDate = document.getElementById("ATFormTargetDate").value;
	var myTDate = new Date(tgDate);
	var myCDate = new Date(clDate);
	
	if(tgDate != '') {
		document.getElementById("ATForm").submit();
	}else{
		$("#errorDiv").show();
		 var now = new Date(),
		    minDateForAll = now.toISOString().substring(0,10);
			$('input[type="date"]').prop('min', minDateForAll);
		$("#errorDiv" ).text( "Please Select Proper Target Date");
	}
	
}
function ValidateCommissioningForm() {
	
	var clDate = document.getElementById("commissioningCloseDate").value;
	var tgDate = document.getElementById("commissioningTargetDate").value;
	var myTDate = new Date(tgDate);
	var myCDate = new Date(clDate);
	
	if(tgDate != '') {
		document.getElementById("commissioningForm").submit();
	}else{
		$("#errorDiv").show();
		 var now = new Date(),
		    minDateForAll = now.toISOString().substring(0,10);
			$('input[type="date"]').prop('min', minDateForAll);
		$("#errorDiv" ).text( "Please Select Proper Target Date");
	}
	
}
function ValidateATCForm() {
	
	var clDate = document.getElementById("ATCCloseDate").value;
	var tgDate = document.getElementById("ATCTargetDate").value;
	var myTDate = new Date(tgDate);
	var myCDate = new Date(clDate);
	
	if(tgDate != '') {
		document.getElementById("ATCForm").submit();
	}else{
		$("#errorDiv").show();
		 var now = new Date(),
		    minDateForAll = now.toISOString().substring(0,10);
			$('input[type="date"]').prop('min', minDateForAll);
		$("#errorDiv" ).text( "Please Select Proper Target Date");
	}
	
}


function resetSiteSurveyCloseDate() {
	var tgDate = document.getElementById("siteSurTargetDate").value;
	$('#siteSurCloseDate').prop('max', tgDate);
	$('#siteSurCloseDate').prop('min', tgDate);
}
         
</script>

</html>
