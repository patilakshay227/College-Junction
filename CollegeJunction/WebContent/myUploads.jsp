<%@page import="entities.Research"%>
<%@page import="entities.MotivationalThought"%>
<%@page import="entities.Photography"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="entities.Poetry"%>
<%@page import="entities.Videos"%>
<%@page import="java.util.List"%>
<%@page import="models.SkillsModels"%>
<%@page import="entities.Skills"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>College Junction - My Uploads</title>
<style>
tr, td, th {
	padding: 5px 10px;
}

.deleteBtn {
	float: right;
}

b {
	font-size: 20px;
}

img {
	width: 200px;
	height: 200px;
}
</style>
<script src="./js/jquery.js"></script>
<script>
	function deleteResearch(id) {
		var res = confirm("Are You sure want to delete this Research");
		if (res) {
			
			$.post("/CollegeJunction/deleteResearch.jsp", "id=" + id, function(
					data, status) {
				alert(data.trim());
				location.reload();
				
			});
		}
	}

	function deleteVideo(id) {
		var res = confirm("Are You sure want to delete this Video");
		if (res) {
			$.post("/CollegeJunction/deleteVideo.jsp", "id=" + id, function(
					data, status) {
				alert(data.trim());
				location.reload();
			});
		}
	}

	function deletePoetry(id) {
		var res = confirm("Are You sure want to delete this Poem");
		if (res) {
			$.post("/CollegeJunction/deletePoetry.jsp", "id=" + id, function(
					data, status) {
				alert(data.trim());
				location.reload();
				
			});
		}
	}

	function deletePhoto(id) {
		var res = confirm("Are You sure want to delete this Photo");
		if (res) {
			$.post("/CollegeJunction/deletePhoto.jsp", "id=" + id, function(
					data, status) {
				alert(data.trim());
				location.reload();
			});
		}
	}
	
	function deleteMotivationalThought(id) {
		var res = confirm("Are You sure want to delete this Thought");
		if (res) {
			$.post("/CollegeJunction/deleteMotivationalThought.jsp", "id=" + id, function(
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
		List<Skills> list = SkillsModels.fetchMyUploads("NULL");
		Collections.sort(list, new Comparator<Skills>() {
			@Override
			public int compare(Skills a, Skills b) {

				int res = b.getUploadDate().compareTo(a.getUploadDate());
				if (res == 0) {
					res = b.getUploadTime().compareTo(a.getUploadTime());
				}
				return res;
			}
		});
	%>
	<table>
		<%
			for (Skills s : list) {
		%>
		<tr>
			<td><hr>
				<table width="800px">

					<%
						if (s instanceof Videos) {
								Videos vd = (Videos) s;
					%>

					<tr>
						<td colspan="2"><b>Video</b>
						<button class="deleteBtn" type="button"
								onclick="deleteVideo('<%=vd.getId()%>')">Delete</button></td>
					</tr>
					<tr>
						<th>Title</th>
						<td><%=s.getTitle()%></td>
					</tr>
					<tr>
						<th>Video</th>
						<td><video width="200px" height="150px" controls> <source
								src="<%=vd.getLink()%>"></source> </video></td>
					</tr>
					<tr>
						<th>Video Caption</th>
						<td><%=vd.getCaption()%></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><%=vd.getViews()%> Views <%=vd.getLikes()%>
							Likes</td>
					</tr>
					<tr>
						<th>Rating</th>
						<td><%=vd.getRating()%> Stars</td>
					</tr>
					<%
						} else if (s instanceof Poetry) {
								Poetry p = (Poetry) s;
					%>

					<tr>
						<td colspan="2"><b>Poetry</b>
						<button class="deleteBtn" type="button"
								onclick="deletePoetry('<%=p.getId()%>')">Delete</button></td>
					</tr>
					<tr>
						<th>Title</th>
						<td><%=s.getTitle()%></td>
					</tr>
					<tr>
						<th>Poem</th>
						<td><pre><%=p.getPoem()%></pre></td>
					</tr>
					<tr>
						<td colspan="2"><%=p.getViews()%> Views <%=p.getLikes()%>
							Likes</td>
					</tr>
					<tr>
						<th>Rating</th>
						<td><%=p.getRating()%> Stars</td>
					</tr>
					<%
						} else if (s instanceof Photography) {
								Photography p = (Photography) s;
					%>

					<tr>
						<td colspan="2"><b>Photohraphy</b>
						<button class="deleteBtn" type="button"
								onclick="deletePhoto('<%=p.getId()%>')">Delete</button></td>
					</tr>
					<tr>
						<th>Title</th>
						<td><%=p.getTitle()%></td>
					</tr>
					<tr>
						<th>Photo</th>
						<td><figure> <img
								src="./FetchPhotographyImage?id=<%=p.getId()%> "> <figcaption>
							<%=p.getCaption()%></figcaption> </figure></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><%=p.getViews()%> Views <%=p.getLikes()%>
							Likes</td>
					</tr>
					<tr>
						<th>Rating</th>
						<td><%=p.getRating()%> Stars</td>
					</tr>
					<%
						} else if (s instanceof MotivationalThought) {
								MotivationalThought mt = (MotivationalThought) s;
					%>
					<tr>
						<td colspan="2"><b>Motivational Thought</b>
							<button class="deleteBtn" type="button"
								onclick="deleteMotivationalThought('<%=mt.getId()%>')">Delete</button></td>
					</tr>
					<tr>
						<th>Thought</th>
						<td><%=mt.getThought()%></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><%=mt.getViews()%> Views <%=mt.getLikes()%>
							Likes</td>
					</tr>
					<tr>
						<th>Rating</th>
						<td><%=mt.getRating()%> Stars</td>
					</tr>
					<%
						} else if (s instanceof Research) {
								Research r = (Research) s;
					%>
					<tr>
						<td colspan="2"><b>Research</b>
							<button class="deleteBtn" type="button"
								onclick="deleteResearch('<%=r.getId()%>')">Delete</button></td>
					</tr>
					<tr>
						<th>Title</th>
						<td><%=r.getTitle()%></td>
					</tr>
					<tr>
						<th>Description</th>
						<td><pre><%=r.getDescription()%></pre></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><%=r.getViews()%> Views <%=r.getLikes()%>
							Likes</td>
					</tr>
					<tr>
						<th>Rating</th>
						<td><%=r.getRating()%> Stars</td>
					</tr>
					<%
						}
					%>

				</table></td>
		</tr>
		<%
			}
		%>
	</table>
	<div></div>

</body>
</html>