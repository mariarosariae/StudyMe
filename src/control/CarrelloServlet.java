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
import model.dao.PacchettoDao;

@WebServlet("/CarrelloServlet")
public class CarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PacchettoDao dao= new PacchettoDao();
   
    public CarrelloServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String action=request.getParameter("action");	
		
		/*CarrelloBean carrello =((CarrelloBean)session.getAttribute("carrello"));*/
		System.out.println(action);
		System.out.println("sei nella servlet");
		ArrayList<PacchettoBean> carrello = (ArrayList<PacchettoBean>)session.getAttribute("carrello");
		
		if(carrello==null) {
			carrello=new ArrayList<PacchettoBean>();
		}
		
		if(action!=null){
			if(action.equalsIgnoreCase("aggiungiAlCarrello")){
				response.setContentType("text/html");
				String codiceP=request.getParameter("codiceP");
				boolean uguale = false;
				PacchettoBean pacchetto = new PacchettoBean();
				pacchetto=dao.getPacchetto(codiceP);
				for(PacchettoBean p: carrello) {
				if(p.getCodicePacchetto().equalsIgnoreCase(pacchetto.getCodicePacchetto()))
				uguale= true;
				else uguale= false;
				}
				if (!uguale) {
					carrello.add(pacchetto);
				}
				
				
				 
				session.setAttribute("carrello", carrello);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Cart.jsp");
				dispatcher.forward(request, response);
			
			}else if(action.equalsIgnoreCase("rimuoviDalCarrello")) {
				
				response.setContentType("text/html");
				String codiceP=request.getParameter("codiceP");
					System.out.println(codiceP);
				for(int i=0;i<carrello.size();i++) {
					if(codiceP.equalsIgnoreCase(carrello.get(i).getCodicePacchetto()))
					{
						carrello.remove(i);
					}
				}
				System.out.println(carrello);
				session.setAttribute("carrello", carrello);
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Cart.jsp");
				dispatcher.forward(request, response);
			
				
				
				}else if(action.equalsIgnoreCase("rimuovitutto")) {
					carrello.clear();
					session.setAttribute("carrello", carrello);
					RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/Cart.jsp");
					dispatcher.forward(request, response);
				}
			}else System.out.println("String action nulla");
				session.setAttribute("carrello", carrello);
}}