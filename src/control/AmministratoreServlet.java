package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import model.dao.CategoriaManager;
import model.dao.PacchettoDao;
import model.dao.SottocategoriaManager;

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
		String action = request.getParameter("azione");
		
		if(action == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		String vecchioCodice = request.getParameter("vecchioCodice");
		String vecchioTitolo = request.getParameter("vecchioTitolo");

		//Modifica pacchetto
		//Cambia codice
		if(action.equalsIgnoreCase("cambiaCodice")) { 
			String nuovoCodice = request.getParameter("nuovoCodice");
			
			PacchettoDao pacchettoDao = new PacchettoDao();
			PacchettoBean pacchettoEsistente = pacchettoDao.getPacchetto(nuovoCodice);
			
			if(pacchettoEsistente != null) {
				JSONResponse jsonResponse = new JSONResponse(false, INVALID_CODE);
				out.print(gson.toJson(jsonResponse));
				return;
			}
			
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
			double nuovoPrezzo = 0;
			try {
				nuovoPrezzo = Double.parseDouble(request.getParameter("nuovoPrezzo"));
			} catch(NumberFormatException e) {
				JSONResponse jsonResponse = new JSONResponse(false, INVALID_PRICE);
				out.print(gson.toJson(jsonResponse));
				return;
			}
			pacchetto.setPrezzo(nuovoPrezzo);
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
			
			if(nuovoCodice == null || nuovaSottocategoria == null || nuovaCategoria == null || nuovoPrezzo == 0 || nuovaDescrizione == null || nuovoTitolo == null || nuovaFoto == null) {
				JSONResponse jsonResponse = new JSONResponse(false, NO_ARGUMENT);
				out.print(gson.toJson(jsonResponse));
				return;
			}
			
			CategoriaManager categoriaManager = new CategoriaManager();
			SottocategoriaManager sottoCategoriaManager = new SottocategoriaManager();
			
			//Controllo che i codici di categoria e sottocategoria siano validi
			try {
				Object categoria = categoriaManager.findByKey(nuovaCategoria);
				Object sottocategoria = sottoCategoriaManager.findByKey(nuovaSottocategoria);
				
				if(categoria == null) {
					JSONResponse jsonResponse = new JSONResponse(false, NO_CATEGORY);
					out.print(gson.toJson(jsonResponse));
					return;	
				}
				
				if(sottocategoria == null) {
					JSONResponse jsonResponse = new JSONResponse(false, NO_SOTTOCATEGORY);
					out.print(gson.toJson(jsonResponse));
					return;	
				}
			} catch (SQLException e) {
				JSONResponse jsonResponse = new JSONResponse(false, NO_INSERT);
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
			
			if(vecchioCodice == null || vecchioCodice.length() == 0 || url == null || url.length() == 0 || titolo == null || titolo.length() == 0 || durata == null || durata.length() == 0) {
				JSONResponse jsonResponse = new JSONResponse(false, NO_ARGUMENT);
				out.print(gson.toJson(jsonResponse));
				return;
			}
			
			Pattern pattern = Pattern.compile("https:\\/\\/www.youtube.com\\/embed\\/\\w+");
			Matcher matcher = pattern.matcher(url);
			
			if(!matcher.find()) {
				JSONResponse jsonResponse = new JSONResponse(false, NO_URL);
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
			
			Pattern pattern = Pattern.compile("https:\\/\\/www.youtube.com\\/embed\\/\\w+");
			Matcher matcher = pattern.matcher(nuovoUrlLezione);
			
			if(!matcher.find()) {
				JSONResponse jsonResponse = new JSONResponse(false, NO_URL);
				out.print(gson.toJson(jsonResponse));
				return;	
			}
						
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
			AmministratoreDao manager = new AmministratoreDao();
			manager.deleteLesson(vecchioTitolo);
			JSONResponse jsonResponse = new JSONResponse(true, "OK");
			out.print(gson.toJson(jsonResponse));		
		}
	}
	
	private static final String NO_URL = "Url non valido!";
	private static final String NO_INSERT = "Inserimento non riuscito!";
	private static final String COMPLETE = "Pacchetto inserito con successo!";
	private static final String INVALID_PRICE = "Prezzo non valido";
	private static final String INVALID_CODE = "Codice pacchetto gi&agrave; in uso";
	private static final String NO_CODE = "Inserire codice per proseguire!";
	private static final String NO_ARGUMENT = "Tutti i parametri devono essere passati";
	private static final String NO_CATEGORY = "Categoria non valida";
	private static final String NO_SOTTOCATEGORY = "Codice sottocategoria non valido";
}