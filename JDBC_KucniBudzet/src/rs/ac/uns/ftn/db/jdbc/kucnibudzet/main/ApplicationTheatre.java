package rs.ac.uns.ftn.db.jdbc.kucnibudzet.main;

import rs.ac.uns.ftn.db.jdbc.kucnibudzet.connection.ConnectionUtil_HikariCP;
import rs.ac.uns.ftn.db.jdbc.kucnibudzet.ui_handler.MainUIHandler;

public class ApplicationTheatre {

	public static void main(String[] args) {

		// set application log level
		System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "WARN");

		MainUIHandler mainUIHandler = new MainUIHandler();
		try {
			mainUIHandler.handleMainMenu();
			ConnectionUtil_HikariCP.closeDataSource();
		} catch (Exception e) {
			ConnectionUtil_HikariCP.closeDataSource();
		}
	}

}
