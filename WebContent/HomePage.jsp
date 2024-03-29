<!DOCTYPE html>
	<%@ include file = "header.jsp" %>
<body>
    <div class ="container">
 	<%@ include file="NavigationBar.jsp"%>       
	<%@ include file="BarCategory.jsp"%> 
    
    <!-- Slide Show -->
	<div class = "slideshow-container">
		<div class="slideshow" style="background: url('img/slideshow/Home1.jpg')">
			<div class = "text-wrapper">
				<div class = "slideshow-frase">Non abbandonare le tue passioni</div>
				<div class = "slideshow-sottofrase">Essere appassionati di qualcosa &egrave; la caratteristica pi&ugrave; bella che si pu&ograve; sviluppare.</div>
			</div>
		</div>
		
		<div class="slideshow" style="background: url('img/slideshow/Home2.jpg')">
		     <div class = "text-wrapper">
			      <div class = "slideshow-frase">StudyMe in qualsiasi momento della giornata</div>
			           <div class = "slideshow-sottofrase">Impara quando e ovunque tu voglia, la prima lezione la offriamo noi.</div>
			      </div>
		     </div>
		            
		<div class="slideshow" style="background: url('img/slideshow/Home3.jpg')">
		     <div class = "text-wrapper">
			       <div class = "slideshow-frase">Investi su di te</div>
			       <div class = "slideshow-sottofrase">Con un corso aggiunto ogni giorno, &egrave; garantito che tu possa trovare quello che fa per te.</div>
		     </div>
		</div>
	</div>
	        
	<!-- Chi siamo -->
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
	        
	<!-- Lista vantaggi -->
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
	   <%@ include file="Footer.jsp"%> 
    </div>
    <script type="text/javascript" src="./js/showSlides.js"></script>
</body>