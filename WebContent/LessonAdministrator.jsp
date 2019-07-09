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
   					<div id= "AggiungiLezione" onClick = "AddLesson()">
	   					<i class="fas fa-plus-square"></i>
	   					<span id = "add">Aggiungi lezione</span>
   					</div>
   				</div>
   				<div id = "lezioni">
	   					<%for(LezioniBean lezione : result){%>
	   						<div class = "lezione">
	   							<iframe src= <%=lezione.getUrl()%> width="200px" height="150px"></iframe>
	   							<div id="dettagli">
		   							<span id = "TitoloLezione">
		   								<%=lezione.getTitolo()%>
		   									<i class="fas fa-pencil-alt" data-toggle="tooltip" title="Modifica lezione!" onClick="modificaLezione()"></i>
		   							</span>
				   					<div class = "rimuovi">Rimuovi dal pacchetto  <i class='fas fa-trash-alt'></i></div>
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
			<div id="modificaLezione">
				<h2>Modifica lezione</h2>
				<form id="update">
					<div id="updateName">
						<label for="uname"><b>Nuovo nome: </b></label> <input type="text" name="newName" required>
						<div id="updateButton" onClick="">
							<i class="fas fa-arrow-right"></i>
						</div>
					</div>
					<div id="updateUrl">
						<label for="uname"><b>Nuovo url: </b></label> <input type="text" name="newUrls" required>
						<div id="updateButton" onClick="">
							<i class="fas fa-arrow-right"></i>
						</div>
					</div>
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
				<div id="modificaLezione">
					<h2>Aggiungi lezione</h2>
					<form id="update">
						<div id="addUrl">
							<label for="url"><b>Inserire url: </b></label> <input type="text" required>
						</div>
						<div id="addTitle">
							<label for="title"><b>Inserire titolo: </b></label> <input type="text" required>
						</div>
						<div id="addTime">
							<label for="title"><b>Inserire durata: </b></label> <input type="text" required>
						</div>
						<div id ="addLesson">Aggiungi nuova lezione</div>
					</form>
				</div>
			</div>	
		</div>
			
		<%@ include file="Footer.jsp"%> 
   	</div>
   		<script type="text/javascript" src="./js/Lesson.js"></script>
</body>
</html>