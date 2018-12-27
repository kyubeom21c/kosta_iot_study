<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member insert</title>
</head>
<body>
	<h1>member insert</h1>
	<a href="index.do">index.do</a>
	
	<form action="insertOK.do" method="post">
		<label>num:</label>
		<input type="text" id="num" name="num" value="33"/>
		<label>id:</label>
		<input type="text" id="id" name="id" value="kim"/>
		<input type="submit" value="insertOK"/>
	</form>
</body>
</html>