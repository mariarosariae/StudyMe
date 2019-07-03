<%@page import="java.util.ArrayList" %>
<%@page import="model.bean.*" %>
<%@page import="model.dao.*" %>

<%
	ArrayList<LezioniBean> result = (ArrayList<LezioniBean>)request.getAttribute("lezioni");
	PacchettoBean pacchetto = (PacchettoBean)request.getAttribute("pacchetto");
	ArrayList<RecensioneBean> recensioni = (ArrayList<RecensioneBean>)request.getAttribute("recensioni");
%>

<!DOCTYPE html>
<html>
<head>
    <link rel = "stylesheet" href = "css/Lesson.css">
	<meta charset="ISO-8859-1">
	<title>Lezioni</title>
</head>
	<%@ include file = "header.jsp" %>
<body>
	<div class ="containerLezioni">
	 	<%@ include file="NavigationBar.jsp"%>  
	 	<%@ include file="BarCategory.jsp"%> 	
	 
	 	<%if(result == null || result.size() == 0){ %>
	 		<h1>Lezioni ancora non disponibili</h1>	 	
   		<%}else{%>			
   				<div id = "pacchetto">
   					<h1 id = "titoloPacchetto"><%=pacchetto.getTitolo()%></h1>
   					<p id = "descrizione"><%=pacchetto.getDescrizione()%>.</p>
   					<p id  ="prezzo"><strong>Prezzo:</strong> <%=pacchetto.getPrezzo()%>&euro;</p><br>
   					<div id="bottoni">
	   					<span id="videoIntroduzione">Guarda prima lezione gratis <i class="far fa-play-circle"></i></span>
	   					<span id ="aggiungiAlCarrello">Aggiungi al carrello <i class="fas fa-cart-plus"></i></span>
   					</div>
   				</div>
   								
				<div id = "recensioni">
					<i class="fas fa-quote-left" id = "topIcon"></i>
					<h1 id = "titoloRecensioni">Recensioni</h1>
					<%if(recensioni == null || recensioni.size() == 0) {%>
						<p id ="commento">Non ci sono recensioni per questo pacchetto</p>
					<%} else{ for(RecensioneBean recensione : recensioni){%>
						<p id ="commento">''<%= recensione.getTitolo()%>''<br> <%=recensione.getCommento()%></p>
						<p id = "recensore"> <strong>Fiore</strong> </p>
					<%} 
					}%>
					<i class="fas fa-quote-left" id = "bottomIcon"></i>		
				</div>
				<p id="avviso">*Aquistando questo pacchetto avrai accesso a tutte le sue lezioni direttamente dalla tua libreria</p>					
    	<%}%>
 	
 	<%@ include file="Footer.jsp"%> 
 	</div>
 	<script type="text/javascript" src="./js/catalogo.js"></script>
 </body>
</html>