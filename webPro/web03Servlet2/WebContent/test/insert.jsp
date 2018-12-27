<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
</head>
<body>
	<h1>insert</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	
	<form action="insertOK.do" method="post">
		<label>NUM:</label>
		<input type="number" name="num" value="99"/> <br/>
		<label>ID:</label>
		<input type="text" name="id" value="yangssem"/> <br/>
		<input type="submit" value="insertOK"/> 
	</form>
</body>
</html>