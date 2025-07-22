package rs.ac.uns.ftn.db.jdbc.kucnibudzet.service;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.RacunDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.TransakcijaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.RacunDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.TransakcijaDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Racun;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Transakcija;

public class RacunService {
	private static final RacunDAO racunDAO = new RacunDAOImpl();
	
	public List<Racun> getSviRacuni() throws SQLException
	{
		return racunDAO.getSviRacuni();
		
	}
}
