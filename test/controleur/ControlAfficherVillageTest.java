package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private ControlAfficherVillage controlAfficherVillage;
	private Village village;
	private Gaulois gaulois;
	
	@BeforeEach
	void initialiseSituation() {
		village=new Village("Village Gaulois",20,10);
		gaulois= new Gaulois("Panoramix",2);
		village.ajouterHabitant(gaulois);
		gaulois=new Gaulois("Obélix",20);
		village.ajouterHabitant(gaulois);
		controlAfficherVillage=new ControlAfficherVillage(village);
	}
	
	@Test
	void testDonnerNomVillagoies() {
		String[] nomsGaulois= new String[3];
		nomsGaulois[0]="Pas de Chef";
		nomsGaulois[1]="Panoramix";
		nomsGaulois[2]="Obélix";
		assertArrayEquals(nomsGaulois,controlAfficherVillage.donnerNomsVillageois());
	}
	
	@Test
	void testDonnerNomVillage() {
		String nom="Village Gaulois";
		assertEquals(nom,controlAfficherVillage.donnerNomVillage());
	}
	
	@Test
	void testDonnerNbEtals() {
		int i =10;
		assertEquals(i,controlAfficherVillage.donnerNbEtals());
	}
}
