package com.ipiecoles.java.java340.model;

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
		
		}



