package entities;

public class LigneDemande {
	private Produit produit;
	private Demande demande;
	private int qte;

	public LigneDemande(Demande demande, Produit produit, int qte) {
		this.produit = produit;
		this.demande = demande;
		this.qte = qte;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	@Override
	public String toString() {
		String out = produit.getDesignation() + " ( " + produit.getRayon() + " ) ";
		return out + " Q : " + qte + " Prix : " + produit.getPrixVente();
	}

	
}
