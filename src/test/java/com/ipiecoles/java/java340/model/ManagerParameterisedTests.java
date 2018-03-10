package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.ipiecoles.java.java340.exception.EmployeException;


@RunWith(value = Parameterized.class)
public class ManagerParameterisedTests {
		
	private static LocalDate nowMinus2 = LocalDate.now().minusYears(2);
	
	@Parameterized.Parameter(value = 0)
	public Double salaireManager;
		
	@Parameterized.Parameter(value = 1)
	public Double salaireTechnicien;
		
	@Parameterized.Parameter(value = 2) 
	public Double primeManagerAttendue;
	
	@Parameterized.Parameter(value = 3) 
	public Double primeTechnicienAttendue;
			
	@Parameterized.Parameters (name = "pour un Manager gagnant {0} par mois avec une éuipe de 1 technicien, la primeManagerattendue est : {1} - pour un Technicien gagnant {2} par mois la primeTechnicienAttendue est égale à : {3}")
	public static Collection<Object[]> data() {
		 return Arrays.asList(new Object[][] {
				{Entreprise.SALAIRE_BASE,Entreprise.SALAIRE_BASE, 1259d, 2960.54d}
			
			});
	}
					
	@Test
	public void getPrimeAnnuelleTest() throws Exception {
		//Given 
		Manager manager = new Manager();
		manager.setSalaire(salaireManager);
		Technicien technicien = new Technicien();
		technicien.setGrade(10);//Grade = 10, Permet de verifier que l'on ajoute bien la prime d'anciennete et simplifie la verification
		technicien.setSalaire(salaireTechnicien);
		HashSet<Technicien> equipe = new HashSet<Technicien>();
						
		//When 
		
		try {
			technicien.setDateEmbauche(nowMinus2);
			equipe.add(technicien);
			manager.setEquipe(equipe);
			manager.getPrimeAnnuelle();
			technicien.getPrimeAnnuelle();
			//Then
			Assertions.assertThat(technicien.getDateEmbauche()).isEqualTo(nowMinus2);
			Assertions.assertThat(manager.getPrimeAnnuelle()).isEqualTo(primeManagerAttendue);
			Assertions.assertThat(!manager.getEquipe().isEmpty());
			Assertions.assertThat(technicien.getSalaire()).isEqualTo(primeTechnicienAttendue);	
			
			
			} catch (EmployeException e) {
								
				Assertions.assertThat(e.getMessage()).isEqualTo("La date d'embauche ne peut être postérieure à la date courante");
				Assertions.assertThat(nowMinus2).isNull();
			}
								
		}

}


		