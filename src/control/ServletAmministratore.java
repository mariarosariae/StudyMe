package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import control.util.JSONResponse;
import model.bean.OrdineBean;
import model.bean.PacchettoBean;
import model.dao.AmministratoreDao;

@WebServlet("/ServletAmministratore")
public class ServletAmministratore extends HttpServlet {
       
    public ServletAmministratore() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String action=request.getParameter("action");
		System.out.println("sei nella servelet");
		System.out.println(action);
		
		if(action !=null) {
			if(action.equalsIgnoreCase("inserisciPacchetto")) {
		System.out.println("sono qua");
		ArrayList<PacchettoBean> lista=new ArrayList<PacchettoBean>();
		boolean test=false;
		PacchettoBean pacchetto=new PacchettoBean();
		for(PacchettoBean p: lista) {
			if (p.getCodicePacchetto().equalsIgnoreCase(pacchetto.getCodicePacchetto())) {
				test=true;
			}else {
				test=false;
			}
		}
		if(!test) {
		String codicePacchetto= request.getParameter("codicePacchetto");
		String titolo= request.getParameter("titolo");
		String descrizione= request.getParameter("descrizione");
		String categoria=request.getParameter("categoria");
		String idsott=request.getParameter("sottocategoria");	
		double prezzo=Double.parseDouble(request.getParameter("prezzo"));
		String foto=request.getParameter("foto");
		
		System.out.println("Pacchetto inserito");
		
		AmministratoreDao nuovoPacchetto= new AmministratoreDao();
		nuovoPacchetto.inserPacchetto(codicePacchetto,categoria,idsott,prezzo,descrizione,titolo,foto);
			}	
		}else if (action.equalsIgnoreCase("modificaPacchetto")) {
				String codicePacchetto= request.getParameter("codicePacchetto");
				double prezzo=Double.parseDouble(request.getParameter("prezzo"));
				String titolo=request.getParameter("titolo");
				String descrizione=request.getParameter("descrzione");				
				
				System.out.println("pacchetto modificato");
				AmministratoreDao PacchettoModificato= new AmministratoreDao();
				
				
		}else if (action.equalsIgnoreCase("eliminaPacchetto") ) {
			System.out.println("sono qui");
			String codicePacchetto=request.getParameter("codicePacchetto");
			
			System.out.println("Pacchetto eliminato");
			AmministratoreDao pacchettoEliminato= new AmministratoreDao();
			pacchettoEliminato.deletePacchetto(codicePacchetto);
		
		
		}else if(action.equalsIgnoreCase("inserisciLezione")) {
			String url=request.getParameter("url");
			String titolo=request.getParameter("titolo");
			String durata=request.getParameter("durata");
			String codicePacchetto = request.getParameter("codicePacchetto");
			
			AmministratoreDao nuovaLezione= new AmministratoreDao();
			nuovaLezione.insertLezione(url, titolo, durata,codicePacchetto);
			System.out.println("Lezione inserita");
			
		}else if(action.equalsIgnoreCase("eliminalezione")) {
			String url=request.getParameter("url");
			
			System.out.println(url);
			
		
			AmministratoreDao lezioneEliminata= new AmministratoreDao();
			lezioneEliminata.deleteLezione(url);
			System.out.println("Lezione eliminata");
			
		}else if(action.equalsIgnoreCase("modificaTitolo")) {
			System.out.println("sei nella funzione modifica titolo");
			String titolo=request.getParameter("titolo");
			String newTitolo=request.getParameter("newTitolo");
			
			AmministratoreDao nuovoTitolo=new AmministratoreDao();
			
			System.out.println("Titolo sostituito");
			
		}else if(action.equalsIgnoreCase("modificaUrl")) {
			String url=request.getParameter("url");
			
			AmministratoreDao nuovoTitolo=new AmministratoreDao();
			
			System.out.println("Url sostituito");
			
		}else if(action.equalsIgnoreCase("informazionicliente")) {
			String nomeCliente=request.getParameter("nomeCliente");
			
			
			System.out.println("Informazioni ordini");
			AmministratoreDao ordini= new AmministratoreDao();
			ordini.getOrdine(nomeCliente);
			
			request.setAttribute("ordini", ordini);
			
			RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/Ordini.jsp");
			dispatcher.forward(request, response);
			
				}
			}
		}
}

