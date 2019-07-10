package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.entity.Plat;

public interface IPlatDao {

	void ajouterPlat(Plat plat);

	void deletePlatById(int id);

	void updatePlat(int id, Plat plat);

	Plat findPlatById(int id);

	List<Plat> findAllPlat();

}
