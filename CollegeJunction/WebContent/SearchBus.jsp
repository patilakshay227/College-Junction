<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Bus Routes</title>
</head>
<style>
	th,td{
		padding: 5px 10px;
	}
</style>q2
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
	
		$(document).ready(function(){
		    
			$(window).load(function() {
				$('form').get(0).reset();
			   
			});
			
			$('input:radio[name="searchType"]').change(function(){
		    var n = $(this).val();
		    if($(this).is(':checked') && n=='searchByBusNo'){
		    	$('#search').html('<th><label>Bus Number </label></th>'+
		    			'<td><input type="number" name="busNo"></td>'+ 
		    			'<td><button type="submit">Search</button></td>');
		    }
		    else{
		    	$('#search').html('<th><label>Stop Name </label></th>'+
						'<td><input type="text" name="stopName"></td>'+ 
						'<td><button type="submit">Search</button></td>');
		    }
		    });
			
			
		});
	
	
</script>
</head>
<body>
	<div align="center">
	<h3>Search Bus</h3>
	
	<form action="./BusSearchEngine" method="post" id="form1" name="form1" autocomplete="off">
	<table>
	<tr>
	  <th><label>Search By : </label></th>
	  <td> <input type="radio" name="searchType" id="searchType" value="searchByBusNo" >Bus Number </td> 
	  <td> <input type="radio" name="searchType" id="searchType" value="searchByStopName" > Stop Name </td>
	</tr>
	<tr><td> </td></tr>
	<tr id="search">
	</tr>
	</table>
	</form>
	</div>
	
</body>

</html>