package rs.ac.uns.ftn.db.jdbc.kucnibudzet.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.PlayDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.RoleDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.SceneDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.ShowingDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.TheatreDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.PlayDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.RoleDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.SceneDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.ShowingDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.TheatreDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.complexquery1.ScenesForTheatreDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.complexquery2.PlayShowingsStatsDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.complexquery2.ShowingsForPlayDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.complexquery3.PlayStatsDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.complexquery3.PlaysForSceneDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.complexquery4.PlayDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.complexquery5.ShowingDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Role;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Scene;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Theatre;

public class ComplexFuncionalityService {
	private static final TheatreDAO theatreDAO = new TheatreDAOImpl();
	private static final SceneDAO sceneDAO = new SceneDAOImpl();
	private static final ShowingDAO showingDAO = new ShowingDAOImpl();
	private static final PlayDAO playDAO = new PlayDAOImpl();
	private static final RoleDAO roleDAO = new RoleDAOImpl();
	
	//complex query 1
	public List<ScenesForTheatreDTO> getScenesForTheatres() throws SQLException{
		List<ScenesForTheatreDTO> ret = new ArrayList<ScenesForTheatreDTO>();
		for(Theatre t: theatreDAO.findAll()) {
			ScenesForTheatreDTO dto = new ScenesForTheatreDTO();
			dto.setTheatre(t);
			dto.setScenes(sceneDAO.findSceneByTheatre(t.getId()));
			ret.add(dto);
		}
		return ret;
	}
	
	//complex query 2
	public List<ShowingsForPlayDTO> getShowingsForPlays() throws SQLException{
		List<ShowingsForPlayDTO> ret = new ArrayList<ShowingsForPlayDTO>();
		for(PlayShowingsStatsDTO stats: showingDAO.findSumAvgCountForShowingPlays()) {
			ShowingsForPlayDTO dto = new ShowingsForPlayDTO();
			dto.setStats(stats);
			dto.setPlay(playDAO.findById(stats.getPlayId()));
			dto.setShowings(showingDAO.findShowingByPlayId(stats.getPlayId()));
			ret.add(dto);
		}
		return ret;
	}
	
	//complex query 3
	public List<PlaysForSceneDTO> getDataForComplexQuery() throws SQLException {
		ArrayList<PlaysForSceneDTO> result = new ArrayList<PlaysForSceneDTO>();

		for (Scene scene : sceneDAO.findSceneForSpecificNumberOfSeats()) {
			PlaysForSceneDTO dto = new PlaysForSceneDTO(scene);

			for (PlayStatsDTO sotDTO : showingDAO.findBySceneId(scene.getId())) {
				sotDTO.setTotalNumOfRoles(roleDAO.findCountByPlayId(sotDTO.getPlayId()));
				dto.addShowingOfPlay(sotDTO);
			}

			result.add(dto);
		}

		return result;
	}

	//complex query 4
	public List<PlayDTO> getMostVisitedPlays() throws SQLException {
		ArrayList<PlayDTO> result = new ArrayList<PlayDTO>();

		for (PlayDTO playDTO : playDAO.findMostVisitedPlays()) {
			PlayDTO pDTO = new PlayDTO(playDTO);

			for (Role role : roleDAO.findRoleByPlayId(playDTO.getId())) {
				pDTO.addRole(role);
			}

			pDTO.setNumOfMaleRoles(roleDAO.findCountForRoleGender(playDTO.getId(), "m"));
			pDTO.setNumOfFemaleRoles(roleDAO.findCountForRoleGender(playDTO.getId(), "z"));

			result.add(pDTO);
		}

		return result;
	}

	//complex query 5
	public List<ShowingDTO> deleteShowings() throws SQLException {
		return showingDAO.deleteAndInsertIntoShowing();
	}

}
