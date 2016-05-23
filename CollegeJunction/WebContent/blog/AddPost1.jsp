<%@page import="entities.BlogPost"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Blog Post</title>
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
			BlogPost post = (BlogPost)request.getAttribute("post");
	%>
	<div><%=msg%></div>
	 <table>
	      <tr>
	        <th>Title</th>
	        <td><%= post.getTitle() %></td>
	      </tr>
	      <tr>
	        <th>Content</th>
	     	<td><pre><%= post.getPost() %></pre></td>
	      </tr>
	</table>
	<%
		}
	%>
</body>
</html>