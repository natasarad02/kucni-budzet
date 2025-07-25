package rs.ac.uns.ftn.db.jdbc.kucnibudzet.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.KategorijaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.TransakcijaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.KategorijaDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.TransakcijaDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.jednostavanupit.TransakcijaKategorijaDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Kategorija;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Transakcija;

public class TransakcijaService {
	
	private static final TransakcijaDAO transakcijaDAO = new TransakcijaDAOImpl();
	private static final KategorijaDAO kategorijaDAO = new KategorijaDAOImpl();
	
	public List<TransakcijaKategorijaDTO> racunajSumuPoKategoriji() throws SQLException
	{
		return transakcijaDAO.izracunajSumuPoKategoriji();
		
	}
	
	// metoda napravljena zbog debugginga
	public List<Transakcija> getSveTransakcijeZaRacun101() throws SQLException
	{
		return transakcijaDAO.getTransakcijeZaRacun(101);
		
	}
	
	public int unesiTransakcijuSaKategorijom(Transakcija tr)
	{
		Connection conn = null;
		try {
			 conn = ConnectionUtil_HikariCP.getConnection();
			 conn.setAutoCommit(false);
			 
			 
			 Kategorija kat = kategorijaDAO.getKategorijaById(tr.getIdKategorije());
			// System.out.println("uslo");
			 if(kat == null)
			 {
				 Scanner sc = new Scanner(System.in);
				 System.out.print("Unesite naziv kategorije: ");
		          String kategorija = sc.nextLine();
		            
		          System.out.print("Unesite tip kategorije (prihod/rashod): ");
		          String tip = sc.nextLine();
				 
		          Kategorija novaKategorija = new Kategorija(-1, kategorija, tip, -1, -1, -1);
				 int katId = kategorijaDAO.insertKategorija(novaKategorija);
				 tr.setIdKategorije(katId);
				// System.out.println(katId);
			 }
			 else
			 {
				 
				
				// System.out.println("uslo2");
			 }
			 
			 int idTr = transakcijaDAO.insertTransakcija(tr);
			 
			 conn.commit();
			 System.out.println("Uspesno dodata transakcija");
			 return idTr;
		
		} catch (SQLException e) {
		        if (conn != null) {
		            try {
		                conn.rollback();
		                
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		            }
		        }
		        e.printStackTrace();
		    } finally {
		        if (conn != null) try { conn.setAutoCommit(true); conn.close();  } catch (SQLException e) { }
		    }
		return 0;
	}
}
