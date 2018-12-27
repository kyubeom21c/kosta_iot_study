<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>

<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style type="text/css">
.aaa{
	background: #f00
}
</style>
</head>
<body>
	<h1>Hello world!</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>

	<p>The time on the server is ${serverTime}.</p>
	<h1>${user_id }</h1>
	<p>
		<a href="login.do">login.do</a>
	</p>
	<p>
		<a href="logout.do">logout.do</a>
	</p>
</body>
</html>
