package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import control.util.JSONResponse;
import model.bean.OrdineAcquistoBean;

import model.bean.UserBean;
import model.dao.OrdineAcquistoDao;


@WebServlet("/GetListaProdottiUtente")
public class GetListaProdottiUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetListaProdottiUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<OrdineAcquistoBean> listaOrdine = new ArrayList<OrdineAcquistoBean>();
		
		OrdineAcquistoDao ordineAcquistoDao = new OrdineAcquistoDao();
		System.out.println("sono nella servlet");
		HttpSession session = request.getSession();
		UserBean user =(UserBean)session.getAttribute("User");
		
		String nomeUtente=user.getNomeUtente();
		
		JSONResponse result;
		
		try {
		
			listaOrdine= ordineAcquistoDao.findByNomeCliente(nomeUtente);
			result = new JSONResponse(true, "ok" , listaOrdine);
		
		}
		catch(SQLException e) {
			result = new JSONResponse(false, "Problema con il database");
		}
		
		response.getWriter().print(new Gson().toJson(result));
	}
}