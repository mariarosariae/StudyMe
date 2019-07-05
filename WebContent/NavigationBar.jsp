<!-- Barra di navigazione -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.bean.UserBean"%>
<%
	UserBean loggedUser = (UserBean) session.getAttribute("User");

	String initial = null;
	
	if(loggedUser != null) {
		initial = loggedUser.getNomeUtente().substring(0,2);
	}
%>

<div class = "navbar">
	<div id = "logo">
		<div class="navbar-item" id="logo-item">
			<div class = "navbar-item-image">
				<a href = "HomePage.jsp"><img src="./Icons/Logo sito.png" alt = "logo"></a>
             </div>             
             <div class="navbar-item-description">StudyMe</div>               
        </div>
    </div>
            
    <form id = "ricerca" method ="GET" action ="SearchServlet" >
        <i class="fas fa-search"></i>
        <input type = "Text" name = "argument" placeholder="Cosa vuoi imparare oggi ?" >
    </form>
                
    <div id = "carrello">
    	<nav>
           <ul class="nav">        
           		<%if(loggedUser != null ){%>
                <li>
	            	<div class = "navbar-item login"> 
	                	<div class = "navbar-item-image" onClick = "redirectUserArea()">              	
		                	<div class ="cerchio">
		                    	<h1><%= initial %></h1>
		                    </div> 
		                </div>                        
	                </div>
                </li>
                <li>
	               <div class = "navbar-item login">
		               <div class = "navbar-item-image">
		                    <img src="./Icons/libreria.png" alt = "logo" onClick="">
		                </div>
		                <div class = "navbar-item-description">
	                        <div id = "pulsante-accedi" onClick="">
	                        	Lezioni
	                        </div>
	                     </div>
		            </div>
	            </li>
                <%}else{%>
                <li>
	            	<div class = "navbar-item login">
		            	<div class = "navbar-item-image">
		                     <img src="./Icons/user.png" alt = "logo" id="loginImage" onClick="mostraLogin()">
		                </div>
	                    <div class = "navbar-item-description">
		                      <div id = "pulsante-accedi" onClick="mostraLogin()">
		                      	 Accedi
		                      </div>
	                    </div>
	               </div>
	            </li>     	
	            <%}%>
				<li>
                	<div class="navbar-item">
                    	<div class = "navbar-item-image">
                    		<a href = "Cart.jsp"><img src="./Icons/carrello.png" alt = "logo"></a>
                    	</div>
                        <a href = "CarrelloServlet"><div class="navbar-item-description">Carrello</div></a>
                    </div>
                </li>
           </ul>
  		</nav>
	</div> 
	<i class="fas fa-bars" onclick="openNav()"></i>
</div>
  
<!-- Barra di navigazione resposive -->
<div id="responsive-bar">
	<div id ="lateral">
		<i class="closebtn" onclick="closeNav()">&times;</i>
             <nav>
                  <ul class="navLateral">       
	                      <%if(loggedUser != null ){%>
                          <li>
	                          <div class = "navbar-item login"> 
	                            <div class = "navbar-item-image" onClick = "redirectUserArea()">              	
		                              <div class ="cerchio">
		                                  <h1><%= initial %></h1>
		                              </div> 
		                          </div>                        
	                         </div>
                         </li>
                         <li>
	                         <div class = "navbar-item login">
			                          <div class = "navbar-item-image">
			                              <i class="fas fa-money-check-alt" onClick = "showOrders()"></i>
			                          </div>
			                          <div class = "navbar-item-description">
		                                <div id = "pulsante-accedi" onClick="showOrders()">
		                                    Ordini
		                                 </div>
		                             </div>
			                      </div>
                         </li>
                         <li>
	                         <div id = "formSearch">
		                         <i class="fas fa-search" onClick ="ShowSearchBar()"></i>
			                     <div class="navbar-item-description search" onClick ="ShowSearchBar()">
			                     	Cerca
			                     </div> 
			                 </div>
			                 <div id = "formSearchResponse">
				                 <form id = "ricercaResponsive" method ="GET" action ="SearchServlet" >
	        							<i class="fas fa-times" onClick = "HideSearchBar()"></i>
	       								<input type = "Text" name = "argument" placeholder="Cerca pacchetti" >
	   							 </form>
   							 </div>
                       	 </li>
                         <li>
	                         <div class = "navbar-item login">
		                          <div class = "navbar-item-image">
		                              <img src="./Icons/libreria.png" alt = "logo" onClick="">
		                          </div>
		                          <div class = "navbar-item-description">
	                                <div id = "pulsante-accedi" onClick="">
	                                    Lezioni
	                                 </div>
	                             </div>
		                      </div>
	                    </li>
                        <%}else{%>                     
                        <li>
	                        <div id = "formSearch">
		                        <i class="fas fa-search" onClick ="ShowSearchBar()"></i>
			                    <div class="navbar-item-description search" onClick ="ShowSearchBar()">
			                    	Cerca
			                    </div> 
			                 </div>
			                 <div id = "formSearchResponse">
				                 <form id = "ricercaResponsive" method ="GET" action ="SearchServlet" >
	        						<i class="fas fa-times" onClick = "HideSearchBar()"></i>
	       							<input type = "Text" name = "argument" placeholder="Cerca pacchetti" >
	   							 </form>
	   						 </div>
                       	 </li>
                        <li>
	                    	<div class = "navbar-item login">
		                         <div class = "navbar-item-image">
		                              <img src="./Icons/user.png" alt = "logo" id="loginImage" onClick="mostraLogin()">
		                         </div>
	                             <div class = "navbar-item-description">
		                              <div id = "pulsante-accedi" onClick="mostraLogin()">
		                                   Accedi
		                              </div>
	                             </div>
	                    	</div>
	                    </li>     	
	                    <%}%>
						<li>
	                         <div class="navbar-item">
	                               <div class = "navbar-item-image">
	                                    <a href = "Cart.jsp"><img src="./Icons/carrello.png" alt = "logo"></a>
	                               </div>
	                               <div class="navbar-item-description">Carrello</div> 
	                         </div>
                        </li>
                        <%if(loggedUser != null ){%>
                        <a href = "LogoutServlet">  
	                         <li>                	
			                     <i class="fas fa-sign-out-alt"></i>
				                 <div class="navbar-item-description">Logout</div>                
	                         </li>
                        </a>
                        <%}%>
                    </ul>
               	</nav>
          </div>
    </div> 
    
 <!-- Login -->
