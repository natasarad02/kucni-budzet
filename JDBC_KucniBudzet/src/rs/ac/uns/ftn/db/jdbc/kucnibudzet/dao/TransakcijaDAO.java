package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao;

import java.sql.SQLException;
import java.util.List;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Transakcija;



public interface TransakcijaDAO extends CRUDDao<Transakcija, Integer> {

	//metoda koja vraca najposecenije predstave (moze ih biti vise jednako posecenih zbog toga je lista, a ne jedna predstava)
	
}
