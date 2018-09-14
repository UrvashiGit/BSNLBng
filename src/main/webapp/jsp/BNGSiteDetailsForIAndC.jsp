
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

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
				
				<c:if test="${successMsg != null}">
					<div class="alert alert-success alert-dismissible" style="font-size: 12px;" id="successMsgDiv">
					 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> 
							${successMsg}
					</div>
				</c:if>
				
				<div style="display: none;font-size: 12px;" class="alert alert-danger" id="errorDiv">
					<a href="#" class="close clErr" >&times;</a> 
				</div>


				<%-- <div style="display: none;color: red;" id="errorDiv"></div>
			<div style="color: blue;" id="successDiv">
				<b>${successMsg}</b>
			</div> --%>
			<div style="color: green;font-style: bold;font-size: 11px">Note: Stage Can not be Modified, once it is Closed. </div>
			
				<br>
			<h6>&nbsp;&nbsp;&nbsp;BNG ID :  <c:out value = "${singleMap.get('Site Survey').getBngid()}"/></h6>
				
				<c:forEach var="entry" items="${singleMap}">
				<hr>
					<div id="siteSurvey">
						<c:if test="${'Site Survey' == entry.key}">
							<form method="post" action="updateSiteSurvey" id="siteSurveyForm">
							<input type="hidden" name="currentStatus" value="${entry.value.getStatus()}" id="currentStatus">
							<input type="hidden" name=bngid value="${entry.value.getBngid()}">
							<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
							<input type="hidden" name="currentBNGOrderId" value="${entry.value.getCurrentBNGOrderId()}">
							<b>Site Survey</b> <br> 
							<table>
								<tr>
									<td>Status : &nbsp;&nbsp;</td>
									<td>
										<select name="Status" onchange="changeSiteSurStatus()" id="siteSurveyStatusDD" 
										<c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
											<option value="Closed"${entry.value.getStatus() == 'Closed' ? 'selected="selected"' : ''}">Closed
											</option>
											<option value="Pending"${entry.value.getStatus() == 'Pending' ? 'selected="selected"' : ''}">Pending
											</option>
											<option value="In Progress"${entry.value.getStatus() == 'In Progress'? 'selected="selected"' : ''}">In Progress
											</option>
										</select> 
									</td>
								</tr>
								
								<tr>
									<td>CloseDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="closeDate" id="siteSurCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getCloseDate()}" 
										<c:if test="${entry.value.getStatus() == 'Closed' || entry.value.getStatus() == 'Pending' || entry.value.getStatus() == 'In Progress'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>TargetDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="targetDate" id="siteSurTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getTargetDate()}"  <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>Remark <b style="color: red">*</b> : &nbsp;&nbsp;</td>
									<td>
										<input type="text" name="remark" maxlength="500" required="required" id="ssRemark1" value="${entry.value.getRemark()}" 
							 			<c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>" > 
									</td>
								</tr>
								
								<tr>
									<td>
										<c:if test="${entry.value.getStatus() != 'Closed'}">
								 		<input type="button" value="update" onclick="ValidateSiteSurveyForm()">
										</c:if>
									</td>
									<td></td>
								</tr>
							</table>
							</form>
						</c:if>
					</div>
					
					<div id="siteReady">
						<c:if test="${'Site Ready' == entry.key}">
							<form method="post" action="updateSiteReady" id="siteReadyForm">
							<input type="hidden" name=bngid value="${entry.value.getBngid()}">
							<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
							<input type="hidden" name="currentBNGOrderId" value="${entry.value.getCurrentBNGOrderId()}">
							<b>Site Ready</b> <br> 
							<table>
								<tr>
									<td>Status : &nbsp;&nbsp;</td>
									<td>
										<select name="Status" onchange="changeSiteReadyStatus()" id="siteReadyStatusDD" <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
											<option value="Closed"${entry.value.getStatus() == 'Closed' ? 'selected="selected"' : ''}">Closed
											</option>
											<option value="Pending"${entry.value.getStatus() == 'Pending' ? 'selected="selected"' : ''}">Pending
											</option>
											<option value="In Progress"${entry.value.getStatus() == 'In Progress'? 'selected="selected"' : ''}">In Progress
											</option>
										</select> 
									</td>
								</tr>
								
								<tr>
									<td>CloseDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="closeDate" id="siteReadyCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getCloseDate()}" 
										<c:if test="${entry.value.getStatus() == 'Closed' || entry.value.getStatus() == 'Pending' || entry.value.getStatus() == 'In Progress'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>TargetDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="targetDate" id="siteReadyTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getTargetDate()}"  <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>Remark <b style="color: red">*</b> : &nbsp;&nbsp;</td>
									<td>
										<input type="text" name="remark" maxlength="500" required="required" id="ssRemark2" value="${entry.value.getRemark()}" 
							 			<c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>" > 
									</td>
								</tr>
								
								<tr>
									<td>
										<c:if test="${entry.value.getStatus() != 'Closed'}">
								 		<input type="button" value="update" onclick="ValidateSiteReadyForm()">
										</c:if>
									</td>
									<td></td>
								</tr>
							</table>
							</form>
						</c:if>
					</div>
					
					<div id="materialDel">
						<c:if test="${'Material Delivery' == entry.key}">
							<form method="post" action="updateMD" name="" id="MDForm">
							<input type="hidden" name=bngid value="${entry.value.getBngid()}">
							<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
							<input type="hidden" name="currentBNGOrderId" value="${entry.value.getCurrentBNGOrderId()}">
							<b>Material Delivery</b> <br> 
							<table>
								<tr>
									<td>Status : &nbsp;&nbsp;</td>
									<td>
										<select name="Status" onchange="changeMDStatus()" id="MDStatusDD" <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
											<option value="Closed"${entry.value.getStatus() == 'Closed' ? 'selected="selected"' : ''}">Closed
											</option>
											<option value="Pending"${entry.value.getStatus() == 'Pending' ? 'selected="selected"' : ''}">Pending
											</option>
											<option value="In Progress"${entry.value.getStatus() == 'In Progress'? 'selected="selected"' : ''}">In Progress
											</option>
										</select> 
									</td>
								</tr>
								
								<tr>
									<td>CloseDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="closeDate" id="MDCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getCloseDate()}" 
										<c:if test="${entry.value.getStatus() == 'Closed' || entry.value.getStatus() == 'Pending' || entry.value.getStatus() == 'In Progress'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>TargetDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="targetDate" id="MDTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getTargetDate()}"  <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>Remark <b style="color: red">*</b> : &nbsp;&nbsp;</td>
									<td>
										<input type="text" name="remark" maxlength="500" required="required" id="ssRemark3" value="${entry.value.getRemark()}" 
							 			<c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>" > 
									</td>
								</tr>
								
								<tr>
									<td>
										<c:if test="${entry.value.getStatus() != 'Closed'}">
								 		<input type="button" value="update" onclick="ValidateMDForm()">
										</c:if>
									</td>
									<td></td>
								</tr>
							</table>
							</form>
						</c:if>
					</div>
					
					<div id="powerOn">
						<c:if test="${'Power On' == entry.key}">
							<form method="post" action="updatePowerOn" name="" id="powerOnForm">
							<input type="hidden" name=bngid value="${entry.value.getBngid()}">
							<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
							<input type="hidden" name="currentBNGOrderId" value="${entry.value.getCurrentBNGOrderId()}">
							<b>Power On</b> <br> 
							<table>
								<tr>
									<td>Status : &nbsp;&nbsp;</td>
									<td>
										<select name="Status" onchange="changepowerOnStatus()" id="powerOnStatusDD" <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
											<option value="Closed"${entry.value.getStatus() == 'Closed' ? 'selected="selected"' : ''}">Closed
											</option>
											<option value="Pending"${entry.value.getStatus() == 'Pending' ? 'selected="selected"' : ''}">Pending
											</option>
											<option value="In Progress"${entry.value.getStatus() == 'In Progress'? 'selected="selected"' : ''}">In Progress
											</option>
										</select> 
									</td>
								</tr>
								
								<tr>
									<td>CloseDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="closeDate" id="powerOnCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getCloseDate()}" 
										<c:if test="${entry.value.getStatus() == 'Closed' || entry.value.getStatus() == 'Pending' || entry.value.getStatus() == 'In Progress'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>TargetDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="targetDate" id="powerOnTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getTargetDate()}"  <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>Remark <b style="color: red">*</b> : &nbsp;&nbsp;</td>
									<td>
										<input type="text" name="remark" maxlength="500" required="required" id="ssRemark4" value="${entry.value.getRemark()}" 
							 			<c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>" > 
									</td>
								</tr>
								
								<tr>
									<td>
										<c:if test="${entry.value.getStatus() != 'Closed'}">
								 		<input type="button" value="update" onclick="ValidatepowerOnForm()">
										</c:if>
									</td>
									<td></td>
								</tr>
							</table>
							</form>
						</c:if>
					</div>
					

					<div id="nwIntegration">
						<c:if test="${'NW Integration' == entry.key}">
							<form method="post" action="updateNWI" name="" id="NWIForm">
							<input type="hidden" name=bngid value="${entry.value.getBngid()}">
							<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
							<input type="hidden" name="currentBNGOrderId" value="${entry.value.getCurrentBNGOrderId()}">
							<b>NW Integration</b> <br> 
							<table>
								<tr>
									<td>Status : &nbsp;&nbsp;</td>
									<td>
										<select name="Status" onchange="changeNWIStatus()" id="NWIStatusDD" <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
											<option value="Closed"${entry.value.getStatus() == 'Closed' ? 'selected="selected"' : ''}">Closed
											</option>
											<option value="Pending"${entry.value.getStatus() == 'Pending' ? 'selected="selected"' : ''}">Pending
											</option>
											<option value="In Progress"${entry.value.getStatus() == 'In Progress'? 'selected="selected"' : ''}">In Progress
											</option>
										</select> 
									</td>
								</tr>
								
								<tr>
									<td>CloseDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="closeDate" id="NWICloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getCloseDate()}" 
										<c:if test="${entry.value.getStatus() == 'Closed' || entry.value.getStatus() == 'Pending' || entry.value.getStatus() == 'In Progress'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>TargetDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="targetDate" id="NWITargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getTargetDate()}"  <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>Remark <b style="color: red">*</b> : &nbsp;&nbsp;</td>
									<td>
										<input type="text" name="remark" maxlength="500" required="required" id="ssRemark5" value="${entry.value.getRemark()}" 
							 			<c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>" > 
									</td>
								</tr>
								
								<tr>
									<td>
										<c:if test="${entry.value.getStatus() != 'Closed'}">
								 		<input type="button" value="update" onclick="ValidateNWIForm()">
										</c:if>
									</td>
									<td></td>
								</tr>
							</table>
							</form>
						</c:if>
					</div>
					
					<div id="AT">
						<c:if test="${'AT' == entry.key}">
							<form method="post" action="updateAT" name="" id="ATForm">
							<input type="hidden" name=bngid value="${entry.value.getBngid()}">
							<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
							<input type="hidden" name="currentBNGOrderId" value="${entry.value.getCurrentBNGOrderId()}">
							<b>AT</b> <br> 
							<table>
								<tr>
									<td>Status : &nbsp;&nbsp;</td>
									<td>
										<select name="Status" onchange="changeATStatus()" id="ATStatusDD" <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
											<option value="Closed"${entry.value.getStatus() == 'Closed' ? 'selected="selected"' : ''}">Closed
											</option>
											<option value="Pending"${entry.value.getStatus() == 'Pending' ? 'selected="selected"' : ''}">Pending
											</option>
											<option value="In Progress"${entry.value.getStatus() == 'In Progress'? 'selected="selected"' : ''}">In Progress
											</option>
										</select> 
									</td>
								</tr>
								
								<tr>
									<td>CloseDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="closeDate" id="ATCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getCloseDate()}" 
										<c:if test="${entry.value.getStatus() == 'Closed' || entry.value.getStatus() == 'Pending' || entry.value.getStatus() == 'In Progress'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>TargetDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="targetDate" id="ATTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getTargetDate()}"  <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>Remark <b style="color: red">*</b> : &nbsp;&nbsp;</td>
									<td>
										<input type="text" name="remark" maxlength="500" required="required" id="ssRemark6" value="${entry.value.getRemark()}" 
							 			<c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>" > 
									</td>
								</tr>
								
								<tr>
									<td>
										<c:if test="${entry.value.getStatus() != 'Closed'}">
								 		<input type="button" value="update" onclick="ValidateATForm()">
										</c:if>
									</td>
									<td></td>
								</tr>
							</table>
							</form>
						</c:if>
					</div>
					
					
					<div id="commissioning">
						<c:if test="${'Commissinong' == entry.key}">
							<form method="post" action="updateCommissioning" name="" id="commissioningForm">
							<input type="hidden" name=bngid value="${entry.value.getBngid()}">
							<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
							<input type="hidden" name="currentBNGOrderId" value="${entry.value.getCurrentBNGOrderId()}">
							<b>Commissioning</b> <br> 
							<table>
								<tr>
									<td>Status : &nbsp;&nbsp;</td>
									<td>
										<select name="Status" onchange="changecommissioningStatus()" id="commissioningStatusDD" <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
											<option value="Closed"${entry.value.getStatus() == 'Closed' ? 'selected="selected"' : ''}">Closed
											</option>
											<option value="Pending"${entry.value.getStatus() == 'Pending' ? 'selected="selected"' : ''}">Pending
											</option>
											<option value="In Progress"${entry.value.getStatus() == 'In Progress'? 'selected="selected"' : ''}">In Progress
											</option>
										</select> 
									</td>
								</tr>
								
								<tr>
									<td>CloseDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="closeDate" id="commissioningCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getCloseDate()}" 
										<c:if test="${entry.value.getStatus() == 'Closed' || entry.value.getStatus() == 'Pending' || entry.value.getStatus() == 'In Progress'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>TargetDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="targetDate" id="commissioningTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getTargetDate()}"  <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>Remark <b style="color: red">*</b> : &nbsp;&nbsp;</td>
									<td>
										<input type="text" name="remark" maxlength="500" required="required" id="ssRemark7" value="${entry.value.getRemark()}" 
							 			<c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>" > 
									</td>
								</tr>
								
								<tr>
									<td>
										<c:if test="${entry.value.getStatus() != 'Closed'}">
								 		<input type="button" value="update" onclick="ValidatecommissioningForm()">
										</c:if>
									</td>
									<td></td>
								</tr>
							</table>
							</form>
						</c:if>
					</div>
					
					<div id="ATC">
						<c:if test="${'ATC' == entry.key}">
							<form method="post" action="updateATC" name="" id="ATCForm">
							<input type="hidden" name=bngid value="${entry.value.getBngid()}">
							<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
							<input type="hidden" name="currentBNGOrderId" value="${entry.value.getCurrentBNGOrderId()}">
							<b>ATC</b> <br> 
							<table>
								<tr>
									<td>Status : &nbsp;&nbsp;</td>
									<td>
										<select name="Status" onchange="changeATCStatus()" id="ATCStatusDD" <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
											<option value="Closed"${entry.value.getStatus() == 'Closed' ? 'selected="selected"' : ''}">Closed
											</option>
											<option value="Pending"${entry.value.getStatus() == 'Pending' ? 'selected="selected"' : ''}">Pending
											</option>
											<option value="In Progress"${entry.value.getStatus() == 'In Progress'? 'selected="selected"' : ''}">In Progress
											</option>
										</select> 
									</td>
								</tr>
								
								<tr>
									<td>CloseDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="closeDate" id="ATCCloseDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getCloseDate()}" 
										<c:if test="${entry.value.getStatus() == 'Closed' || entry.value.getStatus() == 'Pending' || entry.value.getStatus() == 'In Progress'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>TargetDate : &nbsp;&nbsp;</td>
									<td>
										<input type="date" name="targetDate" id="ATCTargetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
										value="${entry.value.getTargetDate()}"  <c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>">
									</td>
								</tr>
								
								<tr>
									<td>Remark <b style="color: red">*</b> : &nbsp;&nbsp;</td>
									<td>
										<input type="text" name="remark" maxlength="500" required="required" id="ssRemark8" value="${entry.value.getRemark()}" 
							 			<c:if test="${entry.value.getStatus() == 'Closed'}">
										<c:out value="disabled='disabled'"/></c:if>" > 
									</td>
								</tr>
								
								<tr>
									<td>
										<c:if test="${entry.value.getStatus() != 'Closed'}">
								 		<input type="button" value="update" onclick="ValidateATCForm()">
										</c:if>
									</td>
									<td></td>
								</tr>
							</table>
							</form>
						</c:if>
					</div>
					
				</c:forEach>
			</div>
			</div>
			<%@include file="footer.jsp"%>

		</div>
		<script src="js/BngICForms.js"></script>
</body>


<script type="text/javascript">
$( document ).ready(function() {

    // Do not allow to select past date for all datepicker
    var now = new Date(),
    minDateForAll = now.toISOString().substring(0,10);
	$('input[id *="TargetDate"]').prop('min', minDateForAll);
	$('input[id *="CloseDate"]').prop('max', minDateForAll);
	
});



         
</script>
