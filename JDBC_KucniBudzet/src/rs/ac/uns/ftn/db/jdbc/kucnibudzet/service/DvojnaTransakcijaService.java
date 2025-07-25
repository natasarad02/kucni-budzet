package rs.ac.uns.ftn.db.jdbc.kucnibudzet.service;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.DvojnaTransakcijaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.TransakcijaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.DvojnaTransakcijaDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.TransakcijaDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.jednostavanupit.TransakcijaKategorijaDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.DvojnaTransakcija;

public class DvojnaTransakcijaService {
	private static final DvojnaTransakcijaDAO transakcijaDAO = new DvojnaTransakcijaDAOImpl();

	public void insertDvojnaTransakcija(DvojnaTransakcija tr) throws SQLException
	{
		transakcijaDAO.insertDvTransakcija(tr);;
		
	}
}
