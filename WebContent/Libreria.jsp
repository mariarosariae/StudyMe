<%@page import="java.util.ArrayList" %>
<%@page import="model.bean.*" %>
<%@page import="model.dao.*" %>

<%
	ArrayList<ArrayList<LezioniBean>> lezioni= (ArrayList<ArrayList<LezioniBean>>) request.getAttribute("lezioni");
	ArrayList<PacchettoBean> pacchetti =(ArrayList<PacchettoBean>) request.getAttribute("pacchetti");
%>


<!DOCTYPE html>
<html lang="it" dir="ltr">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/b81887022a.js"></script>
        <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous">
        </script>
        <link rel="stylesheet" href="css/libreria.css">
        <title>Lista corsi</title>
    </head>
    <body>
    	<%@ include file="header.jsp"%> 
    	<%@ include file="NavigationBar.jsp"%>
    	<%@ include file="BarCategory.jsp"%> 
        <div class="container">
            <div class="information">
                <h1>I tuoi acquisti</h1>
                <h4>In questa sezione vengono mostrati i tuoi acquisti</h4>
                <span>Clicca su un corso per vedere l'elenco completo delle lezioni</span>
            </div>

            <div class="pacchetto-wrap">
	            <% for(int i=0; i<pacchetti.size();i++) {%>
	            <div class="pacchetto">
                    <img src="<%=pacchetti.get(i).getFoto()%>">
                    <span><%=pacchetti.get(i).getTitolo()%></span>
                    <i class="fas fa-chevron-down"></i>
                    <ul class="lezioni">
						<%ArrayList<LezioniBean> lezioniCorrenti = lezioni.get(i);
						for(LezioniBean lezione: lezioniCorrenti) {%>
							<li class="lezione" data="<%=lezione.getUrl()%>">
	                            <i class="fas fa-play"></i>
	                            <span class="title"><%=lezione.getTitolo()%></span>
	                            <span class="durata"><%=lezione.getDurata()%></span>
                        	</li>
						<% } %>
						</ul>
			<%} %>
			  </div>
            </div>
        </div>
        <%@ include file="Footer.jsp"%> 
        <script src="js/libreria.js" charset="utf-8"></script>
    </body>
</html>
	    	