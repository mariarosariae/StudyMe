package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import model.bean.PacchettoBean;

public class PacchettoDS implements  Model_interface <PacchettoBean> {
	private static DataSource ds;
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/studyme");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	private static final String TABLE_NAME = "pacchetto";
		@Override
		public synchronized void  insert(PacchettoBean pacchetto) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			String insertSQL = "INSERT INTO " + TABLE_NAME + 
					" (codicePacchetto, categoria, idSott, prezzo,descrizione,titolo) VALUES (?, ?, ?, ?,?,?)";


			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setString(1, pacchetto.getCodicePacchetto());
				preparedStatement.setString(2, pacchetto.getCatagoria());
				preparedStatement.setString(3, pacchetto.getSottocategoria());
				preparedStatement.setDouble(4, pacchetto.getPrezzo());
				preparedStatement.setString(5,pacchetto.getDescrizione());
				preparedStatement.setString(6,pacchetto.getTitolo());
		
				preparedStatement.executeUpdate();
				connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}



		@Override
		public synchronized boolean remove(String codiceP) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			int result = 0;

			String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE codicePacchetto = ?";

			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(deleteSQL);
				preparedStatement.setString(1, codiceP);

				result = preparedStatement.executeUpdate();

			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (connection != null)
						connection.close();
				}
			}
			return (result != 0);
		}

		@Override
		public synchronized PacchettoBean findByKey(String codiceP) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			PacchettoBean pacchetto = new PacchettoBean();

			String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE codicePacchetto = ?";

			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, codiceP);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					pacchetto.setCodicePacchetto(rs.getString("codicePacchetto"));
					pacchetto.setCatagoria(rs.getString("categoria"));
					pacchetto.setSottocategoria(rs.getString("idSott"));
					pacchetto.setPrezzo(rs.getDouble("prezzo"));
					pacchetto.setDescrizione(rs.getString("descrizione"));
					pacchetto.setTitolo(rs.getString("titolo"));
					
				}
				

			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (connection != null)
						connection.close();
				}
			}
			return pacchetto;
		}

		@Override
		public synchronized Collection<PacchettoBean> findAll() throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			Collection<PacchettoBean> pacchetto = new LinkedList<PacchettoBean>();
			
			
			String selectSQL = "SELECT * FROM " + TABLE_NAME ;
			
			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					PacchettoBean pa = new PacchettoBean();
					pa.setCodicePacchetto(rs.getString("codicePacchetto"));
					pa.setCatagoria(rs.getString("categoria"));
					pa.setSottocategoria(rs.getString("idSott"));
					pa.setPrezzo(rs.getDouble("prezzo"));
					pa.setDescrizione(rs.getString("descrizione"));
					pa.setTitolo(rs.getString("titolo"));
					
					pacchetto.add(pa);
				}
			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (connection != null)
						connection.close();
				}
			}
			Iterator<?> it = pacchetto.iterator();
			while (it.hasNext()) {
				PacchettoBean pacc = (PacchettoBean) it.next();
				
			}
			return pacchetto;
		}

			@Override
			public synchronized void update(PacchettoBean pacchetto) throws SQLException {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				String updateSql = "UPDATE " + TABLE_NAME + " SET categoria= ?, idSott= ? ,prezzo= ? , descrizione = ? , titolo=?  WHERE codicePacchetto = ? ";


				try {
					connection = ds.getConnection();
					preparedStatement = connection.prepareStatement(updateSql);
					preparedStatement.setString(6, pacchetto.getCodicePacchetto());
					preparedStatement.setString(1, pacchetto.getCatagoria());
					preparedStatement.setString(2, pacchetto.getSottocategoria());
					preparedStatement.setDouble(3,pacchetto.getPrezzo());
					preparedStatement.setString(4, pacchetto.getDescrizione());
					preparedStatement.setString(5, pacchetto.getTitolo());
					preparedStatement.executeUpdate();
					connection.commit();

				} finally {
					try {
						if (preparedStatement != null)
							preparedStatement.close();
					} finally {
						if (connection != null)
							connection.close();
					}
				}



			}
			
			
			
}
