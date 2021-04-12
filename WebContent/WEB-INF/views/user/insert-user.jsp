<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Page Title - SB Admin</title>
<link href="<c:url value="/assets/css/styles.css"/>" rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="bg-primary">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-5">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">Thêm USER</h3>
								</div>
								<div class="card-body">
									<form:form action="user/user-insert" modelAttribute="user"
										method="POST">
																			${message }
										<div class="form-group">
											<label class="small mb-1" for="inputEmailAddress">UserName</label>
											<form:input path="username" class="form-control py-4" />
										</div>
										<div class="form-group">
											<label class="small mb-1" for="inputPassword">PassWord
											</label>
											<form:input type="password" path="password"
												class="form-control py-4" />
										</div>
										<div class="form-group">
											<label class="small mb-1" for="inputPassword">FullName
											</label>
											<form:input path="fullname" class="form-control py-4"
												id="inputPassword" />
										</div>
										<div>
											<button class="btn btn-primary btn-block">Thêm</button>
										</div>
									</form:form>
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
