package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.jednostavanupit;

public class TransakcijaKategorijaDTO {
	
	private String nazivKat;
	private double ukupIznos;
	public String getNazivKat() {
		return nazivKat;
	}
	public void setNazivKat(String nazivKat) {
		this.nazivKat = nazivKat;
	}
	public double getUkupIznos() {
		return ukupIznos;
	}
	public void setUkupIznos(double ukupIznos) {
		this.ukupIznos = ukupIznos;
	}
	public TransakcijaKategorijaDTO(String nazivKat, double ukupIznos) {
		
		this.nazivKat = nazivKat;
		this.ukupIznos = ukupIznos;
	}
	public TransakcijaKategorijaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
