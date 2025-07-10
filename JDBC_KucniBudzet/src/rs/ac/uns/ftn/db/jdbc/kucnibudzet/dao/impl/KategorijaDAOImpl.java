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
		return null;
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
	public Kategorija getKategorijaByNaziv(String naziv) throws SQLException {
		// TODO Auto-generated method stub
		String query = "SELECT IDKAT, NAZKAT, TIPKAT FROM Kategorija WHERE NAZKAT = ?";
		
		 try(Connection connection = ConnectionUtil_HikariCP.getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(query);)
		 {
			 preparedStatement.setString(1, naziv);
			 try(ResultSet resultSet = preparedStatement.executeQuery())
			 {
				 if(resultSet.next())
				 {
					 return new Kategorija(resultSet.getInt("IDKAT"), resultSet.getString("NAZKAT"), resultSet.getString("TIPKAT"), -1, -1, -1);
				 }
			 }
		 }
		return null;
	}

	@Override
	public int insertKategorija(Kategorija kat) throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Kategorija (IDKAT, NAZKAT, TIPKAT) VALUES (KAT_SEQ.NEXTVAL, ?, ?)";
		
		 try(Connection connection = ConnectionUtil_HikariCP.getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(query);)
		 {
			 preparedStatement.setString(1, kat.getNaziv());
			 preparedStatement.setString(2, kat.getTipKat());
			
			 int rowsAffected = preparedStatement.executeUpdate();
			 return rowsAffected;
			 
			 
		 }
	}

	

}
