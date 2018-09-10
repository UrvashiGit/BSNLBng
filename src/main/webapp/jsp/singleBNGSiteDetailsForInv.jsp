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
	<%@include file="header.jsp"%>
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">

				<form method="post" action="updateSingleBNGInvDetails" name="updateBNGInv">
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> BSNL-BNG Invoicing
						</div>
						<div class="card-body">


							<c:forEach var="entry" items="${singleMap}">

								<c:if test="${'ERP PO' == entry.key}">
									<b><u> ERP PO </u></b>
									</br>
									Status
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
										 <%-- ${entry.value.getStatus()} --%>
										<select name="Status">
											<option value="Completed"   <c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Pending </option>
										 	<option value="Pending" <c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Completed </option>
											<option value="InProgress" <c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress </option>
									</select>
									 </br>
									 <!-- Date logic based on Status (code pending)
									  -->
									CloseDate &nbsp;&nbsp;&nbsp; :  ${entry.value.getCloseDate()}  
									 <input type="date" name="closeDate1" id="closeDate1id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									 </br>
									TargetDate &nbsp; :  ${entry.value.getTargetDate()} 
									 <input type="date" name="targetDate1" id="targetDate1id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									</br>
									
									
								</c:if>

								<c:if test="${'MIGO' == entry.key}">
									<b><u> MIGO </u></b>
									</br>
									Status
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
										 <%-- ${entry.value.getStatus()} --%>
										<select name="Status">
											<option value="Completed"   <c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Pending </option>
										 	<option value="Pending" <c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Completed </option>
											<option value="InProgress" <c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress </option>
									</select>
									 </br>
									CloseDate &nbsp;&nbsp;&nbsp; :  ${entry.value.getCloseDate()}  
									 <input type="date" name="closeDate2" id="closeDate2id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									 </br>
									TargetDate &nbsp; :  ${entry.value.getTargetDate()} 
									 <input type="date" name="targetDate2" id="targetDate2id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									</br>
								</c:if>

								<c:if test="${'MIRO' == entry.key}">
									<b><u> MIRO</u></b>
									</br>
									Status
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
										 <%-- ${entry.value.getStatus()} --%>
										<select name="Status">
											<option value="Completed"   <c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Pending </option>
										 	<option value="Pending" <c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Completed </option>
											<option value="InProgress" <c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress </option>
									</select>
									 </br>
									CloseDate &nbsp;&nbsp;&nbsp; :  ${entry.value.getCloseDate()}  
									 <input type="date" name="closeDate3" id="closeDate3id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									 </br>
									TargetDate &nbsp; :  ${entry.value.getTargetDate()} 
									 <input type="date" name="targetDate3" id="targetDate3id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									</br>
									
								
								</c:if>

								<c:if test="${'Payment Status' == entry.key}">
									<b><u> Payment Status </u></b>
									</br>
									Status
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
										 <%-- ${entry.value.getStatus()} --%>
										<select name="Status">
											<option value="Completed"   <c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Pending </option>
										 	<option value="Pending" <c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Completed </option>
											<option value="InProgress" <c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress </option>
									</select>
									 </br>
									CloseDate &nbsp;&nbsp;&nbsp; :  ${entry.value.getCloseDate()}  
									 <input type="date" name="closeDate4" id="closeDate4id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									 </br>
									TargetDate &nbsp; :  ${entry.value.getTargetDate()} 
									 <input type="date" name="targetDate4" id="targetDate4id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									</br>
									
									JV &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;:  <input type="text" name= "JV" value="${entry.value.getJV()}" /> 
							</br>
								</c:if>

								

							</c:forEach>
							
							</br>
						
							<!-- separate jsp page will show all history (Auditing) -->
							<a href="#"><b> <u> Audit</u> </b></a>
							</br>
							
							<div>
							</br>
							</br>
    <input type="submit" value = "Update Details" >
  </div>
				</form>



				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						
						</thead>
						
						<tbody>
						
						</tbody>


					</table>

					<div>
					
					</div>
				</div>
			
			</div>

		</div>
		

		<%@include file="footer.jsp"%>

	</div>

	</div>
	
</body>

</html>
