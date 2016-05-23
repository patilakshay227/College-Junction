<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Blog Post</title>

<script src="../js/nicEdit.js"></script>
<script>
bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
</script>
</head>
<body>
	<div>
	  <form action="../SaveBlogPost" method="post">
	    <table>
	      <tr>
	        <th>Title</th>
	        <td><input type="text" name="title" ></td>
	      </tr>
	      <tr>
	        <th>Content</th>
	     	<td><textarea cols="40" rows="10" name="post" id="postContent"></textarea></td>
	      </tr>
	      <tr>
	        <td colspan="2" align="center"><button type="submit">Post</button></td>
	      </tr>
	    </table>
	  </form>
	</div>
</body>
</html>