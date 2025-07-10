package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Kategorija;


public interface KategorijaDAO extends CRUDDao<Kategorija, Integer> {

	
	public Kategorija getKategorijaByNaziv(String naziv) throws SQLException;
	public int insertKategorija(Kategorija kat) throws SQLException;
}
