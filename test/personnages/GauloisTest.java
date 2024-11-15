package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GauloisTest {
	private Gaulois gaulois;
	
	@BeforeEach
	void initialisation() {
		gaulois=new Gaulois("Obélix",20);
	}

	@Test
	void testGetForce() {
		assertEquals(20,gaulois.getForce());
	}
	
	@Test
	void testGetNom() {
		assertEquals("Obélix",gaulois.getNom());
	}
	
	@Test
	void testToString() {
		assertEquals("Gaulois [nom=Obélix, force=20, effetPotion=1]",gaulois.toString());
	}
	
	@Test
	void testPrendreParole() {
		assertEquals("Le gaulois Obélix : ",gaulois.prendreParole());
	}

}
