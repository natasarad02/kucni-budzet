package rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.kompleksanupit1;

public class StatistikaTransakcijaKategorijaDTO {
	
	    private int idRacuna;
	    private String nazivKategorije;
	    private Double prosecniIznos;

	    public StatistikaTransakcijaKategorijaDTO(int racunId, String nazivKategorije, Double prosecniIznos) {
	        this.idRacuna = racunId;
	        this.nazivKategorije = nazivKategorije;
	        this.prosecniIznos = prosecniIznos;
	    }

		public int getIdRacuna() {
			return idRacuna;
		}

		public void setIdRacuna(int idRacuna) {
			this.idRacuna = idRacuna;
		}

		public String getNazivKategorije() {
			return nazivKategorije;
		}

		public void setNazivKategorije(String nazivKategorije) {
			this.nazivKategorije = nazivKategorije;
		}

		public Double getProsecniIznos() {
			return prosecniIznos;
		}

		public void setProsecniIznos(Double prosecniIznos) {
			this.prosecniIznos = prosecniIznos;
		}
	    
	    

}
