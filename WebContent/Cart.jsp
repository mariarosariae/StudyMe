<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
import = "java.util.*, model.bean.*"%>
<!DOCTYPE html>


	

	<%@ include file = "header.jsp" %>
	<link rel="stylesheet" href="css/UserArea.css">
	<link rel="stylesheet" href="css/Carrello.css">
	
<%	
		HttpSession sessione = request.getSession();
		ArrayList<PacchettoBean> carrello=(ArrayList<PacchettoBean>)sessione.getAttribute("carrello");	
		UserBean user=(UserBean)sessione.getAttribute("User");
		if(carrello==null){
			carrello=new ArrayList<PacchettoBean>();
		}
	%>	

<body>
	<div class ="container">
        <%@ include file="NavigationBar.jsp"%>       
		<%@ include file="BarCategory.jsp"%> 
		
						
		<div class="tabellaCarrello">	
		 <table class="bordered" class="responsive-table">			
       	<%if(carrello.size()!=0){%>
       
		<thead>
        	<tr>
        		<td>Foto</td>
	            <td>Nome</td>
	            <td>Prezzo</td>
	            <form action="CarrelloServlet" method="post">
 			 
				 <input type="hidden" name="action" value="rimuovitutto"/>
				 <td><button type="submit" class="waves-effect waves-light btn">  
				Rimuovi Tutto</button></td>
			</form>
	          
          	</tr>
        </thead>
        
        <%double sum=0;%>
        
        <tbody>
         <%for(int i=0;i<carrello.size();i++){%>
 			 <tr>
 			 <td><img src="<%=carrello.get(i).getFoto()%>" style="width: 65px; height: 90px;"></td>
 			 <td><%=carrello.get(i).getTitolo()%></td>	
 			 <td><%=carrello.get(i).getPrezzo()%></td>
 			 
 			 <form action="CarrelloServlet" method="post">
 			 
				 <input type="hidden" name="action" value="rimuoviDalCarrello"/>
			     <input type="hidden" name="codiceP" value="<%=carrello.get(i).getCodicePacchetto()%>"/>
				 <td><button type="submit" class="waves-effect waves-light btn">  
				Rimuovi</button></td> 
			</form>	
				  </tbody>
		<%sum=sum+carrello.get(i).getPrezzo();%>
			<%}%>									
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>Prezzo Totale :<%=sum%>&#8364;</td>
		 </table>
		 
			<%if(user==null){%>
		 	<h1 text-align="center">EFFETTUARE PRIMA L'ACCESSO</h1>
	 		 <button type="submit" onClick="mostraLogin()">ACCEDI</button>
		 		
		 		<%}else{%>
		 		<div class = "paypalCheckOut"></div>
			<%}%>
		
    
        	<%}else{%>
      
		
        	
        <h1>Non ci sono prodotti aggiunti al carrello</h1>
       	<%}%>	
       
       
            <form action="CarrelloServlet" method="post">
			  <input type="hidden" name="action" value="aggiungiAlCarrello"/>
			 codice pacchetto : <input type="text" name="codiceP">
			 
			 <button type="submit">Aggiungi al carrello</button>
			  
	  
       	
       	
       	</form>
       	 	
       	
       	
       	
       	</div>       	
     	</div>
   
   <%@ include file="Footer.jsp"%> 
     
 <script src="https://www.paypal.com/sdk/js?client-id=sb&currency=EUR"></script>
</body>
</html>