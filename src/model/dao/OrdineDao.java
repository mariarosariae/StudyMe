package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DriverManagerConnectionPool;
import model.bean.OrdineBean;

public class OrdineDao {
	 public OrdineDao() {
		 
	 }
	  
	 public int insert(OrdineBean ordine){
		 OrdineBean ord = null;
		 try {
			 	Connection conn = DriverManagerConnectionPool.getConnection();
				PreparedStatement stm = conn.prepareStatement("INSERT INTO ordine(nomeCliente,titoloPacchetto, dataOdierna) VALUES(?,?,?)");
				stm.setString(1,ordine.getCliente());
				stm.setString(2,ordine.getTitoloPacchetto());
				stm.setString(3,ordine.getData());
				stm.executeUpdate();
				
				ord = new OrdineBean();
				stm = conn.prepareStatement("SELECT numOrdine FROM ordine WHERE titoloPacchetto = ?");
				stm.setString(1,ordine.getTitoloPacchetto());
				ResultSet res = stm.executeQuery();
				
				if(res.next()) {
					ord.setNumOrdine(res.getInt(1));
				}
				
				int numOrdine = res.getInt(1);
				
				conn.commit();	
				return numOrdine;
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
	 }
}
