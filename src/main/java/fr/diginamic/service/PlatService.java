package fr.diginamic.service;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.dao.PlatDao;
import fr.diginamic.entity.Plat;

public class PlatService implements IPlatService {

	public void afficherMenu() {
		System.out.println("***** Menu principal *****");
		System.out.println("1 - Afficher la liste des plats");
		System.out.println("2 - Ajouter un plat ");
		System.out.println("3 - Modifier un plat ");
		System.out.println("4 - Suprimer un plat ");
		System.out.println("99 - Quitter ");

	}

	public void ajoutPlat(Scanner sc, PlatDao dao) {
		Plat plat = new Plat();
		System.out.println("Veuillez renseignez le nom du plat à ajouter");
		String nom = sc.next();
		System.out.println("Veuillez renseigner son prix");
		String prixString = sc.next();
		Float prix = Float.parseFloat(prixString);
		System.out.println("Indiquez la quantité en stock");
		String quantiteString = sc.next();
		int quantite = Integer.parseInt(quantiteString);
		System.out.println("Entrez une breve description du plat");
		String description = sc.next();
		plat.setNom(nom);
		plat.setPrix(prix);
		plat.setQuantite(quantite);
		plat.setDescription(description);
		dao.ajouterPlat(plat);
		System.out.println("Plat ajouté.");

	}

	public void modifPlat(Scanner sc, PlatDao dao) {

		System.out.println("Entrez le numéro du plat à modifier");
		String num = sc.next();

		int numeroPlat = Integer.parseInt(num);

		if (dao.findPlatById(numeroPlat) != null) {
			Plat plat = new Plat();
			System.out.println("Entrez le nouveau nom");
			String nom = sc.next();
			plat.setNom(nom);
			System.out.println("Entrez le prix");
			String prixString = sc.next();
			float prix = Float.parseFloat(prixString);
			plat.setPrix(prix);
			System.out.println("Quelle quantité ?");
			String quantiteString = sc.next();
			int quantite = Integer.parseInt(quantiteString);
			plat.setQuantite(quantite);
			System.out.println("Veuillez entrez la nouvelle description");
			String description = sc.next();
			plat.setDescription(description);
			dao.updatePlat(numeroPlat, plat);
		}

	}

	public void suppressionPlat(Scanner sc, PlatDao dao) {
		System.out.println("Veuillez renseigner le numéro du plat à supprimer");
		String id = sc.next();
		if (dao.findPlatById(Integer.parseInt(id)) == null) {
			System.out.println("Ce plat n'existe pas.");
		} else {
			dao.deletePlatById(Integer.parseInt(id));
			System.out.println("Suppression effectuée.");
		}

	}

	public void consulterPlat(Scanner sc, PlatDao dao) {
		System.out.println("Affichage de la liste des plats disponibles : ");
		List<Plat> listePlat = dao.findAllPlat();
		if (listePlat == null || listePlat.isEmpty()) {
			System.out.println("Aucun plat n'est enregistré");
		} else {
			for (int i = 0; i < listePlat.size(); i++) {
				System.out.println(listePlat.get(i).toString());
			}
		}

	}

}
