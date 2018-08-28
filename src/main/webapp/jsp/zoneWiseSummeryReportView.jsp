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
<title>Zone Wise Summery Report</title>


</head>

<body id="page-top">
	<%@include file="header.jsp"%>
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="sidebar.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">

				<h3>BNG Zone Wise Summary Report as on DD-MM-YYYY</h3>
				<hr>
				<br>
				<table class="table table-bordered" width="100%" cellspacing="0"
					border="1px">
					<thead style="font-size: 12px;">
						<tr>
							<th>Phase</th>
							<th>Zone Name</th>
							<th>Total BNG</th>
							<th>Site Survey </th>
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
						<tr>
							<td>Phase - 1</td>
							<td>South</td>
							<td>34</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>Phase - 1</td>
							<td>South</td>
							<td>34</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>Phase - 1</td>
							<td>South</td>
							<td>34</td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>

				<div>
					<a href="zoneWiseSummeryReportDownloadExcel" class="btn btn-primary">Download As
						Excel</a>
					<a href="pdfreport" target="_blank" class="btn btn-primary">Download As
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
