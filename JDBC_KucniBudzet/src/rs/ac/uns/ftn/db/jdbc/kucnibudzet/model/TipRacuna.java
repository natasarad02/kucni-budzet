package rs.ac.uns.ftn.db.jdbc.kucnibudzet.model;

public class TipRacuna {
	private int id;
	private String naziv;
	private String opis;
	private double min_iznos;
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

	public double getMin_iznos() {
		return min_iznos;
	}

	public void setMin_iznos(double min_iznos) {
		this.min_iznos = min_iznos;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	

}
