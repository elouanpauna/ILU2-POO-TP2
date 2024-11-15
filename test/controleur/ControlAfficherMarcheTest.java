package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private ControlAfficherMarche controlAfficherMarche;
	private Village village;
	private Gaulois gaulois;
	
	@BeforeEach
	void initialisation() {
		village=new Village("village gaulois",20,20);
		gaulois= new Gaulois("Bonemine",3);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "Fleurs", 5);
		controlAfficherMarche= new ControlAfficherMarche(village);
	}
	
	@Test
	void testDonnerInfosMarche() {
		String[] result=new String[3];
		result[0]="Bonemine";
		result[1]=String.valueOf(5);
		result[2]="Fleurs";
		assertArrayEquals(result,controlAfficherMarche.donnerInfosMarche());
	}

}
