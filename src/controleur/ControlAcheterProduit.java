package controleur;

import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,ControlTrouverEtalVendeur controlTrouverEtalVendeur,Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierIdentite(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	public String[] vendeursProduit(String nomProduit) {
		String[] vendeurs=new String[village.rechercherVendeursProduit(nomProduit).length];
		int i=0;
		while (i<village.rechercherVendeursProduit(nomProduit).length) {
			vendeurs[i]=village.rechercherVendeursProduit(nomProduit)[i].getNom();
			i++;
		}
		return vendeurs;
	}

	public int acheterProduit(String nomVendeur,int nbAchat) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(nbAchat);
	}
}
