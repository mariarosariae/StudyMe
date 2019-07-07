<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Map" %>
<%@page import="model.bean.*" %>
<%@page import="model.dao.*" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	OrdineBean ordine= (OrdineBean) request.getAttribute("nomeCliente"); 
%>
<!DOCTYPE html>
<html>
		<link rel="stylesheet"  type="text/css" href="css/amministratore.css">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
<head>
	  <%@ include file = "header.jsp" %>
	  
	<div class ="container">
 	<%@ include file="NavigationBar.jsp"%>  
    <%@ include file="BarCategory.jsp"%>   
	
	<h2><%=ordine.getCliente() %></h2>
	<h2><%=ordine.getNumFattura() %></h2>
	<%=ordine.getQuantita()%>
	
	
</head>
<body>
	<%@ include file="Footer.jsp"%> 
</body>
</html>