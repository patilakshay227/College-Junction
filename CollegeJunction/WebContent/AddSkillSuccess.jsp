<%@page import="models.SkillsModels"%>
<%@page import="entities.Research"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Skill</title>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
		String errMsg = (String) request.getAttribute("errMsg");
	%>
	<%
		if (errMsg != null) {
	%>
	<div style="color: red"><%=errMsg%></div>
	
	<%
		} else {
	%>
	<div><%=msg%></div>
	<div><a href="myUploads.jsp">View My Uploads</a></div>
	<%
		}
	%>
</body>
</html>