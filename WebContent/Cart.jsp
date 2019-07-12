<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*, model.bean.*"%>
<!DOCTYPE html>

<%@ include file="header.jsp"%>
<link rel="stylesheet" href="css/UserArea.css">
<link rel="stylesheet" href="css/Carrello.css">

<%
	HttpSession sessione = request.getSession();
	ArrayList<PacchettoBean> carrello = (ArrayList<PacchettoBean>) sessione.getAttribute("carrello");
	if (carrello == null) {
		carrello = new ArrayList<PacchettoBean>();
	}
%>

<body>
		<%@ include file="NavigationBar.jsp"%>
		<%@ include file="BarCategory.jsp"%>
		
		<div class="containerCart">
			<%
				if (carrello.size() != 0) {
			%>
			
			<div class = "nameColumn">
					<h1 class = "cellCart">Foto</h1>
					<h1 class = "cellCart">Nome</h1>
					<h1 class = "cellCart">Prezzo</h1>
			</div>
	
			<div class="containerProduct">		
					<%
						double sum = 0;
						for (int i = 0; i < carrello.size(); i++) {
					%>
					<div class="product">
						<div class= "cellCart photo">
							<img src="<%=carrello.get(i).getFoto()%>">
						</div>
						<div class="cellCart title">
							<%=carrello.get(i).getTitolo()%>
						</div>
						<div class="cellCart price">
							<%=carrello.get(i).getPrezzo()%>
						</div>
						<div class="cellCart botton">
							<div id="removeProduct" data="<%=carrello.get(i).getCodicePacchetto()%>" onClick="onRemoveClick()"><i class='fas fa-trash-alt'></i></div>
						</div>
					</div>
					
					<%
						sum = sum + carrello.get(i).getPrezzo();
						}
					%>
					
				</div>
				
				<div class="priceTotal">
					<strong>Prezzo Totale: <%=sum%></strong>
				</div>
				
				<div class="divTableHead">
					<button class="waves-effect waves-light btn" onClick="onClearCartClick()">Rimuovi Tutto</button>
				</div>
		
				<%
					if (loggedUser == null) {
				%>
				
				<h1>EFFETTUARE PRIMA L'ACCESSO</h1>
				<button type="submit" onClick="mostraLogin()">ACCEDI</button>
	
				<%
					} else {
				%>
					<div class="paypalCheckOut"></div>
				<%
					}
				%>
			<%
				} else {
			%>
			<h1>Non ci sono prodotti aggiunti al carrello</h1>

			<%
				}
			%>
	</div>
	<%@ include file="Footer.jsp"%>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
 	<script src="https://www.paypal.com/sdk/js?client-id=AQ_HcZLDjYjZJHt_AjzYC50ORb03jemJQPANDcU0WD0IzSlvb3lZv23FXR4XPL94z9hfE4UGFhlJMCE1&currency=EUR"></script>
 	<script src = "js/Cart.js"></script>
</body>
</html>