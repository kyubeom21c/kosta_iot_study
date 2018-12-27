<%@page import="test.com.model.MemberDAOimpl"%>
<%@page import="test.com.model.MemberVO"%>
<%@page import="test.com.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberVO vo = new MemberVO();
	vo.setNum(Integer.parseInt(request.getParameter("num")));
	MemberDAO dao = new MemberDAOimpl();
	MemberVO vo2 = dao.selectOne(vo);
	System.out.println(vo2.getNum());
	System.out.println(vo2.getId());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member update</title>
</head>
<body>
	<h1>member update</h1>
	<a href="index.jsp">index.jsp</a>
	
	<form action="updateOK.jsp" method="post">
		<label>num:</label> <input type="text" id="num" name="num"
			value="${param.num}" /> 
			
		<label>id:</label> <input type="text" id="id"
			name="id" value="<%=vo2.getId()%>" /> 
			
		<input type="submit" value="updateOK" />
	</form>
</body>
</html>