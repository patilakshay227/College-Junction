<%@page import="entities.Photography"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>College Junction</title>
</head>
<body>
	<%
		Photography photography = (Photography) request.getAttribute("photography");
		String msg = (String) request.getAttribute("msg");
	%>
	<h4>
		<%=msg%>
	</h4>
	<%
		if (photography != null) {
	%>
	<table>
		<tr>
			<th>Title</th>
			<td><%=photography.getTitle()%></td>
		</tr>
		<tr>
			<td colspan="2">
			<figure>
			  <img src="./FetchPhotographyImage?id=<%= photography.getId() %> ">
			  <figcaption> <%= photography.getCaption() %></figcaption>
			</figure>
			</td>
		</tr>
	</table>

	<%
		}
	%>
</body>
</html>