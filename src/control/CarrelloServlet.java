package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.CarrelloBean;
import model.bean.PacchettoBean;
import model.dao.PacchettoDS;

@WebServlet("/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PacchettoDS pacchettods= new PacchettoDS();
   
    public CarrelloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		HttpSession session = request.getSession();
		String action=request.getParameter("action");
		CarrelloBean carrello =((CarrelloBean)session.getAttribute("carrello"));
		
		System.out.println("ciao");
		
		if(action!=null){
			if(action.equalsIgnoreCase("aggiungiAlCarrello")){
				
				boolean presente=false;  //diventerà true quando il carrello conterr� gi� prodotti con quell'id
				String codiceP	= request.getParameter("codiceProdotto");
			
				ArrayList<PacchettoBean>pacchetticarrello=carrello.getOggettiCarrello();

				for(int i=0; i<pacchetticarrello.size(); i++){
					if(codiceP==pacchetticarrello.get(i).getCodicePacchetto()){
				
						presente=true;
					}
				}
				if(!presente) {
					PacchettoBean pacchetto=null;
					try {
						pacchetto=pacchettods.findByKey(codiceP);
						
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
					carrello.aggiungi(pacchetto);
				}
				session.setAttribute("carrello", carrello);
				RequestDispatcher dispatcher;
				dispatcher=getServletContext().getRequestDispatcher("/Cart.jsp");
				dispatcher.forward(request, response);
				
				}else if(action.equalsIgnoreCase("rimuoviDalCarrello")) {
					String codiceP=request.getParameter("codicePacchetto");
					ArrayList<PacchettoBean>pacchcarrello=carrello.getOggettiCarrello();
					for(int i=0;i<pacchcarrello.size();i++) {
						if(codiceP==pacchcarrello.get(i).getCodicePacchetto()) {
							carrello.rimuovi(i);
						}
					}
					session.setAttribute("carrello",carrello);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Cart.jsp");
					dispatcher.forward(request, response);
				}else if(action.equalsIgnoreCase("rimuovitutto")) {
					carrello.rimuovitutto();
					session.setAttribute("carrello", carrello);
					RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/Cart.jsp");
					dispatcher.forward(request, response);
				}
			}else System.out.println("String action nulla");
				session.setAttribute("carrello", carrello);
	}
}