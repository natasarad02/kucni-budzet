package rs.ac.uns.ftn.db.jdbc.kucnibudzet.model;

import java.time.LocalDateTime;

public class Transakcija {
	
	private int id;
	private String opis;
	private double iznosOsnovnaValuta;
	private double iznosTransakcije;
	private LocalDateTime datum;
	private String tip;
	private int idRacuna;
	private int idTipaRacuna;
	private int idValute;
	private int idKategorije;
	public Transakcija() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public double getIznosOsnovnaValuta() {
		return iznosOsnovnaValuta;
	}
	public void setIznosOsnovnaValuta(double iznosOsnovnaValuta) {
		this.iznosOsnovnaValuta = iznosOsnovnaValuta;
	}
	public double getIznosTransakcije() {
		return iznosTransakcije;
	}
	public void setIznosTransakcije(double iznosTransakcije) {
		this.iznosTransakcije = iznosTransakcije;
	}
	public LocalDateTime getDatum() {
		return datum;
	}
	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public int getIdRacuna() {
		return idRacuna;
	}
	public void setIdRacuna(int idRacuna) {
		this.idRacuna = idRacuna;
	}
	public int getIdTipaRacuna() {
		return idTipaRacuna;
	}
	public void setIdTipaRacuna(int idTipaRacuna) {
		this.idTipaRacuna = idTipaRacuna;
	}
	public int getIdValute() {
		return idValute;
	}
	public void setIdValute(int idValute) {
		this.idValute = idValute;
	}
	public int getIdKategorije() {
		return idKategorije;
	}
	public void setIdKategorije(int idKategorije) {
		this.idKategorije = idKategorije;
	}
	public Transakcija(int id, String opis, double iznosOsnovnaValuta, double iznosTransakcije, LocalDateTime datum,
			String tip, int idRacuna, int idTipaRacuna, int idValute, int idKategorije) {
		super();
		this.id = id;
		this.opis = opis;
		this.iznosOsnovnaValuta = iznosOsnovnaValuta;
		this.iznosTransakcije = iznosTransakcije;
		this.datum = datum;
		this.tip = tip;
		this.idRacuna = idRacuna;
		this.idTipaRacuna = idTipaRacuna;
		this.idValute = idValute;
		this.idKategorije = idKategorije;
	}
	
	
	
	

}
