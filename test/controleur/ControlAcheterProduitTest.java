package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private ControlAcheterProduit controlAcheterProduit;
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Gaulois gaulois;
	
	@BeforeEach
	void initialisation() {
		village= new Village("village gaulois",20,20);
		gaulois=new Gaulois("Bonemine",3);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "Fleurs", 10);
		controlTrouverEtalVendeur= new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite= new ControlVerifierIdentite(village);
		controlAcheterProduit= new ControlAcheterProduit(controlVerifierIdentite,controlTrouverEtalVendeur,village);
	}
	
	@Test
	void testVerifierIdentite() {
		assertTrue(controlAcheterProduit.verifierIdentite("Bonemine"));
		assertFalse(controlAcheterProduit.verifierIdentite("Idefix"));
	}
	
	@Test
	void testVendeursProduit() {
		String[] result=new String[1];
		result[0]="Bonemine";
		assertArrayEquals(result,controlAcheterProduit.vendeursProduit("Fleurs"));
		
	}
	
	@Test
	void testAcheterProduit() {
		assertEquals(5,controlAcheterProduit.acheterProduit("Bonemine", 5));
		assertEquals(null,controlTrouverEtalVendeur.trouverEtalVendeur("Idefix"));
	}

}
