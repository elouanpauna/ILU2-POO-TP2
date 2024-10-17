package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder question2 =new StringBuilder();
					question2.append("Bienvenue vilageois " + nomVisiteur + "\n");
					question2.append("Quel est votre force ?\n");
					int force=0;
					force=Clavier.entrerEntier(question2.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur,force);
					break;
				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question=new StringBuilder();
		question.append("Bienvenue druide "+nomVisiteur+"\n");
		question.append("Quelle est votre force ?\n");
		int force=0;
		force=Clavier.entrerEntier(question.toString());
		int effetPotionMin=1;
		int effetPotionMax=0;
		while (effetPotionMax<effetPotionMin) {
			StringBuilder question2 =new StringBuilder();
			StringBuilder question3 = new StringBuilder();
			question2.append("Quelle est la force de potion la plus faible que vous produisez ?\n");
			question3.append("Quelle est la force de potion la plus forte que vous produisez ? \n");
			effetPotionMin=Clavier.entrerEntier(question2.toString());
			effetPotionMax=Clavier.entrerEntier(question3.toString());
			if (effetPotionMax<effetPotionMin) {
				System.out.println("Attention druide, vous vous �tes tromp�s entre le minimum et le maximum. \n");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
}
