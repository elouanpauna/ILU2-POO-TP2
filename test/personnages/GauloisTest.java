package personnages;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GauloisTest {
	private Gaulois gaulois;
	
	@BeforeEach
	void initialisation() {
		gaulois=new Gaulois("Ob�lix",20);
	}

	@Test
	void testGetForce() {
		assertEquals(20,gaulois.getForce());
	}
	
	@Test
	void testGetNom() {
		assertEquals("Ob�lix",gaulois.getNom());
	}
	
	@Test
	void testToString() {
		assertEquals("Gaulois [nom=Ob�lix, force=20, effetPotion=1]",gaulois.toString());
	}
	
	@Test
	void testPrendreParole() {
		assertEquals("Le gaulois Ob�lix : ",gaulois.prendreParole());
	}

}
