package rs.ac.uns.ftn.db.jdbc.kucnibudzet.model;

import java.util.Date;

public class DvojnaTransakcija {
	
	private int idTransakcije; // is-a hijerarhija, nasledjen kljuc
	private int id;
	private String vrsta;
	private String status;
	public int idProvizije;
	
	public DvojnaTransakcija() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DvojnaTransakcija(int idTransakcije, int id, String vrsta, String status, int idProvizije) {
		super();
		this.idTransakcije = idTransakcije;
		this.id = id;
		this.vrsta = vrsta;
		this.status = status;
		this.idProvizije = idProvizije;
	}
	public int getIdProvizije() {
		return idProvizije;
	}
	public void setIdProvizije(int idProvizije) {
		this.idProvizije = idProvizije;
	}
	public int getIdTransakcije() {
		return idTransakcije;
	}
	public void setIdTransakcije(int idTransakcije) {
		this.idTransakcije = idTransakcije;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVrsta() {
		return vrsta;
	}
	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

}
