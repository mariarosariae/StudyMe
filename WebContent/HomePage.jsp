<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
    <title>StudyMe</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="HomePage.css">
    <link rel = "stylesheet" href = "login.css">
    <link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Courgette&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Coming+Soon&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Karma" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">  
</head>
<body>
    <div class ="container">
        <div class = "navbar">
            <div id = "logo">
                <div class="navbar-item" id="logo-item">
                    <div class = "navbar-item-image">
                        <a href = "HomePage.html"><img src="./Icons/Logo sito.png" alt = "logo"></a>
                    </div>             
                        <div class="navbar-item-description">StudyMe</div>               
                </div>
            </div>
            
            <form id="ricerca">
                <i class="fas fa-search"></i>
                <input type = "Text" placeholder="Cosa vuoi imparare oggi ?" >
            </form>
                
            <div id = "carrello">
                <nav>
                    <ul class="nav">
                        <li>
                            <div class = "navbar-item">
                                <div class = "navbar-item-image">
                                    <a href = "#"><img src="./Icons/user.png" alt = "logo"></a>
                                </div>
                                <div class = "navbar-item-description">
                                    <div id = "pulsante-accedi" onClick="mostraLogin()">
                                    	Accedi
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li>
                            <div class="navbar-item">
                                <div class = "navbar-item-image">
                                    <a href = "#"><img src="./Icons/carrello.png" alt = "logo"></a>
                                </div>
                                   <div class="navbar-item-description">Carrello</div> 
                            </div>
                        </li>
                    </ul>
                </nav>
            </div>
        </div> 
        
        <!--  ACCEDI -->
        <div class= "sfondo-login">
        	<div id = "close-icon" onClick = "nascondi()">
       			<i class="far fa-times-circle"></i>
       		</div>
        	<div class ="container-login">
				<div class ="form">
					<h2> Accedi </h2>				
					<form name = "login" action="Login" method="get">
						<label for="uname"><b>Nome utente</b></label>
					    <input type="text" placeholder="Inserisci nome utente" name="NomeUtente" required>
					
					    <label for="psw"><b>Password</b></label>  
					    <div class="input-with-icon">
							<input type="password" placeholder="Inserisci password" name="Password" id="myInput" required>
							<i class="fas fa-eye-slash" onclick="togglePassword(event)"></i>
						</div>
					    <span class="dim"><a href="#">Password dimenticata ?</a></span> 	
					    	    
					    <button type="submit">Accedi</button>
					    <span class = "remb"><label> <input type="checkbox" checked="checked" name="remember">Ricordami</label></span>
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
   		
   		<!-- REGISTRATI -->	 
   		<div class="sfondo-login registrazione">
	   		<div id = "close-icon" onClick = "nascondi()">
	       			<i class="far fa-times-circle"></i>
	       	</div>
   			<div class="container-login registrazione">
				<div class ="form">
					<h2> Registrati</h2>
							
					<form action="Registration" method="get">
					<label for="surname"><b>Nome Utente</b></label><br>
					<input type="text" placeholder="Inserisci nome utente" name="NomeUtente" required onSelect="allLetter(document.form1.text1)">
						    	
					<label for="email"><b>Email</b></label><br>
					<input type="email" placeholder="Inserisci email" name="Email" required onSelect="ValidateEmail(document.form1.text1)">
						    	
					<label for="password" class="control-label"><b>Password</b></label>
					<div class="input-with-icon">
					<input type="password" placeholder="Inserisci password" name="Password" id="myInput" required>
					<i class="fas fa-eye-slash" onclick="togglePassword(event)"></i>
					</div>
						    	
					<label for="confPass"><b>Conferma password</b></label>
						    	
					<div class="input-with-icon">
						<input type="password" placeholder="Reinserisci password" name="Conf_Password" id="myInput2" required>
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
        <div class = "barraCategorie">
            <a href = "#"> 
                <span class = "cartaCategoria" style="background: url('img/category/sviluppo2.png') no-repeat;">
                    <span class = "sfondo"></span>
                    <h1>Sviluppo</h1>
                </span>
            </a>

            <a href = "#"> 
                <span class = "cartaCategoria" style="background: url('img/category/fotografia2.jpg') no-repeat;">
                    <span class = "sfondo"></span>
                    <h1>Fotografia</h1>
                </span>
            </a>

            <a href = "#"> 
                <span class = "cartaCategoria" style="background: url('img/category/musica2.jpg') no-repeat;">
                    <span class = "sfondo"></span>
                    <h1>Musica</h1>
                </span>
            </a>

            <a href = "#"> 
                <span class = "cartaCategoria" style="background: url('img/category/informatica2.jpg') no-repeat;">
                    <span class = "sfondo"></span>
                    <h1>Informatica</h1>
                </span>
            </a>

            <a href = "#"> 
                <span class = "cartaCategoria" style="background: url('img/category/Produttivita.jpg') no-repeat;">
                    <span class = "sfondo"></span>
                    <h1>Produttività</h1>
                </span>
            </a>

            <a href = "#"> 
                <span class = "cartaCategoria" style="background: url('img/category/design.jpg') no-repeat;">
                    <span class = "sfondo"></span>
                    <h1>Design</h1>
                </span>
            </a>

            <a href = "#"> 
                <span class = "cartaCategoria" style="background: url('img/category/Insegnamento.jpg') no-repeat;">
                    <span class = "sfondo"></span>
                    <h1>Insegnamento</h1>
                </span>
            </a>

            <a href = "#"> 
                <span class = "cartaCategoria" style="background: url('img/category/Business.jpg') no-repeat;">
                    <span class = "sfondo"></span>
                    <h1>Business</h1>
                </span>
            </a>
        </div>

        <div class = "slideshow-container">
            <div class="slideshow" style="background: url('img/slideshow/Home1.jpg')">
                <div class = "slideshow-frase">Non abbandonare le tue passioni</div>
                <div class = "slideshow-sottofrase">Essere appassionati di qualcosa &egrave; la caratteristica pi&ugrave; bella che si pu&ograve; sviluppare.</div>
            </div>

            <div class="slideshow" style="background: url('img/slideshow/Home2.jpg')">
                <div class = "slideshow-frase">StudyMe in qualsiasi momento della giornata</div>
                <div class = "slideshow-sottofrase">Impara quando e ovunque tu voglia, la prima lezione la offriamo noi.</div>
            </div>
            
            <div class="slideshow" style="background: url('img/slideshow/Home3.jpg')">
                <div class = "slideshow-frase">Investi su di te</div>
                <div class = "slideshow-sottofrase">Con un corso aggiunto ogni giorno, &egrave; garantito che tu possa trovare quello che fa per te.</div>
            </div>
        </div>

        <div class = "whoWeAre">
                <h1>Chi siamo?</h1>
                <!--Modificare info-->
                <div class = "grid-container">
                    <div class = "cell medium">
                        <h1>La nostra missione</h1>
                        <p>StudyMe &egrave; un sito web nato con l&apos; idea di rendere pi&ugrave; semplice e rapido il modo di apprendere per chi durante la quotidianit&agrave; non ha tempo di frequentare dei veri e propri corsi d&apos;apprendimento oppure per la semplice volont&agrave; di aumentare le proprie conoscenze. </p>
                    </div>

                    <div class = "cell medium">
                        <h1>La nostra essenza</h1>
                        <p>Con StudyMe puoi usufrire di videolezioni utili alla comprensione dell&apos;argomento da te desiderato, in qualsiasi momento della giornata e in qualsiasi luogo, basta solo un dispositivo connesso ad internet che abbia accesso ad un browser. </p>
                    </div>

                    <div class = "cell medium">
                        <h1>Le nostre promesse</h1>
                        <p>StudyMe promette ai propri studenti una conoscenza completa su ogni argomento utile non solo per inseguire una semplice passione, ma anche per aumentare le possibilit&agrave; di lavoro. Per assicurarti che tu abbia intrapreso il corso giusto, la prima lezione la offriamo noi.</p>
                    </div>

                    <div class = "cell medium">
                        <h1>La nostra atmosfera</h1>
                        <p>StudyMe offre una sezione di registrazione per i nuovi utenti e una sezione di accesso per gli utenti gi&agrave; registrati. Alla registrazione dell&apos;utente sar&agrave; disponibile un area personale nella quale saranno visibili i video dei pacchetti acquistati. Una volta che un pacchetto &egrave; presente nell&apos;area personale dell&apos;utente, le video lezioni possono essere consultate senza alcun limite. Una sezione ricerca render&agrave; per l&apos;utente pi&ugrave; facile ed efficiente la ricerca di un pacchetto.</p>
                    </div>
                </div>
        </div>

        <div class = "listaVantaggi-container">
            <h1>Perch&egrave; scegliere noi ?</h1>

            <div class="grid-container">
                <div class = "cell">
                    <i class="fas fa-piggy-bank"></i>
                    <h1>Risparmia il tuo denaro</h1>
                    <p>Con StudyMe non avrai pi&igrave; bisogno di ripetizioni, spostamenti o libri. L&apos;unica cosa che ti occorre &egrave; un dispositivo con accesso alla rete.</p>
                </div>
                
                <div class = "cell">
                    <i class="fas fa-heart"></i>
                    <h1>Insegui i tuoi sogni</h1>
                    <p>StudyMe mette a disposizione ogni giorno nuove video lezioni di ogni categoria. Qualsiasi sia la tua passione, sar&agrave; semplice seguirla.</p>
                </div>

                <div class = "cell odd">
                    <i class="fas fa-clock"></i>
                    <h1>Non temere il tempo</h1>
                    <p>Con StudyMe puoi apprendere a qualsiasi orario tu voglia, sar&agrave; sempre l&igrave; a tua disposizione.</p>
                </div>
            </div>
        </div>

        <div class = "footer-container">
            <div class = "grid-container light-font-color">
                <div class = "cell">
                    <i class="fas fa-map-marker-alt small-font">
                        <p>
                            <a href="https://goo.gl/maps/RcSBNEArTeUgF8Se8" target= "_blank">
                                Via Giovanni Paolo II, 132, <br> 
                                84084 Fisciano SA
                            </a>
                        </p>
                    </i>
                </div>

                <div class = "cell">
                    <i class="fas fa-phone small-font">
                        <p>
                            <a href="tel:+089 961111">
                                +089 961111
                            </a>
                        </p>
                    </i>
                </div>

                <div class = "cell odd">
                    <i class="far fa-envelope small-font">
                        <p>
                            <a href = "mailto: info@studyme.com">info@studyme.com</a> <!-- Email da sostituire -->
                        </p>
                    </i>
                </div>
            </div>
        </div>
    </div>
    
  	<script src="validation.js"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <script type="text/javascript" src="showSlides.js"></script>
    <script type="text/javascript" src="mostraPassword.js"></script>
    <script src="jquery.nicescroll.min.js"></script>
</body>