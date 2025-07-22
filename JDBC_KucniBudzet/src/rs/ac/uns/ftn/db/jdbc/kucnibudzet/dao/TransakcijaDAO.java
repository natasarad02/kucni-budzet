package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.jednostavanupit.TransakcijaKategorijaDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Kategorija;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Transakcija;



public interface TransakcijaDAO extends CRUDDao<Transakcija, Integer> {

	//metoda koja vraca najposecenije predstave (moze ih biti vise jednako posecenih zbog toga je lista, a ne jedna predstava)
	public List<TransakcijaKategorijaDTO> izracunajSumuPoKategoriji() throws SQLException;
	public void insertTransakcija(Transakcija tr) throws SQLException;
	public Kategorija getKategorijaZaTransakciju(int idTransakcije) throws SQLException;
	public List<Transakcija> getTransakcijeZaRacun(int idRac) throws SQLException;
}
