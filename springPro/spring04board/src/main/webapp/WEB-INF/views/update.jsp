<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>update</h1>
	<jsp:include page="top_menu.jsp"></jsp:include>
	<form action="updateOK.do" method="post">
		<label>${vo2.num}</label>
		<input type="hidden" name="num" value="${vo2.num}"/>
		<input type="text" name="title" value="${vo2.title}"/>
		<input type="text" name="content" value="${vo2.content}"/>
		<input type="text" name="writer" value="${vo2.writer}"/>
		<input type="submit" value="updateOK"/>
	</form>

</body>
</html>