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
<title>Circle Wise Summery Report</title>


</head>

<body id="page-top">
	<%@include file="header.jsp"%>
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">
<%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
				<h3>BNG Circle Wise Summary Report as on <%= df.format(new java.util.Date()) %></h3>
				<hr>
				<br>
				<table class="table table-bordered" width="100%" cellspacing="0"
					border="1px">
					<thead style="font-size: 12px;">
						<tr>
							<th>Phase</th>
							<th>Circle Name</th>
							<th>Circle Code</th>
							<th>Total BNG</th>
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
					   <c:if test="${not empty cwsList}">
						<c:forEach items="${cwsList}" var="cws">
										<tr>
											<td>${cws.getPhase()}</td>
											<td>${cws.getCircleName()}</td>
											<td>${cws.getCircleCode()}</td>
											<td>${cws.getTotalBng()}</td>
											<td>${cws.getSiteSurvey()}</td>
											<td>${cws.getSiteReady()}</td>
											<td>${cws.getMaterialDelivery()}</td>
											<td>${cws.getPowerOn()}</td>
											<td>${cws.getNWIntegration()}</td>
											<td>${cws.getAT()}</td>
											<td>${cws.getCommissioning()}</td>
											<td>${cws.getATC()}</td>
											<td>${cws.getERPPO()}</td>
											<td>${cws.getMIGO()}</td>
											<td>${cws.getMIRO()}</td>
											<td>${cws.getPaymentStatus()}</td>
											
											
										</tr>
									</c:forEach>
									</c:if>
									
					</tbody>
					<tbody style="font-size: 11px;">
					   <c:if test="${empty cwsList}">
						
										<tr>
											<td colspan="16"><b>No records found !!</b></td>
											
										</tr>
							</c:if>		
									
					</tbody>
				</table>

				<div>
				<a href="circleWiseSummeryReportDownloadExcel" class="btn btn-primary">Download As
						Excel</a>
					<a href="circleWiseSummeryReportPdfDownload" target="_blank" class="btn btn-primary">Download As
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
