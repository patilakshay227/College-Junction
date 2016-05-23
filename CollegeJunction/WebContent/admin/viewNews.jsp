<%@page import="entities.News"%>
<%@page import="models.NewsAndNotices"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
	List<News> newsList = NewsAndNotices.fetchNews();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uploaded News on site</title>
<script src="/CollegeJunction/js/jquery.js"></script>
<script>
	$(document).ready(function() {

	});

	function deleteNews(id) {
		var res = confirm("Are You sure want to delete News");
		if (res) {
			$.post("/CollegeJunction/admin/deleteNews.jsp", "id=" + id, function(data, status) {
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

		<%
			if (msg != null) {
		%>
		<script src="./js/jquery.js"></script>
		<center>
			<h4><%=msg%></h4>
		</center>
		<%
			}
		%>
		<table>
			<%
				if (newsList.size() > 0) {
			%>

			<tr>
				<th>S.no</th>
				<th>News</th>
				<th>Upload Date</th>
			</tr>
			<%
				int i = 1;
					for (News n : newsList) {
			%>
			<tr>
				<td><%=i++%></td>
				<td><%=n.getNews()%></td>
				<td><%=n.getUploadDate()%></td>
				<%
					if (msg == null) {
				%>
				<td><button type="button"
						onclick="return deleteNews('<%=n.getId()%>')">Delete</button></td>
				<%
					}
				%>
			</tr>
			<%
				}
				} else {
			%>
			<center>
				<h4>No News Found</h4>
			</center>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>