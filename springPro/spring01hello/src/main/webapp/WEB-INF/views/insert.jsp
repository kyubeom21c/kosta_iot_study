<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>
</head>
<body>
	<h1>Hello insert!</h1>
	<a href="home.do">home</a>
	<a href="insert.do">insert</a>
	<a href="test2.do">test2</a>
	
	<form action="insertOK.do" method="post">
		<input type="text" name="id" value="admin"/>
		<input type="text" name="pw" value="hi123456"/>
		<input type="text" name="name" value="kim"/>
		<input type="text" name="tel" value="010"/>
		<input type="submit" value="send"/>
	</form>
</body>
</html>
