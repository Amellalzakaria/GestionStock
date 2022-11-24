package services;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;
import entities.Client;


public class ClientService implements IDao<Client> {

	

	public ClientService() {
		
	}

	@Override
	public boolean create(Client o) {
		try {
			String req = "insert into clients values (null, ?, ? , ?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getTelephone());
			ps.setString(3, o.getEmail());
			
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Client o) {
		// TODO Auto-generated method stub
		try {
			String req = "delete from clients where id  = ?";
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
	public boolean update(Client o) {

		try {
			String req = "update clients set nom = ? , telephone = ?, email = ? where id = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getTelephone());
			ps.setString(3, o.getEmail());
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Client findById(int id) {
		try {
			String sql = "select * from clients where id = ?";
			PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return new Client(rs.getInt("id"), rs.getString("nom"),
						rs.getString("telephone"), rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Client> findAll() {
		List<Client> clients = new ArrayList<Client>();
		try {
			String sql = "select * from clients";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
				clients.add(new Client(rs.getInt("id"), rs.getString("nom"),
						rs.getString("telephone"), rs.getString("email")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clients;
	}

}
