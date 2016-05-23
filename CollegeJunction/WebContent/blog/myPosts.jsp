<%@page import="users.Dean"%>
<%@page import="users.Director"%>
<%@page import="models.BlogModel"%>
<%@page import="entities.BlogPost"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Blog Post</title>
<script src="../js/jquery.js"></script>
<script>
	
	function deletePost(id){
		
		var res = confirm("Are you sure want to delete this post");
		if(res){
		$.post("./deletePost.jsp?id="+id,function(data,status){
			alert(data.trim());
			location.reload();
		});
		}
	}
</script>
</head>
<body>
	<%
		List<BlogPost> list = null;

		if (((String) session.getAttribute("userType")).equals("Director")) {
			Director d = (Director) session.getAttribute("user");
			list = BlogModel.fetchMyPosts(d.getName(), "Director");
		} else if (((String) session.getAttribute("userType")).equals("Dean")) {
			Dean d = (Dean) session.getAttribute("user");
			list = BlogModel.fetchMyPosts(d.getName(), "Dean");
		}

		if ((list != null) && list.size() > 0) {
	%>
	<table>
	<%
		for (BlogPost post : list) {
	%>
			<tr>
			<td><b><%=post.getTitle()%></b>  <button type="button" onclick="deletePost(<%= post.getId() %>)"> Delete</button></td>
			</tr>
			<tr>
				<td>on <%=post.getDate()%></td>
			</tr>
			<tr>
				<td><pre><%= post.getPost()%></pre></td>
			</tr>
	<%
		}
	%>
	</table>
	<%
		} else {
	%>
	<h4>No Content Posted yet</h4>
	<%
		}
	%>
</body>
</html>