<%@page import="entities.Notices"%>
<%@page import="java.util.List"%>
<%@page import="models.NewsAndNotices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
	List<Notices> noticesList = NewsAndNotices.fetchNotices();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uploaded Notices on site</title>
<script src="/CollegeJunction/js/jquery.js"></script>
<script>
	$(document).ready(function() {

	});

	function deleteNotice(id) {
		var res = confirm("Are You sure want to delete Notice");
		if (res) {
			$.post("/CollegeJunction/admin/deleteNotice.jsp", "id=" + id, function(data, status) {
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
				if (noticesList.size() > 0) {
			%>

			<tr>
				<th>S.no</th>
				<th>Title</th>
				<th>Upload Date</th>
				<th>View</th>
			</tr>
			<%
				int i = 1;
					for (Notices n : noticesList) {
			%>
			<tr>
				<td><%=i++%></td>
				<td><%=n.getTitle()%></td>
				<td><%=n.getDate()%></td>
				<td><a href="../DownloadNotice?id=<%=n.getId()%>">View</a></td>
				<%
					if (msg == null) {
				%>
				<td><button type="button"
						onclick="return deleteNotice('<%=n.getId()%>')">Delete</button></td>
				<%
					}
				%>
			</tr>
			<%
				}
				} else {
			%>
			<center>
				<h4>No Notices Found</h4>
			</center>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>