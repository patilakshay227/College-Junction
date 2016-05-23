<%@page import="models.BlogModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<% 
		int id = Integer.parseInt(request.getParameter("id"));
		String msg = BlogModel.deletePost(id);
	%>
	<%= msg %>