<div class= "sfondo-login">
	<div id = "close-icon" onClick = "nascondi()">
		<i class="far fa-times-circle"></i>
	</div>
	
	<div class ="container-login">
		<div class ="form">
			<h2> Accedi </h2>		
			<div id = "messageError"></div>
			<form name = "login">
				<label for="uname"><b>Nome utente</b></label>
				<input type="text" placeholder="Inserisci nome utente" name="NomeUtente" id="myName" required>
					
				<label for="psw"><b>Password</b></label>  
				<div class="input-with-icon">
					<input type="password" placeholder="Inserisci password" name="Password" id="myPass" required>
					<i class="fas fa-eye-slash" onclick="togglePassword(event)"></i>
				</div>
					<span class="dim" onclick="mostraRecuperoPassword()">Password dimenticata ?</span> 		
					    	    
				<button type="submit">Accedi</button>
				<span class = "remb">
					<label> <input type="checkbox" checked="checked" id="remember" onClick = "">Ricordami</label>
				</span>
			</form>
			<div class="footer">Non sei ancora registrato?</div>
			<div class="footer">
				<div id = "pulsante-registrati" onClick="mostraRegistrazione()">
					Registrati
				</div>
			</div> 	
		</div>
	</div>
</div>

<!-- Registrazione -->
<div class="sfondo-login registrazione">
	<div id = "close-icon" onClick = "nascondi()">
		<i class="far fa-times-circle"></i>
	</div>
	<div class="container-login registrazione">
		<div class ="form">
		<h2> Registrati</h2>
			<div id = "signUpMessageError"></div>
				<form name="sign-up">
					<label for="surname"><b>Nome Utente</b></label><br>
					<input type="text" placeholder="Inserisci nome utente" name="NomeUtente" required id = "newName">
							    	
					<label for="email"><b>Email</b></label><br>
					<input type="email" placeholder="Inserisci email" name="Email" required id = "newEmail">
							    	
					<label for="password" class="control-label"><b>Password</b></label>
					<div class="input-with-icon">
						<input type="password" placeholder="Inserisci password" name="Password" id="regPass" required>
						<i class="fas fa-eye-slash" onclick="togglePassword(event)"></i>
					</div>
							    	
					<label for="confPass"><b>Conferma password</b></label>
							    	
					<div class="input-with-icon">
						<input type="password" placeholder="Reinserisci password" name="Conf_Password" id="regPassRepeat" required>
						<i class="fas fa-eye-slash" onclick="togglePassword(event)"></i>
					</div>
							    	
					<button type="submit">Registrati</button>
							    	
					<div class="footer">Sei gi&agrave; registrato?</div>
					<div class="footer">
						<div id = "new-pulsante-accedi" onClick="mostraLogin()"> Accedi </div>
					</div>
			</form>	    
		</div>	
	</div>
</div>

<!-- Recupera password -->
<div class = "sfondo-login recuperoPassword">
	<div id = "close-icon" onClick = "nascondi()">
		<i class="far fa-times-circle"></i>
	</div>
	       	
	<div class="container-login recuperoPassword">
		<div class ="form">
			<h2 id="recovery">Recupero password</h2>
			<div id = "signUpMessageError"></div>
			<form name="passRecovery" id="formRecovery">	
				<label for="email"><b>Inserisci la tua mail</b></label><br>
				<input type="email" placeholder="es: marioRossi@libero.it" name="Email" required id = "emailF">
				<button type="submit">Invio</button>
			</form>	   
		</div>
	</div>
</div>