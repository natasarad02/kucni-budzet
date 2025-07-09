package rs.ac.uns.ftn.db.jdbc.kucnibudzet.model;

public class TipRacuna {
	private int id;
	private String naziv;
	private String opis;
	private double minIznos;
	private double limit;
	
	public TipRacuna() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public double getMinIznos() {
		return minIznos;
	}

	public void setMinIznos(double min_iznos) {
		this.minIznos = min_iznos;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	

}
