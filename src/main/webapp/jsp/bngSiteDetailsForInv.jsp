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

<title>BSNL-BNG Invoicing</title>

</head>

<body id="page-top">
	<%@include file="header.jsp"%>
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
			<!-- 	<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
					<li class="breadcrumb-item active">Overview</li>
				</ol> -->

				<!-- Icon Cards-->
				<!-- <div class="row">
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-primary o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-comments"></i>
								</div>
								<div class="mr-5">26 New Messages!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-warning o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-list"></i>
								</div>
								<div class="mr-5">11 New Tasks!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-success o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-shopping-cart"></i>
								</div>
								<div class="mr-5">123 New Orders!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-danger o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-life-ring"></i>
								</div>
								<div class="mr-5">13 New Tickets!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">View Details</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
				</div> -->



				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> BSNL-BNG Invoicing
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>BNG ID</th>
										<th>VID</th>
										<th>Phase</th>
										<th>Zone Name</th>
										<th>Circle Name</th>
										<th>Circle Code</th>
										<th>Location</th>
										<th>SSA Code</th>
										<th>BNG Type</th>
										<th>Exist/New/Train</th>
										
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
								<tbody>
									<c:forEach items="${bngList}" var="bng">
										<tr>
											<td><a href="singleBNGInvDetails?getBNGID=${bng.id}">${bng.id} </a></td>
											<td>${bng.vid}</td>
											<td>${bng.phase}</td>
											<td>${bng.zoneName}</td>
											<td>${bng.circleName}</td>
											<td>${bng.circleCode}</td>
											<td>${bng.location}</td>
											<td>${bng.ssaCode}</td>
											<td>${bng.bngType}</td>
											<td>${bng.exitNewTrain}</td>
											
											
											
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
				<!-- 	<a href="bngSiteDetailsReportDownloadExcel" class="btn btn-primary">Download As
						Excel</a>
					<a href="bngSiteDetailsReportPdfDownload" target="_blank" class="btn btn-primary">Download As
						Pdf</a> -->
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
