package services;

import java.util.ArrayList;
import java.util.List;

import dao.IDao;
import entities.Client;
import entities.Fournisseur;

public class FournisseurService implements IDao<Fournisseur> {

	private List<Fournisseur> fournisseurs;
	
	

	public FournisseurService() {
		fournisseurs = new ArrayList<Fournisseur>();
	}

	@Override
	public boolean create(Fournisseur o) {
		// TODO Auto-generated method stub
		return fournisseurs.add(o);
	}

	@Override
	public boolean delete(Fournisseur o) {
		// TODO Auto-generated method stub
		return fournisseurs.remove(o);
	}

	@Override
	public boolean update(Fournisseur o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Fournisseur findById(int id) {
		for (Fournisseur s : fournisseurs)
			if (s.getId() == id)
				return s;
		return null;
	}

	@Override
	public List<Fournisseur> findAll() {
		// TODO Auto-generated method stub
		return fournisseurs;
	}

}
