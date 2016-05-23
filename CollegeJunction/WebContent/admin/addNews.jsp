<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add News</title>
<style>
  tr,td,th{
  	padding: 5px 5px;
  }
</style>
<script src="../js/jquery.js"></script>

</head>
<body>
	<center>
		<form action="../NewsAdder" method="post" >
	 	<table>
	 	  <tr>
	 	    <th>News</th>
	 	    <td><textarea rows="2" cols="30" name="news" style=" overflow: hidden;"></textarea></td>
	 	  </tr>
	 	  <tr>
	 	    <td colspan="2" align="center"><button type="submit" >Add News</button></td>
	 	  </tr>
	 	</table>
	 	</form>
	</center>
</body>
</html>