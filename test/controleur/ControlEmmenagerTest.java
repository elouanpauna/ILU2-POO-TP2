package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private ControlEmmenager controlEmmenager;
	private Village village;
	private Gaulois gaulois;
	private Chef chef;
	
	
	@BeforeEach
	void initialisation() {
		village=new Village("Village Gaulois",20,20);
		gaulois=new Gaulois("Idéfix",1);
		chef=new Chef("Abraracourcix",2,village);
		village.ajouterHabitant(gaulois);
		village.setChef(chef);
		controlEmmenager= new ControlEmmenager(village);
		
	}
	
	
	@Test
	void testIsHabitant() {
		assertEquals(true,controlEmmenager.isHabitant("Idéfix"));
	}
	
	@Test
	void testAjouterDruide() {
		controlEmmenager.ajouterDruide("Panoramix", 3, 10, 20);
		assertEquals(true,controlEmmenager.isHabitant("Panoramix"));
	}
	
	@Test
	void testAjouterGaulois() {
		controlEmmenager.ajouterGaulois("Obélix", 20);
		assertEquals(true,controlEmmenager.isHabitant("Obélix"));
	}

}
