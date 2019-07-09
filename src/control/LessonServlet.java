package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.bean.LezioniBean;
import model.bean.PacchettoBean;
import model.bean.RecensioneBean;
import model.dao.PacchettoDS;

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
		
		PacchettoDS manager = new PacchettoDS();
		lezioni = manager.getLezioni(codicePacchetto);
		pacchetto = manager.getPacchetto(codicePacchetto);
		recensioni = manager.getRecensioni(codicePacchetto);
		
		request.setAttribute("lezioni", lezioni);
		request.setAttribute("pacchetto", pacchetto);
		request.setAttribute("recensioni", recensioni);
		
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