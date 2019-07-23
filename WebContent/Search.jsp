<%@page import="java.util.ArrayList" %>
<%@page import="model.bean.*" %>
<%@page import="model.dao.*" %>
<%@page import = "java.util.*" %>

<% ArrayList<PacchettoBean> result = (ArrayList<PacchettoBean>) request.getAttribute("pacchetti");
   String argument = (String) request.getAttribute("argomento");
%>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet"  type="text/css" href="css/catalogo.css">
	</head>
	<%@ include file = "header.jsp" %>
<body>
	<div class = "containerTotale">
		<%@ include file="NavigationBar.jsp"%>  
	 	<%@ include file="BarCategory.jsp"%>
    <div class ="container" style = "background: linear-gradient(to right, #0f2027, #203a43, #2c5364);">
	 	<%if(result == null || result.size() == 0){ %> 	
	 		<h1 id = "ricercaTitolo">Pacchetti con il titolo: <%=argument%> </h1> 	
	 		<h1 id = "ricercaTitolo">Nessun pacchetto trovato! </h1> 		
	 		<img src = "img/utility/ricercaFallita.png" id = "immagineRicerca" alt = "Pacchetto non trovato">
   		<%}else{
   			if(argument.length() != 0) {%>
   				<h1 id = "ricercaTitolo">Pacchetti con il titolo: <%=argument%> </h1> 
			<%} %>
   			<div class="grid-generale">
		   	<% for(PacchettoBean pacchetto : result) {%>	
		        <div class= "pacchetto">        
			        <div class = "foto-categoria" style = "background-image: url(<%=pacchetto.getFoto()%>)"></div>
			        <h1><%=pacchetto.getTitolo()%></h1><br>
			            <%if(pacchetto.getDescrizione().length() > 100) { %>
			            	<p><%= pacchetto.getDescrizione().substring(0, 100)%> ...</p>
			            <%}else{%>
			           	 <p><%= pacchetto.getDescrizione()%>...</p>
			           	 <%}%>
			        <div class="buy-now">
			       		<a href = "LessonServlet?codicePacchetto=<%=pacchetto.getCodicePacchetto()%>"> 
				        	<span class ="catalogo">
				        		Anteprima
				        	</span>
			        	</a>
			        </div>
		    	</div>
		    	<%}%>
    		</div>   
    	<%}%> 		
 	</div>
 	<%@ include file="Footer.jsp"%> 
 	</div>
 </body>
</html> 