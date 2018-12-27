<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>selectAll</title>
</head>
<body>
	<h1>Hello selectAll!</h1>
	<a href="home.do">home</a>
	<a href="insert.do">insert</a>
	<a href="test2.do">test2</a> 
	
	<table>
		<c:forEach var="vo" items="${vos}">
		<tr>
			<td>${vo.num}</td>
			<td>${vo.id}</td>
			<td>${vo.pw}</td>
			<td>${vo.name}</td>
			<td>${vo.tel}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
