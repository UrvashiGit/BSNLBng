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

<title>BSNL-BNG Invoicing</title>

</head>

<body id="page-top">
<c:set var = "stageLimit" value = "4"/>
	<%@include file="header.jsp"%>
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="sidebar.jsp"%>

		<div id="content-wrapper">
		<h6>&nbsp;&nbsp;&nbsp;BNG ID :  <c:out value = "${singleMap.get('ERP PO').getBngid()}"/></h6>
			<div class="container-fluid">
				<c:forEach var="entry" items="${singleMap}">
				
	<hr>

					<div id="erpPo">
						<c:if test="${'ERP PO' == entry.key}">
							<form method="post" action="updateERPPO"
								name="">
								<b><u> ERP PO </u></b> </br> Status :
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
								<%-- ${entry.value.getStatus()} --%>
								<input type="hidden" name="Status" value="${entry.value.getStatus()}">
								<input type="hidden" name=bngid value="${entry.value.getBngid()}">
								<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
								<select name="Status" disabled="disabled">
									<option value="Closed"${entry.value.getStatus() == 'Closed' ? 'selected="selected"' : ''}">Closed
									</option>
									<option value="Pending"${entry.value.getStatus() == 'Pending' ? 'selected="selected"' : ''}">Pending
									</option>
									<option value="In Progress"${entry.value.getStatus() == 'In Progress'? 'selected="selected"' : ''}">In Progress
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
									
							
							
							<input type="submit" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
							</form>
						</c:if>

					</div>


					<div id="migo">


						<c:if test="${'MIGO' == entry.key}">
							<form method="post" action="updateMIGO" name="">
								<b><u> MIGO </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<input type="hidden" name="Status" value="${entry.value.getStatus()}">
								<input type="hidden" name=bngid value="${entry.value.getBngid()}">
								<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
								<select name="Status">
									<option value="Closed"
										<c:if test="${entry.value.getStatus() eq 'Closed'}">selected</c:if>>Closed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="In Progress"
										<c:if test="${entry.value.getStatus() eq 'In Progress'}">selected</c:if>>In Progress
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


					<div id="miro">


						<c:if test="${'MIRO' == entry.key}">
							<form method="post" action="updateMIRO" name="">
								<b><u> MIRO </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<input type="hidden" name="Status" value="${entry.value.getStatus()}">
								<input type="hidden" name=bngid value="${entry.value.getBngid()}">
								<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
								<select name="Status">
									<option value="Closed"
										<c:if test="${entry.value.getStatus() eq 'Closed'}">selected</c:if>>Closed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="In Progress"
										<c:if test="${entry.value.getStatus() eq 'In Progress'}">selected</c:if>>In Progress
									</option>
								</select> </br> 
								
								CloseDate &nbsp;&nbsp;&nbsp; : <input type="date" name="closeDate" id="closeDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getCloseDate()}"> 
									
								</br> 
								
								TargetDate &nbsp;&nbsp;&nbsp; : <input type="date" name="targetDate" id="targetDate" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
									value="${entry.value.getTargetDate()}"> 
								</br> JV &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;:  <input type="text" name= "JV" value="${entry.value.getJV()}" /> 
							</br>
							
							<input type="submit" value="update" <c:if test="${entry.value.getCurrentBNGOrderId() != stageLimit && entry.value.getOrderId() > entry.value.getCurrentBNGOrderId()+1}">
								<c:out value="disabled='disabled'"/></c:if>">
							</form>
						</c:if>

					</div>



					<div id="paymentStatus">


						<c:if test="${'Payment Status' == entry.key}">
							<form method="post" action="updatePaymentStatus" name="">
								<b><u> Payment Status </u></b> </br> Status
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
								<%-- ${entry.value.getStatus()} --%>
								<input type="hidden" name="Status" value="${entry.value.getStatus()}">
								<input type="hidden" name=bngid value="${entry.value.getBngid()}">
								<input type="hidden" name="orderId" value="${entry.value.getOrderId()}">
								<select name="Status">
									<option value="Closed"
										<c:if test="${entry.value.getStatus() eq 'Closed'}">selected</c:if>>Closed
									</option>
									<option value="Pending"
										<c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending
									</option>
									<option value="In Progress"
										<c:if test="${entry.value.getStatus() eq 'In Progress'}">selected</c:if>>In Progress
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


				</c:forEach>


			</div>
			</div>


			<%@include file="footer.jsp"%>

		</div>
</body>

</html>
