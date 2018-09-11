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

<title>BSNL-BNG</title>

</head>

<body id="page-top">
	<%@include file="header.jsp"%>
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">

			

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> BNG Site Details
									
					<a href="bngSiteDetailsReportDownloadExcel" class="btn btn-primary">Download As
						Excel</a>
					<a href="bngSiteDetailsReportPdfDownload" target="_blank" class="btn btn-primary">Download As
						Pdf</a>
				
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead style="font-size: 12px;">
									<tr>
									    <th>Phase</th>
										<th>BNG ID</th>
										<th>VID</th>
										<th>Zone</th>
										<th>Circle</th>
										<th>Circle Code</th>
										<th>Location</th>
										<th>SSA Code</th>
										<th>BNG Type</th>
										<th>Type</th>
										<th>Site Location</th>
										<th>Circle Coordinator</th>
										<th>Consignee</th>
										<th>Site Address</th>
										<th>Site Person</th>
										<th>Site Contact</th>
										<th>GSTIN</th>
									</tr>
								</thead>
								<!-- <tfoot>
									<tr>
										<th>Name</th>
										<th>Author</th>
										<th>publication</th>
										<th>category</th>
										<th>pages</th>
										<th>price</th>
									</tr>
								</tfoot> -->
								<tbody style="font-size: 11px;">
									<c:forEach items="${bngList}" var="bng">
										<tr>
										    <td>${bng.phase}</td>
											<td>${bng.id}</td>
											<td>${bng.vid}</td>
											<td>${bng.zoneName}</td>
											<td>${bng.circleName}</td>
											<td>${bng.circleCode}</td>
											<td>${bng.location}</td>
											<td>${bng.ssaCode}</td>
											<td>${bng.bngType}</td>
											<td>${bng.exitNewTrain}</td>
											<td>${bng.siteNameLocation}</td>
											<td>${bng.circleCoordinatorDet}</td>
											<td>${bng.consigneeDet}</td>
											<td>${bng.siteAddress}</td>
											<td>${bng.sitePersonDet}</td>
											<td>${bng.siteContactNo}</td>
											<td>${bng.gstin}</td>
											
											
										</tr>
									</c:forEach>
								</tbody>
								
								<tbody style="font-size: 11px;">
					        <c:if test="${empty bngList}">
						
										<tr>
											<td colspan="16"><b>No records found !!</b></td>
											
										</tr>
							</c:if>		
									
					</tbody>
								
							</table>
							
							<div>
					<a href="bngSiteDetailsReportDownloadExcel" class="btn btn-primary">Download As
						Excel</a>
					<a href="bngSiteDetailsReportPdfDownload" target="_blank" class="btn btn-primary">Download As
						Pdf</a>
				</div>
							
							
						</div>
					</div>
				<!-- 	<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div> -->
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
