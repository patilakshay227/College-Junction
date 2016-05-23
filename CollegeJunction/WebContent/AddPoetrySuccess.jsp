<%@page import="entities.Poetry"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Poem</title>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
		Poetry poem = (Poetry) request.getAttribute("poem");
	%>

	<table>
		<tr>
			<td><%=msg%></td>
		</tr>
		<%
			if (poem != null) {
		%>
		<tr>
			<td>Title</td>
			<td><%=poem.getTitle()%></td>
		</tr>
		<tr>
		  <td>Posted on </td>
		  <td> <%= poem.getUploadDate() %>  <%=  poem.getUploadTime() %></td>
		</tr>
		<tr>
			<td>Your Poem</td>
			<td><pre><%= poem.getPoem() %> </pre></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>