<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>next</title>
<!-- <script src="http://aaaa.com/???.js"></script> -->
<script>
	//1.선언과 콜
	function test(x, y) {
		console.log("test()...");
		console.log(x);
		console.log(y);
		console.log(arguments[2]);
	}

	test();
	test(100, 200);
	test(100, 200, 300);
	console.log(test());
	console.log(test);

	//2.반환 리턴
	function test2() {
		return 100;
	}
	var su = test2();
	console.log(test2());
	console.log(test2);
	console.log(su);

	//3. 함수 할당
	var fn = function() {
		console.log("fn()....")
		return 100;
	};

	var x = fn();
	console.log(x);

	//4. 함수콜할때 인자로 줄수있다
	function test3(fn) {
		console.log("test3()...");
		console.log(fn);
		console.log(fn());
	}
	test3(function() {
		return "kim"
	});
	
	//5.리턴문에 함수사용
	function test4(){
		console.log("test4()...");
		return function(){
			console.log("return fn...");
			return {name:"kim"};
		};
	}
	
	var f = test4();
	console.log(f);
	console.log(f());
</script>
</head>
<body>
	<header>
		<hgroup>
			<h1 id="a1">header</h1>
			<h1 id="a2">header</h1>
		</hgroup>
		<button id="btn">click</button>
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