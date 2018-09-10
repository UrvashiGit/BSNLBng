<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Circle Wise Detailed Report</title>


</head>

<body id="page-top">
	<%@include file="header.jsp"%>
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid" style=" overflow-x: auto !important;">
				<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
				<h3>BNG Circle Wise Detailed Report as on <%= df.format(new java.util.Date()) %> </h3>
				<hr>
				<br>
				<table class="table table-bordered" width="100%" cellspacing="0"
					border="1px">
					<thead style="font-size: 11px;">
						<tr>
							<th>Phase</th>
							<!-- <th>Zone Name</th> -->
							<th>Circle Name</th>
							<th>Circle Code	</th>
							<th>Location</th>
							<th>SSA Code</th>	
							<th>BNG Type</th>
							<th>Exist/New/Train</th>
							<th>BNG ID</th>
							<th>Site Survey</th>
							<th>Site Ready</th>
							<th>Material Delivery</th>
							<th>Power On</th>
							<th>NW Integration</th>
							<th>AT</th>
							<th>Commissinong</th>
							<th>ATC</th>
							<th>ERP PO</th>
							<th>MIGO</th>
							<th>MIRO</th>
							<th>Payment Status</th>

						</tr>
					</thead>
					<tbody style="font-size: 11px;">
					<c:forEach items="${cwdList}" var="cwd">
										<tr>
											<td>${cwd.getPhase()}</td>
											<%-- <td>${cwd.getZoneName()}</td> --%>
											<td>${cwd.getCircleName()}</td>
											<td>${cwd.getCircleCode()}</td>
											<td>${cwd.getLocation()}</td>
											<td>${cwd.getSSACode()}</td>
											<td>${cwd.getBNGType()}</td>
											<td>${cwd.getExistNewTrain()}</td>
											<td>${cwd.getBNGID()}</td>
											<td>${cwd.getSiteSurvey()}</td>
											<td>${cwd.getSiteReady()}</td>
											<td>${cwd.getMaterialDelivery()}</td>
											<td>${cwd.getPowerOn()}</td>
											<td>${cwd.getNWIntegration()}</td>
											<td>${cwd.getAT()}</td>
											<td>${cwd.getCommissioning()}</td>
											<td>${cwd.getATC()}</td>
											<td>${cwd.getERPPO()}</td>
											<td>${cwd.getMIGO()}</td>
											<td>${cwd.getMIRO()}</td>
											<td>${cwd.getPaymentStatus()}</td>
											
											
										</tr>
									</c:forEach>

					</tbody>
					<tbody style="font-size: 11px;">
					        <c:if test="${empty cwdList}">
						
										<tr>
											<td colspan="20"><b>No records found !!</b></td>
											
										</tr>
							</c:if>		
									
					</tbody>
				</table>

				<div>
					<a href="circleWiseDetailedReportDownloadExcel" class="btn btn-primary">Download As
						Excel</a>
					<a href="circleWiseDetailedReportPdfDownload" target="_blank" class="btn btn-primary">Download As
						Pdf</a>
				</div>

			</div>
			<!-- /.container-fluid -->

			<%@include file="footer.jsp"%>

		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

</body>

</html>
