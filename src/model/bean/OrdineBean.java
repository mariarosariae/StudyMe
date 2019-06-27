package model.bean;

import java.sql.Date;

public class OrdineBean {

	public OrdineBean() {}
	
	public String getCliente() {
		return cliente;
	}
	
	public int getNumFattura() {
		return numFattura;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public double getIva() {
		return iva;
	}
	
	public double getImponibile() {
		return imponibile;
	}
	
	public double getPrezzoTot() {
		return prezzoTot;
	}
	
	public Date getData() {
		return data;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setNumFattura(int numFattura) {
		this.numFattura = numFattura;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public void setImponibile(double imponibile) {
		this.imponibile = imponibile;
	}

	public void setPrezzoTot(double prezzoTot) {
		this.prezzoTot = prezzoTot;
	}

	public void setData(Date data) {
		this.data = data;
	}

	//VARIABILI D'ISTANZA
	private String cliente;
	private int numFattura, quantita;
	private double iva, imponibile, prezzoTot;
	private Date data;
}