<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Map" %>
<%@page import="model.bean.*" %>
<%@page import="model.dao.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

</head>
		<%@ include file = "header.jsp" %>
		<link rel="stylesheet"  type="text/css" href="css/amministratore.css">
<body>
	 <div class ="container">
 	<%@ include file="NavigationBar.jsp"%>  
    <%@ include file="BarCategory.jsp"%>   
	<h3>Benvenuto nell'area dell'amministratore</h3>
	
<div class="button">
	<form action="ServletAmministratore" method="post">
	<h3>Inserisci pacchetto</h3>
	<input type="hidden" name="action" value="inserisciPacchetto">
	Codice pacchetto:<br><input type="text" name="codicePacchetto">
	Titolo:<br><input type="text" name="titolo">
	Descrizione:<br><input type="text" name="descrizione">
	Categoria:<br><input type="text" name="categoria"><br>
	Sottocategoria:<br><input type="text" name="sottocategoria">
	Prezzo:<br><input type="text" name="prezzo">
	Foto:<br><input type="text" name="foto">
	<button type="submit">Inserisci  Pacchetto</button>
	</form>
	
	<form action="ServletAmministratore" method="post">
	<h3>Modifica Pacchetto</h3>
	<input type="hidden" name="action" value="modificaPacchetto">	
	Codice Pachetto: <br><input type="text" name="codicePacchetto">
	Prezzo: <br><input type="text" name="prezzo">
	<button type="submit">Modifica pacchetto</button>
	</form>
	
	<form action="ServletAmministratore" method="post">
	<h3>ELIMINA PACCHETTO</h3>
	<input type="hidden" name="action" value="eliminaPacchetto">
	Codice Pacchetto:<input type="text" name="codicePacchetto">
	<button type="submit">Elimina Pacchetto</button>
	</form>
	
	<form action="ServletAmministratore" method="post">	
	<h3>Inserisci lezione</h3>
	<input type="hidden" name="action" value="inseriscilezione">
	URL:<br><input type="text" name="url">
	Titolo:<br><input type="text" name="titolo">
	Durata:<br><input type="text" name="durata">
	Codice :<br><input type="text" name="codiceP"><br>
	<button type="submit">Inserisci  Lezione</button>
	</form>
	
	<form action="ServletAmministratore" method="post">	
	<h3>Elimina lezione</h3>
	<input type="hidden" name="action" value="eliminalezione">
	URL:<br> <input type="text" name="url">
	<button type="submit">Elimina Lezione</button>
	</form>
	
	<form action="ServletAmministratore" method="post">	
	<input type="hidden" name="action" value="informazioniOrdini">
	<button type>Informazioni ordini</button>
	
	</form>
	</div>
</div>

	<%@ include file="Footer.jsp"%> 
</body>
</html>