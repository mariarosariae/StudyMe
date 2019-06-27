package model.bean;

public class RecensioneBean {

	public RecensioneBean() {}
	
	public String getCliente() {
		return Cliente;
	}

	public String getPacchetto() {
		return Pacchetto;
	}

	public String getCommento() {
		return commento;
	}

	public String getIdRecensione() {
		return idRecensione;
	}

	public void setCliente(String cliente) {
		Cliente = cliente;
	}

	public void setPacchetto(String pacchetto) {
		Pacchetto = pacchetto;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public void setIdRecensione(String idRecensione) {
		this.idRecensione = idRecensione;
	}

	//VARIABILI D'ISTANZA
	private String Cliente, Pacchetto, commento, idRecensione;
}