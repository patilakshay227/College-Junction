<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Photo</title>

<style>
   tr,th,td{
   	padding: 5px 10px;
   }
</style>
</head>
<body>
	<form action="./SavePhotography" method="post" enctype="multipart/form-data">
	<table>
		<tr>
		  <th>Title </th>
		  <td><input type="text" name="title"></td>
		</tr>
		<tr>
		  <th>Photo </th>
		  <td><input type="file" name="photo" accept="image/*"> <span style="color: red;font-size: 0.8em">Image size should be less than 10 MB</span></td>
		</tr>
		<tr>
		  <th>Photo Caption </th>
		  <td><input type="text" name="caption"></td>
		</tr>
		<tr>
		  <td colspan="2" style="padding-left: 80px;"><input type="submit" value="Save Photo"></td>
		</tr>
	</table>
	</form>
</body>
</html>