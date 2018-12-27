<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h1>Hello world! ${name}</h1>

	<a href="home.do">home</a>
	<a href="insert.do">insert</a>
	<a href="test2.do">test2</a>
	<P>The time on the server is ${serverTime}.</P>
</body>
</html>
