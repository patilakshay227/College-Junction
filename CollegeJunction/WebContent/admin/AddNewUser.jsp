<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Faculty</title>

<script src="../js/jquery.js">
</script>  
<script>
  $(document).ready(function(){
	  
	 
	  
	  var depHtml = $('#departmentRow').html();
	  $('select[name="userType"]').change(function(){
		  var form = $('#AddNewUserForm');
		  var userType = $('select[name="userType"]').val();
	  console.log(userType);
	  switch(userType){
	  	
	  	case 'Faculty':
	  		$('#departmentRow').html(depHtml);
	  		form.attr('action','../FacultyRegistration');
	  		break;
	  	case 'Dean': 
	  		$('#departmentRow').html(depHtml);
	  		form.attr('action','../DeanRegistration');
	  		break;
	  	case 'Director' :
	  		$('#departmentRow').html('');
	  		form.attr('action','../DirectorRegistration');
	  		break;
	  	case 'TPO':
	  		$('#departmentRow').html('');
	  		form.attr('action','../TPORegistration');
	  		break;
	  	}
	  })
  })
</script>
</head>
<body>
	<form method="post" id="AddNewUserForm" action="../FacultyRegistration"
		>
		<table>
			<tr>
				<th>User Type</th>
				<td><select name="userType">
						<option>Faculty</option>
						<option>Dean</option>
						<option>Director</option>
						<option>TPO</option>
				</select></td>
			</tr>
			<tr>
				<th>Name</th>
				<td><input type="text" name="name" required="required"></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="email" name="email" required="required"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password" maxlength="20"
					required="required"></td>
			</tr>
			<tr id="departmentRow">
				<th>Department</th>
				<td><select name="department">
						<option>---Select Department---</option>
						<option>Computer Science</option>
						<option>Information Technology</option>
						<option>Electronics and Communication</option>
						<option>Mechanical</option>
						<option>Civil</option>
						<option>Chemical</option>
						<option>Training And Placement</option>
				</select></td>
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><button type="submit" onclick="return validate();">Register</button>
					<button type="reset">Reset</button></td>
			</tr>
		</table>
	</form>
	
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
</body>

</html>