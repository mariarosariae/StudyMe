package model.bean;

public class OrdineBean {

	public OrdineBean() {}
	
	public String getCliente() {
		return cliente;
	}
	
	public int getNumOrdine() {
		return numOrdine;
	}
	
	public String getData() {
		return data;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public void setData(String data) {
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

	//VARIABILI D'ISTANZA
	private String cliente;
	private int numOrdine;
	private String titoloPacchetto;
	private String data;
}