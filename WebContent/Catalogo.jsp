<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Map" %>
<%@page import="model.bean.*" %>
<%@page import="model.dao.*" %>

<% 	Map<String, ArrayList<PacchettoBean>> result =(Map<String, ArrayList<PacchettoBean>>) request.getAttribute("pacchetti"); 
	String categoria = (String) request.getAttribute("categoria");
%>

<!DOCTYPE html>
<html>
	<head >
		<link rel="stylesheet" href="css/catalogo.css">
	</head>
    <%@ include file = "header.jsp" %>
<body>
     <div class ="container">
 	<%@ include file="NavigationBar.jsp"%>  
       
	<div class="categoria" style = "background-image: url('./img/category/sviluppo2.png')">
		<h1> <%=categoria.toUpperCase()%> </h1>
	</div>
	
	
	
	<% for(String categoryName : result.keySet()) { %>
	<div class="sottocat">
    <h1><%= categoryName %></h1>
    <div class="grid-generale">
   		<% 
   		ArrayList<PacchettoBean> pacchetti = result.get(categoryName);
   		for(PacchettoBean pacchetto : pacchetti) {%>	
        <div class= "pacchetto">
            <h1><%=pacchetto.getTitolo() %></h1><br>
	        <div class = "foto-categoria" style="background-image: url(./img/immaginipacchetti/C1.jpg)"></div>
	            <p><%=pacchetto.getDescrizione()%></p>
	        <div class="buy-now">
	            <input type = "submit" value = "Vai alle lezioni">
	        </div>
    	</div>
    	<%}%>
    </div>     
</div>
<%}%>
<%@ include file="Footer.jsp"%> 
</div> 
 
 </body>
</html>