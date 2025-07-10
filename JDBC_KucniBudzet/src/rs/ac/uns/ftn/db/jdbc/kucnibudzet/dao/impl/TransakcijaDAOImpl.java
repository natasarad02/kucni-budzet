package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.connection.ConnectionUtil_HikariCP;
//import rs.ac.uns.ftn.db.jdbc.kucnibudzet.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.TransakcijaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.jednostavanupit.TransakcijaKategorijaDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Transakcija;


public class TransakcijaDAOImpl implements TransakcijaDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Transakcija entity) throws SQLException {
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
	public Iterable<Transakcija> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Transakcija> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transakcija findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Transakcija entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Transakcija> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TransakcijaKategorijaDTO> izracunajSumuPoKategoriji() throws SQLException {
		// TODO Auto-generated method stub
		
		List<TransakcijaKategorijaDTO> rezultat = new ArrayList<>();
		
		 String query = "SELECT k.NAZKAT, SUM(t.IZNOV) AS ukupno " +
                 "FROM Transakcija t " +
                 "JOIN Kategorija k ON t.Kategorija_IDKAT = k.IDKAT " +
                 "GROUP BY k.NAZKAT";
		 
		 try(Connection connection = ConnectionUtil_HikariCP.getConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(query);
				 ResultSet resultSet = preparedStatement.executeQuery())
		 {
			 while(resultSet.next())
			 {
				 String naziv = resultSet.getString("NAZKAT");
		         Double ukupno = resultSet.getDouble("ukupno");

		         rezultat.add(new TransakcijaKategorijaDTO(naziv, ukupno));
			 }
		 }
		return rezultat;
	}

	

	
}
