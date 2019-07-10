package control;

import java.io.IOException;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DriverManagerConnectionPool;
import model.bean.AcquistoBean;
import model.bean.OrdineBean;
import model.bean.PacchettoBean;
import model.bean.UserBean;
import model.dao.AcquistoDao;
import model.dao.OrdineDao;
import model.dao.UserManager;

/**
 * Servlet implementation class CheckoutServelet
 */
@WebServlet("/AcquistoServlet")
public class AcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrdineDao ordineDao = new OrdineDao();
	private UserManager userDao = new UserManager();
	private AcquistoDao acq = new AcquistoDao();

	public AcquistoServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("User");
		ArrayList<PacchettoBean> carrello = (ArrayList<PacchettoBean>) session.getAttribute("carrello");
		OrdineBean ordine = new OrdineBean();

		String userName = user.getNomeUtente();

		GregorianCalendar gc = new GregorianCalendar();
		int ggoggi = gc.get(Calendar.DAY_OF_MONTH);
		int mmoggi = gc.get(Calendar.MONTH);
		int aaoggi = gc.get(Calendar.YEAR) - 1900;

		Date dataOdierna = new Date(aaoggi, mmoggi, ggoggi);

		for (PacchettoBean p : carrello) {
			ordine.setTitoloPacchetto(p.getTitolo());
		}

		ordine.setCliente(userName);
		ordine.setData(dataOdierna);

		ordineDao.insert(ordine);

		ArrayList<PacchettoBean> pacchetti = new ArrayList<PacchettoBean>();

		pacchetti = carrello;
		String codiceP;
		double prezzo = 0;
		String titoloPacchetto = "";
		int numOrdine = 0;

		for (int i = 0; i < pacchetti.size(); i++) {
			codiceP = pacchetti.get(i).getCodicePacchetto();
			titoloPacchetto = pacchetti.get(i).getTitolo();
			prezzo = pacchetti.get(i).getPrezzo();

			AcquistoBean acquisto = new AcquistoBean(numOrdine, codiceP, titoloPacchetto, prezzo);

			acq.insertAcquisto(acquisto);

		}
		carrello.clear();
		session.setAttribute("carrello", carrello);
		session.setAttribute("User", user);

	}

}
