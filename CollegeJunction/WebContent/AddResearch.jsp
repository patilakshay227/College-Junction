<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Research work</title>
<style>
  tr,td,th{
  	padding: 5px 10px;
  }
</style>
</head>
<body>
	
	<form action="./SaveResearch" method="post">
	<table>
	 <tr>
	   <th>Title</th>
	   <td> <input type="text" name="title"></td>
	 </tr>
	 <tr>
	   <th>Research Description </th>
	   <td><textarea rows="20" cols="50" name="description"></textarea></td>
	 </tr>
	 <tr>
	   <td colspan="2" align="center"><input type="submit" value="Add Research"></td>
	 </tr>
	</table>
	</form>
	
</body>
</html>