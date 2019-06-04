package model.bean;

import java.sql.Time;

public class LezioniBean {

	public LezioniBean() {}

	public String getUrl() {
		return url;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public String getPacchetto() {
		return pacchetto;
	}
	
	public Time getDurata() {
		return durata;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setPacchetto(String pacchetto) {
		this.pacchetto = pacchetto;
	}

	public void setDurata(Time durata) {
		this.durata = durata;
	}

	//VARIABILI D'ISTANZA
	public String url, titolo, pacchetto;
	public Time durata;
}