<%@page import="entities.Videos"%>
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
		Videos video = (Videos) request.getAttribute("video");
		String msg = (String) request.getAttribute("msg");
	%>
	<h4>
		<%=msg%>
	</h4>
	<%
		if (video != null) {
	%>
	<table>
		<tr>
			<th>Title</th>
			<td><%= video.getTitle()%></td>
		</tr>
		<tr>
			<td colspan="2">
			<video width="320" height="240" controls>
				<source src="${video.getLink()}">  
			</video>
			</td>
		</tr>
		<tr>
		  <th>Caption</th>
		  <td><%= video.getCaption() %></td>
		</tr>
	</table>

	<%
		}
	%>
</body>
</html>