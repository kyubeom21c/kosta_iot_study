<%@ page contentType="text/html;charset=euc-kr"%>
<%@ page import="java.util.*" %>

<%
String pno = request.getParameter("pno");
String currentPage = request.getParameter("currentPage");
List<String[]> phoneDb = (List<String[]>) session.getAttribute("phoneDb");
String[] phone = null;
for(String[] p : phoneDb) {
	if(p[0].equals(pno)) {
		phone = p;
		break;
	}
}
%>
<!DOCTYPE html> 
<html> 
	<head> 
		<title>jQuery Mobile</title> 
		<meta charset="euc-kr" /> 	
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>
		
		<link rel="shortcut icon" href="../image/icon.png">
		<link rel="apple-touch-icon" href="../image/icon.png">

		<!-- 
		<link href="http://code.jquery.com/mobile/latest/jquery.mobile.min.css" 
				rel="stylesheet" type="text/css" />
		<script src="http://code.jquery.com/jquery-1.6.4.min.js"></script>
		-->
		
		<link href="../framework/jquery.mobile-1.0.css" rel="stylesheet" type="text/css" />
		<script src="../framework/jquery-1.6.4.js"></script>
				
		<script type="text/javascript">
			$(document).bind("mobileinit", function() {
				$("#home").live("pagebeforeshow", function(event, ui) {
					btnShowAndHide();
				});
			});
			
			
			// JavaScript
			function jsUpdateSize(){
			    // Get the dimensions of the viewport
			    var width = window.innerWidth ||
			                document.documentElement.clientWidth ||
			                document.body.clientWidth;
			    var height = window.innerHeight ||
			                 document.documentElement.clientHeight ||
			                 document.body.clientHeight;

			    document.getElementById('jsWidth').innerHTML = width;
			    document.getElementById('jsHeight').innerHTML = height;
			    
			    document.getElementById('test').style.width = width+"px";
// 			    myimg.style.height = "50px";
// 			    myimg.style.width = "50px";
			};
			window.onload = jsUpdateSize;       // When the page first loads
			window.onresize = jsUpdateSize;     // When the browser changes size

			// jQuery
			function jqUpdateSize(){
			    // Get the dimensions of the viewport
			    var width = $(window).width();
			    var height = $(window).height();

			    $('#jqWidth').html(width);
			    $('#jqHeight').html(height);
			};
			$(document).ready(jqUpdateSize);    // When the page first loads
			$(window).resize(jqUpdateSize);     // When the browser changes size
		</script>
		
		<!-- 
		<script src="http://code.jquery.com/mobile/latest/jquery.mobile.min.js"></script>
		-->
		
		<script src="../framework/jquery.mobile-1.0.js"></script>

		<script type="text/javascript">
			function btnShowAndHide() {
				if($("#home").attr("data-login") == "ok") {
					$("#btnLogin").hide();
					$("#btnLogout").show();
					$("#btnPhoneList").attr("href", "phonelist.jsp?currentPage=1");
				} else {
					$("#btnLogin").show();
					$("#btnLogout").hide();
					$("#btnPhoneList").attr("href", "#");
				}
			}
			function logout() {
				$("#home").attr("data-login", "");
				btnShowAndHide();
			}
		</script>
	</head> 

	<body>
<div id="phonedetail" data-role="page" data-theme="a">
	<div data-role="header" data-theme="a">
		<h1>폰 상세 내용</h1>
	</div>  

	<div data-role="content">
		<ul data-role="listview">
			<li>
				<table>
					<tr>
						<td >
     <img id="test"   src="../image/<%=phone[2]%>"/>
						</td>
						<td style="padding-left: 5px">
							<table>
								<tr style="padding: 5px">
									<td style="padding: 5px">모델명:</td>
									<td><%=phone[1]%></td>
								</tr>
								<tr style="padding: 5px">
									<td style="padding: 5px">제조사:</td>
									<td><%=phone[3]%></td>
								</tr>
								<tr style="padding: 5px">
									<td style="padding: 5px">상품가:</td>
									<td><%=phone[4]%></td>
								</tr>
								<tr style="padding: 5px">
									<td style="padding: 5px">색상:</td>
									<td><%=phone[5]%></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr><td><!-- JavaScript -->
<p>
    <strong>JavaScript resize:</strong>
    <span id="jsWidth">0</span>,
    <span id="jsHeight">0</span>
</p>
<br/>

<!-- jQuery -->
<p>
    <strong>jQuery resize:</strong>
    <span id="jqWidth">0</span>,
    <span id="jqHeight">0</span>
</p></td></tr>
				</table>
			</li>
		</ul>
    </div>
    
	<div data-role="footer" data-position="fixed" data-theme="a">
    	<div data-role="navbar">
    		<ul>
				<li><a href="#home" data-icon="home" 
							data-transition="slide" 
							data-direction="reverse">앱홈</a></li>
				<li><a href="phonelist.jsp?currentPage=1" 
							data-icon="grid"
							data-transition="slide" 
							data-direction="reverse">목록</a></li>
				<li><a href="phoneupdateform.jsp?pno=<%=pno%>" 
							data-icon="grid"
							data-transition="slide" 
							data-direction="reverse">수정</a></li>
				<li><a href="phonedelete.jsp?pno=<%=pno%>" 
							data-icon="grid"
							data-transition="slide" 
							data-direction="reverse">삭제</a></li>
			</ul>
		</div>
    </div>
</div>
</body>
</html>