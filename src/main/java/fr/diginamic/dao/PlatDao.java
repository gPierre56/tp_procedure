package fr.diginamic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.entity.Plat;
import fr.diginamic.utils.ConnectionManager;

public class PlatDao implements IPlatDao {

	public void ajouterPlat(Plat plat) {
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement(
					"insert into repas (repas.nom_plat, repas.prix_plat, repas.quantite_plat, repas.description_plat)\r\n"
							+ "values(?, ?, ?, ?);");
			statement.setString(1, plat.getNom());
			statement.setFloat(2, plat.getPrix());
			statement.setInt(3, plat.getQuantite());
			statement.setString(4, plat.getDescription());
			statement.executeUpdate();
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("modification du plat impossible");
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void deletePlatById(int id) {

		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement("DELETE from repas where id_plat = ?;");
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void updatePlat(int id, Plat plat) {
		Connection con = ConnectionManager.getInstance();
		try {
			PreparedStatement statement = con.prepareStatement(
					"update repas set nom_plat = ?, prix_plat = ?, quantite_plat = ?, description_plat = ? where id_plat = ?");
			statement.setString(1, plat.getNom());
			statement.setFloat(2, plat.getPrix());
			statement.setInt(3, plat.getQuantite());
			statement.setString(4, plat.getDescription());
			statement.setInt(5, id);
			statement.executeUpdate();
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public Plat findPlatById(int id) {
		Connection con = ConnectionManager.getInstance();
		Plat plat = new Plat();
		try {
			PreparedStatement statement = con.prepareStatement("select * from repas where id_plat = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				plat = new Plat(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5));

			}
			statement.close();
			return plat;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

	public List<Plat> findAllPlat() {
		Connection con = ConnectionManager.getInstance();
		List<Plat> listeRepas = new ArrayList<Plat>();
		try {
			PreparedStatement statement = con.prepareStatement("select * from repas");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Plat plat = new Plat(result.getInt(1), result.getString(2), result.getFloat(3), result.getInt(4),
						result.getString(5));
				listeRepas.add(plat);

			}
			statement.close();
			if (!listeRepas.isEmpty()) {
				return listeRepas;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

}
