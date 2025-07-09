package rs.ac.uns.ftn.db.jdbc.kucnibudzet.model;

public class Kategorija {
	
	private int id;
	private String naziv;
	private String tipKat;
	private int idKat; // ukoliko je potkategorija
	private int idPlana;
	private int idStednje;
	
	
	public Kategorija() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Kategorija(int id, String naziv, String tipKat, int idKat, int idPlana, int idStednje) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.tipKat = tipKat;
		this.idKat = idKat;
		this.idPlana = idPlana;
		this.idStednje = idStednje;
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
	public String getTipKat() {
		return tipKat;
	}
	public void setTipKat(String tipKat) {
		this.tipKat = tipKat;
	}
	public int getIdKat() {
		return idKat;
	}
	public void setIdKat(int idKat) {
		this.idKat = idKat;
	}
	public int getIdPlana() {
		return idPlana;
	}
	public void setIdPlana(int idPlana) {
		this.idPlana = idPlana;
	}
	public int getIdStednje() {
		return idStednje;
	}
	public void setIdStednje(int idStednje) {
		this.idStednje = idStednje;
	}
	
	

}
