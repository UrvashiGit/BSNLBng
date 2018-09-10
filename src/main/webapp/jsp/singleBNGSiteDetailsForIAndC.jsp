<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<script>
         
</script>

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
				<c:forEach var="entry" items="${singleMap}">
				
	<hr>

					<div id="siteSurvey">
						<c:if test="${'Site Survey' == entry.key}">
							<form method="post" action="updateSiteSurvey"
								name="updateBNGIAndC">
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
								<!-- Date logic based on Status (code pending)
									  -->
								CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="closeDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}"> 
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="targetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}"> 
									</br> 
									
								Survey Report :
								<a href="#"> <u> Details</u></a> </br>
							<%-- <c:if test="${entry.value.currentBNGOrderId() == entry.value.getOrderId}">
								<input type="submit" value="update" <c:if test="{empty aaa}">disabled="disabled" </c:if>>
							</c:if> --%>
							<input type="submit" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
							</form>
						</c:if>

					</div>


					<div id="siteReady">


						<c:if test="${'Site Ready' == entry.key}">
							<form method="post" action="" name="">
								<b><u> Site Ready </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select name="Status">
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
								
								CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="closeDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}"> 
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="targetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}"> 
									</br> 
								 </br>
									
									<input type="submit" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit  && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
							</form>
						</c:if>

					</div>


					<div id="matDelivery">


						<c:if test="${'Material Delivery' == entry.key}">
							<form method="post" action="" name="">
								<b><u> Material Delivery </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select name="Status">
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
								
								CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="closeDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}"> 
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="targetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}"> 
									</br> 
								</br> Challan
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : <a href="#"> <u>
										Details</u></a> </br>
							
							<input type="submit" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
							</form>
						</c:if>

					</div>



					<div id="powerOn">


						<c:if test="${'Power On' == entry.key}">
							<form method="post" action="" name="">
								<b><u> Power On </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select name="Status">
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

								CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="closeDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}"> 
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="targetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}"> 
									</br> 
								</br>
							<input type="submit" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit  && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
							</form>
						</c:if>

					</div>


					<div id="nwIntegration">


						<c:if test="${'NW Integration' == entry.key}">
							<form method="post" action="" name="">
								<b><u> NW Integration</u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select name="Status">
									<option value="Completed"
										<c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="InProgress"
										<c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress
									</option>
								</select> </br> CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="closeDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}"> 
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="targetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}"> 
									</br> 
							<input type="submit" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit  && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
							</form>
						</c:if>

					</div>


					<div id="AT">


						<c:if test="${'AT' == entry.key}">
							<form method="post" action="" name="">
								<b><u> AT </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select name="Status">
									<option value="Completed"
										<c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="InProgress"
										<c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress
									</option>
								</select> </br> CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="closeDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}"> 
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="targetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}"> 
									</br> 
							<input type="submit" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit  && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
							</form>
						</c:if>

					</div>


					<div id="commisioning">


						<c:if test="${'Commissinong' == entry.key}">
							<form method="post" action="" name="">
								<b><u> Commissioning </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select name="Status">
									<option value="Completed"
										<c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="InProgress"
										<c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress
									</option>
								</select> </br> CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="closeDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}"> 
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="targetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}"> 
									</br>  </br>
							<input type="submit" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit  && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
							
							</form>
						</c:if>

					</div>


					<div id="ATC">


						<c:if test="${'ATC' == entry.key}">
							<form method="post" action="" name="">
								<b><u> ATC </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<select name="Status">
									<option value="Completed"
										<c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="InProgress"
										<c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress
									</option>
								</select> </br>CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="closeDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}"> 
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="targetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}"> 
									</br> </br> Certificate
								&nbsp;&nbsp;&nbsp; : <a href="#"> <u> Details</u></a> </br>
							<input type="submit" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit  && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
							</form>
						</c:if>

					</div>



				</c:forEach>










			</div>
			</div>


			<%@include file="footer.jsp"%>

		</div>
</body>

</html>
