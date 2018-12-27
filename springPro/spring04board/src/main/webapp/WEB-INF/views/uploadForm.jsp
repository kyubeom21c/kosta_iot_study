<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadForm.jsp</title>
</head>
<body>
	<h2>uploadForm.jsp</h2>

	<form action="uploadOK.do" method="post" 
		enctype="multipart/form-data">
		key01:<input type="text" name="key01" value="yangssem"><br />
		key02:<input type="text" name="key02" value="010"><br />
		key03:<input type="file" name="key03"><br /> <input
			type="submit" value="전송">
	</form>
</body>
</html>