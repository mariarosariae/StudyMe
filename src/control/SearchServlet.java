package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.PacchettoBean;
import model.dao.PacchettoDS;
import model.dao.UserManager;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String argument = request.getParameter("argument");
		
		if(argument == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		argument = argument.trim();
		
		ArrayList<PacchettoBean> pacchettiRicercati = null;
		PacchettoDS manager = new PacchettoDS();
		pacchettiRicercati = manager.searchPackage(argument);
		
		request.setAttribute("pacchetti", pacchettiRicercati);
		request.setAttribute("argomento", argument);

		RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/Search.jsp");
		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}