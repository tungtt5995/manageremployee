<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- chọn layout nào để áp dụng dựa vào giá trị của tham số view -->
	<%
		String view = request.getParameter("view");
	if (view.startsWith("login/")) {
		pageContext.forward("layout-hello.jsp");
	} else {
		pageContext.forward("home.jsp");
	}
	%>
</body>
</html>