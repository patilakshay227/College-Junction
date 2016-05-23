<%@page import="models.ElearningModel"%>
<%@page import="entities.Ebooks"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ebooks Section - College Junction</title>
</head>
<body>
	<%
		List<Ebooks> list = ElearningModel.fetchNewlyAddedEbooks();
		if (list.size() == 0) {
	%>
	<h4>No ebooks added yet</h4>
	<%
		} else {
	%>
	
	<table>
	  <caption>Recently Added Ebooks</caption>
	  <tr>
	    <th>S.no</th>
	    <th>Title</th>
	    <th>Uploaded By</th>
	    <th>Download</th>
	  </tr>
	  <%   
	  	int i=1;
	  	for(Ebooks e : list) { %>
		<tr>
		  <td><%= i++ %></td>
		  <td><%= e.getTitle() %></td>
		  <td><%= e.getUploader() %></td>
		  <td><a href="./DownloadEbook?id=<%=e.getId()%>" >Download</a></td>
		</tr>
	<% }  %>
	</table>
	<%
		}
	%>
</body>
</html>