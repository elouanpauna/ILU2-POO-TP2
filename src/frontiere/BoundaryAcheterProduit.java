package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée "+ nomAcheteur+" mais il faut être habitant de notre village pour commercer ici.");
			}
		else {
		System.out.println("Quel produit voulez vous acheter ?");
		String produit=scan.next();
		int i=1;
		String [] vendeurs=controlAcheterProduit.vendeursProduit(produit);
		if(vendeurs==null) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
		}else {
			System.out.println("Chez quel vendeur voulez-vous acheter des fleurs?");
			while (i-1<vendeurs.length) {
				System.out.println(i + " - "+ vendeurs[i-1]);
				i++;
			}
			i=scan.nextInt();
			String vendeur=vendeurs[i-1];
			if (!controlAcheterProduit.verifierIdentite(vendeur)) {
				System.out.println("Je suis désolée "+vendeur+ " mais il faut être un habitant de notre village pour commercer ici");
			} else {
				System.out.println(nomAcheteur+ " se déplace jusqu'à l'étal du vendeur "+ vendeur);
				System.out.println("Bonjour "+ nomAcheteur);
				System.out.println("Combien de "+ produit+ " voulez-vous acheter?");
				int nbAchat=scan.nextInt();
				int nbAchete=controlAcheterProduit.acheterProduit(vendeur, nbAchat);
				if (nbAchat==nbAchete) {
					System.out.println(nomAcheteur + " achète "+nbAchete+ " "+ produit +" à "+ vendeur);
				}
				else if (nbAchete==0) {
					System.out.println(nomAcheteur + " veut acheter "+ nbAchat + " " + produit +", malheureusement il n'y en a plus !");
				}
				else if (nbAchat>nbAchete) {
					System.out.println(nomAcheteur + " veut acheter " + nbAchat + " " +produit +", malheureusement "+ vendeur+" n'en a plus que "+ nbAchete + ". "+ nomAcheteur + " achète tous le stock de "+ vendeur + ".");
				}
				
				
				
			}
			
			
			
		}
		}
	}
}
