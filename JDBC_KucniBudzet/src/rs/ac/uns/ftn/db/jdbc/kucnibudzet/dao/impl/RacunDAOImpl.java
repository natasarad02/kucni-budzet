package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.RacunDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Racun;


public class RacunDAOImpl implements RacunDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Racun entity) throws SQLException {
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
	public Iterable<Racun> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Racun> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Racun findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Racun entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Racun> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}



}
