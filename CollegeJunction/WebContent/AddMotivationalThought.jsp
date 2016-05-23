<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Motivational Thought</title>
</head>
<body>
	<div>
	  <form action="./SaveMotivationalThought" method="post">
	  <table>
	    <tr>
	      <th>Thought</th>
	      <td><textarea cols="30" rows="2" placeholder="Type your thought here..." name="thought"></textarea></td>
	    </tr>
	    <tr>
	      <td colspan="2" align="center"><button type="submit">Add Thought</button></td>
	    </tr>
	  </table>
	  </form>
	</div>
</body>
</html>