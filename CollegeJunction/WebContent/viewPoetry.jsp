<%@page import="models.SkillsModels"%>
<%@page import="entities.Poetry"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Poetries Section - College Junction</title>
</head>
<body>
	<%
		long id = Long.parseLong(request.getParameter("id"));
		SkillsModels.updateView("Poetry", id);
		Poetry p = SkillsModels.getPoetry(id);
	%>
	<table>
		<tr>
			<th>Title</th>
			<td><%=p.getTitle()%><sub>By <%= p.getAuthor() +" , "+ p.getAuthorType() %></sub></td>
		</tr>
		<tr>
			<th>Poem</th>
			<td><pre><%=p.getPoem()%></pre></td>
		</tr>
		<tr>
			<td colspan="2"><%=p.getViews()%> Views <%=p.getLikes()%> Likes</td>
		</tr>
		<tr>
			<td colspan="2"><%=p.getRating()%> Stars</td>
		</tr>
		<tr>
		  <td><button type="button" onclick="likeSkill(<%=p.getId() %>)">Like</button></td>	
		</tr>
	</table>

</body>
</html>