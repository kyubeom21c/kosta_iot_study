window.onload = function() {
	console.log("onload...");
	var btn = document.getElementById("btn");
	var btn2 = document.getElementById("btn2");
	var uList = document.getElementById("uList");
	var tList = document.getElementById("tList");

	btn.onclick = function() {
		console.log("onclick...");
		// http://localhost:8090/web06JSP_js/js05jsonArray.do
		js05jsonArray();
	};
	btn2.onclick = function() {
		console.log("onclick...");
		// http://localhost:8090/web06JSP_js/js05jsonArray.do
		js05jsonObjects();
	};
	var arr;
	var objs;

	function displayTable() {
		tList.innerHTML = "";
		for ( var i in objs) {
			var tr = document.createElement("TR"); // Create a <li> node
			var td1 = document.createElement("TD"); // Create a <li> node
			var td2 = document.createElement("TD"); // Create a <li> node
			var text1 = document.createTextNode(objs[i].name); // Create a text
																// node
			var text2 = document.createTextNode(objs[i].age); // Create a text
																// node
			td1.appendChild(text1); // Append the text to <li>
			td2.appendChild(text2); // Append the text to <li>
			tr.appendChild(td1); // Append the text to <li>
			tr.appendChild(td2); // Append the text to <li>
			tList.appendChild(tr);
		}
	}

	function displayUL() {
		uList.innerHTML = "";
		for ( var i in arr) {
			var node = document.createElement("LI"); // Create a <li> node
			var textnode = document.createTextNode(arr[i]); // Create a text
															// node
			node.appendChild(textnode); // Append the text to <li>
			uList.appendChild(node);
		}
	}

	function js05jsonArray() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				arr = JSON.parse(this.responseText);
				console.log(arr);
				displayUL();
			}
		};
		xhttp.open("GET", "js05jsonArray.do", true);
		xhttp.send();
	}
	function js05jsonObjects() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				objs = JSON.parse(this.responseText);
				console.log(objs);
				displayTable();
			}
		};
		xhttp.open("GET", "js05jsonObjects.do", true);
		xhttp.send();
	}
};