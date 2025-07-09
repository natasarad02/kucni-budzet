package rs.ac.uns.ftn.db.jdbc.kucnibudzet.model;

import java.time.LocalDateTime;

public class Provizija {
	
	private int id;
	private double iznos;
	private LocalDateTime datum;
	private String tip;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getIznos() {
		return iznos;
	}
	public void setIznos(double iznos) {
		this.iznos = iznos;
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
	public Provizija() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Provizija(int id, double iznos, LocalDateTime datum, String tip) {
		super();
		this.id = id;
		this.iznos = iznos;
		this.datum = datum;
		this.tip = tip;
	}
	
	

}
