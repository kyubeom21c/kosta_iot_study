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
	var arr = [1,2,3];
// 	var obj = {name:"kim",age:33};
	
	console.log(arr);
	console.log(arr[0]);
	console.log(arr[1]);
	console.log(arr[2]);
	console.log(arr[30]);
	console.log(arr[29]);
	arr[30] = 100;
	arr.push(111);
	console.log(arr[31]);
	console.log(arr.length);
	
	for (var i = 0; i < arr.length; i++) {
		console.log(arr[i]);
	}
	
	for ( var i in arr) {
		console.log(arr[i]);
	}
	
	
	var arr2 = new Array(10);
	arr2[1] = 11;
	console.log(arr2);
	console.log(arr2.length);
	for (var i = 0; i < arr2.length; i++) {
		console.log(arr2[i]);
	}
	for ( var i in arr2) {//데이터가 인는것들만
		console.log(arr2[i]);
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