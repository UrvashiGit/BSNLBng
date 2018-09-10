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
<title>Zone Wise Detail Report</title>


</head>

<body id="page-top">
	<%@include file="header.jsp"%>
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="sidebar.jsp"%>

		<div id="content-wrapper" >

			<div class="container-fluid" style=" overflow-x: auto !important;">
				<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
				<h3>BNG Zone Wise Detailed Report as on  <%= df.format(new java.util.Date()) %></h3>
				<hr>
				<br>
				<table class="table table-bordered" width="100%" cellspacing="0"
					border="1px">
					<thead style="font-size: 11px;">
						<tr>
							<th>Phase</th>
							<th>Zone Name</th>
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
						<c:forEach items="${zwdList}" var="zwd">
										<tr>
											<td>${zwd.getPhase()}</td>
											<td>${zwd.getZoneName()}</td>
											<td>${zwd.getCircleName()}</td>
											<td>${zwd.getCircleCode()}</td>
											<td>${zwd.getLocation()}</td>
											<td>${zwd.getSSACode()}</td>
											<td>${zwd.getBNGType()}</td>
											<td>${zwd.getExistNewTrain()}</td>
											<td>${zwd.getBNGID()}</td>
											<td>${zwd.getSiteSurvey()}</td>
											<td>${zwd.getSiteReady()}</td>
											<td>${zwd.getMaterialDelivery()}</td>
											<td>${zwd.getPowerOn()}</td>
											<td>${zwd.getNWIntegration()}</td>
											<td>${zwd.getAT()}</td>
											<td>${zwd.getCommissioning()}</td>
											<td>${zwd.getATC()}</td>
											<td>${zwd.getERPPO()}</td>
											<td>${zwd.getMIGO()}</td>
											<td>${zwd.getMIRO()}</td>
											<td>${zwd.getPaymentStatus()}</td>
											
											
										</tr>
									</c:forEach>
					</tbody>
					<tbody style="font-size: 11px;">
					        <c:if test="${empty zwdList}">
						
										<tr>
											<td colspan="21"><b>No records found !!</b></td>
											
										</tr>
							</c:if>		
									
					</tbody>
				</table>

				<div>
						<a href="zoneWiseDetailedReportDownloadExcel" class="btn btn-primary">Download As
						Excel</a>
					<a href="zoneWiseDetailedReportPdfDownload" target="_blank" class="btn btn-primary">Download As
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
