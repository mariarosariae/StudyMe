package model.bean;

public class UserBean {

	public UserBean() {}

	public String getNomeUtente() {
		return nomeUtente;
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

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
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
	private String nomeUtente, password, confPassword, email;
}