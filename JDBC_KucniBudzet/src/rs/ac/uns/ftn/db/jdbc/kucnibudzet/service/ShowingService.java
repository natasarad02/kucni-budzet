package rs.ac.uns.ftn.db.jdbc.kucnibudzet.service;

import java.sql.SQLException;
import java.util.ArrayList;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.ShowingDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.ShowingDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.complexquery2.PlayShowingsStatsDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.complexquery3.PlayStatsDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Showing;

public class ShowingService {
	private static final ShowingDAO showingDAO = new ShowingDAOImpl();

	public ArrayList<PlayStatsDTO> getBySceneId(int id) throws SQLException {
		return (ArrayList<PlayStatsDTO>) showingDAO.findBySceneId(id);
	}

	public ArrayList<Showing> getAll() throws SQLException {
		return (ArrayList<Showing>) showingDAO.findAll();
	}

	public ArrayList<Showing> getShowingsForPlay(Integer id) throws SQLException {
		return (ArrayList<Showing>) showingDAO.findShowingByPlayId(id);
	}

	public ArrayList<PlayShowingsStatsDTO> getSumAvgCountForShowing() throws SQLException {
		return (ArrayList<PlayShowingsStatsDTO>) showingDAO.findSumAvgCountForShowingPlays();
	}
}
