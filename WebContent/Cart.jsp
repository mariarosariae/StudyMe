<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
import = "java.util.*, model.bean.*"%>
<!DOCTYPE html>
	<%@ include file = "header.jsp" %>
	<link rel="stylesheet" href="css/UserArea.css">
	
<%
		HttpSession sessione = request.getSession();
	CarrelloBean cart = (CarrelloBean) sessione.getAttribute("carrello");

	if(cart == null)
		cart = new CarrelloBean();

	ArrayList<PacchettoBean> paccCarrello = cart.getOggettiCarrello();
	%>

<body>
	<div class ="container">
        <%@ include file="NavigationBar.jsp"%>       
		<%@ include file="BarCategory.jsp"%> 
									
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
 			 
 			 <form action="CarrelloServlet" method="post">
 			 
				 <input type="hidden" name="action" value="rimuoviDalCarrello"/>
				  
				 <input type="hidden" name="codiceP" value="<%=paccCarrello.get(i).getCodicePacchetto()%>"/>
				 <td><button type="submit" class="waves-effect waves-light btn">  
				
				 <i class="tiny material-icons">Rimuovi</i></button></td> 
			</form>	
				
        	<%}}else{%>
        </tbody>
		</div>
        	
        <h1>Non ci sono prodotti aggiunti al carrello</h1>
       	<%}%>	       	
     </div>
     <%@ include file="Footer.jsp"%>  
</body>
</html>