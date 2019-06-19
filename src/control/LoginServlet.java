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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		response.setContentType("text/html");
		
		String nomeUtente = request.getParameter("NomeUtente");
		String password = request.getParameter("Password");
		
		if(nomeUtente == null || password == null) {
			JSONResponse jsonResponse = new JSONResponse(false, NO_ARGUMENT);
			out.print(gson.toJson(jsonResponse));
			return;
		}
		
		String passwordBase64format  = Base64.getEncoder().encodeToString(password.getBytes()); 
	
		UserManager manager = new UserManager();
		UserBean user = manager.login(nomeUtente, passwordBase64format);
				
		if(user == null) {
			System.out.println("NESSUN UTENTE");
			JSONResponse jsonResponse = new JSONResponse(false, NO_USER);
			out.print(gson.toJson(jsonResponse));
			return;	
		}
		else {	
			System.out.println("utente ok");
			request.getSession().setAttribute("User", user);
			JSONResponse jsonResponse = new JSONResponse(true, "OK", user.getNomeUtente());
			out.print(gson.toJson(jsonResponse));
		}
	}
	
	private static final String NO_ARGUMENT = "Tutti i parametri devono essere passati";
	private static final String NO_USER = "Username o password errati";
}