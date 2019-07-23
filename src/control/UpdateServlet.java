package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import control.util.JSONResponse;
import model.bean.UserBean;
import model.dao.UserManager;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Gson gson = new Gson();
	
		String nuovaEmailUtente = request.getParameter("NuovaEmailUtente");
		String nuovaPasswordUtente = request.getParameter("NuovaPasswordUtente");
		String confermaNuovaPasswordUtente = request.getParameter("ConfermaNuovaPasswordUtente");
		UserBean loggedUser = (UserBean) request.getSession().getAttribute("User");
		if(loggedUser == null) {
			RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/HomePage.jsp");
			dispatcher.forward(request, response);
		}else {
			String emailUtente = loggedUser.getEmail();
			if(nuovaEmailUtente != null && nuovaPasswordUtente == null) {
				UserManager manager = new UserManager();
				boolean res = manager.updateEmail(emailUtente, nuovaEmailUtente);
				if(res == false) {
					JSONResponse jsonResponse = new JSONResponse(false, NO_USER);
					out.print(gson.toJson(jsonResponse));
					return;	
				}else {
					JSONResponse jsonResponse = new JSONResponse(true, "OK");
					out.print(gson.toJson(jsonResponse));
				}
			} else if(nuovaEmailUtente == null && nuovaPasswordUtente != null) {
				if(nuovaPasswordUtente.equals(confermaNuovaPasswordUtente)) {
					UserManager manager = new UserManager();
					String passwordBase64format  = Base64.getEncoder().encodeToString(nuovaPasswordUtente.getBytes()); 
					boolean res = manager.updatePassword(emailUtente, passwordBase64format);
					if(res == false) {
						JSONResponse jsonResponse = new JSONResponse(false, NO_USER);
						out.print(gson.toJson(jsonResponse));
						return;	
					}else {
						JSONResponse jsonResponse = new JSONResponse(true, "OK");
						out.print(gson.toJson(jsonResponse));
					}
				} else {
					JSONResponse jsonResponse = new JSONResponse(false, NO_PASSWORD);
					out.print(gson.toJson(jsonResponse));
					return;	
				}
			}
		}
	}
	private static final String NO_USER = "Utente non esistente";
	private static final String NO_PASSWORD = "Le password non coincidono";
}
