package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.dao.PlatDao;

public interface IPlatService {

	void afficherMenu();

	void ajoutPlat(Scanner sc, PlatDao dao);

	void modifPlat(Scanner sc, PlatDao dao);

	void suppressionPlat(Scanner sc, PlatDao dao);

	void consulterPlat(Scanner sc, PlatDao dao);

}
