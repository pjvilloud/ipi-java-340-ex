import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;

@RunWith(value=Parameterized.class)
public class ManagerParameterizedTest {
	
	
	@Parameter(value=0)
	public int equipe;
	@Parameter(value=1)
	public Double resultat;
	
	  @Parameters(name = "La prime avec {0} personnes est bien égal à {1}")
	  public static Collection<Object[]> data() {
	      return Arrays.asList(new Object[][]{
	        {0, 0d},
	        {1, 1500d},
	        {3, 2000d}
	        
	      });
	  }
	  
	  // Test 1 : Manager sans équipe
	  @Test
	  public void testPrimeManagerSansEquipe() {
			Manager manager = new Manager();
			
			equipe = (int) manager.getEquipe().size(); 
			
			// When 
			resultat = manager.getPrimeAnnuelle();
			
			// Then 
			Assertions.assertThat(equipe).isEqualTo(resultat); 
	  }
	  
	  // Test 2 : Manager avec une personne
	  @Test
	  public void testPrimeManagerAvec1Personne() {
			Manager manager = new Manager();
			Technicien tech = new Technicien();
			tech.setPrenom("Martin");
			manager.ajoutTechnicienEquipe(tech);
			
			equipe = (int) manager.getEquipe().size(); 
			
			// When 
			resultat = manager.getPrimeAnnuelle();
			
			// Then 
			Assertions.assertThat(equipe).isEqualTo(resultat); 
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
			
			equipe = (int) manager.getEquipe().size(); 
			
			// When 
			resultat = manager.getPrimeAnnuelle();
			
			// Then 
			Assertions.assertThat(equipe).isEqualTo(resultat);
	  }

}
