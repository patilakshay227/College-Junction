<%@page import="models.SkillsModels"%>
<%@page import="entities.Videos"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	
	List<Videos> list = SkillsModels.fetchVideos();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uploaded Videos on site</title>
<script src="/CollegeJunction/js/jquery.js"></script>
<script>
	$(document).ready(function() {

	});

	function deleteWorkshop(id) {
		var res = confirm("Are You sure want to delete Video");
		if (res) {
			$.post("/CollegeJunction/deleteVideo.jsp", "id=" + id,
					function(data, status) {
						alert(data.trim());
						location.reload();
					})
		}

	}
</script>
<style>
tr, td, th {
	padding: 5px 10px;
}
</style>
</head>
<body>
	<center>
		<table>
			<%
				if (list.size() > 0) {
			%>

			<tr>
				<th>S.no</th>
				<th>Title</th>
				<th>Date</th>
				<th>Author</th>
			</tr>
			<%
				int i = 1;
					for (Videos v : list) {
			%>
			<tr>
				<td><%=i++%></td>
				<td><%=v.getTitle()%></td>
				<td><%=v.getUploadDate()%></td>
				<td><%= v.getAuthor() %></td>
				<td><button type="button"
						onclick="return deleteWorkshop('<%=v.getId()%>')">Delete</button></td>
				

			</tr>
			<%
				}
				} else {
			%>
			<center>
				<h4>No Videos Found</h4>
			</center>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>