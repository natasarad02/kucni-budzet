package rs.ac.uns.ftn.db.jdbc.kucnibudzet.ui_handler;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dao.TransakcijaDAO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.jednostavanupit.TransakcijaKategorijaDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Racun;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.model.Transakcija;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.service.ComplexFuncionalityService;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.service.RacunService;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.service.TransakcijaService;

public class MainUIHandler {

	public static Scanner sc = new Scanner(System.in);
	private static final TransakcijaService transakcijaService = new TransakcijaService();
	private static final RacunService racunService = new RacunService();
	private static final ComplexFuncionalityService complexService = new ComplexFuncionalityService();
	
	
	private final ComplexQueryUIHandler complexQueryUIHandler = new ComplexQueryUIHandler();

	public void handleMainMenu() throws SQLException {

		String answer;
		do {
			System.out.println("\nOdaberite opciju:");
			System.out.println("1 - Jednostavan upit - izracunaj sumu iznosa transakcija po kategorijama");
			System.out.println("2 - Kompleksan upit 1 - Prikaz ukupnog iznosa transakcije po tipu i racunu");
			System.out.println("3 - Kompleksan upit 2");
			System.out.println("4 - Dodavanje nove transakcije");
			System.out.println("X - Izlazak iz programa");

			answer = sc.nextLine();

			switch (answer) {
			case "1":
				prikazJednostavnogUpita();
				break;
			case "2":
				//sceneUIHandler.handleSceneMenu();
				prikazPrvogKompleksnogUpita();
				break;
			case "3":
				//complexQueryUIHandler.handleComplexQueryMenu();
				break;
			case "4":
				handleDodavanjeTransakcije();
				break;
			}

		} while (!answer.equalsIgnoreCase("X"));

		sc.close();
	}

	private void prikazPrvogKompleksnogUpita() throws SQLException {
		// TODO Auto-generated method stub
		complexService.prikaziUkupanIznosPoTipuTransakcije();
		
		
	}

	private void handleDodavanjeTransakcije() {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 
		 try {
	            System.out.print("Unesite iznos transakcije: ");
	            double iznos = Double.parseDouble(sc.nextLine());
	            double iznosOv = 2.0; //zakucana vrednost za sad
	            
	            System.out.print("Unesite opis: ");
	            String opis = sc.nextLine();
	            
	            System.out.print("Unesite tip transakcije: ");
	            String tip = sc.nextLine();


	            System.out.print("Unesite datum (YYYY-MM-DD): ");
	            String datumStr = sc.nextLine();
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            LocalDate datum = LocalDate.parse(datumStr, formatter);
	            LocalDateTime datumVreme = datum.atTime(LocalTime.now());
	            
	            System.out.print("Unesite kategoriju: ");
	            int idKategorije = Integer.parseInt(sc.nextLine());
	            
	         /*   System.out.print("Unesite racun: ");
	            int idRacuna = Integer.parseInt(sc.nextLine());
	            
	            System.out.print("Unesite tip racuna: ");
	            int idTipaRacuna = Integer.parseInt(sc.nextLine());
	            
	            System.out.print("Unesite valutu: ");
	            int idValute = Integer.parseInt(sc.nextLine());*/


	            // Radi lakseg testiranja, idRacuna, idValute i idTipaRacuna su zakucane vrednosti
	            Transakcija novaTransakcija = new Transakcija(0, opis, iznosOv, iznos, datumVreme, tip, 101, 1, 1, idKategorije);
	            transakcijaService.unesiTransakcijuSaKategorijom(novaTransakcija);

	          

	        } catch (Exception e) {
	            System.out.println("Greška pri unosu: " + e.getMessage());
	        }
	    }
		 
		
		
	

	private void prikazJednostavnogUpita() {
		
		try {
			for (TransakcijaKategorijaDTO tk : transakcijaService.racunajSumuPoKategoriji()) {
				System.out.println(tk.getNazivKat() + " -> " + tk.getUkupIznos());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// TODO Auto-generated method stub
		
	}

}
