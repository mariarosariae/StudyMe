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
		if(carrello==null){
			carrello=new ArrayList<PacchettoBean>();
		}
	%>	

<body>
	<div class ="container">
        <%@ include file="NavigationBar.jsp"%>       
		<%@ include file="BarCategory.jsp"%> 
		
		<div class="divTable greyGridTable">
				<div class="divTableHeading">		
       	<%if(carrello.size()!=0){%>
       	
				<div class="divTableRow">
						<div class="divTableHead"><span style="vertical-align: inherit;"><span style="vertical-align: inherit;">Foto</span></span></div>
						<div class="divTableHead"><span style="vertical-align: inherit;"><span style="vertical-align: inherit;">Nome</span></span></div>
						<div class="divTableHead"><span style="vertical-align: inherit;"><span style="vertical-align: inherit;">Prezzo</span></span></div>
						<div class="divTableHead"><span style="vertical-align: inherit;"><span style="vertical-align: inherit;"><button class="waves-effect waves-light btn" onClick = "onClearCartClick()">Rimuovi Tutto</button></span></span></div>
		</div>
		</div>
       	  

     
        
        
			<div class="divTableBody">
				<div class="divTableRow">
					<%double sum=0;%>
				<%for(int i=0;i<carrello.size();i++){%>
							<div class="divTableCell"><span style="vertical-align: inherit;"><span style="vertical-align: inherit;"><img src="<%=carrello.get(i).getFoto()%>" style="width: 65px; height: 90px;"></span></span></div>
							<div class="divTableCell"><span style="vertical-align: inherit;"><span style="vertical-align: inherit;"><%=carrello.get(i).getTitolo()%></span></span></div>
							<div class="divTableCell"><span style="vertical-align: inherit;"><span style="vertical-align: inherit;"><%=carrello.get(i).getPrezzo()%></span></span></div>
							<div class="divTableCell"><span style="vertical-align: inherit;"><span style="vertical-align: inherit;"><button type="submit" class="waves-effect waves-light btn" data = "<%=carrello.get(i).getCodicePacchetto()%>" onClick = "onRemoveClick()">  
								Rimuovi</button></span></span></div>
        
        
        		</div>
        		
        		
       			    
				<%sum=sum+carrello.get(i).getPrezzo();%>
			<%}%>		
			<div class="divTableFoot tableFootStyle">
				<div class="divTableRow">
					<div class="prezzo"><span style="vertical-align: inherit;"><span style="vertical-align: inherit;">Prezzo Totale:<%=sum%></span></span></div>
				
				</div>
		   	</div>
			</div>
							
		
			<%if(loggedUser==null){%>
		 	<h1 text-align="center">EFFETTUARE PRIMA L'ACCESSO</h1>
	 		 <button type="submit" onClick="mostraLogin()">ACCEDI</button>
		 		
		 		<%}else{%>
		 		<div class = "paypalCheckOut"></div>
			<%}%>
		
    
        	<%}else{%>
        		<h1>Non ci sono prodotti aggiunti al carrello</h1>
       				
       				<%}%>	
       	</div>       	
     	</div>
   
   <%@ include file="Footer.jsp"%> 
 
 <script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
 <script src="https://www.paypal.com/sdk/js?client-id=sb&currency=EUR"></script>
 <script src = "js/Cart.js"></script>
</body>
</html>