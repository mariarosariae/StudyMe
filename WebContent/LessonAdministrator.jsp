<%@page import="java.util.ArrayList" %>
<%@page import="model.bean.*" %>
<%@page import="model.dao.*" %>

<%
	ArrayList<LezioniBean> result = (ArrayList<LezioniBean>)request.getAttribute("lezioni");
	PacchettoBean pacchetto = (PacchettoBean)request.getAttribute("pacchetto");
	ArrayList<RecensioneBean> recensioni = (ArrayList<RecensioneBean>)request.getAttribute("recensioni");
	String nomeTitolo = "";
%>

<!DOCTYPE html>
<html>
<head>
    <link rel = "stylesheet" href = "css/LessonAdministrator.css">
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
   					<h1 id = "titoloPacchetto"><%=pacchetto.getTitolo()%></h1>
   					<div id= "AggiungiLezione" onClick = "showAddLesson('<%=pacchetto.getCodicePacchetto()%>')">
	   					<i class="fas fa-plus-square"></i>
	   					<span id = "addL">Aggiungi lezione</span>
   					</div>
   				</div>
   				<div id = "lezioni">
	   					<%for(LezioniBean lezione : result){%>
	   						<div class = "lezione">
	   							<iframe src= <%=lezione.getUrl()%> width="200px" height="150px"></iframe>
	   							<div id="dettagli">
		   							<span id = "TitoloLezione">
		   								<%=lezione.getTitolo()%>
		   								<%nomeTitolo = lezione.getTitolo();%>
		   							</span>
				   					<div class = "modificaLezione" onClick = "mostraModificaLezione('<%=lezione.getTitolo()%>')"> Modifica lezione <i class="fas fa-pencil-alt"></i></div>
		   						</div>
	   						</div>
	   					<%}%>
   					</div>
   				<%}%>
		
		<!-- Modifica nome -->
		<div id="sfondoModificaLezione">
		<div id="close-icon" onClick="nascondiModifiche()">
			<i class="far fa-times-circle"></i>
		</div>
		
		<div id = "containerModificaLezione">
			<div id="modificaLez">
				<h2>Modifica lezione</h2>
				<div id="insuccess"></div>
				<form id="update">
					<div>
						<input id = "TitoloLezioneVecchio" type="hidden" readonly required>
					</div>
					<div id="updateName">
						<label for="uname"><b>Nuovo nome: </b></label> <input  id = "nomeModificaLezione" style = "width:85%" type="text" name="newName" required>
						<div id="updateButton" data = "modificaNomeLezione" onClick="modificaLezione()">
							<i class="fas fa-arrow-right"></i>
						</div>
					</div>
					<div id="updateUrl">
						<label for="uname"><b>Nuovo url: </b></label> <input id = "urlModificaLezione" style = "width:85%" type="text" name="newUrls" required>
						<div id="updateButton" data = "modificaVideoLezione" onClick="modificaLezione()">
							<i class="fas fa-arrow-right"></i>
						</div>
					</div>
					<div id="updateDurata">
						<label for="uname"><b>Nuova durata: </b></label> <input id = "durataModificaLezione" style = "width:85%" type="text" name="newUrls" required>
						<div id="updateButton" data = "modificaDurataLezione" onClick="modificaLezione()">
							<i class="fas fa-arrow-right"></i>
						</div>
					</div>
					<span id = "delete" data = "rimuoviLezione" onClick="modificaLezione()">Rimuovi dal pacchetto</span>
				</form>
				</div>
			</div>
		</div>
		
		<!-- Aggiungi lezione -->
		<div id="sfondoAggiungiLezione">
			<div id="close-icon" onClick="nascondiAggiunta()">
				<i class="far fa-times-circle"></i>
			</div>
				
			<div id = "containerAggiungiLezione">
				<div id="modificaLez">
					<h2>Aggiungi lezione</h2>
					<form id="add">
						<div id="addUrl">
							<label for="url"><b>Codice pacchetto: </b></label> <input id = "codiceP" value = "" readonly type="text" required>
						</div>
						<div id="addUrl">
							<label for="url"><b>Inserire url: </b></label> <input id = "url" type="text" required>
						</div>
						<div id="addTitle">
							<label for="title"><b>Inserire titolo: </b></label> <input  id = "title" type="text" required>
						</div>
						<div id="addTime">
							<label for="title"><b>Inserire durata: </b></label> <input id = "duration" type="text" required>
						</div>
						<div id ="addLesson" data = "aggiungiLezione" onClick = "addLesson()">Aggiungi nuova lezione</div>
					</form>
				</div>
			</div>	
		</div>
			
		<%@ include file="Footer.jsp"%> 
   	</div>
   		<script type="text/javascript" src="./js/Lesson.js"></script>
</body>
</html>