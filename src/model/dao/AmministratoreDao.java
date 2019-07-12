package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DriverManagerConnectionPool;
import model.bean.LezioniBean;
import model.bean.OrdineBean;
import model.bean.PacchettoBean;

public class AmministratoreDao {

	public AmministratoreDao() {}
	
	public void inserPacchetto(String codicePacchetto, String categoria, String idsott, double prezzo, String descrizione,String titolo, String foto) {
		
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			
			PreparedStatement stm = conn.prepareStatement("INSERT into pacchetto(codicePacchetto,categoria,idSott,prezzo,descrizione,titolo,foto) VALUES (?,?,?,?,?,?,?)");
			
			stm.setString(1, codicePacchetto );
			stm.setString(2,categoria);
			stm.setString(3, idsott);
			stm.setDouble(4, prezzo);
			stm.setString(5,descrizione);
			stm.setString(6, titolo);
			stm.setString(7,foto);
			
			stm.executeUpdate();
			
			conn.commit();
		}catch (SQLException e) {
			e.printStackTrace();			
		}
		
	}
	
	public boolean deletePacchetto(String codicePacchetto) {
		
		try {
			Connection conn= DriverManagerConnectionPool.getConnection();
			
			PreparedStatement stm= conn.prepareStatement("SELECT * FROM pacchetto WHERE codicePacchetto = ? ");
			stm.setString(1,codicePacchetto);
			ResultSet res = stm.executeQuery();
			if(res.next()) {
				stm = conn.prepareStatement("DELETE FROM pacchetto WHERE codicePacchetto = ?");
				stm.setString(1, codicePacchetto);
				stm.execute();
				
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
	
	public boolean updatePacchetto(String codicePacchetto,double prezzo) {
		try {
			Connection conn= DriverManagerConnectionPool.getConnection();
			
			PreparedStatement stm= conn.prepareStatement("SELECT * FROM pacchetto WHERE codicePacchetto= ? ");
			stm.setString(1,codicePacchetto);
			ResultSet res = stm.executeQuery();
			if(res.next()) {
				stm = conn.prepareStatement("UPDATE pacchetto SET prezzo = ?  WHERE codicePacchetto= ? ");
				stm.setDouble(1, prezzo);
				stm.setString(2, codicePacchetto);
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
	
	public void insertLezione(String url, String titolo, String durata, String codiceP) {
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();
			
			PreparedStatement stm = conn.prepareStatement("INSERT into lezioni(url,titolo,durata, codiceP) VALUES (?,?,?,?)");
			
			stm.setString(1, url);
			stm.setString(2, titolo);
			stm.setString(3, durata);
			stm.setString(4, codiceP);
			
			stm.executeUpdate();
			
			conn.commit();
		}catch (SQLException e) {
			e.printStackTrace();			
		}
	}
	public boolean deleteLezione(String url) {
		
		try {
			Connection conn= DriverManagerConnectionPool.getConnection();
			
			PreparedStatement stm= conn.prepareStatement("SELECT * FROM lezioni WHERE url = ?");
			stm.setString(1,url);
			ResultSet res = stm.executeQuery();
			if(res.next()) {
				stm = conn.prepareStatement("DELETE FROM lezioni WHERE url = ?");
				stm.setString(1, url);
				stm.execute();
				
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
	
	public ArrayList<OrdineBean> getOrdine(String nomeCliente) {
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();

			String sql = "SELECT * " + "FROM ordine " + "WHERE nomeCliente = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, nomeCliente);
			ResultSet res = stm.executeQuery();
			conn.commit();
			
			ArrayList <OrdineBean> ordini= new ArrayList<OrdineBean>();
		
			
			
			return ordini;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	
	}
}