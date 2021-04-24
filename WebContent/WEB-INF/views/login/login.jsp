<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page pageEncoding="utf-8"%>
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
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-5">
							<div class="card shadow-lg border-0 rounded-lg mt-5">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">Login</h3>
								</div>
								<div class="card-body">
									${message}
									<form:form action="login/submit" method="post"
										modelAttribute="auth">

										<div class="form-group">
											<label class="small mb-1">Username</label>
											<form:input path="username" name="username"
												class="form-control py-4" id="inputEmailAddress" />
											<form:errors cssStyle="color:red" path="username"
												name="password" element="ul" />
										</div>
										<div class="form-group">
											<label class="small mb-1">Password</label>
											<form:input path="password" class="form-control py-4"
												type="password" id="inputPassword" />
											<form:errors cssStyle="color:red" path="password"
												element="ul" />
										</div>
										<div>											
											<div class="text-center mt-2">
												<button class="btn btn-info">
													Log in <i class="fas fa-sign-in-alt ml-1"></i>
												</button>
											</div>
									</form:form>

								</div>

							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
</body>
</html>
