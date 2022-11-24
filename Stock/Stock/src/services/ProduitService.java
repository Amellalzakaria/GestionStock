package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Produit;

public class ProduitService implements IDao<Produit> {

	RayonService rr;

	public ProduitService() {
		rr = new RayonService();
	}

	@Override
	public boolean create(Produit o) {
		try {
			String req = "insert into produits values (null, ?, ?, ?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getDesignation());
			ps.setDouble(2, o.getPrixVente());
			ps.setInt(3, o.getRayon().getId());
			
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Produit o) {
		try {
			String req = "delete from produits where id  = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getId());
			if (ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Produit o) {
		try {
			String req = "update produits set designation = ? , prixVente = ?, rayon = ? where id = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getDesignation());
			ps.setDouble(2, o.getPrixVente());
			ps.setInt(3, o.getRayon().getId());
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Produit findById(int id) {
		try {
			String sql = "select * from produits where id = ?";
			PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return new Produit(id, rs.getString("designation"),
						rs.getDouble("prixVente"),
						rr.findById(rs.getInt("rayon")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> produits = new ArrayList<Produit>();
		try {
			String sql = "select * from produits";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
				produits.add(new Produit(rs.getInt("id"), rs.getString("designation"),
						rs.getDouble("prixVente"),
						rr.findById(rs.getInt("rayon"))));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produits;
	}

}
