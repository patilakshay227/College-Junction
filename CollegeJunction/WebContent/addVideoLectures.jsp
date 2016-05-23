<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Video Lectures</title>
<script src="./js/jquery.js"></script>
<style>
	input,select{
		width: 100%;
	}
	tr,td,th{
		padding: 5px;
	}
</style>
<script type="text/javascript">
	
function validate(){
		
	  if( ($('select[name="department"]').val()!='---Select Department---')){
		  return true;
	  }
	  else{ 
		  console.log('else');
		  alert('Please select Department');
		  return false;
	  }
}
</script>
</head>
<body>
	<center>
	<form action="./VideoLecturesAdder" method="post" onsubmit="return validate();">
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
		  <th>Video URL </th>
		  <td><input type="url" name="videoLink"></td>
		</tr>
		<tr>
		  <th>Description</th>
		  <td><textarea rows="10" cols="35" name="description"></textarea></td>
		</tr>
		<tr>
		  <td colspan="2" style="padding-left: 80px;"><button type="submit" >Add</button></td>
		</tr>
	</table>
	</form>
	</center>
</body>
</html>