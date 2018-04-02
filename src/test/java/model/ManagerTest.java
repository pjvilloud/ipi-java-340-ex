package model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.ipiecoles.java.java340.model.Entreprise;
import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;

public class ManagerTest {
	
	@Test
	public void TsetSalaireManager() {
		Manager m = new Manager();
		Technicien t = new Technicien();
		m.ajoutTechnicienEquipe(t);
		m.setSalaire(100d);
		
		Double salaire=m.getSalaire();
		Integer sizeEquipe = m.getEquipe().size();
		
		Assertions.assertThat(sizeEquipe).isEqualTo(1);
	}
	
	@Test
	public void TaugmenterSalaire() {
		Manager m = new Manager();
		Technicien t = new Technicien();
		m.ajoutTechnicienEquipe(t);
		m.setSalaire(100d);
		
		
		m.augmenterSalaire(20d);
		Double s = m.getSalaire();
		
		Assertions.assertThat(s).isEqualTo(120d);
		
	}
	
	
	@Test
	public void TgetPrimeAnnuelle() {
		Manager m = new Manager();
		Technicien t = new Technicien();
		m.ajoutTechnicienEquipe(t);
		m.setSalaire(100d);
		
		
		Double prime = m.getPrimeAnnuelle();
		Assertions.assertThat(prime).isEqualTo(1260);
		
	}

}
