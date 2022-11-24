package services;

import java.util.ArrayList;
import java.util.List;

import dao.IDao;
import entities.Client;
import entities.Demande;
import entities.LigneCommande;
import entities.LigneDemande;

public class DemandeService implements IDao<Demande>{

	private List<Demande> demandes;
	
	
	public DemandeService() {
		demandes = new ArrayList<Demande>();
	}

	@Override
	public boolean create(Demande o) {
		// TODO Auto-generated method stub
		return demandes.add(o);
	}

	@Override
	public boolean delete(Demande o) {
		// TODO Auto-generated method stub
		return demandes.remove(o);
	}

	@Override
	public boolean update(Demande o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Demande findById(int id) {
		for (Demande s : demandes)
			if (s.getId() == id)
				return s;
		return null;
	}

	@Override
	public List<Demande> findAll() {
		// TODO Auto-generated method stub
		return demandes;
	}
	
	public double getTotalPrix(int code) {
		double total = 0;
		for(LigneDemande lc : findById(code).getLignesDemandes()) {
			total += lc.getProduit().getPrixVente() * lc.getQte();
		}
		return total;
	}

}
