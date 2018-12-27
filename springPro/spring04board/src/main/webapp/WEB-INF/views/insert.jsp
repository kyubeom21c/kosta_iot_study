<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>insert</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	<form action="insertOK2.do" method="post" enctype="multipart/form-data">
		<input type="text" name="key01" value="title"/>
		<input type="text" name="key02" value="content"/>
		<input type="text" name="key03" value="writer"/>
		<input type="file" name="key04">
		<input type="submit" value="insertOK"/>
	</form>

</body>
</html>