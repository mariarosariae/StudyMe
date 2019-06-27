package control;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import control.util.JSONResponse;
import model.dao.UserManager;
import utility.EmailSender;

@WebServlet("/ForgotPasswordServlet")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ForgotPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Gson gson = new Gson();
		
		String emailUtente = request.getParameter("Email");
		
		if(emailUtente == null || emailUtente.length() == 0) {
			JSONResponse jsonResponse = new JSONResponse(false, NO_EMAIL);
			out.print(gson.toJson(jsonResponse));
			return;
		}
		
		//Restituisce l'unica istanza che esiste in quella classe
		//La prima volta che viene chiamato crea l'instanza, le volte a seguire ritornerà sempre quella.
		UUID uuid = UUID.randomUUID();
	    String randomUUIDString = uuid.toString();
	    String[] random = randomUUIDString.split("-"); 
	    String newPassword = random[0];
	    
		EmailSender sender = EmailSender.GetInstance();
		sender.SendEmail("Recupero password", "Ecco la tua nuova password: " + newPassword , emailUtente);
		System.out.println("Inviata");
		
		String passwordBase64format  = Base64.getEncoder().encodeToString(newPassword.getBytes()); 
		
		UserManager manager = new UserManager();	
		boolean resp = manager.updatePassword(emailUtente, passwordBase64format);
		if(resp == false) {
			System.out.println("NESSUN UTENTE");
			JSONResponse jsonResponse = new JSONResponse(false, NO_USEREMAIL);
			out.print(gson.toJson(jsonResponse));
			return;	
		}else {
			JSONResponse jsonResponse = new JSONResponse(true, "OK");
			out.print(gson.toJson(jsonResponse));
		}
	}
	
	private static final String NO_EMAIL = "Email non inserita";
	private static final String NO_USEREMAIL = "Email non esistente";
}