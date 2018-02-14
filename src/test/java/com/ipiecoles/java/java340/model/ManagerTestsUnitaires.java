package com.ipiecoles.java.java340.model;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;

public class ManagerTestsUnitaires {

	//Tests unitaires-------------------------------------------------------------------------------
			@Test
			public void testUnitAugmenterSalaire() {
						
				//Given
				Manager manager = new Manager();
				
				Double salaireBase = 1000d;
				manager.setSalaire(salaireBase);
				Double pc = 0.5d;
				manager.augmenterSalaire(pc);
				
				//When
				Double salaire = manager.getSalaire();
				
				//Then
				Assertions.assertThat(salaire).isEqualTo(salaireBase*Entreprise.INDICE_MANAGER*(1+pc));
			}	
			
			@Test
			public void testUnitaireGetPrimeAnnuelle() {
			
				
				//Given
				Manager manager = new Manager();
			
				Technicien technicien1 = new Technicien("Durand","Jean","T12345",new LocalDate(), 1500d, 3);
				Technicien technicien2 = new Technicien("Dupont","Jeanne","T12346",new LocalDate(), 1600d, 2);
				
				
				HashSet<Technicien> equipe = new HashSet<>();
				equipe.add(technicien1);
				equipe.add(technicien2);
				manager.setEquipe(equipe);
				
				
				//When
				Double primeAnnuelle = Entreprise.primeAnnuelleBase() +  equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
				Double primeMethode = manager.getPrimeAnnuelle();
				
				//Then
				Assertions.assertThat(primeAnnuelle).isEqualTo(primeMethode);
			}
	
}
