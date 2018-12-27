<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>next</title>
<!-- <script src="http://aaaa.com/???.js"></script> -->
<script>
	console.log("hello1");
	
	var obj = {name:"kim",tel:"010"};
	console.log(obj);
	console.log(obj["name"]);
	console.log(obj["tel"]);
	console.log(obj.name);
	console.log(obj.tel);
	obj.age = 33;
	console.log(obj.age);
	
	console.log("++++");
	for ( var key in obj) {
		console.log(obj[key]);
	}
	
	
	var obj2 = new Object();
	obj2.kor = 99;
	obj2.eng = 88;
	obj2.math = 77;
	for ( var key in obj2) {
		console.log(obj2[key]);
	}
	
</script>
</head>
<body>
	<script>
		console.log("hello2");
	</script>
	<header>
		<hgroup>
			<h1>header</h1>
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
	<script>
		console.log("hello3");
	</script>

</body>
</html>