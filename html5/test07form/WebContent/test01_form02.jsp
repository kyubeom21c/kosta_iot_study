<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String name = request.getParameter("name");
	String passwd = request.getParameter("passwd");
	System.out.println(name);
	System.out.println(passwd);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>test01_form02.jsp</h1>
	<p><%= name%></p>
	<p><%= passwd%></p>
</body>
</html>