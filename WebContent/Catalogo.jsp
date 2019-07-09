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
	</head>
    <%@ include file = "header.jsp" %>
<body>
     <div class ="container">
 	<%@ include file="NavigationBar.jsp"%>  
    <%@ include file="BarCategory.jsp"%>   
    
	<div class="categoria" style = "background-image: url(<%= cat.getFotoCategoria()%>)">
		<h1> <%=categoria.toUpperCase()%> </h1>
		<span class = "sfondoCategoria"></span>
	</div>
	
	<% for(String categoryName : result.keySet()) { %>
	<div class="sottocat">
    <h1><%= categoryName %></h1>
    <div class="grid-generale">
   		<% 
   		ArrayList<PacchettoBean> pacchetti = result.get(categoryName);
   		for(PacchettoBean pacchetto : pacchetti) {%>	
        <div class= "pacchetto">
            <h1><%=pacchetto.getTitolo()%></h1><br>
           
	        <div class = "foto-categoria" style = "background-image: url(<%= pacchetto.getFoto()%>)"></div>
	            <%if(pacchetto.getDescrizione().length() > 100) { %>
	            	<p><%= pacchetto.getDescrizione().substring(0, 100)%> ...</p>
	            <%}else{%>
	           	 <p><%= pacchetto.getDescrizione()%>...</p>
	           	 <%}%>
	        <div class="buy-now">
	       		<%if(administrator != null){ %>
	       		<div class="amministratore">
	       		 	<span class ="modifica" onClick = "mostraModifiche('<%=pacchetto.getCodicePacchetto()%>', '<%=pacchetto.getTitolo()%>','<%=pacchetto.getPrezzo()%>','<%=pacchetto.getDescrizione()%>')">
			        	Modifica
			        </span>
				    <span class ="catalogo catalogoAmministratore">
				       <a href = "LessonServlet?codicePacchetto=<%=pacchetto.getCodicePacchetto()%>&nomeAmministratore=<%=administrator.getNomeAmministratore()%>">
				        	Lezioni
				        </a>
				    </span>	       
		        </div>
		        <%} else{ %>
		        <a href = "LessonServlet?codicePacchetto=<%=pacchetto.getCodicePacchetto()%>"> 
			        <span class ="catalogo">
			        	Anteprima
			        </span>
		        </a>
		        <%}%>    	
	        </div>
    	</div>
    	<%}%>
    </div>     
	</div>
	<%}%>
	
	 <!-- Modifica pacchetto -->
	<div id="sfondoModificaPacchetto">
		<div id="close-icon" onClick="nascondiModifiche()">
			<i class="far fa-times-circle"></i>
		</div>
		
		<div id = "containerModificaPacchetto">
			<div id="modificaPacchetto">
				<h2>Modifica pacchetto</h2>
				<div id="messageError"></div>
				<form id="update">
					<div id="updateCod">
						<label for="uname"><b>Codice pacchetto: </b></label> <input type="text" placeholder="" name="codPacc" required>
						<div id="updateButton" onClick="">
							<i class="fas fa-arrow-right"></i>
						</div>
					</div>
					<div id="updateTitle">
						<label for="uname"><b>Titolo: </b></label> <input type="text"placeholder="" name="titolo" required>
						<div id="updateButton" onClick="">
							<i class="fas fa-arrow-right"></i>
						</div>
					</div>
					<div id="updatePrice">
						<label for="uname"><b>Prezzo: </b></label> <input type="text" placeholder="" name="prezzo" required>
						<div id="updateButton" onClick="">
							<i class="fas fa-arrow-right"></i>
						</div>
					</div>
					<div id="updateDescr">
						<label for="uname"><b>Descrizione: </b></label>
						<textarea rows="3" cols="45" name = "descrizione"></textarea>
						<div id="updateButton" onClick="">
							<i class="fas fa-arrow-right"></i>
						</div>
					</div>
					<span id = "delete">Rimuovi dal catalogo</span>
				</form>
			</div>
		</div>
	</div>	
	
	<%@ include file="Footer.jsp"%>
	
	</div> 
		<script type="text/javascript" src="./js/catalogo.js"></script>
	</body>
</html>