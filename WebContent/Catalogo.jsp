<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Map" %>
<%@page import="model.bean.*" %>
<%@page import="model.dao.*" %>

<% 	Map<String, ArrayList<PacchettoBean>> result =(Map<String, ArrayList<PacchettoBean>>) request.getAttribute("pacchetti"); 
	String categoria = (String) request.getAttribute("categoria");
	
	CategoriaBean cat= (CategoriaBean) request.getAttribute("fotoCat");
%>
<!DOCTYPE html>
<html>
	<head >
		<link rel="stylesheet"  type="text/css" href="css/catalogo.css">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<script src="./js/catalogo.js" type="text/javascript"></script>
	</head>
    <%@ include file = "header.jsp" %>
<body>
     <div class ="container">
 	<%@ include file="NavigationBar.jsp"%>  
    <%@ include file="BarCategory.jsp"%>   
    
	<div class="categoria" style = "background-image: url(<%= cat.getFotoCategoria()%>)">
		<h1> <%=categoria.toUpperCase()%> </h1>
	</div>
	
	
	
	<% for(String categoryName : result.keySet()) { %>
	<div class="sottocat">
    <h1><%= categoryName %></h1>
    <div class="grid-generale">
   		<% 
   		ArrayList<PacchettoBean> pacchetti = result.get(categoryName);
   		for(PacchettoBean pacchetto : pacchetti) {%>	
        <div class= "pacchetto" onmouseover="Zoomin()">
            <h1><%=pacchetto.getTitolo() %></h1><br>
           
	        <div class = "foto-categoria" style = "background-image: url(<%= pacchetto.getFoto()%>)"></div>
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