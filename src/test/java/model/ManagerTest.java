package model;

import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.assertj.core.internal.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.ipiecoles.java.java340.model.Entreprise;
import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;

import javassist.compiler.ast.ASTList;

@RunWith(Parameterized.class)
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
		Assertions.assertThat(prime).isEqualTo(1259);
		
	}
	
	@Parameters
	public static Collection<Object[]> params() {
		return Arrays.asList(
				new Object[] {1,1259d}
				
				);
		
	}

}
