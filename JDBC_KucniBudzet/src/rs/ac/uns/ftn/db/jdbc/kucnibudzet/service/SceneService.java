package rs.ac.uns.ftn.db.jdbc.kucnibudzet.service;

import java.sql.SQLException;
import java.util.ArrayList;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.SceneDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.SceneDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Scene;

public class SceneService {
	private static final SceneDAO sceneDAO = new SceneDAOImpl();

	public ArrayList<Scene> getAll() throws SQLException {
		return (ArrayList<Scene>) sceneDAO.findAll();
	}

	public Scene getById(int id) throws SQLException {
		return sceneDAO.findById(id);
	}

	public ArrayList<Scene> getScenesByTheatre(int id) throws SQLException {
		return (ArrayList<Scene>) sceneDAO.findSceneByTheatre(id);
	}
}
