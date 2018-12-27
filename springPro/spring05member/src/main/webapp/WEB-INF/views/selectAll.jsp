<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>selectAll</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	<form action="search.do">
		<select name="searchKey">
			<option>name</option>
			<option>tel</option>
		</select>
		<input type="text" name="searchWord" value="kim">
		<input type="submit" value="search">
	</form>
	
	<table>
		<tr>
			<th>NUM</th>
			<th>ID</th>
			<th>PW</th>
			<th>NAME</th>
			<th>TEL</th>
			<th></th>
		</tr>
		
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td><a href="update.do?num=${vo.num}">${vo.num}</a></td>
				<td>${vo.id}</td>
				<td>${vo.pw}</td>
				<td>${vo.name}</td>
				<td>${vo.tel}</td>
				<td><a href="deleteOK.do?num=${vo.num}">deleteOK</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>