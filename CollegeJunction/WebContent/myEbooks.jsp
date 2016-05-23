<%@page import="models.UsersModel"%>
<%@page import="models.ElearningModel"%>
<%@page import="entities.Ebooks"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Uploaded Ebooks</title>
<script src="./js/jquery.js"> </script>
<script>
	function deleteEbook(id){
		var res = confirm("Are you sure want to delete this Ebook");
	if (res) {
			
			$.post("./deleteEbook.jsp", "id=" + id, function(
					data, status) {
				alert(data.trim());
				location.reload();
				
			});
		}
	}
</script>
</head>
<body>
	<%
		List<Ebooks> list = ElearningModel.fetchMyEbooks("akshaydapora@gmail.com");
		if (list.size() == 0) {
	%>
	<h4>You haven't uploaded any ebooks yet.</h4>
	<%
		} else {
	%>
	<table>
		<tr>
			<th>S.no</th>
			<th>Title</th>
			<th>Uploaded By</th>
			<th>Download</th>
		</tr>
		<%
			int i = 1;
				for (Ebooks e : list) {
		%>
		<tr>
			<td><%=i++%></td>
			<td><%=e.getTitle()%></td>
			<td><%=UsersModel.getName(e.getUploader())%></td>
			<td><a href="./DownloadEbook?id=<%=e.getId()%>">Download</a></td>
			<td><button type="button" onclick="deleteEbook(<%= e.getId()%>)">Delete</button></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
</body>
</html>