<%@page import="test.com.model.TestVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectAll</title>
</head>
<body>
	<h1>selectAll</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	
	<table border="1">
		<tr>
			<th>NUM</th>
			<th>ID</th>
			<th></th>
		</tr>
		<c:forEach var="vo" items="${vos}">
		<tr>
			<td><a href="update.do?num=${vo.num}">${vo.num}</a></td>
			<td>${vo.id}</td>
			<td><a href="deleteOK.do?num=${vo.num}">deleteOK</a></td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>