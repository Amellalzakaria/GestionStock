package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connexion.Connexion;
import dao.IDao;

import entities.Rayon;

public class RayonService implements IDao<Rayon>{
	
	
	public RayonService() {
		
	}

	@Override
	public boolean create(Rayon o) {
		try {
			String req = "insert into rayons values (null, ?)";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getCode());
			
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Rayon o) {
		try {
			String req = "delete from rayons where id  = ?";
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
	public boolean update(Rayon o) {
		try {
			String req = "update rayons set code = ? where id = ?";
			PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
			ps.setString(1, o.getCode());
			ps.setInt(2, o.getId());
			if (ps.executeUpdate() == 1)
				return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Rayon findById(int id) {
		try {
			String sql = "select * from rayons where id = ?";
			PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return new Rayon(rs.getInt("id"), rs.getString("code"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Rayon> findAll() {
		List<Rayon> rayons = new ArrayList<Rayon>();
		try {
			String sql = "select * from rayons";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next())
				rayons.add(new Rayon(rs.getInt("id"), rs.getString("code")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rayons;
	}
	

}
