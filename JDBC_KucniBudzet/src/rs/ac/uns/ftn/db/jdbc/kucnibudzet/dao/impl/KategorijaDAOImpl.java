package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.KategorijaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Kategorija;


public class KategorijaDAOImpl implements KategorijaDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Kategorija entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean existsById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Kategorija> findAll() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM KATEGORIJA";
	    List<Kategorija> rezultat = new ArrayList<>();
	    try (Connection conn = ConnectionUtil_HikariCP.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        while (rs.next()) {
	            Kategorija k = new Kategorija(
	                rs.getInt("IDKAT"),
	                rs.getString("NAZKAT"),
	                rs.getString("TIPKAT"),
	                rs.getInt("KATEGORIJA_IDKAT"),
	                rs.getInt("BUDZETSKI_PLAN_IDPL"),
	                rs.getInt("STEDNJA_IDST")
	            );
	            rezultat.add(k);
	        }
	    }
	    return rezultat;
	}

	@Override
	public Iterable<Kategorija> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Kategorija findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Kategorija entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Kategorija> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Kategorija getKategorijaById(int id) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT IDKAT, NAZKAT, TIPKAT, KATEGORIJA_IDKAT, BUDZETSKI_PLAN_IDPL, STEDNJA_IDST FROM Kategorija WHERE IDKAT = ?";
		
		 try(Connection connection = ConnectionUtil_HikariCP.getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(query);)
		 {
			 preparedStatement.setInt(1, id);
			 try(ResultSet resultSet = preparedStatement.executeQuery())
			 {
				 if(resultSet.next())
				 {
					 return new Kategorija(resultSet.getInt("IDKAT"), resultSet.getString("NAZKAT"), resultSet.getString("TIPKAT"), resultSet.getInt("KATEGORIJA_IDKAT"), resultSet.getInt("BUDZETSKI_PLAN_IDPL"), resultSet.getInt("STEDNJA_IDST"));
				 }
			 }
		 }
		return null;
	}

	@Override
	public int insertKategorija(Kategorija kat) throws SQLException {
		// TODO Auto-generated method stub
		 String getNextIdQuery = "SELECT COALESCE(MAX(IDKAT), 0) + 1 AS NEXT_ID FROM Kategorija";
		 String insertQuery = "INSERT INTO Kategorija (IDKAT, NAZKAT, TIPKAT, KATEGORIJA_IDKAT, BUDZETSKI_PLAN_IDPL, STEDNJA_IDST) VALUES (?, ?, ?, ?, ?, ?)";
		
		 try (Connection connection = ConnectionUtil_HikariCP.getConnection();
		         PreparedStatement idStatement = connection.prepareStatement(getNextIdQuery);
		         ResultSet rs = idStatement.executeQuery()) {

		        int nextId = 1; // fallback
		        if (rs.next()) {
		            nextId = rs.getInt("NEXT_ID");
		        }
		        
		        try(PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);)
		        {
		        	preparedStatement.setInt(1, nextId);
		        	preparedStatement.setString(2, kat.getNaziv());
		        	preparedStatement.setString(3, kat.getTipKat());
		        	preparedStatement.setInt(4, 1);
		        	preparedStatement.setNull(5, java.sql.Types.INTEGER);
		        	preparedStatement.setNull(6, java.sql.Types.INTEGER);
		        	preparedStatement.executeUpdate();
		        	return nextId;
			 
			 
		 }
		 }
	}

	

}
