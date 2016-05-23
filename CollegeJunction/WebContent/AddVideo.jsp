<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Video</title>

<style>
   tr,th,td{
   	padding: 5px 10px;
   }
</style>
</head>
<body>
	<form action="./SaveVideo" method="post" enctype="multipart/form-data" >
	<table>
		<tr>
		  <th>Title </th>
		  <td><input type="text" name="title"></td>
		</tr>
		<tr>
		  <th>Video</th>
		  <td><input type="file"  name="video" accept="video/mp4,video/*"></td>
		</tr>
		<tr>
		  <th>Video Caption </th>
		  <td><input type="text" name="caption"></td>
		</tr>
		<tr>
		  <td colspan="2" style="padding-left: 80px;"><input type="submit" value="Save Video"></td>
		</tr>
	</table>
	</form>
</body>
</html>