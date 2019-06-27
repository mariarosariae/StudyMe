<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
import = "java.util.*, model.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="carrello.css">
<meta charset="ISO-8859-1">
<title>Carrello</title>
</head>
<%

HttpSession sessione = request.getSession();
Carrello cart = (Carrello) sessione.getAttribute("carrello");
ArrayList<PacchettoBean> paccCarrello= cart == null ? new ArrayList <PacchettoBean> () : cart.getOggettiCarrello();
%>

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
                
            <div id = "carrello" >
                <nav>
                    <ul class="nav">
                        <li>
                            <div class = "navbar-item">
                                <div class = "navbar-item-image">
                                	
                                    <a href ="Carrello.jsp"><img src="./Icons/user.png" alt = "logo"></a>
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
                                <img src="./Icons/carrello.png" alt = "logo">
                                </div>
                                   <div class="navbar-item-description"><a href="Cart.jsp">Carrello</a></div>
									</div>		
									</li></ul></nav></div></div>
									
							<div class="tabellaCarrello">
					
       			<%if(paccCarrello.size()!=0){%>
        		table class="bordered" class="responsive-table"
							<thead>
        					  <tr>
              					<th>Nome</th>
              					<th>descrizione</th>
             					<th>prezzo</th>
              		            <th> rimuovi dal carrello</th>
             					 <th></th>
          </tr>
        </thead>
          <tbody>
          <%for(int i=0;i<paccCarrello.size();i++){%>
 			 <tr>
 			 <td><%=paccCarrello.get(i).getTitolo()%></td>	
 			 <td><%=paccCarrello.get(i).getDescrizione()%></td>
 			 <td><%=paccCarrello.get(i).getPrezzo()%></td>
 			 
 			 <form action="CarrelloServelet" method="post">
 			 
			  <input type="hidden" name="action" value="rimuoviDalCarrello"/>
			  
			    <input type="hidden" name="codiceP" value="<%=paccCarrello.get(i).getCodicePacchetto()%>"/>
			<td><button type="submit" class="waves-effect waves-light btn">  
			
			<i class="tiny material-icons">Rimuovi</i></button></td> 
			</form>	
				
        	<%}}else{%>
        	</tbody>
        	</table>
        	</div>
        	
           	<h1>Non ci sono prodotti aggiunti al carrello</h1>
        	<%}%>	
        	</div>
									
						
										
										

</body>
</html>