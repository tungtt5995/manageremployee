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
							<h3 class="text-center font-weight-light my-4">Thêm nhân
								viên</h3>
						</div>
						<div class="card-body">
							${message } ${message1 }
							<form:form action="staff/staff-insert" modelAttribute="staff"
								method="post" enctype="multipart/form-data">
								<div class="form-row">
									
									<div class="col-md-6">
										<div class="form-group">
											<label class="small mb-1" for="inputLastName">Name</label>
											<form:input path="name" class="form-control py-4"
												id="inputLastName" type="text" />
											<form:errors path="name" element="ul" />
										</div>
									</div>
								</div>
								<div class="form-row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="small mb-1" for="inputFirstName">Phone</label>
											<form:input path="phone" class="form-control py-4"
												id="inputFirstName" type="text" />
											<form:errors path="phone" element="ul" />
										</div>
									</div>

									<div class="col-md-6">
										<div class="form-group">
											<label class="small mb-1" for="inputLastName">Email</label>
											<form:input path="email" class="form-control py-4"
												id="inputLastName" type="text" />
											<form:errors path="email" element="ul" />
										</div>
									</div>
								</div>
								<label>Giới Tính:</label>
								<div>
									<form:radiobutton path="gender" value="false" label="Nam" />
									<form:radiobutton path="gender" value="true" label="Nữ" />									
								</div>

								<div class="form-group">
									<label for="exampleFormControlFile1">Ảnh</label> 
									
									<form:hidden path="photo" />
									<input type="file" name="image" class="form-control-file"
										id="exampleFormControlFile1">
${message2 }
								</div>

								<label>Phòng Ban</label>
								<form:select path="departid.id" items="${depart}" itemValue="id"
									itemLabel="name" class="form-control" />
								<div class="form-row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="small mb-1" for="inputPassword">Ngày
												Sinh</label>
											<form:input path="birthday" class="form-control py-4"
												id="inputPassword" placeholder="dd/mm/yyyy" />
												<form:errors path="birthday" element="ul" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label class="small mb-1" for="inputPassword">Lương</label>
											<form:input path="salary" class="form-control py-4"
												id="inputPassword" />
											<form:errors path="salary" element="ul" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="exampleFormControlTextarea1">Note</label>
									<form:textarea path="notes" class="form-control"
										id="exampleFormControlTextarea1" />
									<form:errors path="notes" element="ul" />
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
