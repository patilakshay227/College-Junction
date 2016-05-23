<%@page import="models.SkillsModels"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	long id= Long.parseLong(request.getParameter("id"));
%>
<%= SkillsModels.deleteResearch(id) %>