import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;

public class ManagerTest {
	
	@Test
	public void testerSalaire0() {
		
		// Given 
		Manager manager = new Manager();
		Double salaire = 0d; 
		manager.setSalaire(salaire);
		
		// When 
		Double resultat = manager.getSalaire(); 
		
		// Then 
		Assertions.assertThat(resultat).isEqualTo(0d);
		
	}
	
	@Test
	public void testerSalaireNormalSansEquipe() {
		
		// Given 
		Manager manager = new Manager();
		Double salaire = 1500d; 
		manager.setSalaire(salaire);
		
		// When 
		Double resultat = manager.getSalaire(); 
		
		// Then 
		Assertions.assertThat(resultat).isEqualTo(1950d);
	}
	
	@Test
	public void testerSalaireNormalAvecEquipe() {
		
		// Given 
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
		Double salaire = 1500d;
		manager.setSalaire(salaire);
	
		// When 
		Double resultat = manager.getSalaire(); 
		
		// Then 
		Assertions.assertThat(resultat).isEqualTo(2400d);
	}
	
	@Test
	public void testerSalaireNormalAvec1Personne() {
		
		// Given 
		Manager manager = new Manager();
		Technicien tech = new Technicien(); 
		manager.ajoutTechnicienEquipe(tech);
		Double salaire = 1500d;
		manager.setSalaire(salaire);

		// When 
		Double resultat = manager.getSalaire(); 
		
		// Then 
		Assertions.assertThat(resultat).isEqualTo(2100d);
	}
	

}
