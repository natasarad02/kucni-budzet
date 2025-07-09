package rs.ac.uns.ftn.db.jdbc.kucnibudzet.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Racun {
	private int id;
	private String naziv;
	private double stanje;
	private LocalDateTime datumOtvaranja;
	private LocalDateTime datumZatvaranja;
	private int idTipaRacuna;
	private int idValute;
	
	public Racun() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Racun(int id, String naziv, double stanje, LocalDateTime datumOtvaranja, LocalDateTime datumZatvaranja,
			int idTipaRacuna, int idValute) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.stanje = stanje;
		this.datumOtvaranja = datumOtvaranja;
		this.datumZatvaranja = datumZatvaranja;
		this.idTipaRacuna = idTipaRacuna;
		this.idValute = idValute;
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

	public double getStanje() {
		return stanje;
	}

	public void setStanje(double stanje) {
		this.stanje = stanje;
	}

	public LocalDateTime getDatumOtvaranja() {
		return datumOtvaranja;
	}

	public void setDatumOtvaranja(LocalDateTime datumOtvaranja) {
		this.datumOtvaranja = datumOtvaranja;
	}

	public LocalDateTime getDatumZatvaranja() {
		return datumZatvaranja;
	}

	public void setDatumZatvaranja(LocalDateTime datumZatvaranja) {
		this.datumZatvaranja = datumZatvaranja;
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
	
	
	
}
