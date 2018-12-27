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
	<form action="insertOK.do" method="post">
		<input type="text" name="id" value="id"/>
		<input type="text" name="pw" value="pw"/>
		<input type="text" name="name" value="name"/>
		<input type="text" name="tel" value="tel"/>
		<input type="submit" value="insertOK"/>
	</form>

</body>
</html>