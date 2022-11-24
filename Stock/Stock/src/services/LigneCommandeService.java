package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.LigneCommande;

public class LigneCommandeService implements IDao<LigneCommande>{

	CommandeService cs;
	ProduitService pp;
	
	
	
	public LigneCommandeService() {
		cs = new CommandeService();
		pp = new ProduitService();
	}

	@Override
	public boolean create(LigneCommande o) {
		try {
			String req = "insert into lignesCommandes values (null, ?, ? , ?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getCommande().getId());
			ps.setInt(2, o.getProduit().getId());
			ps.setInt(3, o.getQuantite());
			
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(LigneCommande o) {
		try {
			String req = "delete from lignesCommandes where id  = ?";
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
	public boolean update(LigneCommande o) {
		try {
			String req = "update lignesCommandes set commande = ? , produit = ?, quantite = ? where id = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setInt(1, o.getCommande().getId());
			ps.setInt(2, o.getProduit().getId());
			ps.setInt(3, o.getQuantite());
			ps.setInt(4, o.getId());
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public LigneCommande findById(int id) {
		try {
			String sql = "select * from lignesCommandes where id = ?";
			PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return new LigneCommande(id, cs.findById(rs.getInt("commande")),
						pp.findById(rs.getInt("produit")), rs.getInt("quantite"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LigneCommande> findAll() {
		List<LigneCommande> lignesCommandes = new ArrayList<LigneCommande>();
		try {
			String sql = "select * from lignesCommandes";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
				lignesCommandes.add(new LigneCommande(rs.getInt("id"),
						cs.findById(rs.getInt("commande")), pp.findById(rs.getInt("produit")),
						rs.getInt("quantite")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lignesCommandes;
	}

}
