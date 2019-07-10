package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DriverManagerConnectionPool;
import model.bean.OrdineBean;

public class OrdineDao {
	 public OrdineDao() {
		 
	 }
	 
	 
	 public void insert(OrdineBean ordine){
		 Connection conn;
		 try {
			 	conn = DriverManagerConnectionPool.getConnection();
				PreparedStatement stm = conn.prepareStatement("INSERT INTO ordine(numOrdine,nomeCliente,dataOdierna,) VALUES(?,?,?,?)");
				stm.setInt(1,ordine.getNumOrdine());
				stm.setString(2,ordine.getCliente());
				stm.setDate(4,ordine.getData());
				stm.setString(3,ordine.getTitoloPacchetto());
				
				
				stm.executeUpdate();
				conn.commit();
				
				
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
	 }
}
