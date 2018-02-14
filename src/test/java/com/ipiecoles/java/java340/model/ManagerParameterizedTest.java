package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class ManagerParameterizedTest {
	
	@Parameterized.Parameter(value = 0)
	  public Integer expectedsizeEquipe;
	
	@Parameterized.Parameter(value = 1)
	  public Double expectedprimeAnnuelle;
	
	@Parameterized.Parameters(name = "Avec {0} personne(s), le manager à une prime annuelle de : {1}")
	  public static Collection<Object[]> data() {
	      return Arrays.asList(new Object[][]{
	    	  {1, 1259d}
	      });
	  }
	
	//Entreprise.primeAnnuelleBase() + equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN
	//2018 * 0.5     + 1 * 250d
		
		@Test
		public void testgetPrimeAnnuelle() {
			//Given
			Manager mng = new Manager();
			Technicien tec = new Technicien();
			mng.ajoutTechnicienEquipe(tec);
			
			//When
			Double primeAnnuelle = mng.getPrimeAnnuelle();
			Integer sizeEquipe = mng.getEquipe().size();
			
			//Then
			Assertions.assertThat(sizeEquipe).isEqualTo(expectedsizeEquipe);
			Assertions.assertThat(primeAnnuelle).isEqualTo(expectedprimeAnnuelle);
		}
	
	
	

}
