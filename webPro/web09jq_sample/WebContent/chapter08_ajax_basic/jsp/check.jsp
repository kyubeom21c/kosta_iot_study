<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("userid");
	System.out.println("check.jsp" + id);
	if ("admin".equals(id)) {
		out.print("�ߺ��� ���̵��Դϴ�.");
	} else {
		out.print("��밡����  ���̵��Դϴ�.");
	}
%>
