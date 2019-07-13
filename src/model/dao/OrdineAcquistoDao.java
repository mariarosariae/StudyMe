package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import model.DriverManagerConnectionPool;
import model.bean.OrdineAcquistoBean;
import model.bean.OrdineBean;
import model.bean.PacchettoBean;

public class OrdineAcquistoDao {

	public ArrayList<OrdineAcquistoBean> findByNomeCliente(Object nomeCliente) throws SQLException {
		if(!(nomeCliente instanceof String))
			throw new IllegalArgumentException("La chiave primaria deve essere di tipo String");
		
		String cliente = (String) nomeCliente;
		
		Connection conn = DriverManagerConnectionPool.getConnection();

		String sql = "SELECT * " + "FROM ordine " + "WHERE nomeCliente = ?";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, cliente);
		ResultSet res = stm.executeQuery();
		conn.commit();
		
		PacchettoDao pacchettoDao = new PacchettoDao();
		
		ArrayList<OrdineAcquistoBean> ordineCompleto = new ArrayList<OrdineAcquistoBean>();
		
		//Estraggo l'ordine
		while(res.next()) {
			OrdineAcquistoBean ordine= new OrdineAcquistoBean();
			ordine.setNumOrdine(res.getInt(1));
			ordine.setCliente(res.getString(2));
			ordine.setData(res.getDate(4));
			
			ArrayList<PacchettoBean> listaPacchetti = new ArrayList<PacchettoBean>();
			
			String sql1 = "SELECT * FROM acquisto WHERE numOrdine = ?";
			stm = conn.prepareStatement(sql1);
			stm.setInt(1, ordine.getNumOrdine());
			
			ResultSet ris1 = stm.executeQuery();
			
			//Estraggo i dettagli dell'ordine in base al numero d'ordine
			while(ris1.next()) {
				String codiceP = ris1.getString(2);
				
				PacchettoBean pacchetto = new PacchettoBean();
				
				pacchetto.setCodicePacchetto(codiceP);
				pacchetto.setTitolo(ris1.getString(3));
				pacchetto.setPrezzo(ris1.getDouble(4));
				
				PacchettoBean pacchettoCompleto = pacchettoDao.getPacchetto(codiceP);
				
				pacchetto.setDescrizione(pacchettoCompleto.getDescrizione());
				pacchetto.setFoto(pacchettoCompleto.getFoto());
				pacchetto.setCatagoria(pacchettoCompleto.getCatagoria());
				pacchetto.setSottocategoria(pacchettoCompleto.getSottocategoria());
				
				listaPacchetti.add(pacchetto);
			}
			
			ordine.setPacchettiAcquistati(listaPacchetti);
			
			ordineCompleto.add(ordine);
		}
		return ordineCompleto;
	}

}
