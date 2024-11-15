package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private ControlPrendreEtal controlPrendreEtal;
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Gaulois gaulois;
	
	@BeforeEach
	void initialisation() {
		village=new Village("village gaulois",20,20);
		gaulois=new Gaulois("Bonemine",2);
		village.ajouterHabitant(gaulois);
		controlVerifierIdentite= new ControlVerifierIdentite(village);
		controlPrendreEtal=new ControlPrendreEtal(controlVerifierIdentite,village);
	}
	
	@Test
	void testVerifierIdentite() {
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
	}
	
	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testPrendreEtal(){
		int i=controlPrendreEtal.prendreEtal("Bonemine","Fleurs",1);
		assertEquals(0,i);
		
	}
}
