package rs.ac.uns.ftn.db.jdbc.kucnibudzet.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.TheatreDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.TheatreDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Theatre;

public class TheatreService {
	private static final TheatreDAO theatreDAO = new TheatreDAOImpl();

	public ArrayList<Theatre> getAll() throws SQLException {
		return (ArrayList<Theatre>) theatreDAO.findAll();
	}

	public Theatre getById(int id) throws SQLException {
		return theatreDAO.findById(id);
	}

	public boolean existsById(int id) throws SQLException {
		return theatreDAO.existsById(id);
	}

	public boolean save(Theatre p) throws SQLException {
		return theatreDAO.save(p);
	}

	public boolean deleteById(int id) throws SQLException {
		return theatreDAO.deleteById(id);
	}

	public int saveAll(List<Theatre> pozoristeList) throws SQLException {
		return theatreDAO.saveAll(pozoristeList);
	}

}
