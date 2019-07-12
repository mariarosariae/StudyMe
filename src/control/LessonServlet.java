package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.CarrelloBean;
import model.bean.LezioniBean;
import model.bean.PacchettoBean;
import model.bean.RecensioneBean;
import model.bean.UserBean;
import model.dao.PacchettoDS;
import model.dao.UserManager;

@WebServlet("/LessonServlet")
public class LessonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LessonServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codicePacchetto = request.getParameter("codicePacchetto");
		String nomeAmministratore = request.getParameter("nomeAmministratore");

		ArrayList<LezioniBean> lezioni = null;
		PacchettoBean pacchetto = null;
		ArrayList<RecensioneBean> recensioni = null;
		boolean comprato = false;
		boolean nelCarrello = false;
		
		PacchettoDS manager = new PacchettoDS();
		lezioni = manager.getLezioni(codicePacchetto);
		pacchetto = manager.getPacchetto(codicePacchetto);
		recensioni = manager.getRecensioni(codicePacchetto);
		
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("User");
		ArrayList<PacchettoBean> cart = (ArrayList<PacchettoBean>) session.getAttribute("carrello") ;
		
		if(cart == null) {
			System.out.println("Carrello vuoto");
			cart = new ArrayList<PacchettoBean>();
			session.setAttribute("carrello", cart);
		}
		
		//Se l'utente è loggato
		if(user != null) {
			//TODO controllare nel db se l'utente ha acquistato il pacchetto
			//Nel caso in cui lo abbia comprato porre comprato = true
			comprato = false;
			if(!comprato) {
				//Controlla che sia nel carrello
				for(PacchettoBean product : cart) {
					if(product.getCodicePacchetto().equalsIgnoreCase(codicePacchetto)) {
						nelCarrello = true;
						break;
					}
				}
			}
		}
		
		request.setAttribute("lezioni", lezioni);
		request.setAttribute("pacchetto", pacchetto);
		request.setAttribute("recensioni", recensioni);
		request.setAttribute("comprato", comprato);
		request.setAttribute("nelCarrello", nelCarrello);
		
		if(nomeAmministratore != null) {
			RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/LessonAdministrator.jsp");
			dispatcher.forward(request, response);	
		} else {
			RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/Lesson.jsp");
			dispatcher.forward(request, response);	
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}