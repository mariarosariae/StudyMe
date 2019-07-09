package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DriverManagerConnectionPool;
import model.bean.AmministratoreBean;
import model.bean.PacchettoBean;
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
				user.setEmail(res.getString(3));
			}
			
			else
				return null;
					
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
	public AmministratoreBean loginAmministratore(String nomeUtente, String password) {
		AmministratoreBean amministratore = null;
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
	
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM amministratore WHERE nomeAmministratore = ? AND password = ?");
			stm.setString(1, nomeUtente);
			stm.setString(2, password);
			ResultSet res = stm.executeQuery();
			
			amministratore = new AmministratoreBean();
			
			//Se esiste l'amminitratore
			if(res.next()) {
				amministratore.setNomeAmministratore(res.getString(1));
				amministratore.setPassword(res.getString(2));
				amministratore.setEmail(res.getString(3));
			}	
			else
				return null;
					
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return amministratore;
	}
	
	public boolean registration(String email, String nomeUtente, String password){
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM cliente WHERE email = ? OR nomeUtente = ?");
			stm.setString(1, email);
			stm.setString(2, nomeUtente);
			ResultSet res = stm.executeQuery();
			if(!res.next()) {
				stm = conn.prepareStatement("INSERT INTO  cliente(nomeUtente, password, email) VALUES (?, ?, ?)");
				stm.setString(1, nomeUtente);
				stm.setString(2, password);
				stm.setString(3, email);
				stm.executeUpdate();	
				
				conn.commit();
			}else {
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();			
		}	
		return true;
	}
	
	public boolean updatePassword(String email, String password) {
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM cliente WHERE email = ?");
			stm.setString(1, email);
			ResultSet res = stm.executeQuery();
			if(res.next()) {
				stm = conn.prepareStatement("UPDATE cliente SET password = ? WHERE email = ?");
				stm.setString(1, password);
				stm.setString(2, email);
				stm.executeUpdate();
				
				conn.commit();
				return true;
			}			
			else
				return false;
		}catch (SQLException e) {
			e.printStackTrace();			
		}
		return false;
	}
	
	public boolean updateEmail(String email, String newEmail) {
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			
			PreparedStatement stm = conn.prepareStatement("SELECT * FROM cliente WHERE email = ?");
			stm.setString(1, email);
			
			ResultSet res = stm.executeQuery();
			if(res.next()) {
				stm = conn.prepareStatement("UPDATE cliente SET email = ? WHERE email = ?");
				stm.setString(1, newEmail);
				stm.setString(2, email);
				stm.executeUpdate();
				
				conn.commit();
				return true;
			}
				else
					return false;
			}catch (SQLException e) {
				e.printStackTrace();			
			}
			return false;
		}
}