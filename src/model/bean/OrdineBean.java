package model.bean;

import java.sql.Date;

public class OrdineBean {

	public OrdineBean() {}
	
	public String getCliente() {
		return cliente;
	}
	
	public int getNumOrdine() {
		return numOrdine;
	}
	
	public Date getData() {
		return data;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public void setData(Date data) {
		this.data = data;
	}

	
	public void setNumOrdine(int numOrdine) {
		this.numOrdine = numOrdine;
	}

	public String getTitoloPacchetto() {
		return titoloPacchetto;
	}

	public void setTitoloPacchetto(String titoloPacchetto) {
		this.titoloPacchetto = titoloPacchetto;
	}
	
	public String getCodiceP() {
		return codiceP;
	}

	public void setCodiceP(String codiceP) {
		this.codiceP = codiceP;
	}



	//VARIABILI D'ISTANZA
	private String cliente,codiceP;
	private int numOrdine;
	private String titoloPacchetto;
	private Date data;
}