package model.bean;

import java.util.ArrayList;
import model.bean.PacchettoBean;

public class Carrello {
	 ArrayList<PacchettoBean> oggetti_carrello;
     
	    public Carrello() {
	            oggetti_carrello = new ArrayList<PacchettoBean>();
	    }
	         
	    @Override
		public String toString() {
			return "Carrello [oggetti_carrello=" + oggetti_carrello + "]";
		}

		public void aggiungi(PacchettoBean pacchetto) {
	            oggetti_carrello.add(pacchetto);
	    }
	    public void rimuovi(int i) {
	            oggetti_carrello.remove(i);
	    }   
	    public ArrayList<PacchettoBean> getOggettiCarrello() {
	            return oggetti_carrello;
	    }
	    public void rimuovitutto(){
	   // 	oggetti_carrello.removeAll(oggetti_carrello);
	    	oggetti_carrello.clear();
	    }
}
