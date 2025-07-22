package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.KategorijaDAO;
//import rs.ac.uns.ftn.db.jdbc.kucnibudzet.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.TransakcijaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.jednostavanupit.TransakcijaKategorijaDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Kategorija;
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

	@Override
	public void insertTransakcija(Transakcija tr) throws SQLException {
	    String getMaxIdSql = "SELECT COALESCE(MAX(IDTR), 0) + 1 FROM Transakcija";
	    String insertSql = "INSERT INTO Transakcija (IDTR, OPISTR, IZNOV, DATTR, IZNTR, TIPTR, Kategorija_IDKAT, Racun_IDRAC, Racun_Tip_racuna_IDTIP, Racun_Valuta_IDVAL) " +
	                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection conn = ConnectionUtil_HikariCP.getConnection();
	         PreparedStatement getMaxIdStmt = conn.prepareStatement(getMaxIdSql);
	         ResultSet rs = getMaxIdStmt.executeQuery()) {

	        int nextId = 1;
	        if (rs.next()) {
	            nextId = rs.getInt(1);
	        }

	        try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
	            ps.setInt(1, nextId);
	            ps.setString(2, tr.getOpis());
	            ps.setDouble(3, tr.getIznosOsnovnaValuta());
	            ps.setTimestamp(4, java.sql.Timestamp.valueOf(tr.getDatum()));
	            ps.setDouble(5, tr.getIznosTransakcije());
	            ps.setString(6, tr.getTip());
	            ps.setInt(7, tr.getIdKategorije());
	            ps.setInt(8, tr.getIdRacuna());
	            ps.setInt(9, tr.getIdTipaRacuna());
	            ps.setInt(10, tr.getIdValute());

	            ps.executeUpdate();
	        }
	    }
	}

	@Override
	public Kategorija getKategorijaZaTransakciju(int idTransakcije) throws SQLException {
		String query = "SELECT k.IDKAT, k.NAZKAT, k.TIPKAT, k.KATEGORIJA_IDKAT, k.BUDZETSKI_PLAN_IDPL, k.STEDNJA_IDST " +
                "FROM Kategorija k " +
                "JOIN Transakcija t ON k.IDKAT = t.KATEGORIJA_IDKAT " +
                "WHERE t.IDTR = ?";
		
		 try (Connection connection = ConnectionUtil_HikariCP.getConnection();
		         PreparedStatement ps = connection.prepareStatement(query)) {

		        ps.setInt(1, idTransakcije);

		        try (ResultSet rs = ps.executeQuery()) {
		            if (rs.next()) {
		                return new Kategorija(
		                    rs.getInt("IDKAT"),
		                    rs.getString("NAZKAT"),
		                    rs.getString("TIPKAT"),
		                    rs.getInt("KATEGORIJA_IDKAT"),
		                    rs.getInt("BUDZETSKI_PLAN_IDPL"),
		                    rs.getInt("STEDNJA_IDST")
		                );
		            }
		        }
		    }
		return null;
	}

	@Override
	public List<Transakcija> getTransakcijeZaRacun(int idRac) throws SQLException {
		// TODO Auto-generated method stub
		 String sql = "SELECT * FROM TRANSAKCIJA WHERE RACUN_IDRAC = ?";
		    List<Transakcija> rezultat = new ArrayList<>();
		    try (Connection conn = ConnectionUtil_HikariCP.getConnection();
		         PreparedStatement ps = conn.prepareStatement(sql)) {
		        ps.setInt(1, idRac);
		        try (ResultSet rs = ps.executeQuery()) {
		            while (rs.next()) {
		                Transakcija tr = new Transakcija(
		                		rs.getInt("IDTR"),
		                		rs.getString("OPISTR"),
		                		rs.getDouble("IZNOV"),
		                		rs.getDouble("IZNTR"),
		                		rs.getTimestamp("DATTR").toLocalDateTime(),
		                		rs.getString("TIPTR"),
		                		rs.getInt("RACUN_IDRAC"),
		                		rs.getInt("RACUN_TIP_RACUNA_IDTIP"),
		                		rs.getInt("RACUN_VALUTA_IDVAL"),
		                		rs.getInt("KATEGORIJA_IDKAT")
		                		);
		              
		                // postavi druge ako treba
		                rezultat.add(tr);
		            }
		        }
		    }
		    return rezultat;
	}

	@Override
	public List<Transakcija> getTransakcijeZaRacunIKategoriju(int idRacuna, int idKategorije) throws SQLException {
		// TODO Auto-generated method stub
		 List<Transakcija> rezultat = new ArrayList<>();
		    String query = "SELECT * FROM Transakcija WHERE RACUN_IDRAC = ? AND KATEGORIJA_IDKAT = ?";

		    try (Connection con = ConnectionUtil_HikariCP.getConnection();
		         PreparedStatement ps = con.prepareStatement(query)) {

		        ps.setInt(1, idRacuna);
		        ps.setInt(2, idKategorije);

		        try (ResultSet rs = ps.executeQuery()) {
		            while (rs.next()) {
		            	Transakcija tr = new Transakcija(
		                		rs.getInt("IDTR"),
		                		rs.getString("OPISTR"),
		                		rs.getDouble("IZNOV"),
		                		rs.getDouble("IZNTR"),
		                		rs.getTimestamp("DATTR").toLocalDateTime(),
		                		rs.getString("TIPTR"),
		                		rs.getInt("RACUN_IDRAC"),
		                		rs.getInt("RACUN_TIP_RACUNA_IDTIP"),
		                		rs.getInt("RACUN_VALUTA_IDVAL"),
		                		rs.getInt("KATEGORIJA_IDKAT")
		                		);
		              
		                // postavi druge ako treba
		                rezultat.add(tr);
		            }
		        }
		    }
		    return rezultat;
	}

	

	
}
