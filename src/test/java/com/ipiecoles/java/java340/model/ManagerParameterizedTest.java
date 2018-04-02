package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ManagerParameterizedTest {
	public Manager manager = new Manager();
	public Technicien tech1
	= new Technicien();
	public Technicien tech2 = new Technicien(); 
	public Technicien tech3 = new Technicien();
	
	@Parameter(value=0)
	public Double salaire;
	@Parameter(value=1)
	public Double salaireFinal;
	@Parameters(name = "Le Manager qui a un salaire de {0} euro, aura {1} euros")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][]{
			{0, 0d},
			{1500d, 2100d},
			{1600d, 2240d}, 
			{2000d, 2800d}
							});
		}
// Manager sans équipe
		@Test
			public void testPrimeManagerSansEquipe() {
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
			tech.setPrenom("Martin");
			manager.ajoutTechnicienEquipe(tech);
			manager.ajoutTechnicienEquipe(tech);
			manager.getEquipe().size();
			
			// When 
			Double primeAnnuelle = manager.getPrimeAnnuelle();
			
			// Then 
			Assertions.assertThat(primeAnnuelle).isEqualTo(1259d); 
			}
			 
//Manager avec plusieurs personnes
		@Test
			public void testPrimeManagerAvecEquipe() {
			Manager manager = new Manager();
			Technicien tech1 = new Technicien();
			tech1.setPrenom("Martin");
			Technicien tech2 = new Technicien();
			tech2.setPrenom("Alain");
			Technicien tech3 = new Technicien(); 
			tech3.setPrenom("Jean");
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
