package rs.ac.uns.ftn.db.jdbc.kucnibudzet.ui_handler;

import java.sql.SQLException;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.dto.jednostavanupit.TransakcijaKategorijaDTO;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.service.TransakcijaService;

public class MainUIHandler {

	public static Scanner sc = new Scanner(System.in);
	private static final TransakcijaService transakcijaService = new TransakcijaService();
	
	
	private final ComplexQueryUIHandler complexQueryUIHandler = new ComplexQueryUIHandler();

	public void handleMainMenu() {

		String answer;
		do {
			System.out.println("\nOdaberite opciju:");
			System.out.println("1 - Jednostavan upit - izracunaj sumu iznosa transakcija po kategorijama");
			System.out.println("2 - Rukovanje scenama");
			System.out.println("3 - Kompleksni upiti");
			System.out.println("X - Izlazak iz programa");

			answer = sc.nextLine();

			switch (answer) {
			case "1":
				prikazJednostavnogUpita();
				break;
			case "2":
				//sceneUIHandler.handleSceneMenu();
				break;
			case "3":
				//complexQueryUIHandler.handleComplexQueryMenu();
				break;
			}

		} while (!answer.equalsIgnoreCase("X"));

		sc.close();
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
