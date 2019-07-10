package fr.diginamic.main;

import java.util.Scanner;

import fr.diginamic.dao.PlatDao;
import fr.diginamic.service.PlatService;
import fr.diginamic.utils.ConnectionManager;

public class Main {

	public static void main(String[] args) {

		try {
			Class.forName(ConnectionManager.getDriver());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);

		PlatService service = new PlatService();
		PlatDao dao = new PlatDao();

		service.afficherMenu();
		String choix = "";

		while (!choix.equals("99")) {
			choix = sc.next();

			switch (choix) {
			case "1":
				service.consulterPlat(sc, dao);
				service.afficherMenu();

				break;

			case "2":
				service.ajoutPlat(sc, dao);
				service.afficherMenu();

				break;
			case "3":
				service.modifPlat(sc, dao);
				service.afficherMenu();
				break;

			case "4":
				service.suppressionPlat(sc, dao);
				service.afficherMenu();
				break;
			default:
				service.afficherMenu();

				break;
			}
		}

	}

}
