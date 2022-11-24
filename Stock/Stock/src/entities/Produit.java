package entities;


public class Produit {
	
	private int id;
	private String designation;
	private double prixVente;
	private Rayon rayon;
	

	public Produit(int id, String designation, double prixAchat, Rayon rayon) {
		this.id = id;
		this.designation = designation;
		this.prixVente = prixAchat;
		this.rayon = rayon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}

	
	
	

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}

	@Override
	public String toString() {
		return "Produit : " + designation + " ( " + rayon + " ) ";
	}

}
