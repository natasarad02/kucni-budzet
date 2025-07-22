package rs.ac.uns.ftn.db.jdbc.kucnibudzet.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.KategorijaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.RacunDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.TransakcijaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.KategorijaDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.RacunDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.impl.TransakcijaDAOImpl;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.kompleksanupit1.StatistikaTransakcijaTipDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Racun;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Transakcija;



public class ComplexFuncionalityService {
	private static final TransakcijaDAO transakcijaDAO = new TransakcijaDAOImpl();
	private static final KategorijaDAO kategorijaDAO = new KategorijaDAOImpl();
	private static final RacunDAO racunDAO = new RacunDAOImpl();
	
	
	public void prikaziUkupanIznosPoTipuTransakcije() throws SQLException{
		List<StatistikaTransakcijaTipDTO> rezultat = new ArrayList<>();
		
		List<Racun> racuni = racunDAO.getSviRacuni();
		
		for(Racun racun : racuni)
		{
			List<Transakcija> transakcije = transakcijaDAO.getTransakcijeZaRacun(racun.getId());
			List<String> tipovi = new ArrayList<>();
			for (Transakcija t : transakcije) {
			    String tip = t.getTip();
			    if (!tipovi.contains(tip)) {
			        tipovi.add(tip);
			    }
			} // dobija se ["Dv_trans", "Pon_trans"]
			
			for (String tip : tipovi) {
			    double suma = 0;
			    int broj = 0;

			    for (Transakcija t : transakcije) {
			        if (t.getTip().equals(tip)) {
			            suma += t.getIznosOsnovnaValuta();
			            broj++;
			        }
			    }

			   rezultat.add(new StatistikaTransakcijaTipDTO(racun.getId(), tip, suma, broj));
			
			   
			   Collections.sort(rezultat, new Comparator<StatistikaTransakcijaTipDTO>() {
				    @Override
				    public int compare(StatistikaTransakcijaTipDTO o1, StatistikaTransakcijaTipDTO o2) {
				        return Double.compare(o1.getUkupnaSuma(), o2.getUkupnaSuma()); // sortiranje po sumi opadajuće
				    }
				});


			}
	}
		
		for(StatistikaTransakcijaTipDTO dto : rezultat)
		{
			 System.out.printf("Račun ID: %d | Tip: %s | Ukupno: %.2f | Broj: %d%n",
			            dto.getIdRacuna(), dto.getTipTransakcije(), dto.getUkupnaSuma(), dto.getBrojTransakcija());
		}
	}
	
	
	
}
