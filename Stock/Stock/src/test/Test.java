package test;



import entities.Client;
import entities.Commande;
import entities.LigneCommande;
import entities.Rayon;
import services.ClientService;
import services.CommandeService;
import services.LigneCommandeService;
import services.ProduitService;
import services.RayonService;

public class Test {

	public static void main(String[] args) {
		
		RayonService rs = new RayonService();
		
		
		rs.create(new Rayon(1, "R1"));
		rs.create(new Rayon(2, "R2"));
		
		ProduitService ps = new ProduitService();
		
		/*
		ps.create(new Produit(1, "P1", 10, rs.findById(11)));
		ps.create(new Produit(2, "P2", 20, rs.findById(12)));
		*/
		
		
		
		ClientService cs = new ClientService();
		
		/*
		cs.create(new Client(3, "Malkova", "+351484621", "malkova@mail.com"));
		cs.create(new Client(4, "Katherine", "+458412351", "katherine@mail.com"));
		*/
		
		CommandeService cc = new CommandeService();
		
		//cc.create(new Commande(1, "C1", new Date(), cs.findById(3)));
		
		LigneCommandeService ls = new LigneCommandeService();
		
		/*
		ls.create(new LigneCommande(1, cc.findById(2), ps.findById(3), 2));
		ls.create(new LigneCommande(2, cc.findById(2), ps.findById(4), 10));
		*/
		
		for(Client c : cs.findAll()) {
			double total = 0;
			System.out.println(c);
			for (Commande cmd : cc.findAll()) {
				if (cmd.getClient().getId() == c.getId()) {
					System.out.println("\t" + cmd);
					for (LigneCommande lcs : ls.findAll()) {
						if(lcs.getCommande().getId() == cmd.getId()) {
							System.out.println("\t - " + lcs);
							total += lcs.getQuantite() * lcs.getProduit().getPrixVente();
						}
							
					}
						
					System.out.println("### Total : " + total);

				}
			}
		}
		/*
		lignesCommandes.add(new LigneCommande(1, , null, 0, 0));
		*/
		/*
		cc.create(new Commande(1, "C1", new Date(), cs.findById(3)));
		cc.create(new Commande(2, "C2", new Date(), cs.findById(4)));
		*/
		/*
		
		*/
		
		//rs.update(new Rayon(1, "R5"));
		
		
		/*
		ClientService cs = new ClientService();
		cs.create(new Client("Rami", "0254879555", "rami@gmail.com"));
		cs.create(new Client("Safi", "0865784554", "safi@gmail.com"));

		RayonService rs = new RayonService();
		rs.create(new Rayon("R1"));
		rs.create(new Rayon("R2"));
		rs.create(new Rayon("R3"));

		ProduitService ps = new ProduitService();
		ps.create(new Produit("P21", 20));
		ps.create(new Produit("P55", 60));
		ps.create(new Produit("P27", 220));
		ps.create(new Produit("P28", 29));

		// adding rayons to products
		ps.findById(1).getRayons().add(rs.findById(1));
		ps.findById(1).getRayons().add(rs.findById(2));
		ps.findById(2).getRayons().add(rs.findById(2));
		ps.findById(3).getRayons().add(rs.findById(3));
		ps.findById(4).getRayons().add(rs.findById(3));

		CommandeService cms = new CommandeService();
		cms.create(new Commande(101, new Date(), cs.findById(1)));
		cms.findById(101).getLigneCommandes().add(new LigneCommande(cms.findById(101), ps.findById(1), 2, 22));
		cms.findById(101).getLigneCommandes().add(new LigneCommande(cms.findById(101), ps.findById(2), 10, 70));

		cms.create(new Commande(103, new Date(), cs.findById(1)));
		cms.findById(103).getLigneCommandes().add(new LigneCommande(cms.findById(103), ps.findById(3), 2, 25));
		cms.findById(103).getLigneCommandes().add(new LigneCommande(cms.findById(103), ps.findById(2), 9, 74));

		cms.create(new Commande(102, new Date(), cs.findById(2)));

		cms.findById(102).getLigneCommandes().add(new LigneCommande(cms.findById(102), ps.findById(3), 21, 226));
		cms.findById(102).getLigneCommandes().add(new LigneCommande(cms.findById(102), ps.findById(4), 3, 70));

		FournisseurService fs = new FournisseurService();

		fs.create(new Fournisseur("F1", "+21263211524", "F1@gmail.com"));
		fs.create(new Fournisseur("F2", "+21263211524", "F2@gmail.com"));

		DemandeService ds = new DemandeService();

		ds.create(new Demande(fs.findById(1), new Date()));
		ds.create(new Demande(fs.findById(2), new Date()));

		ds.findById(1).getLignesDemandes().add(new LigneDemande(ds.findById(1), ps.findById(1), 12));
		ds.findById(2).getLignesDemandes().add(new LigneDemande(ds.findById(2), ps.findById(1), 5));
		ds.findById(2).getLignesDemandes().add(new LigneDemande(ds.findById(2), ps.findById(2), 25));

		for (Client c : cs.findAll()) {
			System.out.println(c);
			for (Commande cmd : cms.findAll()) {
				if (cmd.getClient().getId() == c.getId()) {
					System.out.println("\t" + cmd);
					for (LigneCommande lcs : cmd.getLigneCommandes())
						System.out.println("\t - " + lcs);
					System.out.println("### Total : " + cms.getTotalPrix(cmd.getCode()));

				}
			}
		}
		
		System.out.println();
		System.out.println("#####################################");
		System.out.println();

		for (Fournisseur f : fs.findAll()) {
			System.out.println(f);
			for (Demande d : ds.findAll()) {
				if (d.getFournisseur().getId() == f.getId()) {
					System.out.println("\t" + d);
					for (LigneDemande ld : d.getLignesDemandes())
						System.out.println("\t - " + ld);
					System.out.println("### Total : " + ds.getTotalPrix(d.getId()));
				}
			}
		}
		
		*/

	}

}
