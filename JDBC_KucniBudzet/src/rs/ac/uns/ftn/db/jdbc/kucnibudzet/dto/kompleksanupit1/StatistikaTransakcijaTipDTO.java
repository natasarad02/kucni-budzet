package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.kompleksanupit1;

public class StatistikaTransakcijaTipDTO {
	  private int idRacuna;
	    private String tipTransakcije;
	    private double ukupnaSuma;
	    private int brojTransakcija;

	    public StatistikaTransakcijaTipDTO(int idRacuna, String tipTransakcije, double ukupnaSuma, int brojTransakcija) {
	        this.idRacuna = idRacuna;
	        this.tipTransakcije = tipTransakcije;
	        this.ukupnaSuma = ukupnaSuma;
	        this.brojTransakcija = brojTransakcija;
	    }

		public int getIdRacuna() {
			return idRacuna;
		}

		public void setIdRacuna(int idRacuna) {
			this.idRacuna = idRacuna;
		}

		public String getTipTransakcije() {
			return tipTransakcije;
		}

		public void setTipTransakcije(String tipTransakcije) {
			this.tipTransakcije = tipTransakcije;
		}

		public double getUkupnaSuma() {
			return ukupnaSuma;
		}

		public void setUkupnaSuma(double ukupnaSuma) {
			this.ukupnaSuma = ukupnaSuma;
		}

		public int getBrojTransakcija() {
			return brojTransakcija;
		}

		public void setBrojTransakcija(int brojTransakcija) {
			this.brojTransakcija = brojTransakcija;
		}

}
