<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="entities.Stops"%>
<%@page import="entities.Bus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus Details</title>

<style>
	
	tr,td,th{
		padding : 10px 20px;
	}
</style>
</head>
<body>

	<!--  Showing Bus details searched by Bus no   -->
	<%
		String searchType = (String) request.getAttribute("searchType");
		String errorMsg = (String) request.getAttribute("errorMsg");
		if(errorMsg!=null){
			%>		
			<center>
				<table>
					<tr>
					  <td><%= errorMsg %></td>
					</tr>
				</table>
			</center>
		
		<% }
		else if (searchType.equalsIgnoreCase("busNo")) {

			Bus bus = (Bus) request.getAttribute("bus");
			List<Stops> stops = (List<Stops>) request.getAttribute("stops");
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	%>

	<center>
		<table>
			<tr>
				<th colspan="2">Bus Number :</th>
				<td><%=bus.getBusNo()%></td>
			</tr>
			<tr>
				<th colspan="2">Driver Name :</th>
				<td><%=bus.getDriverName()%></td>
			</tr>
			<tr>
				<th colspan="2">Driver Contact Number : </th>
				<td><%= bus.getDriverContactNo() %></td>
			</tr>
			<tr>
				<th>S.No</th>
				<th>Stop Name</th>
				<th>Time</th>
			</tr>

			<%
				int i = 1;
					for (Stops stop : stops) {
			%>
			<tr>
				<td><%=i++%></td>
				<td><%=stop.getStopName()%></td>
				<td><%= sdf.format(stop.getTime())  %></td>
			</tr>
	<%
					}
	%>
	</table>
	</center>
	<!--  Showing Bus list searched by Stop Name   -->
	<%
		}

		else {
			String stopName = (String) request.getAttribute("stopName");
			List<Bus> busList = (List<Bus>) request.getAttribute("busList");
			List<Stops> stopsList = (List<Stops>) request.getAttribute("stopslist");
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	%>
	<center>
		<table>
			<tr>
				<th colspan="4"><b>Stop Name : <%=stopName%></b></th>
			</tr>
			<tr>
				<th>Bus Number</th>
				<th>Your Stop Time</th>
				<th>Driver Name</th>
				<th>Contact Number</th>
			</tr>
			<%
				for (int i = 0; i < stopsList.size(); i++) {

						Stops stop = stopsList.get(i);
						Bus bus = busList.get(i);
			%>
			<tr>
				<td><%=bus.getBusNo()%></td>
				<td><%= sdf.format(stop.getTime())%></td>
				<td><%=bus.getDriverName()%></td>
				<td><%=bus.getDriverContactNo()%></td>
			</tr>
		
	<%
		} %>
			</table>
			</center>
		<% }
	%>
</body>
</html>