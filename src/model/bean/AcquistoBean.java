package model.bean;

public class AcquistoBean {

	public AcquistoBean() {
	}
	
	public int getNumOrdine() {
		return numOrdine;
	}
	
	
	public double getImporto() {
		return importo;
	}


	public String getCodiceP() {
		return codiceP;
	}

	public void setCodiceP(String codiceP) {
		this.codiceP = codiceP;
	}

	public void setNumOrdine(int numOrdine) {
		this.numOrdine = numOrdine;
	}

	
	public void setImporto(double importo) {
		this.importo = importo;
	}
	
	

	public String getTitoloPacchetto() {
		return titoloPacchetto;
	}

	public void setTitoloPacchetto(String titoloPacchetto) {
		this.titoloPacchetto = titoloPacchetto;
	}
	
	//VARIABILI D'ISTANZA
	private int numOrdine;
	private String codiceP,titoloPacchetto;
	private double importo;
}