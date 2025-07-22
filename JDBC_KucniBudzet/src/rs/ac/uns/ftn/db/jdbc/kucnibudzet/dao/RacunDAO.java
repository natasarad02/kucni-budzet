package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Racun;


public interface RacunDAO extends CRUDDao<Racun, Integer> {

	public List<Racun> getSviRacuni() throws SQLException;

}
