<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add e-Book</title>
<style>
	input{
		width: 100%;
	}
	tr,td,th{
		padding: 5px;
	}
</style>
</head>
<body>
	<center>
	<form action="./EbookAdder" method="post" enctype="multipart/form-data">
	<table>
		<tr>
		  <th>Title </th>
		  <td><input type="text" name="title"></td>
		</tr>
		<tr>
		  <th>Department</th>
		  <td>
		      <select name="department">
						<option>---Select Department---</option>
						<option>Computer Science</option>
						<option>Information Technology</option>
						<option>Electronics and Communication</option>
						<option>Mechanical</option>
						<option>Civil</option>
						<option>Chemical</option>
				</select>
			</td>
		</tr>
		<tr>
		  <th>Year</th>
		  <td><input type="number" name="year" max="4" min="1" maxlength="1"></td>
		</tr>
		<tr>
		  <td></td>
		  
		</tr>
		<tr>
		  <th>PDF File </th>
		  <td><input type="file" name="pdfFile" accept="application/pdf"></td>
		</tr>
		<tr>
		  <td colspan="2" style="padding-left: 80px;"><button type="submit" >Add</button></td>
		</tr>
	</table>
	</form>
	</center>
</body>
</html>