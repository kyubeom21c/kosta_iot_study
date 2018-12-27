<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadImageView</title>
</head>
<body>
	<h1>uploadImage file name : ${param.img}</h1>
	<img src="resources/uploadimg/${param.img}" />
	<img src="resources/uploadimg/thumb_${param.img}" />
</body>
</html>