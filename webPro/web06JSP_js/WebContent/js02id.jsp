<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>next</title>
<!-- <script src="http://aaaa.com/???.js"></script> -->
<script>
	function test(){
		var a1 = document.getElementById("a1");
		var a2 = document.getElementById("a2");
		a1.innerHTML = "<p>aaaaaa</p>";
		a2.innerText = "<p>xxxxxx</p>";
		console.log(a1);
		console.log(a2);
		console.log("hello3");
	}
</script>
</head>
<body onload="test()">
	<header>
		<hgroup>
			<h1 id="a1">header</h1>
			<h1 id="a2">header</h1>
		</hgroup>
	</header>
	<section>
		<h1>section</h1>
		<ul>
			<li>data</li>
			<li>data</li>
			<li>data</li>
		</ul>
		<ol>
			<li>data</li>
			<li>data</li>
			<li>data</li>
		</ol>
	</section>
	<footer>
		<p>footer</p>
	</footer>


</body>
</html>