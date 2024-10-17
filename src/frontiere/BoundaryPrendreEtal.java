package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomConnu=controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomConnu){
			System.out.println("Je suis d�sol� "+ nomVendeur + " mais il faut �tre habitant de notre village pour commercer ici.\n");
		}
		else {
			System.out.println("Bonjour "+nomVendeur+ ", je vais voir si je peux vous trouver un etal.\n");
			boolean etaldisponible=controlPrendreEtal.resteEtals();
			if (!etaldisponible){
				System.out.println("D�sol� "+nomVendeur + " je n'ai plus d'�tal qui ne soit pas d�ja occup�.");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder question=new StringBuilder();
		question.append("C'est parfait il me reste un �tal pour vous ! \n");
		question.append("Il me faudrait quelques renseignements : \n");
		question.append("Quel produit souhaitez vous vendre ? \n");
		System.out.println(question.toString());
		String produit;
		produit=scan.nextLine();
		int nbProduits;
		System.out.println("Combien souhaitez vous en vendre ?\n");
		nbProduits=scan.nextInt();
		int numEtal;
		numEtal=controlPrendreEtal.prendreEtal(nomVendeur,produit,nbProduits);
		if (numEtal!=-1) {
			System.out.println("Le vendeur "+nomVendeur+ " s'est install� � l'�tal n�"+numEtal+"\n");	
		}
	}
}
