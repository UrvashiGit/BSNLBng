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
	<%@include file="header.jsp"%>
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">

				<form method="post" action="updateSingleBNGDetails" name="updateBNGIAndC">
					<!-- DataTables Example -->
					<div class="card mb-3">
						<div class="card-header">
							<i class="fas fa-table"></i> BSNL-BNG Installation And
							Commissioning
						</div>
						<div class="card-body">


							<c:forEach var="entry" items="${singleMap}">

								<c:if test="${'Site Survey' == entry.key}">
									<b><u> Site Survey </u></b>
									</br>
									Status : ${entry.value.getStatus()}
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
										 <%-- ${entry.value.getStatus()} --%>
										<%-- <select name="Status">
											<option value="Completed"   ${entry.value.getStatus() == 'Completed' ? 'selected="selected"' : ''}">Completed </option>
										 	<option value="Pending" ${entry.value.getStatus() == 'Pending' ? 'selected="selected"' : ''}">Pending </option>
											<option value="InProgress" ${entry.value.getStatus() == 'InProgress'? 'selected="selected"' : ''}">InProgress </option>
									</select> --%>
									 </br>
									 <!-- Date logic based on Status (code pending)
									  -->
									CloseDate &nbsp;&nbsp;&nbsp; :  ${entry.value.getCloseDate()}  
									 <input type="date" name="closeDate1" id="closeDate1id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									 </br>
									TargetDate &nbsp; :  ${entry.value.getTargetDate()} 
									 <input type="date" name="targetDate1" id="targetDate1id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									</br>
									
									Survey Report  : <a href="#"> <u> Details</u></a>
									</br>
								</c:if>

								<c:if test="${'Site Ready' == entry.key}">
									<b><u> Site Ready </u></b>
									</br>
									Status
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
										 <%-- ${entry.value.getStatus()} --%>
										<select name="Status">
											<option value="Completed"   <c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed </option>
										 	<option value="Pending" <c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending </option>
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

								<c:if test="${'Material Delivery' == entry.key}">
									<b><u> Material Delivery </u></b>
									</br>
									Status
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
										 <%-- ${entry.value.getStatus()} --%>
										<select name="Status">
											<option value="Completed"   <c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed </option>
										 	<option value="Pending" <c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending </option>
											<option value="InProgress" <c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress </option>
									</select>
									 </br>
									CloseDate &nbsp;&nbsp;&nbsp; :  ${entry.value.getCloseDate()}  
									 <input type="date" name="closeDate3" id="closeDate3id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									 </br>
									TargetDate &nbsp; :  ${entry.value.getTargetDate()} 
									 <input type="date" name="targetDate3" id="targetDate3id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									</br>
									
									Challan &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : <a href="#"> <u> Details</u></a>
									</br>
								</c:if>

								<c:if test="${'Power On' == entry.key}">
									<b><u> Power On </u></b>
									</br>
									Status
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
										 <%-- ${entry.value.getStatus()} --%>
										<select name="Status">
											<option value="Completed"   <c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed </option>
										 	<option value="Pending" <c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending </option>
											<option value="InProgress" <c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress </option>
									</select>
									 </br>
									CloseDate &nbsp;&nbsp;&nbsp; :  ${entry.value.getCloseDate()}  
									 <input type="date" name="closeDate4" id="closeDate4id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									 </br>
									TargetDate &nbsp; :  ${entry.value.getTargetDate()} 
									 <input type="date" name="targetDate4" id="targetDate4id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									</br>
								</c:if>

								<c:if test="${'NW Integration' == entry.key}">
									<b><u> NW Integration</u></b>
									</br>
									Status
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
										 <%-- ${entry.value.getStatus()} --%>
										<select name="Status">
											<option value="Completed"   <c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed </option>
										 	<option value="Pending" <c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending </option>
											<option value="InProgress" <c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress </option>
									</select>
									 </br>
									CloseDate &nbsp;&nbsp;&nbsp; :  ${entry.value.getCloseDate()}  
									 <input type="date" name="closeDate5" id="closeDate5id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									 </br>
									TargetDate &nbsp; :  ${entry.value.getTargetDate()} 
									 <input type="date" name="targetDate5" id="targetDate5id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									</br>
								</c:if>

								<c:if test="${'AT' == entry.key}">
									<b><u> AT </u></b>
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
									 <input type="date" name="closeDate6" id="closeDate6id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									 </br>
									TargetDate &nbsp; :  ${entry.value.getTargetDate()} 
									 <input type="date" name="targetDate6" id="targetDate6id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									</br>
								</c:if>

								<c:if test="${'Commissioning' == entry.key}">
									<b><u> Commissioning </u></b>
									</br>
									Status
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
										 <%-- ${entry.value.getStatus()} --%>
										<select name="Status">
											<option value="Completed"   <c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed </option>
										 	<option value="Pending" <c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending </option>
											<option value="InProgress" <c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress </option>
									</select>
									 </br>
									CloseDate &nbsp;&nbsp;&nbsp; :  ${entry.value.getCloseDate()}  
									 <input type="date" name="closeDate7" id="closeDate7id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									 </br>
									TargetDate &nbsp; :  ${entry.value.getTargetDate()} 
									 <input type="date" name="targetDate7" id="targetDate7id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									</br>
								</c:if>

								<c:if test="${'ATC' == entry.key}">
									<b><u> ATC </u></b>
									</br>
									Status
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :
										 <%-- ${entry.value.getStatus()} --%>
										<select name="Status">
											<option value="Completed"   <c:if test="${entry.value.getStatus() eq 'Completed'}">selected</c:if>>Completed </option>
										 	<option value="Pending" <c:if test="${entry.value.getStatus() eq 'Pending'}">selected</c:if>>Pending </option>
											<option value="InProgress" <c:if test="${entry.value.getStatus() eq 'InProgress'}">selected</c:if>>InProgress </option>
									</select>
									 </br>
									CloseDate &nbsp;&nbsp;&nbsp; :  ${entry.value.getCloseDate()}  
									 <input type="date" name="closeDate8" id="closeDate8id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									 </br>
									TargetDate &nbsp; :  ${entry.value.getTargetDate()} 
									 <input type="date" name="targetDate8" id="targetDate8id"  pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" value ="${entry.value.getCloseDate()}" >
									</br>
									
									Certificate &nbsp;&nbsp;&nbsp; : <a href="#"> <u> Details</u></a>
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

						<tbody style="font-size: 11px;">
							<c:if test="${empty singleMap}">

								<tr>
									<td colspan="16"><b>No records found !!</b></td>

								</tr>
							</c:if>

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
