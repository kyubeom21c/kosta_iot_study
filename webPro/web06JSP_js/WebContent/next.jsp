<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>next</title>
</head>
<body>
	<header>
		<hgroup>
			<h1>next</h1>
			<nav>
				<a href="index.do">index</a>
				<a href="next.do">next</a>
				<a href="loginOK.do">loginOK</a>
			</nav>
		</hgroup>
	</header>
	<section>
		<section>
			<p>request-param:${param.msg}</p>
			<p>request-attr:${name}</p>
			<p>session:${user_name}</p>
			<p>context:${info}</p>
			<img alt="" src="yangssem.jpg" />
		</section>
		<section>
			<form action="insertOK.do" method="post" enctype="multipart/form-data">
				<input type="file" name="f1" value=""/>
				<input type="submit"  value="send"/>
			</form>			

		</section>
	</section>
	<footer>
		<p>
			Copyright © 2018 WHATWG (Apple, Google, Mozilla, Microsoft). This work is licensed under a Creative Commons Attribution 4.0 International License.
		</p>
	</footer>
	
	
</body>
</html>