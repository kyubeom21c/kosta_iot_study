<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member index</title>
</head>
<body>
	<h1>member index</h1>
	<h1><%=request.getContextPath()%></h1>
	<a href="<%=request.getContextPath()%>/aaa/test.jsp">test.jsp</a>
	<a href="aaa/test2.jsp">test2.jsp</a>
	<a href="insert.jsp?name=kim">insert.jsp</a>get방식
	
</body>
</html>