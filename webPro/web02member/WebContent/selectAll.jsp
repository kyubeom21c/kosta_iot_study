<%@page import="test.com.model.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="test.com.model.MemberDAOimpl"%>
<%@page import="test.com.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDAO dao = new MemberDAOimpl();
	List<MemberVO> vos = dao.selectAll();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member selectAll</title>
</head>
<body>
	<h1>member selectAll</h1>
	<a href="index.jsp">index.jsp</a>
	<table border="1" >
		<tr>
			<th>NUM</th>
			<th>ID</th>
			<th></th>
		</tr>
	<% for(MemberVO vo:vos){%>
		<tr>
			<td align="center"><a href="update.jsp?num=<%=vo.getNum()%>"><%=vo.getNum()%></a></td>
			<td><%=vo.getId()%></td>
			<td><a href="deleteOK.jsp?num=<%=vo.getNum()%>">deleteOK</a></td>
		</tr>
	<% }%>	
	</table>
</body>
</html>