package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DriverManagerConnectionPool;
import model.bean.UserBean;

public class UserManager {

	public UserManager() {}

	public UserBean login(String nomeUtente, String password) {
		UserBean user = null;
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
	
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM cliente WHERE nomeUtente = ? AND password = ?");
			stm.setString(1, nomeUtente);
			stm.setString(2, password);
			ResultSet res = stm.executeQuery();
			
			user = new UserBean();
			
			//Se esiste l'utente
			if(res.next()) {
				user.setNomeUtente(res.getString(1));
				user.setPassword(res.getString(2));
			}
			
			else
				return null;
					
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
	public void registration(String email, String nomeUtente, String password){
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			
			PreparedStatement stm = conn.prepareStatement("INSERT INTO  cliente(nomeUtente, password, email) VALUES (?, ?, ?)");
			stm.setString(1, nomeUtente);
			stm.setString(2, password);
			stm.setString(3, email);
			stm.executeUpdate();	
			
			conn.commit();
		}catch (SQLException e) {
			e.printStackTrace();			
		}			
	}
}