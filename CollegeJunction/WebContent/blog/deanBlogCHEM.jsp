<%@page import="models.BlogModel"%>
<%@page import="entities.BlogPost"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dean Blog ( Chemical Engineering Department ) - College Junction</title>
</head>
<body>
	<%
		List<BlogPost> posts = BlogModel.fetchDeanPosts("Chemical");
		if (posts.size()>0) {
	%>
	<div>
		<%
			for(BlogPost post : posts){
		%>
		
		<table>
		<tr>
		  <td><b><%= post.getTitle() %></b></td>
		</tr>
		<tr>
		  <td>Posted by : <%= post.getAuthor() %> , <%= post.getAuthorType() %> <%= post.getDepartment()%></td>
		</tr>
		<tr>
		 <td><pre><%= post.getPost() %></pre></td>
		</tr>
		</table>
		<%
			}
		%>
	
	   </div>
	   
	<%
		} else {
			%>
			<h4>Nothing posted yet...</h4>
			<h4>Do Visit Again</h4>
			<%
				}
			%>
</body>
</html>