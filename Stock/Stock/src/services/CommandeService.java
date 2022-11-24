package services;

import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Commande;
import entities.LigneCommande;

public class CommandeService implements IDao<Commande> {

	
	ProduitService pp;
	ClientService cs;
	
	public CommandeService() {
		
		pp = new ProduitService();
		cs = new ClientService();
	}

	@Override
	public boolean create(Commande o) {
		try {
			String req = "insert into commandes values (null, ?, ? , ?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			//String req1 = "insert into lignesCommandes values (null, ?, ? , ?)";
			//PreparedStatement ps1 = Connexion.getConnection().prepareStatement(req1);
			ps.setString(1, o.getCode());
			ps.setDate(2, new Date(o.getDate().getTime()));
			ps.setInt(3, o.getClient().getId());
			/*
			for (LigneCommande l : o.getLigneCommandes()) {
				try {
					
					ps1.setInt(1, o.getId());
					ps1.setInt(2, l.getProduit().getId());
					ps1.setInt(3, l.getQuantite());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Commande o) {
		// TODO Auto-generated method stub
		try {
			String req = "delete from commandes where id  = ?";
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
	public boolean update(Commande o) {
		try {
			String req = "update commandes set code = ? , date = ?, client = ? where id = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			//String req1 = "update lignesCommandes set commande = ? , produit = ?, quantite = ? where commande = ?";
			//PreparedStatement ps1 = Connexion.getConnection().prepareStatement(req1);
			ps.setString(1, o.getCode());
			ps.setDate(2, new Date(o.getDate().getTime()));
			ps.setInt(3, o.getClient().getId());
			ps.setInt(4, o.getId());
			/*
			for (LigneCommande l : o.getLigneCommandes()) {
				try {
					
					ps1.setInt(1, o.getId());
					ps1.setInt(2, l.getProduit().getId());
					ps1.setInt(3, l.getQuantite());
					ps.setInt(4, o.getId());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Commande findById(int id) {
		try {
			String sql = "select * from commandes where id = ?";
			PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
			st.setInt(1, id);
			//String sql1 = "select * from lignesCommandes where commande = ?";
			//PreparedStatement st1 = Connexion.getConnection().prepareStatement(sql1);
			//st1.setInt(1, id);
			ResultSet rs = st.executeQuery();
			//ResultSet rs1 = st1.executeQuery();
			if(rs.next()) {
				//List<LigneCommande> lignesCommandes = new ArrayList<LigneCommande>();
				/*
				while(rs1.next()) {
					lignesCommandes.add(new LigneCommande(rs1.getInt("id"), findById(rs1.getInt("commande")),
							pp.findById(rs1.getInt("produit")), rs1.getInt("quantite"),
							pp.findById(rs1.getInt("produit")).getPrixVente()));
				}*/
				Commande c = new Commande(rs.getInt("id"), rs.getString("code"),
						rs.getDate("date"), cs.findById(rs.getInt("client")));
				//c.setLigneCommandes(lignesCommandes);
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Commande> findAll() {
		List<Commande> commandes = new ArrayList<Commande>();
		try {
			String sql = "select * from commandes";
			Statement st = Connexion.getConnection().createStatement();
			//String sql1 = "select * from lignesCommandes where commande = ?";
			//PreparedStatement st1 = Connexion.getConnection().prepareStatement(sql1);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				//List<LigneCommande> lignesCommandes = new ArrayList<LigneCommande>();
				//st1.setInt(1, rs.getInt("id"));
				//ResultSet rs1 = st.executeQuery(sql1);
				/*
				while(rs1.next()) {
					lignesCommandes.add(new LigneCommande(rs1.getInt("id"), findById(rs1.getInt("commande")),
							pp.findById(rs1.getInt("produit")), rs1.getInt("quantite"),
							pp.findById(rs1.getInt("produit")).getPrixVente()));
				}
				*/
				Commande c = new Commande(rs.getInt("id"), rs.getString("code"),
						rs.getDate("date"), cs.findById(rs.getInt("client")));
				//c.setLigneCommandes(lignesCommandes);
				commandes.add(c);
			}
			return commandes;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public double getTotalPrix(int id) {
		double total = 0;
		for(LigneCommande lc : findById(id).getLigneCommandes()) {
			total += lc.getProduit().getPrixVente() * lc.getQuantite();
		}
		return total;
	}
}
