package entities;

public class LigneCommande {
	
	private int id;
	private Commande commande;
	private Produit produit;
	private int quantite;
	

	public LigneCommande(int id, Commande commande, Produit produit, int quantite) {
		this.id = id;
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
		
	}

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	

	@Override
	public String toString() {
		String out = produit.getDesignation() + " ( " + produit.getRayon() + " ) ";
		return out + " Q : " + quantite + " Prix : " + produit.getPrixVente();
	}

}
