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
	 
	 	<%if(result == null || result.size() == 0){%>
	 		<h1>Nessuna lezione trovata</h1>
   		<%}else{%>			
   				<div id = "pacchetto">
   					<h1 id = "titoloPacchetto"><%=pacchetto.getTitolo()%>*</h1>
   					<p id = "descrizione"><%=pacchetto.getDescrizione()%>.</p>
   					<p id  ="prezzo"><strong>Prezzo:</strong> <%=pacchetto.getPrezzo()%>&euro;</p>
   					<div id="bottoni">
	   					<div id="videoIntroduzione" onClick = "mostraLezioneGratis('<%=result.get(0).getUrl()%>')"> Guarda prima lezione gratis <i class="far fa-play-circle"></i></div>	
	   							<div id ="aggiungiAlCarrello" action="false" data="<%=pacchetto.getCodicePacchetto()%>" onClick = "aggiungiAlCarrello()">Aggiungi al carrello <i class="fas fa-cart-plus"></i></div>
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
				
				<!-- Video -->
			    <div id = "sfondoVideo">
			    	<div id = "close-video" onClick = "nascondiLezioneGratis()">
						<i class="far fa-times-circle"></i>
					</div>
				    <div id ="video">
				    </div>
			    </div>				
    	<%}%>
 	<%@ include file="Footer.jsp"%> 
 	</div>
 	<script type="text/javascript" src="./js/catalogo.js"></script>
 </body>
</html>