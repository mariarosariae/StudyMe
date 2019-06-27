<%@page import="java.util.ArrayList" %>
<%@page import="model.bean.*" %>
<%@page import="model.dao.*" %>

<% 	ArrayList<PacchettoBean>  t =(ArrayList<PacchettoBean>)request.getAttribute("pacchetti"); 
	String categoria = (String) request.getAttribute("categoria");
%>

<!DOCTYPE html>
<html>
	<head >
		<link rel="stylesheet" href="css/catalogo.css">
	</head>
    <%@ include file = "header.jsp" %>
<body>
     <div class ="container">
 	<%@ include file="NavigationBar.jsp"%>  
       
	<div class="categoria" style = "background-image: url('./img/category/sviluppo2.png')">
		<h1> <%=categoria.toUpperCase()%> </h1>
	</div>
	
	
	
	
	<div class="cat1">
    <h1>Linguaggi di programmazione</h1>
    <div class="grid-generale">
   		<% for(int i=0;i<t.size();i++) {%>	
        <div class= "pacchetto">
            <h1><%=t.get(i).getTitolo() %></h1><br>
        <div class = "foto-categoria" style="background-image: url(./img/immaginipacchetti/C1.jpg)"></div>
            <p><%=t.get(i).getDescrizione()%></p>
        <div class="buy-now">
            <input type = "submit" value = "Vai alle lezioni">
        </div>
    </div>
    <%}%>
     
    <!--  <div class= "pacchetto">
        <h1>Programmazione C++</h1><br>
        <div class = "foto-categoria" style="background-image: url(./img/immaginipacchetti/C++.jpg)"></div>
            <p>C ++ pu� essere difficile da imparare, ma farlo ha enormi profitti. Se sei interessato ad imparare come usare C ++ per lo sviluppo del gioco, o una pi� ampia introduzione all'argomento.</p>
        <div class="buy-now">
            <input type = "submit" value = "Vai alle lezioni">
        </div>
    </div>

    <div class= "pacchetto">
        <h1>Java</h1><br>
        <div class = "foto-categoria" style="background-image: url(./img/immaginipacchetti/java1.jpg)"></div>
            <p>Java � uno dei linguaggi di programmazione pi� popolari. Java offre funzioni di programmazione sia orientate agli oggetti che funzionali.</p>
        <div class="buy-now">
             <input type = "submit" value = "Vai alle lezioni">
        </div>
    </div>

    <div class= "pacchetto">
        <h1>Python</h1><br>
        <div class = "foto-categoria" style="background-image: url(./img/immaginipacchetti/python.png)"></div>
            <p>Questo corso � rivolto a principianti inesperti che non hanno mai programmato prima. Python � uno dei linguaggi di programmazione pi� popolari al mondo: aziende  come Google lo utilizzano in  varie applicazioni, � la scelta di linguaggio numero uno per l'apprendimento automatico, la scienza dei dati e l'intelligenza artificiale.</p>
        <div class="buy-now">
            <input type = "submit" value = "Vai alle lezioni">
        </div>
     </div>
    </div>
</div>
<div class="cat2">
<h1>Database</h1>
<div class="grid-generale">
    <div class= "pacchetto">
     <h1>MySQL</h1><br>
     <div class = "foto-categoria" style="background-image: url(./img/immaginipacchetti/mysql.jpg)"></div>
        <p>Stabilire le basi pi� solide possibili nello sviluppo di database imparando a utilizzare MySQL, il database open source pi� popolare al mondo : scrivere query, creare report a proprio piacimento, creare applicazioni Web, incorporare MySQL come livello di database - rendere i propri sogni di sviluppo una realt� seguendo questo corso e mettendo un segno di spunta accanto al tuo skillset di sviluppo in crescita.</p>
     <div class="buy-now">
        <input type = "submit" value = "Vai alle lezioni">
    </div>
    </div>
     <div class= "pacchetto">
         <h1>Linguaggio SQL</h1><br>
        <div class = "foto-categoria" style="background-image: url(./img/immaginipacchetti/sql.png)"></div>
            <p>Per prima cosa iniziamo il corso con l'introduzione di base sui database e comprendiamo cosa sono esattamente i database e perch� vengono utilizzati. Quindi apprendiamo come installare gli strumenti necessari che ci permetteranno di creare i nostri database e aggiungere dati al suo interno.Andando avanti, impariamo alcuni operatori SQL, e impariamo anche come questi operatori possono essere utilizzati nelle query SQL che ci permette di formare query pi� complesse.</p>
        <div class="buy-now">
            <input type = "submit" value = "Vai alle lezioni">
            </div>
        </div> 
    </div>     
