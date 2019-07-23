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

import model.bean.AmministratoreBean;
import model.bean.CarrelloBean;
import model.bean.LezioniBean;
import model.bean.OrdineAcquistoBean;
import model.bean.PacchettoBean;
import model.bean.RecensioneBean;
import model.bean.UserBean;
import model.dao.OrdineAcquistoDao;
import model.dao.PacchettoDS;
import model.dao.RecensioneDao;
import model.dao.UserManager;

@WebServlet("/LessonServlet")
public class LessonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LessonServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codicePacchetto = request.getParameter("codicePacchetto");
		AmministratoreBean amministratore = (AmministratoreBean) request.getSession().getAttribute("Amministratore");
		String nomeAmministratore = null;
		
		if(amministratore != null)
			nomeAmministratore = amministratore.getNomeAmministratore();

		ArrayList<OrdineAcquistoBean> ordiniCliente = null;
		OrdineAcquistoDao dao = new OrdineAcquistoDao();
		ArrayList<LezioniBean> lezioni = null;
		PacchettoBean pacchetto = null;
		ArrayList<RecensioneBean> recensioni = null;
		boolean comprato = false;
		boolean nelCarrello = false;
		boolean recensito = false;
		
		PacchettoDS manager = new PacchettoDS();
		lezioni = manager.getLezioni(codicePacchetto);
		pacchetto = manager.getPacchetto(codicePacchetto);
		if(pacchetto == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		recensioni = manager.getRecensioni(codicePacchetto);
		
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("User");
		ArrayList<PacchettoBean> cart = (ArrayList<PacchettoBean>) session.getAttribute("carrello") ;
		
		if(cart == null) {
			cart = new ArrayList<PacchettoBean>();
			session.setAttribute("carrello", cart);
		}
		
		//Se l'utente è loggato
		if(user != null) {
			String nomeUtente = user.getNomeUtente();
			ArrayList<PacchettoBean> pacchettiAcquistati = null;
			try {
				ordiniCliente = dao.findByNomeCliente(nomeUtente);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for(OrdineAcquistoBean o : ordiniCliente) {
				pacchettiAcquistati = o.getPacchettiAcquistati();
				for(PacchettoBean p : pacchettiAcquistati) {
					if(p.getCodicePacchetto().equals(codicePacchetto)) {
						comprato = true;
						break;
					}
				}
				
			}
			if(!comprato) {
				//Controlla che sia nel carrello
				for(PacchettoBean product : cart) {
					if(product.getCodicePacchetto().equalsIgnoreCase(codicePacchetto)) {
						nelCarrello = true;
						break;
					}
				}
			}else {
				RecensioneDao recensionedao = new RecensioneDao();
				try {
					recensito = recensionedao.isAlwreadyReviewed(nomeUtente, codicePacchetto);
				} catch (SQLException e) {
					e.printStackTrace();
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
					return;
				}
				
			}
		}
		
		request.setAttribute("lezioni", lezioni);
		request.setAttribute("pacchetto", pacchetto);
		request.setAttribute("recensioni", recensioni);
		request.setAttribute("comprato", comprato);
		request.setAttribute("nelCarrello", nelCarrello);
		request.setAttribute("recensito", recensito);
		
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