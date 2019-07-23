package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.LezioniBean;
import model.bean.OrdineAcquistoBean;
import model.bean.PacchettoBean;
import model.bean.UserBean;
import model.dao.OrdineAcquistoDao;
import model.dao.PacchettoDS;


@WebServlet("/LibreriaServlet")
public class LibreriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LibreriaServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean user =(UserBean)session.getAttribute("User");
		
		if(user == null) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		
		String nomeUtente=user.getNomeUtente();
		
		ArrayList<ArrayList<LezioniBean>> lezioni= new ArrayList<ArrayList<LezioniBean>>();
		ArrayList<PacchettoBean> pacchetti = new ArrayList<PacchettoBean>();
		ArrayList<OrdineAcquistoBean> pacchettiAcquistati= new ArrayList<OrdineAcquistoBean>(); //Array che contiene i pacchetti acquistati
		OrdineAcquistoDao dao = new OrdineAcquistoDao();
		
		PacchettoDS pacchetto=new PacchettoDS();
		
		try {			
			pacchettiAcquistati = dao.findByNomeCliente(nomeUtente); // prendo i pacchetti acquistati da un utente  e  mi ritorna un array di pacchetti ascquistati dall'utente		
			for(OrdineAcquistoBean e: pacchettiAcquistati) {
				ArrayList<PacchettoBean> pacchettiOrdineAttuale = e.getPacchettiAcquistati();
				pacchetti.addAll(pacchettiOrdineAttuale);// chiamo il metodo getLezioni per prendere le lezioni del pacchetto e gli passo il codice			
				for(PacchettoBean p : pacchettiOrdineAttuale) {
					//Per ogni pacchetto ottengo tutte le lezioni
					ArrayList<LezioniBean> lezione = new ArrayList<LezioniBean>();
					lezione = pacchetto.getLezioni(p.getCodicePacchetto());// aggiungo le lezioni all'arrayList lezioni 	
					lezioni.add(lezione);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("pacchetti", pacchetti);
		request.setAttribute("lezioni", lezioni);
		
		RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/Libreria.jsp");
		dispatcher.forward(request, response);
	}

}
