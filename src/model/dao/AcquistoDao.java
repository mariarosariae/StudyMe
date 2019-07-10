package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DriverManagerConnectionPool;
import model.bean.AcquistoBean;

public class AcquistoDao {
	
	public AcquistoDao() {
		
	}
	
	
	public void insertAcquisto(AcquistoBean acquisto) {
		Connection conn;
		 try {
			 	conn = DriverManagerConnectionPool.getConnection();
				PreparedStatement stm = conn.prepareStatement("INSERT INTO acquisto(numOrdine,codiceP,titoloPacchetto,prezzo) values(?,?,?,?)");
				stm.setInt(1,acquisto.getNumOrdine());
				stm.setString(1, acquisto.getCodiceP());
				stm.setString(3,acquisto.getTitoloPacchetto());
				stm.setDouble(4,acquisto.getImporto());
				
				stm.executeUpdate();
				conn.commit();
				
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
	

	}
}
