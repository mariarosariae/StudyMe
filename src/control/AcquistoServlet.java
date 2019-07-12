package control;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.AcquistoBean;
import model.bean.OrdineBean;
import model.bean.PacchettoBean;
import model.bean.UserBean;
import model.dao.AcquistoDao;
import model.dao.OrdineDao;

/**
 * Servlet implementation class CheckoutServelet
 */
@WebServlet("/AcquistoServlet")
public class AcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AcquistoServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("User");
		
		@SuppressWarnings("unchecked")
		ArrayList<PacchettoBean> carrello = (ArrayList<PacchettoBean>) session.getAttribute("carrello");
		
		OrdineBean ordineBean = new OrdineBean();
		AcquistoBean acquistoBean = new AcquistoBean();
		OrdineDao ordine = new OrdineDao();
		AcquistoDao acquisto = new AcquistoDao();
		String userName = user.getNomeUtente();

		GregorianCalendar gc = new GregorianCalendar();
		int ggoggi = gc.get(Calendar.DAY_OF_MONTH);
		int mmoggi = gc.get(Calendar.MONTH) + 1;
		int aaoggi = gc.get(Calendar.YEAR);

		String dataOdierna = aaoggi + "-" + mmoggi + "-" + ggoggi;

		int numOrd = 0;
		
		ordineBean.setCliente(userName);
		ordineBean.setData(Date.valueOf(dataOdierna));

		numOrd = ordine.insert(ordineBean);
		
		for (PacchettoBean p : carrello) {
			String codiceP = p.getCodicePacchetto();
			String titoloPacchetto = p.getTitolo();
			double prezzo = p.getPrezzo();

			acquistoBean.setNumOrdine(numOrd);
			acquistoBean.setCodiceP(codiceP);
			acquistoBean.setTitoloPacchetto(titoloPacchetto);
			acquistoBean.setImporto(prezzo);
			acquisto.insertAcquisto(acquistoBean);
		}
		
		carrello.clear();
		session.setAttribute("carrello", carrello);
	}
}