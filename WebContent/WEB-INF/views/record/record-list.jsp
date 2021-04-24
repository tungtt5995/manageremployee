
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Tables - SB Admin</title>
<link href="<c:url value="/assets/css/styles.css"/>" rel="stylesheet" />
<link
	href="<c:url value="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"/>"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<!-- 		<div id="layoutSidenav_content"> -->
	<main>
		<div class="container-fluid">
			<h1 class="mt-4">Xếp loại nhân viên</h1>
			<ol class="breadcrumb mb-4">
				<li class="breadcrumb-item"><a href="home/index">Trang chủ</a></li>
				<li class="breadcrumb-item active">Nhân viên</li>
			</ol>
			<a href="record/formRecord" class="btn btn-primary btn-lg active"
				role="button" aria-pressed="true"> Thêm</a>
			<hr>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table mr-1"></i> DataTable Example
				</div>

				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>ID Record</th>
									<th>MÃ NV</th>
									<th>Name</th>
									<th>Type</th>
									<th>Reson</th>
									<th>Date</th>
									<th>Cập nhật</th>
									<th>Xóa</th>
								</tr>
							</thead>


							<c:forEach var="record" items="${listrecord}" varStatus="status">
								<tr>

									<td>${record.id}</td>
									<td>${record.staff.id}</td>
									<td>${record.staff.name}</td>
									<td>${record.type ? "Thành tích" : "Kỷ luật"}</td>
									<td>${record.reason}</td>
									<td>${record.date}</td>

									<td>
										<!-- 																								<button type="button" class="btn btn-primary">EDIT</button> -->
										<a href="#">EDIT</a>
									</td>
									<td>
										<!-- 												<button type="button" class="btn btn-primary">DELTE</button> -->
										<a href="#">Delete</a>

									</td>




								</tr>

							</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</main>
	<!-- 	</div> -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/datatables-demo.js"></script>
</body>
</html>
