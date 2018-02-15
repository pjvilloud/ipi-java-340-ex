import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;

public class ManagerTest {
	
	
	
	  // Test 1 : Manager sans équipe
	  @Test
	  public void testPrimeManagerSansEquipe() {
			Manager manager = new Manager();
			
			manager.getEquipe().size(); 
			
			// When 
			Double primeAnnuelle = manager.getPrimeAnnuelle();
			
			// Then 
			Assertions.assertThat(primeAnnuelle).isEqualTo(1009d); 
	  }
	  
	  // Test 2 : Manager avec une personne
	  @Test
	  public void testPrimeManagerAvec1Personne() {
			Manager manager = new Manager();
			Technicien tech = new Technicien();
			tech.setPrenom("Martin");
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
			Technicien tech = new Technicien();
			tech.setPrenom("Martin");
			Technicien tech2 = new Technicien();
			tech2.setPrenom("Alain");
			Technicien tech3 = new Technicien(); 
			tech3.setPrenom("Jean");
			manager.ajoutTechnicienEquipe(tech);
			manager.ajoutTechnicienEquipe(tech2);
			manager.ajoutTechnicienEquipe(tech3);
			
			manager.getEquipe().size(); 
			
			// When 
			Double primeAnnuelle = manager.getPrimeAnnuelle();
			
			// Then 
			Assertions.assertThat(primeAnnuelle).isEqualTo(1759d);
	  }

}
