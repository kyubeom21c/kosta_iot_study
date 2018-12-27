<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectAll</title>
</head>
<body>
	<h1>selectAll</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	<table border="1">
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td><a href="selectOne.do?num=${vo.num}">${vo.num}</a></td>
				<td>${vo.name}</td>
				<td>${vo.age}</td>
				<td><a href="deleteOK.do?num=${vo.num}">deleteOK</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>