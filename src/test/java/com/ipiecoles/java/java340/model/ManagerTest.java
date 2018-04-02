package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;

public class ManagerTest {
	// Manager sans équipe
		  @Test
		  public void testPrimeManagerSansEquipe() {
			  		//Given
			  		Manager manager = new Manager();
			  
			  		// When 
			  		Double primeAnnuelle = manager.getPrimeAnnuelle();
			  			
			  		// Then 
			  		Assertions.assertThat(primeAnnuelle).isEqualTo(1009d); 
			  	  }
			  	  
	// Manager avec 1 personne
		  @Test
		  public void testPrimeManagerAvec1Personne() {
			  			Manager manager = new Manager();
			  			Technicien tech = new Technicien();
			  			tech.setPrenom("Julien");
			  			manager.ajoutTechnicienEquipe(tech);
			  			
			  			manager.getEquipe().size(); 
			  			
			  			// When 
			  			Double primeAnnuelle = manager.getPrimeAnnuelle();
			  			
			  			// Then 
			  			Assertions.assertThat(primeAnnuelle).isEqualTo(1259d); 
			  	  }
			  	  
			  	  // Test 3 : Manager avec plusieurs personnes
			  	  @Test
			  	  public void testPrimeManagerAvecEquipe() {
			  			Manager manager = new Manager();
			  			Technicien tech1 = new Technicien();
			  			tech1.setPrenom("Julien");
			  			Technicien tech2 = new Technicien();
			  			tech2.setPrenom("Marc");
			  			Technicien tech3 = new Technicien(); 
			  			tech3.setPrenom("Sophie");
			  			manager.ajoutTechnicienEquipe(tech1);
			  			manager.ajoutTechnicienEquipe(tech2);
			  			manager.ajoutTechnicienEquipe(tech3);
			  			manager.getEquipe().size(); 
			  			
			  			// When 
			  			Double primeAnnuelle = manager.getPrimeAnnuelle();
			  			
			  			// Then 
			  			Assertions.assertThat(primeAnnuelle).isEqualTo(1759d);
			  	  }

}
