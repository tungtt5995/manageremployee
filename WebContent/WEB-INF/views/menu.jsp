<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
		<div class="sb-sidenav-menu">
			<div class="nav">
				<a class="nav-link" href="home/index">
					<div class="sb-nav-link-icon">
						<i class="fas fa-tachometer-alt"></i>
					</div> Trang chủ
				</a> <a class="nav-link collapsed" href="#" data-toggle="collapse"
					data-target="#collapseLayouts" aria-expanded="false"
					aria-controls="collapseLayouts">
					<div class="sb-nav-link-icon">
						<i class="fas fa-columns"></i>
					</div> Quản lý nhân viên
					<div class="sb-sidenav-collapse-arrow">
						<i class="fas fa-angle-down"></i>
					</div>
				</a>
				<div class="collapse" id="collapseLayouts"
					aria-labelledby="headingOne" data-parent="#sidenavAccordion">
					<nav class="sb-sidenav-menu-nested nav">
						<a class="nav-link" href="staff/add">Danh sách nhân viên</a> <a
							class="nav-link" href="staff/formStaff">Thêm nhân viên</a> <a
							class="nav-link" href="user/add">Danh sách User</a> <a
							class="nav-link" href="user/formUser">Thêm User</a>
					</nav>
				</div>
				<a class="nav-link collapsed" href="#" data-toggle="collapse"
					data-target="#collapsePages" aria-expanded="false"
					aria-controls="collapsePages">
					<div class="sb-nav-link-icon">
						<i class="fas fa-book-open"></i>
					</div> Quản lý phòng ban
					<div class="sb-sidenav-collapse-arrow">
						<i class="fas fa-angle-down"></i>
					</div>
				</a>
				<div class="collapse" id="collapsePages"
					aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
					<nav class="sb-sidenav-menu-nested nav accordion"
						id="sidenavAccordionPages">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="depart/add">Danh sách phòng ban</a> <a
								class="nav-link" href="depart/form">Thêm phòng ban</a>
						</nav>
					</nav>
				</div>
				<div class="sb-sidenav-menu-heading">Addons</div>
				<a class="nav-link" href="record/add">
					<div class="sb-nav-link-icon">
						<i class="fas fa-chart-area"></i>
					</div> Thành Tích
				</a> <a class="nav-link" href="staff/report">
					<div class="sb-nav-link-icon">
						<i class="fas fa-table"></i>
					</div> Thống Kê
				</a>
			</div>
		</div>

	</nav>
</body>
</html>