<%@page import="test.com.model.MemberDAOimpl"%>
<%@page import="test.com.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="test.com.model.MemberVO"%>
<%
	System.out.println(request.getParameter("num"));
	System.out.println(request.getParameter("id"));
	String num = request.getParameter("num");
	String id = request.getParameter("id");
	MemberVO vo = new MemberVO();
	vo.setNum(Integer.parseInt(num));
	vo.setId(id);
	MemberDAO dao = new MemberDAOimpl();
	int result = dao.insert(vo);
	if(result==1){
		out.print("insert successed...");
		response.sendRedirect("selectAll.jsp");
	}else{
		out.print("insert failed...");
		response.sendRedirect("insert.jsp");
	}
%>
<%="aaaa"%>
<%=1111%>
<%=id%>
<%=request.getParameter("id")%>
${param.id} EL