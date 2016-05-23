<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Workshop</title>
<style>
  tr,td,th{
  	padding: 5px 5px;
  }
</style>
<script src="../js/jquery.js"></script>

</head>
<body>
	<center>
		<form action="../WorkshopAdder" method="post" >
	 	<table>
	 	  <tr>
	 	    <th>Workshop Name</th>
	 	    <td><input type="text" name="name"></td>
	 	  </tr>
	 	  <tr>
	 	    <th>Date</th>
	 	    <td><input type="text" name="date" placeholder= "dd/mm/yy"> </td>
	 	  </tr>
	 	  <tr>
	 	     <th>Registrations Last Date</th>
	 	    <td><input type="text" name="regLastDate" placeholder= "dd/mm/yy"> </td>
	 	  </tr>
	 	  <tr>
	 	    <th>Registration Fee</th>
	 	    <td><input type="number" name="regFee"></td>
	 	  </tr>
	 	  <tr>
	 	    <th>Venue</th>
	 	    <td><input type="text" name="venue"></td>
	 	  </tr>
	 	  <tr>
	 	    <th>Workshop Details</th>
	 	    <td><textarea name="details" rows="10" cols="30"></textarea></td>
	 	  </tr>
	 	  <tr>
	 	    <td colspan="2" align="center"><button type="submit" >Add Workshop</button></td>
	 	  </tr>
	 	</table>
	 	</form>
	</center>
</body>
</html>