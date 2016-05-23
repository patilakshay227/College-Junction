<%@page import="users.Director"%>
<%@page import="users.TPO"%>
<%@page import="users.Dean"%>
<%@page import="users.Faculty"%>
<%@page import="users.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script src="/CollegeJunction/js/jquery.js"></script>
<style>
.dropbtn {
	padding: 16px 5px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	text-align: left;
	float: left;
	right: 0;
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 150px;
	overflow: auto;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown a:hover {
	background-color: #f1f1f1
}

.show {
	display: block;
}
</style>
<script>
	/* When the user clicks on the button, 
	 toggle between hiding and showing the dropdown content */
	function showOptions() {
		document.getElementById("myDropdown").classList.toggle("show");
	}

	// Close the dropdown if the user clicks outside of it
	window.onclick = function(event) {
		if (!event.target.matches('.dropbtn')) {

			var dropdowns = document.getElementsByClassName("dropdown-content");
			var i;
			for (i = 0; i < dropdowns.length; i++) {
				var openDropdown = dropdowns[i];
				if (openDropdown.classList.contains('show')) {
					openDropdown.classList.remove('show');
				}
			}
		}
	}
</script>
</head>
<body>
	<%
		String userType = (String) session.getAttribute("userType");
		if (userType == "Student") {

			Student s = (Student) session.getAttribute("user");
	%>
	<div style="float: right; font-size: 18px;">
		Welcome
		<%=s.getName()%>
		<div class="dropdown">
			<span onclick="showOptions()" class="dropbtn">&#x25BC; </span>
			<div id="myDropdown" class="dropdown-content">
				<a href="#">My Profile</a> <a href="#">Add Content</a> <a href="#">My
					Uploads</a> <a href="./Logout" style="color: red;">Logout</a>

			</div>
		</div>
	</div>
	<%
		} else if (userType == "Faculty") {
			Faculty f = (Faculty) session.getAttribute("user");
	%>
	<div style="float: right; font-size: 18px;">
		Welcome
		<%=f.getName()%>
		<div class="dropdown">
			<span onclick="showOptions()" class="dropbtn">&#x25BC; </span>
			<div id="myDropdown" class="dropdown-content">
				<a href="#">My Profile</a> <a href="#">View Queries</a> <a href="#">Add
					Content</a> <a href="#">My Uploads</a> <a href="./Logout"
					style="color: red;">Logout</a>

			</div>
		</div>
	</div>
	<%
		}else if (userType == "Director") {
			Director d = (Director) session.getAttribute("user");
	%>
	<div style="float: right; font-size: 18px;">
		Welcome
		<%=d.getName()%>
		<div class="dropdown">
			<span onclick="showOptions()" class="dropbtn">&#x25BC; </span>
			<div id="myDropdown" class="dropdown-content">
				<a href="#">My Profile</a> <a href="#">View Queries</a> <a href="#">Add
					Content</a> <a href="#">My Uploads</a> <a href="./Logout"
					style="color: red;">Logout</a>

			</div>
		</div>
	</div>
	<%
		}else if (userType == "Dean") {
			Dean d = (Dean) session.getAttribute("user");
	%>
	<div style="float: right; font-size: 18px;">
		Welcome
		<%=d.getName()%>
		<div class="dropdown">
			<span onclick="showOptions()" class="dropbtn">&#x25BC; </span>
			<div id="myDropdown" class="dropdown-content">
				<a href="#">My Profile</a> 
				<a gref="#">My Blog</a>
				<a href="#">View Queries</a> <a href="#">Add
					Content</a> <a href="#">My Uploads</a> <a href="./Logout"
					style="color: red;">Logout</a>

			</div>
		</div>
	</div>
	<%
		}else if (userType == "TPO") {
			TPO tpo = (TPO) session.getAttribute("user");
	%>
	<div style="float: right; font-size: 18px;">
		Welcome
		<%=tpo.getName()%>
		<div class="dropdown">
			<span onclick="showOptions()" class="dropbtn">&#x25BC; </span>
			<div id="myDropdown" class="dropdown-content">
				<a href="#">My Profile</a> <a href="#">View Queries</a> <a href="#">Add
					Content</a> <a href="#">My Uploads</a> <a href="./Logout"
					style="color: red;">Logout</a>

			</div>
		</div>
	</div>
	<%
		}
	%>
	

</body>
</html>