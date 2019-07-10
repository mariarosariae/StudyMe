package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DriverManagerConnectionPool;
import model.bean.AcquistoBean;
import model.bean.OrdineBean;

public class AcquistoDao {
	
	public AcquistoDao() {
		
	}
	
	public void insertAcquisto(int numOrd, String codiceP, String titoloPacchetto, Double prezzo) {
		 try {
			 	Connection conn = DriverManagerConnectionPool.getConnection();
				PreparedStatement stm = conn.prepareStatement("INSERT INTO acquisto(numOrdine, codiceP,titoloPacchetto,prezzo) values(?,?,?,?)");
				stm.setInt(1, numOrd);
				stm.setString(2,codiceP);
				stm.setString(3, titoloPacchetto);
				stm.setDouble(4, prezzo);
				
				stm.executeUpdate();
				conn.commit();		
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
	}
}
