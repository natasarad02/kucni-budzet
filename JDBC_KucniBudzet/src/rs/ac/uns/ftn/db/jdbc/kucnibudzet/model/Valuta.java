package rs.ac.uns.ftn.db.jdbc.kucnibudzet.model;

import java.util.Date;

public class Valuta {
	private int id;
	private String naziv;
	private String drzava;
	private String kod;
	
	
	public Valuta() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Valuta(int id, String naziv, String drzava, String kod) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.drzava = drzava;
		this.kod = kod;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getDrzava() {
		return drzava;
	}


	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}


	public String getKod() {
		return kod;
	}


	public void setKod(String kod) {
		this.kod = kod;
	}
	
	
	
	
	
	

}
