<%@page import="entities.VideoLectures"%>
<%@page import="java.util.List"%>
<%@page import="models.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Uploaded Video Lectures</title>
<script src="./js/jquery.js"> </script>
<script>
	function deleteVideoLecture(id){
		var res = confirm("Are you sure want to delete this Video Lecture");
	if (res) {
			
			$.post("./deleteVideoLecture.jsp", "id=" + id, function(
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
		List<VideoLectures> list = ElearningModel.fetchMyVideoLectures("akshaydapora@gmail.com");
		if (list.size() == 0) {
	%>
	<h4>You haven't uploaded any Video Lectures yet.</h4>
	<%
		} else {
	%>
	<table>
		<tr>
			<th>S.no</th>
			<th>Title</th>
			<th>Uploaded By</th>
			<th>Video Link</th>
		</tr>
		<%
			int i = 1;
				for (VideoLectures vl : list) {
		%>
		<tr>
			<td><%=i++%></td>
			<td><%=vl.getTitle()%></td>
			<td><%=UsersModel.getName(vl.getUploader())%></td>
			<td><a href="<%=vl.getLink()%>">Link</a></td>
			<td><button type="button" onclick="deleteVideoLecture(<%= vl.getId()%>)">Delete</button></td>
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