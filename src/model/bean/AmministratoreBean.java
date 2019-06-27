package model.bean;

public class AmministratoreBean {

	public AmministratoreBean() {}
	
	public String getNomeAmministratore() {
		return nomeAmministratore;
	}


	public String getPassword() {
		return password;
	}


	public String getConfPassword() {
		return confPassword;
	}


	public String getEmail() {
		return email;
	}

	public void setNomeAmministratore(String nomeAmministratore) {
		this.nomeAmministratore = nomeAmministratore;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfPassword(String confPassword) {
		this.confPassword = confPassword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//VARIABILI D'ISTANZA
	private String nomeAmministratore, password, confPassword, email;
}