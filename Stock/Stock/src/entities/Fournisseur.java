package entities;

public class Fournisseur {
	private int id;
	private String nom;
	private String telephone;
	private String email;
	private static int comp;

	public Fournisseur(String nom, String telephone, String email) {
		id = ++comp;
		this.nom = nom;
		this.telephone = telephone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Fournisseur : " + this.nom;
	}

	
}
