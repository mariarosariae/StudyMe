package model.bean;

import java.util.ArrayList;

public class OrdineAcquistoBean extends OrdineBean {
	
	public OrdineAcquistoBean() {}
	
	
	public ArrayList<PacchettoBean> getPacchettiAcquistati() {
		return pacchettiAcquistati;
	}



	public void setPacchettiAcquistati(ArrayList<PacchettoBean> pacchettiAcquistati) {
		this.pacchettiAcquistati = pacchettiAcquistati;
	}


	private ArrayList<PacchettoBean> pacchettiAcquistati = new ArrayList<PacchettoBean>();
}
