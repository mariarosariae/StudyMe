<%@page import="model.dao.OrdineDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*, model.bean.*"%>

<!DOCTYPE html>
	<%@ include file = "header.jsp" %>
	    <link rel="stylesheet" href="css/UserArea.css">
<body>
	<div class = "container">
		<%@ include file="NavigationBar.jsp"%>
		<%@ include file="BarCategory.jsp"%>        
		
		<!-- Container area utente -->
		<div class = "containerUserArea">
			
			<!-- Menu laterale -->
			<div class = "userArea">
				<div class = "grid-container-user">
					<div class = "cell-user menu">
						<nav>
							<%if(administrator != null){%>
								<ul id = "navUser">
								<li  id = "updateAccount" class ="active" onClick = "showUpdateAccount()">
									<i class="fas fa-plus-square"></i>
									<span>Aggiungi pacchetti</span>
								</li>
								<li  id = "myOrder" onClick = "showOrders()">
									<i class="fas fa-money-check-alt"></i>
									<span>Ordini</span>
								</li>
								<a href = "LogoutServlet">
									<li>
										<i class="fas fa-sign-out-alt"></i>
										<span>Logout</span>
									</li>
								</a>
							</ul>
							<%} else{ %>
								<ul id = "navUser">
								<li  id = "updateAccount" class ="active" onClick = "showUpdateAccount()">
									<i class="far fa-user-circle"></i>
									<span>Account</span>
								</li>
								<li  id = "myOrder" onClick = "showOrders()">
									<i class="fas fa-money-check-alt"></i>
									<span>Ordini</span>
								</li>
								<a href = "LogoutServlet">
									<li>
										<i class="fas fa-sign-out-alt"></i>
										<span>Logout</span>
									</li>
								</a>
							</ul>
							<%}%>
						</nav>
					</div>
					<div class = "cell-user profile">
							<!-- UpdateAccount -->		
								<%if(administrator != null){%>
								<div id = "UpdateUserName">
								<h1>Inserire dati del nuovo pacchetto da inserire nel catalogo</h1>
								
								<h2>Codice pacchetto: </h2>	
								<form name="insertCod">
									<input type="text" placeholder="Inserisci nuovo codice">	
								</form>
										
								<h2>Categoria: </h2>	
								<form name="insertCat">
									<input type="text" placeholder="Inserisci nome categoria">	
								</form>
								
								<h2>Sottocategoria: </h2>	
								<form name="insertSott">
									<input type="text" placeholder="Inserisci id sottocategoria">	
								</form>
								
								<h2>Titolo: </h2>	
								<form name="insertTitle">
									<input type="text" placeholder="Inserisci titolo">	
								</form>
								
								<h2>Foto copertina: </h2>	
								<form name="insertPhoto">
									<input type="text" placeholder="Inserisci url foto">
								</form>
								
								<h2>Prezzo: </h2>	
								<form name="insertPrice">
									<input type="text" placeholder="Inserisci prezzo">	
								</form>

								<h2>Descrizione: </h2>	
								<form name="insertDes">
									<textarea placeholder="Inserisci nuovo codice"></textarea>
								</form>

								<button type="submit">Aggiungi</button>
								</div>
								<%}else{%>	
								<div id = "UpdateUserName">
								<h1> <%=loggedUser.getNomeUtente()%> modifica il tuo account</h1>
								<h2>Modifica email</h2>	
								<h3 id = "email">Email modificata</h3>
								<div id = "messageErrorEmail"></div>
								<form name="updateEmail" id = "formEmail">
									<input type="email" placeholder="Inserisci nuova email" name="Email" id = "changeEmail">	
									<button type="submit">Invio</button>
								</form>
										
								<h2>Modifica password</h2>
								<h3 id = "password">Password modificata</h3>
								<div id = "messageErrorPassword"></div>
								<form name = "updatePassword" id = "formPassword">    							
									<div class="input-with-icon">
										<input type="password" placeholder="Inserisci nuova password" name="Password" id ="changePassword">
										<i class="fas fa-eye-slash" onclick="togglePassword(event)"></i>
									</div>
									<h2>Conferma nuova password</h2>
							    		<div class="input-with-icon">
											<input type="password" placeholder="Reinserisci password" name="Conf_Password" id="confChangePassword" required>
											<i class="fas fa-eye-slash" onclick="togglePassword(event)"></i>
										</div>
										<button type="submit">Invio</button>
								</form>
								</div>
							<%}%>
							
							<div id = "ordini">
								<!-- Ordini -->
								<div id="MyOrder">
								<h1>I MIEI ORDINI</h1>
								</div>
				
							
							<div class="divTableHeading">
								
							</div>
					</div>
							
							</div>
							
							
			</div>
			</div>
		</div>
		<%@ include file="Footer.jsp"%>  
	</div>
	 <script type="text/javascript" src="./js/UserArea.js"></script>
</body>