<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script> -->
<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		console.log("ready....");
		
		//test2.do
		$.get("test2.do",function(data,status){
			console.log("data...."+data);
			console.log("status...."+status);
			if(status==="success"){
				var objs = JSON.parse(data);
				console.log(objs);
				objs.forEach(function(obj) {
					console.log(obj.num + "," + obj.kor + "," + obj.eng + ","
							+ obj.math);
					var tr = "<tr class='row'>";
					tr += "<td>" + obj.num + "</td>";
					tr += "<td>" + obj.kor + "</td>";
					tr += "<td>" + obj.eng + "</td>";
					tr += "<td>" + obj.math + "</td>";
					tr += "</tr>";
					$("#t01").append(tr);
				});
				
				var images = ["Chrysanthemum.jpg","Desert.jpg","Koala.jpg"];
				
				$(".row").each(function(index){
					console.log("index...."+index);
					$(this).on("mouseover",function(){
						$(this).css({"font-size":"40px"});
						$("#imageView").attr("src","images/"+images[index]);
					}).on("mouseout",function(){
						$(this).css({"font-size":"20px"});
					});
				});
				
				
				
				$("#t01").css({
					background : "red"
				});
				$("#t01").find("td").css({
					background : "white"
				});
				$("#t01").find("th").css({
					background : "gold"
				});
			}
			
		});

		
		$("#selectOneForm").on("submit",function(){
			console.log("submit....");
			$("#tbody01").empty();
			$.post("selectOne.do",{
				num : $("#num").val()
			},function(data,status){
				console.log("data...."+data);
				console.log("status...."+status);
				if(status==="success"){
					var obj = JSON.parse(data);
					console.log(obj);
					
					var tr = "<tr id='row'>";
					tr += "<td>" + obj.num + "</td>";
					tr += "<td>" + obj.kor + "</td>";
					tr += "<td>" + obj.eng + "</td>";
					tr += "<td>" + obj.math + "</td>";
					tr += "</tr>";
					$("#tbody01").append(tr);
					$("#tbody01").find("td").css({
						background : "white"
					});
					
					
				}
			});
			return false;
		});

		
		

	});
</script>
</head>
<body>
	<h1>hello</h1>
	<form id="selectOneForm" action="">
		<input type="number" id="num" name="num" value="1">
		<input type="submit" value="OK">
	</form>
	<table id="t01">
		<thead>
			<tr>
				<th>NUM</th>
				<th>KOR</th>
				<th>ENG</th>
				<th>MATH</th>
			</tr>
		</thead>
		<tbody id="tbody01">
			
		</tbody>
	</table>
	<div>
		<img id="imageView" width="200px" src="images/Chrysanthemum.jpg"/>
	</div>
</body>
</html>