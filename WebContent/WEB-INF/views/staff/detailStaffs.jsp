<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath }/">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<main class="mt-5 pt-4">
		<form:form modelAttribute="detailstaff" enctype="multipart/form-data">
			<div class="container dark-grey-text mt-5">
				<div class="row wow fadeIn">
					<!--Grid column-->
					<div class="col-md-6 mb-4">
						<img
										src="<c:url value="/assets/img/images_staff/${detailstaff.photo}"/>"
										alt="" style="width: 100px; height: 100px;" />
					</div>
					<div class="col-md-6 mb-4">
						<div class="p-4">
							<div class="mb-3"></div>
							<p class="lead font-weight-bold">${detailstaff.name }</p>
							<h4>${detailstaff.phone }</h4>
							<h4>${detailstaff.email }</h4>
							<h4>${detailstaff.birthday }</h4>
							<h1>tungtt</h1>
							
<!-- 								<button class="btn btn-primary btn-md my-0 p" type="submit"> -->
<!-- 									Edit <i class="fas fa-shopping-cart ml-1"></i> -->
<!-- 								</button> -->
						
						</div>
					</div>
				</div>

			</div>
		</form:form>
	</main>
</body>
</html>