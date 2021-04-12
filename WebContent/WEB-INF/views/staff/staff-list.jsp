
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
					<h1 class="mt-4">Danh sách nhân viên</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="index.html">Home</a></li>
						<li class="breadcrumb-item active">Danh sách nhân viên</li>
					</ol>

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
											<th>Ảnh</th>
											<th>TÊN</th>
											<th>MÃ NV</th>
											<th>Giới Tính</th>
											<th>Năm Sinh</th>
											<th>Salary</th>
											<th>Cập nhật</th>
											<th>Xóa</th>
										</tr>
									</thead>


									<c:forEach var="staff" items="${listStaff}" varStatus="status">
										<tr>
											<td><img
												src="<c:url value="/assets/img/images_staff/${staff.photo}"/>"
												alt="" style="width: 60px; height: 60px;" /></td>

											<td>${staff.name}</td>
											<td>${staff.id}</td>
											<td>${staff.gender ? "Nữ" : "Nam"}</td>
											<td>${staff.birthday}</td>
											<td>${staff.salary}</td>

											<td>
												<!-- 																								<button type="button" class="btn btn-primary">EDIT</button> -->
												<a href="staff/edit/${staff.id}">EDIT</a>
											</td>
											<td>
												<!-- 												<button type="button" class="btn btn-primary">DELTE</button> -->
												<a href="staff/delete/${staff.id}">Delete</a>

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
