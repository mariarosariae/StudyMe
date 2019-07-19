package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import control.util.JSONResponse;
import model.bean.LezioniBean;
import model.bean.PacchettoBean;
import model.dao.AmministratoreDao;

@WebServlet("/AmministratoreServlet")
public class AmministratoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AmministratoreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		PacchettoBean pacchetto = new PacchettoBean();
		LezioniBean lezione = new LezioniBean();
		Gson gson = new Gson();
		System.out.println("Sono nella servlet");
		String action = request.getParameter("azione");
		String vecchioCodice = request.getParameter("vecchioCodice");
		String vecchioTitolo = request.getParameter("vecchioTitolo");

		//Modifica pacchetto
		//Cambia codice
		if(action.equalsIgnoreCase("cambiaCodice")) { 
			String nuovoCodice = request.getParameter("nuovoCodice");
			System.out.println(nuovoCodice);
			pacchetto.setCodicePacchetto(nuovoCodice);
			AmministratoreDao manager = new AmministratoreDao();
			manager.updateCode(vecchioCodice, nuovoCodice);		
			JSONResponse jsonResponse = new JSONResponse(true, "OK");
			out.print(gson.toJson(jsonResponse));
		}//Cambia titolo
		else if(action.equalsIgnoreCase("cambiaTitolo")){
			String nuovoTitolo = request.getParameter("nuovoTitolo");
			pacchetto.setTitolo(nuovoTitolo);
			AmministratoreDao manager = new AmministratoreDao();
			manager.updateTitle(vecchioCodice, nuovoTitolo);
			JSONResponse jsonResponse = new JSONResponse(true, "OK");
			out.print(gson.toJson(jsonResponse));
		}//Cambia prezzo
		else if(action.equalsIgnoreCase("cambiaPrezzo")){
			System.out.println(action);
			double nuovoPrezzo = Double.parseDouble(request.getParameter("nuovoPrezzo"));
			pacchetto.setPrezzo(nuovoPrezzo);
			System.out.println(nuovoPrezzo);
			AmministratoreDao manager = new AmministratoreDao();
			manager.updatePrice(vecchioCodice, nuovoPrezzo);
			JSONResponse jsonResponse = new JSONResponse(true, "OK");
			out.print(gson.toJson(jsonResponse));
		}//Cambia descrizione
		else if(action.equalsIgnoreCase("cambiaDescrizione")){
			String nuovaDescrizione = request.getParameter("nuovaDescrizione");
			pacchetto.setDescrizione(nuovaDescrizione);
			AmministratoreDao manager = new AmministratoreDao();
			manager.updateDescr(vecchioCodice, nuovaDescrizione);	
			JSONResponse jsonResponse = new JSONResponse(true, "OK");
			out.print(gson.toJson(jsonResponse));
		}//Rimuovi pacchetto
		else if(action.equalsIgnoreCase("rimuovi")) {
			if(vecchioCodice == null || vecchioCodice.length() == 0) {
				JSONResponse jsonResponse = new JSONResponse(false, NO_CODE);
				out.print(gson.toJson(jsonResponse));
				return;	
			}
			AmministratoreDao manager = new AmministratoreDao();
			manager.deletePacchetto(vecchioCodice);
			JSONResponse jsonResponse = new JSONResponse(true, "OK");
			out.print(gson.toJson(jsonResponse));
		}//Aggiungi pacchetto
		else if(action.equalsIgnoreCase("aggiungiPacchetto")) {
			String nuovoCodice = request.getParameter("nuovoCodice");
			String nuovaCategoria = request.getParameter("categoria");
			String nuovaSottocategoria = request.getParameter("sottocategoria");
			String nuovoTitolo = request.getParameter("titolo");
			String nuovaFoto =  request.getParameter("foto");
			double nuovoPrezzo = 0;
			try {
				nuovoPrezzo = Double.parseDouble(request.getParameter("prezzo"));
			}catch(NumberFormatException e){
				nuovoPrezzo = 0;
			}
			String nuovaDescrizione = request.getParameter("descrizione");
			
			if(nuovoCodice == null || nuovaCategoria == null || nuovoPrezzo == 0 || nuovaDescrizione == null || nuovoTitolo == null || nuovaFoto == null) {
				JSONResponse jsonResponse = new JSONResponse(false, NO_ARGUMENT);
				out.print(gson.toJson(jsonResponse));
				return;
			}
     
			AmministratoreDao manager = new AmministratoreDao();
			boolean res = manager.inserPacchetto(nuovoCodice, nuovaCategoria, nuovaSottocategoria, nuovoPrezzo, nuovaDescrizione, nuovoTitolo, nuovaFoto);
			if(res == false){
				JSONResponse jsonResponse = new JSONResponse(false);
				out.print(gson.toJson(jsonResponse));
				return;	
			}else {
				JSONResponse jsonResponse = new JSONResponse(true, COMPLETE);
				out.print(gson.toJson(jsonResponse));
			}	
		}//Aggiungi lezione
		else if(action.equalsIgnoreCase("aggiungiLezione")) {
			String url = request.getParameter("url");
			String titolo = request.getParameter("titolo");
			String durata = request.getParameter("durata");
			
			if(vecchioCodice == null || url == null || titolo == null || durata == null) {
				JSONResponse jsonResponse = new JSONResponse(false, NO_ARGUMENT);
				out.print(gson.toJson(jsonResponse));
				return;
			}
			
			AmministratoreDao manager = new AmministratoreDao();
			boolean res = manager.insertLesson(vecchioCodice, url, titolo, durata);
			
			if(res == false){
				JSONResponse jsonResponse = new JSONResponse(false, NO_INSERT);
				out.print(gson.toJson(jsonResponse));
				return;	
			}else {
				JSONResponse jsonResponse = new JSONResponse(true, "OK");
				out.print(gson.toJson(jsonResponse));		
			}	
		}//Cambia nome lezione
		else if(action.equalsIgnoreCase("modificaNomeLezione")){
			String nuovoNomeLezione = request.getParameter("nuovoNomeLezione");
			lezione.setTitolo(nuovoNomeLezione);
			AmministratoreDao manager = new AmministratoreDao();
			manager.updateTitleLesson(vecchioTitolo, nuovoNomeLezione);
			JSONResponse jsonResponse = new JSONResponse(true, "OK");
			out.print(gson.toJson(jsonResponse));
		}//Cambia url lezione
		else if(action.equalsIgnoreCase("modificaVideoLezione")){
			String nuovoUrlLezione = request.getParameter("nuovoUrlLezione");
			lezione.setUrl(nuovoUrlLezione);
			AmministratoreDao manager = new AmministratoreDao();
			manager.updateUrlLesson(vecchioTitolo, nuovoUrlLezione);
			JSONResponse jsonResponse = new JSONResponse(true, "OK");
			out.print(gson.toJson(jsonResponse));
		}//Cambia durata
		else if(action.equalsIgnoreCase("modificaDurataLezione")){
			String nuovaDurataLezione = request.getParameter("nuovaDurataLezione");
			lezione.setDurata(nuovaDurataLezione);
			AmministratoreDao manager = new AmministratoreDao();
			manager.updateDurationLesson(vecchioTitolo, nuovaDurataLezione);
			JSONResponse jsonResponse = new JSONResponse(true, "OK");
			out.print(gson.toJson(jsonResponse));
		}else if(action.equalsIgnoreCase("rimuoviLezione")){
			System.out.println("ciao sono in rimuovi");
			AmministratoreDao manager = new AmministratoreDao();
			manager.deleteLesson(vecchioTitolo);
			JSONResponse jsonResponse = new JSONResponse(true, "OK");
			out.print(gson.toJson(jsonResponse));		
		}
	}
	
	private static final String NO_INSERT = "Inserimento non riuscito!";
	private static final String COMPLETE = "Pacchetto inserito con successo!";
	private static final String NO_CODE = "Inserire codice per proseguire!";
	private static final String NO_ARGUMENT = "Tutti i parametri devono essere passati";
}