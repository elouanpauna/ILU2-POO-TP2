package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private ControlLibererEtal controlLibererEtal;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;
	private Gaulois gaulois;
	
	@BeforeEach
	void initialisation() {
		village=new Village("village gaulois",20,20);
		gaulois= new Gaulois("Bonemine",2);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 2);
		controlTrouverEtalVendeur= new ControlTrouverEtalVendeur(village);
		controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
		
	}
	@Test
	void testIsVendeur() {
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
		assertFalse(controlLibererEtal.isVendeur("Idefix"));
	}
	
	@Test
	void testLibererEtal() {
		String[] result= new String[5];
		result[0]=String.valueOf(true);
		result[1]="Bonemine";
		result[2]="fleurs";
		result[3]=String.valueOf(2);
		result[4]=String.valueOf(0);
		assertArrayEquals(result,controlLibererEtal.libererEtal("Bonemine"));
		assertEquals(null,controlLibererEtal.libererEtal("Idefix"));
	}

}
