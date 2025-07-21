package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao;

import java.sql.SQLException;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.DvojnaTransakcija;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Transakcija;


public interface DvojnaTransakcijaDAO  extends CRUDDao<DvojnaTransakcija, Integer>{

	public void insertDvTransakcija(Transakcija tr) throws SQLException;
}
