package rs.ac.uns.ftn.db.jdbc.kucnibudzet.service;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.TransakcijaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.TransakcijaDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.jednostavanupit.TransakcijaKategorijaDTO;

public class TransakcijaService {
	
	private static final TransakcijaDAO transakcijaDAO = new TransakcijaDAOImpl();
	
	public List<TransakcijaKategorijaDTO> racunajSumuPoKategoriji() throws SQLException
	{
		return transakcijaDAO.izracunajSumuPoKategoriji();
		
	}
}
