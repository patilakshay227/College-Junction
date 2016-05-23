
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>College Junction - Administrator Login</title>

<link rel="stylesheet" href="css/templatemo_style.css">

<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>
	

	<!-- Custom Style sheet -->
	<link rel="stylesheet" href="../css/style_admin.css">
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="../css/temp_home.css">

<style>

	.logo{
                width:250px;
                height:145px;
                position:absolute;
               
            
            }
	tr, td, th {

	padding: 10px 5px;
			}    
</style>

<!-- CSS -->

        <link rel="stylesheet" href="css/temp_home.css">
        
<script src="/CollegeJunction/js/jquery.js"></script>
<script>
	
</script>

</head>
<body class="bg_body">

<!-- Logo -->
<div class="logo"><img src="images/logo.png" alt="" width="250" height="145">
</div>


	
	
		
		
	<div align="center" class="login-box animated fadeInUp">
			<div class="box-header">
				<h2>Administrator's Login</h2>
			</div>
		<%
		String errMsg = (String) request.getAttribute("errMsg");
		if (errMsg != null) {
	%>
	<div id="errMsg" align="center" style="color: red; font-size: 1.2em"><%= errMsg %></div>
	<%
		}
	%>
		<form action="../AdminLoginAuth" method="post" id="loginForm" >
			<table align="center">
			
				<tr>
					<th>Username</th>
					<td><input type="text" name="username" required ></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td colspan="2" align="center" ><button  type="submit" class="btn btn-lg btn-default">Log In</button></td>
				</tr>
				
				<tr>
					<th></th>
			
				</tr>
				
			</table>
		</form>
	</div>
	
	        <!-- Home -->
        <section id="templatemo_home">
		
                <div class="show-menu">
            <a href="index.jsp" class="shadow-top-down">&#127968</a>
        </div>
      
        </section>
	
</body>
</html>