<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	
	<P>The time on the server is ${serverTime}.</P>
</body>
</html>