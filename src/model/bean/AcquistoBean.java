package model.bean;

public class AcquistoBean {

	public AcquistoBean() {}
	
	public int getFattura() {
		return fattura;
	}
	
	public String getPacchetto() {
		return pacchetto;
	}
	
	public String getModalitaPagamento() {
		return modalitaPagamento;
	}
	
	public double getImporto() {
		return importo;
	}

	public String getIdAcquisto() {
		return idAcquisto;
	}

	public void setFattura(int fattura) {
		this.fattura = fattura;
	}

	public void setPacchetto(String pacchetto) {
		this.pacchetto = pacchetto;
	}

	public void setModalitaPagamento(String modalitaPagamento) {
		this.modalitaPagamento = modalitaPagamento;
	}


	public void setImporto(double importo) {
		this.importo = importo;
	}
	
	public void setIdAcquisto(String idAcquisto) {
		this.idAcquisto = idAcquisto;
	}

	//VARIABILI D'ISTANZA
	public int fattura;
	public String pacchetto, modalitaPagamento, idAcquisto;
	public double importo;
}