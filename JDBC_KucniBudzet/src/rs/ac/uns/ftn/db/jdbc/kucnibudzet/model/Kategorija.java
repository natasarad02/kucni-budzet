package rs.ac.uns.ftn.db.jdbc.kucnibudzet.model;

public class Kategorija {
	
	private int id;
	private String naziv;
	private String tipKat;

	
	
	public Kategorija() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Kategorija(int id, String naziv, String tipKat) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.tipKat = tipKat;
	
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

	

}
