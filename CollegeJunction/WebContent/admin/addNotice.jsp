<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Notice</title>
<style>
   tr,th,td{
   	padding: 5px 10px;
   	text-align: left;
   }
</style>
</head>
<body>
	<center>
	<form action="../NoticeAdder" method="post" enctype="multipart/form-data">
	<table>
		<tr>
		  <th>Title </th>
		  <td><input type="text" name="title"></td>
		</tr>
		<tr>
		  <th>PDF File </th>
		  <td><input type="file" name="pdfFile" accept="application/pdf"></td>
		</tr>
		<tr>
		  <td colspan="2" style="padding-left: 80px;"><input type="submit" value="Add Notice"></td>
		</tr>
	</table>
	</form>
	</center>
</body>
</html>