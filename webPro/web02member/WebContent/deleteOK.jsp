<%@page import="test.com.model.MemberDAOimpl"%>
<%@page import="test.com.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="test.com.model.MemberVO"%>
<%
	System.out.println(request.getParameter("num"));
	String num = request.getParameter("num");
	MemberVO vo = new MemberVO();
	vo.setNum(Integer.parseInt(num));
	MemberDAO dao = new MemberDAOimpl();
	int result = dao.delete(vo);
	if(result==1){
		out.print("delete successed...");
		response.sendRedirect("selectAll.jsp");
	}else{
		out.print("delete failed...");
	}
%>
