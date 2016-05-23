<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>College Junction - Student Registration</title>
<script>

</script>
</head>
<body>
	<form action="./StudentRegistration" method="post">
	 <table>
    <tr>
      <th>Roll No</th>
      <td><input type="text" name="rollNo" required="required" maxlength="12"></td>
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
      <td><input type="password" name="password" maxlength="20" required="required"></td>
    </tr>
    <tr>
      <th>Branch</th>
      <td>
        <select name="branch">
          <option>---Select Branch---</option>
          <option>Computer Science</option>
          <option>Information Technology</option>
          <option>Mechanical</option>
          <option>Civil</option>
          <option>Electronics & Communication</option>
          <option>Chemical</option>
        </select>
      </td>
    </tr>
    <tr></tr>
    <tr>
     <td></td>
     <td><button type="submit" onclick="return validate()">Register</button><button type="reset">Reset</button></td>
    </tr>
  </table>
	</form>
</body>
</html>