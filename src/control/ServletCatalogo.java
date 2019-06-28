package control;




import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.PacchettoBean;
import model.dao.PacchettoDS;


@WebServlet("/ServletCatalogo")
public class ServletCatalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoria=request.getParameter("categoria");
		System.out.println(categoria);
		
		Map<String,ArrayList<PacchettoBean>> pacchetti = null;
		
		
		PacchettoDS dao = new PacchettoDS();
		pacchetti = dao.getCategoriaRaggruppato(categoria);
		
		if(pacchetti == null || pacchetti.size()==0) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		request.setAttribute("categoria", categoria);
		request.setAttribute("pacchetti", pacchetti);

		RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/Catalogo.jsp");
		dispatcher.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
		}

	}
