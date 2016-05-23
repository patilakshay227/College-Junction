<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Event</title>
<style>
tr, td, th {
	padding: 5px 5px;
}
</style>
<script src="/js/jquery.js"></script>
<script>
	function validate() {
		var re = '^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$';
		var date = $('input[name="date"]').val();
		var flag =false;
		console.log(date);
		if (re.test(date)) {
			flag = true;
		} 
		else {
			alert("Invalid Date");
			$('input[name="date"]').val('');
			$('input[name="date"]').focus();
			return false;
		}
		
		/* var regLastDate = $('input[name="regLastDate"]').val();
		console.log(regLastDate);
		if (re.test(regLastDate)) {
			flag = true;
		} 
		else {
			alert("Invalid Date");
			$('input[name="regLastDate"]').val('');
			$('input[name="regLastDate"]').focus();
			return false;
		} */
		return flag;

	}
</script>
</head>
<body>
	<center>
		<form action="../EventAdder" method="post" id="eventForm">
			<table>
				<tr>
					<th>Event Name</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>Event Date</th>
					<td><input type="text" name="date" placeholder="dd/mm/yyyy">
					</td>
				</tr>
				<tr>
					<th>Registrations Last Date</th>
					<td><input type="text" name="regLastDate"
						placeholder="dd/mm/yyyy"></td>
				</tr>
				<tr>
					<th>Venue</th>
					<td><input type="text" name="venue"></td>
				</tr>
				<tr>
					<th>Event Details</th>
					<td><textarea name="details" rows="10" cols="30"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><button type="submit"
							onclick=" return validate();">Add Event</button></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>