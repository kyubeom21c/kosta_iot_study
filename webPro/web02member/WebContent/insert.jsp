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
	<a href="index.jsp">index.jsp</a>
	<%=request.getParameter("name")%>
	<a href="insertOK.jsp?num=10&id=admin">insertOK</a>
	
	
	<form action="insertOK.jsp" method="post">
		<label>num:</label>
		<input type="text" id="num" name="num" value="33"/>
		<label>id:</label>
		<input type="text" id="id" name="id" value="kim"/>
		<input type="submit" value="insertOK"/>
	</form>
</body>
</html>