package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demande {
	private int id;
	private Fournisseur fournisseur;
	private String date;
	private List<LigneDemande> lignesDemandes;
	private static int comp;

	public Demande(Fournisseur fournisseur, Date date) {
		this.fournisseur = fournisseur;
		SimpleDateFormat sf = new SimpleDateFormat("dd MM yyyy");
		this.date = sf.format(date);
		lignesDemandes = new ArrayList<LigneDemande>();
		id = ++comp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<LigneDemande> getLignesDemandes() {
		return lignesDemandes;
	}

	public void setLignesDemandes(List<LigneDemande> lignesDemandes) {
		this.lignesDemandes = lignesDemandes;
	}

	@Override
	public String toString() {
		return "Commande : " + id + " / " + date;
	}

}
