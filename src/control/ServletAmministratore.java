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
				
				System.out.println("pacchetto modificato");
				AmministratoreDao PacchettoModificato= new AmministratoreDao();
				PacchettoModificato.updatePacchetto(codicePacchetto,prezzo);
				
		}else if (action.equalsIgnoreCase("eliminaPacchetto") ) {
			System.out.println("sono qui");
			String codicePacchetto=request.getParameter("codicePacchetto");
			
			System.out.println("Pacchetto eliminato");
			AmministratoreDao pacchettoEliminato= new AmministratoreDao();
			pacchettoEliminato.deletePacchetto(codicePacchetto);
			
		
		}else if(action.equalsIgnoreCase("inseriscilezione")) {
			String url=request.getParameter("url");
			String titolo=request.getParameter("titolo");
			String durata=request.getParameter("durata");
			String codiceP=request.getParameter("codiceP");
			
			System.out.println("Lezione inserita");
			AmministratoreDao nuovaLezione= new AmministratoreDao();
			nuovaLezione.insertLezione(url, titolo, durata, codiceP);
			
			
		}else if(action.equalsIgnoreCase("eliminalezione")) {
			String url=request.getParameter("url");
			
			System.out.println("Lezione eliminata");
			AmministratoreDao lezioneEliminata= new AmministratoreDao();
			lezioneEliminata.deleteLezione(url);
			
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

