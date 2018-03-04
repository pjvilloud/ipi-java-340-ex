package com.ipiecoles.java.java340.model;

import org.joda.time.LocalDate;

import java.lang.reflect.Field;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ManagerTest {
	
	/**
	 * 
	 * Tests about the method "augmentersalaire" (increase salary) 
	 * 
	 * Reminder  
	 * 	public void augmenterSalaire(Double pourcentage) {
		super.augmenterSalaire(pourcentage);
		augmenterSalaireEquipe(pourcentage);
		}
	 *	private void augmenterSalaireEquipe(Double pourcentage) {
		for (Technicien technicien : equipe) {
			technicien.augmenterSalaire(pourcentage);
			}
		}
		
	 * Super: 
	 * 	public void augmenterSalaire(Double pourcentage) {
		this.salaire = this.getSalaire() * (1 + pourcentage);
		}
		
		has been modified to 
		
		public void augmenterSalaire(Double pourcentage) {	
		if (pourcentage == null) {
			this.salaire = this.getSalaire();
		}
		else if (pourcentage < -1) {
			this.salaire = 0d;
		}
		else {
			this.salaire = this.getSalaire() * (1 + pourcentage);
		}
	}
	 *
	 *
	 */
	
	
		// Increase the salary by 0: the salary should remain the same as first defined 
		@Test
		public void testIncreaseSalaryBy0() {
			//Given
			Manager manager = new Manager();
			manager.setSalaire(1000d);
			Double inputSalary = manager.getSalaire();
			//When
	        manager.augmenterSalaire(0d);
	        Double increasedSalary = manager.getSalaire();
	        //Then
	        Assertions.assertThat(increasedSalary).isEqualTo(inputSalary);
			}


		//Increase the salary by 10%: the salary should be multiplicated by 1.1
		@Test
		public void testIncreaseSalaryBy10() {
			//Given
			Manager manager = new Manager();
			manager.setSalaire(1000d);
			Double inputSalary = manager.getSalaire();
			//When
	        manager.augmenterSalaire(0.1d);
	        Double increasedSalary = manager.getSalaire();
	        //Then
	        Assertions.assertThat(increasedSalary).isEqualTo(inputSalary*1.1d);
			}
		
		//Increase the salary by 100%: the salary should be multiplicated by 2
		@Test
		public void testIncreaseSalaryBy100() {
			//Given
			Manager manager = new Manager();
			manager.setSalaire(1000d);
			Double inputSalary = manager.getSalaire();
			//When
	        manager.augmenterSalaire(1d);
	        Double increasedSalary = manager.getSalaire();
	        //Then
	        Assertions.assertThat(increasedSalary).isEqualTo(inputSalary*2d);
			}

		// We need to modify the method augmenterSalaire which didn't take into considerations the following cases: 
		// - if increase is null
		// - if increase is negative and "stronger" than -100%
		//Increase the salary by null: the salary should remain as first defined 
		@Test
		public void testIncreaseSalaryByNull() {
			//Given
			Manager manager = new Manager();
			manager.setSalaire(1000d);
			Double inputSalary = manager.getSalaire();
			//When
	        manager.augmenterSalaire(null);
	        Double increasedSalary = manager.getSalaire();
	        //Then
	        Assertions.assertThat(increasedSalary).isEqualTo(inputSalary);
			}
		
		//Increase the salary by negative number between 0 and -1: the salary is decreasing
		@Test
		public void testIncreaseSalaryByNegative() {
			//Given
			Manager manager = new Manager();
			manager.setSalaire(1000d);
			Double inputSalary = manager.getSalaire();
			//When
	        manager.augmenterSalaire(-0.2d);
	        Double increasedSalary = manager.getSalaire();
	        //Then
	        Assertions.assertThat(increasedSalary).isEqualTo(inputSalary*0.8d);
			}
		
		//Increase the salary by a really negative number: should be equal to 0
		@Test
		public void testIncreaseSalaryByTooNegative() {
			//Given
			Manager manager = new Manager();
			manager.setSalaire(1000d);
			Double inputSalary = manager.getSalaire();
			//When
	        manager.augmenterSalaire(-1d);
	        Double increasedSalary = manager.getSalaire();
	        //Then
	        Assertions.assertThat(increasedSalary).isEqualTo(0d);
			}
		
		
		// ------------------------------------------------------------------------------------------------------------------
		
		/**
		 * 
		 * Tests about the method "setSalaire" (define salary) 
		 * Reminder: 
		 * 	public void setSalaire(Double salaire) {
		super.setSalaire(salaire * Entreprise.INDICE_MANAGER + (salaire * (double)equipe.size() / 10));
		}
		We also know that: 
		public static final Double INDICE_MANAGER = 1.3;		
		 */
		
		// Set Salaire equal to 0 and no team mates: should be equal to 0
		@Test
		public void testSetSalaireBy0() {
			//Given
			Manager manager = new Manager();
			//When
			manager.setSalaire(0d);
	        Double salaire = manager.getSalaire();
	        //Then
	        Assertions.assertThat(salaire).isEqualTo(0d);
			}
		
		// Set Salaire equal to 0 and we have two technicians in the team: should be still equal to 0
		@Test
		public void testSetSalaireBy0And2Tech() {
			//Given
			Manager manager = new Manager();
			LocalDate dateEmbauche = LocalDate.now();
			manager.ajoutTechnicienEquipe("Bob", "Le bricoleur", "01234", dateEmbauche, 1500d, 1);
			manager.ajoutTechnicienEquipe("Clef", "A molette", "4567", dateEmbauche, 1500d, 1);
			//When
			manager.setSalaire(0d);
	        Double salaire = manager.getSalaire();
	        //Then
	        Assertions.assertThat(salaire).isEqualTo(0d);
			}
		
		
		// Set Salaire equal to 1000 but no team mates: should be equal to 1000*1.3 + 1000*(0/10) = 1300
		@Test
		public void testSetSalaireBy1000() {
			//Given
			Manager manager = new Manager();
			//When
			manager.setSalaire(1000d);
	        Double salaire = manager.getSalaire();
	        //Then
	        Assertions.assertThat(salaire).isEqualTo(1300d);
			}
		
		// Set Salaire equal to 1000 and we have two technicians in the team: should be equal to 1000*1.3 + 1000*(2/10) = 1500
		@Test
		public void testSetSalaireBy1000And2Tech() {
			//Given
			Manager manager = new Manager();
			LocalDate dateEmbauche = LocalDate.now();
			manager.ajoutTechnicienEquipe("Bob", "Le bricoleur", "01234", dateEmbauche, 1500d, 1);
			manager.ajoutTechnicienEquipe("Clef", "A molette", "4567", dateEmbauche, 1500d, 1);
			//When
			manager.setSalaire(1000d);
	        Double salaire = manager.getSalaire();
	        //Then
	        Assertions.assertThat(salaire).isEqualTo(1500d);
			}
		
		// Set Salaire equal to 1000 and we have ten technicians in the team: should be equal to 1000*1.3 + 1000*(10/10) = 2300
		@Test
		public void testSetSalaireBy1000And10Tech() {
			//Given
			Manager manager = new Manager();
			LocalDate dateEmbauche = LocalDate.now();
			manager.ajoutTechnicienEquipe("Bob", "Le bricoleur", "01234", dateEmbauche, 1500d, 1);
			manager.ajoutTechnicienEquipe("Clef", "A molette", "01235", dateEmbauche, 1500d, 1);
			manager.ajoutTechnicienEquipe("Tourne", "Vis", "01236", dateEmbauche, 1500d, 2);
			manager.ajoutTechnicienEquipe("Pierre", "Ponce", "01237", dateEmbauche, 2000d, 1);
			manager.ajoutTechnicienEquipe("John", "Peint", "01238", dateEmbauche, 3000d, 4);
			manager.ajoutTechnicienEquipe("Scie", "Sauteuse", "01210", dateEmbauche, 1400d, 1);
			manager.ajoutTechnicienEquipe("Pon", "ceuse", "01239", dateEmbauche, 500d, 1);
			manager.ajoutTechnicienEquipe("Scie", "A métaux", "12364", dateEmbauche, 1800d, 2);
			manager.ajoutTechnicienEquipe("Papier", "Peint", "78451", dateEmbauche, 25000d, 3);
			manager.ajoutTechnicienEquipe("Ciment", "Mortier", "01836", dateEmbauche, 2200d, 3);
			//When
			manager.setSalaire(1000d);
	        Double salaire = manager.getSalaire();
	        //Then
	        Assertions.assertThat(salaire).isEqualTo(2300d);
			}
			
		
		}



