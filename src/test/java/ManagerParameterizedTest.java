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
	
	public Manager manager = new Manager();
	public Technicien tech = new Technicien(); 
	public Technicien tech2 = new Technicien(); 
	public Technicien tech3 = new Technicien();  
	
	@Parameter(value=0)
	public Double salaire;
	@Parameter(value=1)
	public Double salaireFinal;
	
	  @Parameters(name = "Si le manager a {0} euros de salaire alors il gagnera au final {1} ")
	  public static Collection<Object[]> data() {
	      return Arrays.asList(new Object[][]{
	        {0d, 0d},
	        {1500d, 2100d},
	        {1600d, 2240d}, 
	        {2000d, 2800d}
	      });
	  }
	  

	@Test
	public void testerSalaireNormalAvecEquipe() {
		
		// Given 
		manager.ajoutTechnicienEquipe(tech);
		manager.setSalaire(salaire);

		// When 
		Double resultat = manager.getSalaire(); 
		
		// Then 
		Assertions.assertThat(resultat).isEqualTo(salaireFinal);
	}
	

}