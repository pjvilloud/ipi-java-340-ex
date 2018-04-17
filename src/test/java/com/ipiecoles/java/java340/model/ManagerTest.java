package com.ipiecoles.java.java340.model;

import java.util.HashSet;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;

public class ManagerTest {
	
	
	@Test
	  public void testPrimeManager() {
			Manager manager = new Manager();
			Technicien technicien = new Technicien();
			manager.ajoutTechnicienEquipe(technicien);
			
			manager.getEquipe().size(); 
			
			// When 
			Double primeAnnuelle = manager.getPrimeAnnuelle();
			
			// Then 
			Assertions.assertThat(primeAnnuelle).isEqualTo(1259d); 
	  }
}
