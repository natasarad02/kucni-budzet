package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.ValutaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Theatre;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Valuta;

public class ValutaDAOImpl implements ValutaDAO {

	@Override
	public int count() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Valuta entity) throws SQLException {
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
	public Iterable<Valuta> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Valuta> findAllById(Iterable<Integer> ids) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Valuta findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Valuta entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveAll(Iterable<Valuta> entities) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