</div>
<div class="cat1">
<h1>Web Development</h1>
<div class="grid-generale">
    <div class= "pacchetto">
     <h1>Html e CSS</h1><br>
    <div class = "foto-categoria" style="background-image: url(./img/immaginipacchetti/htmlecss.png)"></div>
        <p>HTML e CSS sono le due lingue pi� importanti da apprendere per un nuovo sviluppatore web. Sono anche i pi� facili. Se hai sempre desiderato creare pagine web, ma il codice ti ha intimidito, questo corso ti aiuter� a imparare le tue prime due lingue in modo rapido e semplice.</p>
     <div class="buy-now">
        <input type = "submit" value = "Vai alle lezioni">
   </div>
 </div>
    <div class= "pacchetto">
     <h1>Javascript</h1><br>
     <div class = "foto-categoria" style="background-image: url(./img/immaginipacchetti/javas.png)"></div>
          <p>Questo corso � una guida passo passo che ti prender� per mano e ti guider� attraverso le basi assolute e ti mostrer� tutto ci� che devi imparare per iniziare con JavaScript.</p>
    <div class="buy-now">
         <input type = "submit" value = "Vai alle lezioni">
    </div>
    </div>
        <div class= "pacchetto">
          <h1>Wordpress</h1><br>
          <div class = "foto-categoria" style="background-image: url(./img/immaginipacchetti/word.png)"></div>
            <p>Non � richiesta alcuna conoscenza dei prerequisiti e non � necessario un sito Web o un account di hosting web esistente. Sarai configurato con un nuovo account di hosting gratuito in modo da poter iniziare a imparare WordPress immediatamente senza dover impegnare ulteriori risorse per un dominio di dot com in anticipo.</p>
          <div class="buy-now">
            <input type = "submit" value = "Vai alle lezioni">
       </div>
        </div>
    </div>
    </div>
    <div class="cat2">
    <h1>Mobile Development</h1>
    <div class="grid-generale">
        <div class= "pacchetto">
         <h1>Android Java Masterclass</h1><br>
         <div class = "foto-categoria" style="background-image: url(./img/immaginipacchetti/android.jpg)"></div>
             <p>In questo corso, scoprirai la potenza dello sviluppo di app per Android e otterrai le competenze per aumentare notevolmente le tue prospettive di carriera come sviluppatore di software. Avrai anche un vantaggio sugli altri sviluppatori che utilizzano strumenti obsoleti e versioni precedenti di Android.</p>
         <div class="buy-now">
            <input type = "submit" value = "Vai alle lezioni">
       </div>  
    </div>
    <div class= "pacchetto">
        <h1>iOS10 Swift 3</h1><br>
        <div class = "foto-categoria" style="background-image: url(./img/immaginipacchetti/ios.jpg)"></div>
            <p>Benvenuto nel corso pi� completo del mondo per lo sviluppo di iOS.Questo corso � progettato come un bootcamp di codifica personale per offrirti la maggior quantit� di contenuti e aiutare con il minor costo possibile.</p>
        <div class="buy-now">
            <input type = "submit" value = "Vai alle lezioni">
       </div>
    </div>
    </div>
</div>
<div class="cat1">
<h1>Game Development</h1>
<div class="grid-generale">
    <div class= "pacchetto">
     <h1>Costruisci giochi 2D e 3D</h1><br>
     <div class = "foto-categoria" style="background-image: url(./img/immaginipacchetti/unity.jpg)"></div>
         <p>Questo � il corso pi� completo su Unity 3d su Internet. Siamo avidi sviluppatori di giochi e siamo stanchi di tutta la spazzatura l� fuori - insegnando agli studenti come realizzare cubi 3D senza sviluppo del mondo reale.</p>
     <div class="buy-now">
        <input type = "submit" value = "Vai alle lezioni">
   </div>-->
        </div>
        
</div>

</div> 
 <%@ include file="Footer.jsp"%> 
 </body>
</html>