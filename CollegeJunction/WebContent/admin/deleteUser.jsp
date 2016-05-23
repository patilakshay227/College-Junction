<%@page import="models.UsersModel"%>
<%@page import="users.Director"%>
<%@page import="users.Dean"%>
<%@page import="users.Faculty"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="hibernate.SessionFactoryBuilder"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	response.setContentType("text/html");
	String email = request.getParameter("email");
	String userType = request.getParameter("userType");	
%>
<%= UsersModel.deleteUser(userType, email) %>