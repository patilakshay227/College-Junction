<%@page import="entities.Events"%>
<%@page import="java.util.List"%>
<%@page import="models.EventsModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
	List<Events> list = EventsModel.fetchEvents();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uploaded Events on site</title>
<script src="/CollegeJunction/js/jquery.js"></script>
<script>
	$(document).ready(function() {

	});

	function deleteEvent(id) {
		var res = confirm("Are You sure want to delete Event");
		if (res) {
			$.post("/CollegeJunction/admin/deleteEvent.jsp", "id=" + id,
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
				if (list.size() > 0) {
			%>

			<tr>
				<th>S.no</th>
				<th>Event</th>
				<th>Date</th>
			</tr>
			<%
				int i = 1;
					for (Events e : list) {
			%>
			<tr>
				<td><%=i++%></td>
				<td><%=e.getName()%></td>
				<td><%=e.getDate()%></td>
				<%
					if (msg == null) {
				%>
				<td><button type="button"
						onclick="return deleteEvent('<%=e.getId()%>')">Delete</button></td>
				<%
					}
				%>

			</tr>
			<%
				}
				} else {
			%>
			<center>
				<h4>No Events Found</h4>
			</center>
			<%
				}
			%>
		</table>
	</center>
</body>
</html>