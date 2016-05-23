<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Bus Route</title>
</head>
<style>
	th,td{
		padding: 5px 10px;
	}
	input[name*=Time]{
		width: 100px;
	}
	table{
		padding: 10px 0px;
	}
</style>
<script>
	
	function validate(){
		
		if(isNaN(document.getElementById("BusNo").value)||document.getElementById("BusNo").value==""){
			alert("Insert Correct Bus No.");
			document.getElementById("BusNo").focus();
			return false;
		}
		var flag =false;
		var Timelist = document.getElementsByName("stopTime");
		for(i=0; i<Timelist.length;i++){
			
			var t = Timelist[i];
			if(t.value==""){
				alert("Insert Time ");
				t.focus();
				return false;
			}
			else if(checkTime(t))
				flag = true;
			else
				return false;
		}
		return flag;
	}
	
	function checkTime(field)
	  {
	    var errorMsg = "";

	    // regular expression to match required time format
	    re = /^(\d{1,2}):(\d{2})(:00)?([ap]m)?$/;

	    if(field.value != '') {
	      if(regs = field.value.match(re)) {
	        if(regs[4]) {
	          // 12-hour time format with am/pm
	          if(regs[1] < 1 || regs[1] > 12) {
	            errorMsg = "Invalid value for hours: " + regs[1];
	          }
	        } else {
	          // 24-hour time format
	          if(regs[1] > 23) {
	            errorMsg = "Invalid value for hours: " + regs[1];
	          }
	        }
	        if(!errorMsg && regs[2] > 59) {
	          errorMsg = "Invalid value for minutes: " + regs[2];
	        }
	      } else {
	        errorMsg = "Invalid time format: " + field.value;
	      }
	    }

	    if(errorMsg != "") {
	      alert(errorMsg);
	      field.focus();
	      return false;
	    }

	    return true;
	  }
	
	function addStop(){
		
		var table = document.getElementById("tab1");
		 
        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);

        var cell1 = row.insertCell(0);
        cell1.innerHTML = rowCount - 3;

        var cell2 = row.insertCell(1);
        var element1 = document.createElement("input");
        element1.setAttribute("type","text");
        element1.setAttribute("name","stopName");
        cell2.appendChild(element1);
        
        var cell3 = row.insertCell(2);
        var element2 = document.createElement("input");
        element2.setAttribute("type","text");
        element2.setAttribute("name","stopTime");
        cell3.appendChild(element2);
		
		
	}
	
</script>
<body>
	<center>
	<h3>Update Bus Details</h3>
	<form action="../UpdateBusRoute" method="post" onsubmit="return validate();">
	<table id="tab1">
	
	<tr >
	<td>Bus No. </td> <td> <input type="number" name="busNo" id="BusNo" style="width: 80px;"></td>
	</tr>
	<tr >
	<td >Driver Name </td> <td><input type="text" name="driverName" ></td>
	</tr>
	<tr >
	<td >Contact Number </td> <td><input type="text" name="contactNumber" maxlength="10" ></td>
	</tr>
	<tr>
	<th>S.no.</th>
	<th>Stop Name</th>
	<th>Time</th>
	</tr>
	<tr>
	  <td id="S.no">1</td>
	  <td><input type="text" name="stopName"></td>
	  <td><input type="text" name="stopTime" ></td>
	</tr>
	</table>
	<button type="submit">Save Route</button> 
	<button type="button" onclick="addStop();">Add Stop</button>
	</form>
	</center>
</body>
</html>