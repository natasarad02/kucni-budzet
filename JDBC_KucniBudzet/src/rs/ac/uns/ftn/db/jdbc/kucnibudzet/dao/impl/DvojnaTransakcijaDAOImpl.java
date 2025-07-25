package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.DvojnaTransakcijaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.DvojnaTransakcija;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Transakcija;

public class DvojnaTransakcijaDAOImpl implements DvojnaTransakcijaDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(DvojnaTransakcija entity) throws SQLException {
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
	public Iterable<DvojnaTransakcija> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<DvojnaTransakcija> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DvojnaTransakcija findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(DvojnaTransakcija entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<DvojnaTransakcija> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertDvTransakcija(DvojnaTransakcija tr) throws SQLException {
		// TODO Auto-generated method stub
		
		
		 String getNextDvIdQuery = "SELECT COALESCE(MAX(IDDV), 0) + 1 AS NEXT_IDDV FROM DV_TRANS";
		 String insertQuery = "INSERT INTO Dv_trans (IDTR, IDDV, VRSTADV, STATUSDV, Provizija_IDPR) VALUES (?, ?, ?, ?, ?)";
		
		 try (Connection connection = ConnectionUtil_HikariCP.getConnection();
		     
		         PreparedStatement idStatement2 = connection.prepareStatement(getNextDvIdQuery);
			
				 ResultSet rs2 = idStatement2.executeQuery();) {

		    
		        int nextDvId = 1;
		    
		        if (rs2.next()) {
		            nextDvId = rs2.getInt("NEXT_IDDV");
		        }
		        
		        try(PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);)
		        {
		        	preparedStatement.setInt(1, tr.getIdTransakcije());
		        	preparedStatement.setInt(2, nextDvId);
		        	preparedStatement.setString(3,tr.getVrsta());
		        	preparedStatement.setString(4,tr.getStatus());
		        	preparedStatement.setInt(5, tr.getIdProvizije());
		        	
		        	
		        	preparedStatement.executeUpdate();
		        	
			 
			 
		 }
		 }
		
	}

}
