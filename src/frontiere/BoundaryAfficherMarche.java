package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
			int i=0;
			String[] etatMarche =controlAfficherMarche.donnerInfosMarche();
			if (etatMarche.length==0) {
				System.out.println("Le marché est vide, revenez plus tard/n");
			}
			else {
				System.out.println(nomAcheteur+ ", vous trouverez au marché :/n");
				while (i<etatMarche.length) {
				System.out.println("-"+ etatMarche[i]+ " qui vend " + etatMarche[i+1] + " "+ etatMarche[i+2]);
				i+=3;
				}
			}
	}
}
