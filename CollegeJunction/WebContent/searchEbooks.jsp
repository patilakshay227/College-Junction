<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ebooks - College Junction</title>
<style>
	input,select{
		width: 100%;
	}
	
	tr,td,th{
		padding: 5px;
	}
</style>
</head>
<body>
	
	<table>
	<form action="./EbookSearchEngine" method="post"  >
	<tr>
	  <th>Search By Name : </th>
	  <td><input type="text" name="name">
	    <input type="hidden" name="searchType" value="name">
	  </td>
	  <td>
	  <button type="submit">Search</button>
	  </td>
	</tr>
	</form>
	<tr>
	  <td colspan="3" align="center"><h3>OR</h3></td>
	</tr>
	<form action="./EbookSearchEngine" method="post"  >
	<tr>
	  <th>Search By Department : </th>
	  <td><select name="department">
						<option>---Select Department---</option>
						<option>Computer Science</option>
						<option>Information Technology</option>
						<option>Electronics and Communication</option>
						<option>Mechanical</option>
						<option>Civil</option>
						<option>Chemical</option>
				</select>
	  	<input type="hidden" name="searchType" value="department">
	  </td>
	  <td>
	  <button type="submit">Search</button>
	  </td>
	</tr>
	</form>
	<tr>
	  <td colspan="3" align="center"><h3>OR</h3></td>
	</tr>
	<form action="./EbookSearchEngine" method="post"  >
	<tr>
	  <th>Search By  Year : </th>
	  <td><select name="year">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
				</select>
	  	<input type="hidden" name="searchType" value="year">
	  </td>
	  <td>
	  <button type="submit">Search</button>
	  </td>
	</tr>
	</form>
	</table>
	
	
</body>
</html>