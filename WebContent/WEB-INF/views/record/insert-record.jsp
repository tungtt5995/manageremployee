<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
*[id$=errors] {
	color: red;
	font-style: italic;
}
</style>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Page Title - SB Admin</title>
<link href="<c:url value="/assets/css/styles.css"/>" rel="stylesheet" />
<base href="${pageContext.servletContext.contextPath }/">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="bg-primary">

	<main>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-7">
					<div class="card shadow-lg border-0 rounded-lg mt-5">
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">Thêm Thành tích nhân
								viên</h3>
						</div>
						<div class="card-body">
							${message }
							${message1 }
							
							<form:form action="record/insert-Record" modelAttribute="record"
								method="POST" enctype="multipart/form-data">
								<form:errors path="*" element="ul"/>
								<label>Nhân Viên</label>
								<form:select path="staff.id" items="${staffs}" itemValue="id"
									itemLabel="name" class="form-control" />
								<label>Xếp loại:</label>
								
								<div>
								<form:errors path="type" element="ul" />
									<form:radiobutton path="type" value="true" label="Thành tích" />
									<form:radiobutton path="type" value="false" label="Kỷ luật" />
									
								</div>
								<div class="form-group">
									<label for="exampleFormControlTextarea1">Lý do</label>
									<form:textarea path="reason" class="form-control"
										id="exampleFormControlTextarea1" />
										<form:errors path="reason" element="ul"/>
								</div>
								<br>
								<div>
									<button type="submit" class="btn btn-primary btn-block">Thêm</button>
								</div>
							</form:form>
						</div>
						<div class="card-footer text-center">
							<div class="small"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
