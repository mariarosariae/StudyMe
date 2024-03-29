package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.DriverManagerConnectionPool;
import model.bean.CategoriaBean;
import model.bean.LezioniBean;
import model.bean.PacchettoBean;
import model.bean.RecensioneBean;

public class PacchettoDS implements Model_interface<PacchettoBean> {
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
	public synchronized void insert(PacchettoBean pacchetto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + TABLE_NAME
				+ " (codicePacchetto, categoria, idSott, prezzo,descrizione,titolo,foto) VALUES (?, ?, ?, ?,?,?,?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, pacchetto.getCodicePacchetto());
			preparedStatement.setString(2, pacchetto.getCatagoria());
			preparedStatement.setString(3, pacchetto.getSottocategoria());
			preparedStatement.setDouble(4, pacchetto.getPrezzo());
			preparedStatement.setString(5, pacchetto.getDescrizione());
			preparedStatement.setString(6, pacchetto.getTitolo());
			preparedStatement.setString(7, pacchetto.getFoto());
			

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
	public synchronized boolean remove(Object codiceP) throws SQLException {
		if(!(codiceP instanceof String))
			throw new IllegalArgumentException("La chiave primaria deve essere di tipo String");
		
		String key = (String) codiceP;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		int result = 0;

		String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE codicePacchetto = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, key);

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
	public synchronized PacchettoBean findByKey(Object codiceP) throws SQLException {
		if(!(codiceP instanceof String))
			throw new IllegalArgumentException("La chiave primaria deve essere di tipo String");
		
		String key = (String) codiceP;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		PacchettoBean pacchetto = new PacchettoBean();

		String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE codicePacchetto = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, key);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				pacchetto.setCodicePacchetto(rs.getString("codicePacchetto"));
				pacchetto.setCatagoria(rs.getString("categoria"));
				pacchetto.setSottocategoria(rs.getString("idSott"));
				pacchetto.setPrezzo(rs.getDouble("prezzo"));
				pacchetto.setDescrizione(rs.getString("descrizione"));
				pacchetto.setTitolo(rs.getString("titolo"));
				pacchetto.setFoto(rs.getString("foto"));

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

		String selectSQL = "SELECT * FROM " + TABLE_NAME;

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
				pa.setFoto(rs.getString("foto"));

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
		String updateSql = "UPDATE " + TABLE_NAME
				+ " SET categoria= ?, idSott= ? ,prezzo= ? , descrizione = ? , titolo=? ,foto=?  WHERE codicePacchetto = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(6, pacchetto.getCodicePacchetto());
			preparedStatement.setString(1, pacchetto.getCatagoria());
			preparedStatement.setString(2, pacchetto.getSottocategoria());
			preparedStatement.setDouble(3, pacchetto.getPrezzo());
			preparedStatement.setString(4, pacchetto.getDescrizione());
			preparedStatement.setString(5, pacchetto.getTitolo());
			preparedStatement.setString(7, pacchetto.getFoto());
			
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

	public PacchettoBean getPacchetto(String codicePacchetto) {
		try {
			Connection conn = DriverManagerConnectionPool.getConnection();

			String sql = "SELECT * " + "FROM pacchetto " + "WHERE codicePacchetto = ?";

			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, codicePacchetto);
			ResultSet res = stm.executeQuery();
			conn.commit();
			if (res.next()) {
				PacchettoBean pacchetto = new PacchettoBean();

				pacchetto.setCodicePacchetto(res.getString(1));
				pacchetto.setCatagoria(res.getString(2));
				pacchetto.setSottocategoria(res.getString(3));
				pacchetto.setPrezzo(res.getDouble(4));
				pacchetto.setDescrizione(res.getString(5));
				pacchetto.setTitolo(res.getString(6));
				pacchetto.setFoto(res.getString(7));

				return pacchetto;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<PacchettoBean> getCategoria(String categoria) {
		try {
			java.sql.Connection conn = DriverManagerConnectionPool.getConnection();

			String sql = "SELECT * " + "FROM pacchetto " + "WHERE categoria = ?";

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, categoria);
			ResultSet res = stm.executeQuery();
			conn.commit();

			ArrayList<PacchettoBean> pac = new ArrayList<PacchettoBean>();

			while (res.next()) {
				PacchettoBean pacchetto1 = new PacchettoBean();
				pacchetto1.setCodicePacchetto(res.getString(1));
				pacchetto1.setCatagoria(res.getString(2));
				pacchetto1.setSottocategoria(res.getString(3));
				pacchetto1.setPrezzo(res.getDouble(4));
				pacchetto1.setDescrizione(res.getString(5));
				pacchetto1.setTitolo(res.getString(6));
				pacchetto1.setFoto(res.getString(7));

				pac.add(pacchetto1);
			}
			return pac;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public Map<String,ArrayList<PacchettoBean>> getCategoriaRaggruppato(String categoria) {
		Map<String, ArrayList<PacchettoBean>> result = new HashMap<String, ArrayList<PacchettoBean>>();
		Map<String, String>  sottocategorie = new HashMap<String, String>();
		
		try {
			java.sql.Connection conn = DriverManagerConnectionPool.getConnection();

			String sql = "SELECT * " + "FROM pacchetto " + "WHERE categoria = ? AND nelCatalogo = ?";

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, categoria);
			stm.setBoolean(2, true);
			ResultSet res = stm.executeQuery();
			conn.commit();

			SottocategoriaManager manager = new SottocategoriaManager();
			
			while (res.next()) {
				PacchettoBean pacchetto1 = new PacchettoBean();
				pacchetto1.setCodicePacchetto(res.getString(1));
				pacchetto1.setCatagoria(res.getString(2));
				pacchetto1.setSottocategoria(res.getString(3));
				pacchetto1.setPrezzo(res.getDouble(4));
				pacchetto1.setDescrizione(res.getString(5));
				pacchetto1.setTitolo(res.getString(6));
				pacchetto1.setFoto(res.getString(7));

				String valueSottocategoria = null;
				
				//Se ho gi� estratto il valore della sottocategoria dal db lo vado a prendere dalla mappa
				//altrimenti lo vado dal db
				if(sottocategorie.containsKey(pacchetto1.getSottocategoria())) {
					valueSottocategoria = sottocategorie.get(pacchetto1.getSottocategoria());
				} else {
					valueSottocategoria = manager.findByKey(pacchetto1.getSottocategoria()).getNomeSott();
				}
				
				if(!result.containsKey(valueSottocategoria)) {
					result.put(valueSottocategoria, new ArrayList<PacchettoBean>());
				}
				
				result.get(valueSottocategoria).add(pacchetto1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return result;
	}

	
	public CategoriaBean getBeanCategoria(String categoria) {
		
		try {
			java.sql.Connection conn = DriverManagerConnectionPool.getConnection();

			String sql = "SELECT * " + "FROM categoria " + "WHERE nomeCategoria = ? ";

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1,categoria);
			ResultSet res = stm.executeQuery();
			conn.commit();
			
		if(res.next()) {
				CategoriaBean  cate = new CategoriaBean();
				cate.setFotoCategoria(res.getString(2));
					return cate;
		}else 
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<PacchettoBean> searchPackage(String word){
		try {
			java.sql.Connection conn = DriverManagerConnectionPool.getConnection();

			String sql = "SELECT * " + "FROM pacchetto " + "WHERE titolo like ?";

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, "%" + word + "%");
			ResultSet res = stm.executeQuery();
			conn.commit();

			ArrayList<PacchettoBean> pacchetti = new ArrayList<PacchettoBean>();

			while (res.next()) {
				PacchettoBean pacchetto = new PacchettoBean();
				pacchetto.setCodicePacchetto(res.getString(1));
				pacchetto.setCatagoria(res.getString(2));
				pacchetto.setSottocategoria(res.getString(3));
				pacchetto.setPrezzo(res.getDouble(4));
				pacchetto.setDescrizione(res.getString(5));
				pacchetto.setTitolo(res.getString(6));
				pacchetto.setFoto(res.getString(7));

				pacchetti.add(pacchetto);
			}
			return pacchetti;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<LezioniBean> getLezioni(String codicePacchetto){
		try {
			java.sql.Connection conn = DriverManagerConnectionPool.getConnection();

			String sql = "SELECT * " + "FROM lezioni " + "WHERE codiceP = ?";

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, codicePacchetto);
			ResultSet res = stm.executeQuery();
			conn.commit();

			ArrayList<LezioniBean> lezioni = new ArrayList<LezioniBean>();
			
			while (res.next()) {
				LezioniBean lezione = new LezioniBean();
				lezione.setUrl(res.getString(1));
				lezione.setTitolo(res.getString(2));
				lezione.setDurata(res.getString(3));
				lezione.setPacchetto(res.getString(4));

				lezioni.add(lezione);
			}
			return lezioni;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<RecensioneBean> getRecensioni(String codicePacchetto){
		try {
			java.sql.Connection conn = DriverManagerConnectionPool.getConnection();

			String sql = "SELECT * " + "FROM recensione " + "WHERE codiceP = ?";

			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1, codicePacchetto);
			ResultSet res = stm.executeQuery();
			conn.commit();

			ArrayList<RecensioneBean> recensioni = new ArrayList<RecensioneBean>();
			
			while (res.next()) {
				RecensioneBean recensione = new RecensioneBean();
				recensione.setIdRecensione(res.getString(1));
				recensione.setCliente(res.getString(2));
				recensione.setPacchetto(res.getString(3));
				recensione.setCommento(res.getString(4));
				recensione.setTitolo(res.getString(5));

				recensioni.add(recensione);
			}
			return recensioni;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}