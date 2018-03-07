package com.ipiecoles.java.java340.model;

import org.joda.time.LocalDate;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.ipiecoles.java.java340.exception.EmployeException;

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
	
		// Increase the salary by 0 of the manager: the salaries of both manager and technician should remain the same as first defined 
		@Test
		public void testIncreaseSalaryBy0() {
			//Given
			Manager manager = new Manager();
			Technicien technicien = new Technicien(); 
			// Don't forget to put at least a name OR surname OR matricule otherwise it is like the technician does not exist
			technicien.setNom("bob");
			technicien.setGrade(0);
			technicien.setManager(manager);
			manager.ajoutTechnicienEquipe(technicien);
			manager.setSalaire(1000d);
			technicien.setSalaire(500d);
			Double inputSalaryMan = manager.getSalaire();
			Double inputSalaryTech = technicien.getSalaire();
			int managerTeam = manager.getEquipe().size();
			//When
	        manager.augmenterSalaire(0d);
	        Double increasedSalaryMan = manager.getSalaire();
	        Double increasedSalaryTech = technicien.getSalaire();
	        //Then
	        Assertions.assertThat(increasedSalaryMan).isEqualTo(inputSalaryMan);
	        Assertions.assertThat(increasedSalaryTech).isEqualTo(inputSalaryTech);
	        Assertions.assertThat(managerTeam).isEqualTo(1);
			}


		//Increase the salary of the manager by 10%: the salaries of both manager and technician should be multiplicated by 1.1
		@Test
		public void testIncreaseSalaryBy10() {
			//Given
			Manager manager = new Manager();
			Technicien technicien = new Technicien(); 
			// Don't forget to put at least a name OR surname OR matricule otherwise it is like the technician does not exist
			technicien.setNom("bob");
			technicien.setGrade(0);
			technicien.setManager(manager);
			manager.ajoutTechnicienEquipe(technicien);
			manager.setSalaire(1000d);
			technicien.setSalaire(500d);
			Double inputSalaryMan = manager.getSalaire();
			Double inputSalaryTech = technicien.getSalaire();
			int managerTeam = manager.getEquipe().size();
			//When
	        manager.augmenterSalaire(0.1d);
	        Double increasedSalaryMan = manager.getSalaire();
	        Double increasedSalaryTech = technicien.getSalaire();
	        //Then
	        Assertions.assertThat(increasedSalaryMan).isEqualTo(inputSalaryMan*1.1d);
	        Assertions.assertThat(increasedSalaryTech).isEqualTo(inputSalaryTech*1.1d);
	        Assertions.assertThat(managerTeam).isEqualTo(1);
			}
		
		//Increase the salary of the manager by 110%: the salaries of both manager and technician should be multiplicated by 2
		@Test
		public void testIncreaseSalaryBy110() {
			//Given
			Manager manager = new Manager();
			Technicien technicien = new Technicien(); 
			// Don't forget to put at least a name OR surname OR matricule otherwise it is like the technician does not exist
			technicien.setNom("bob");
			technicien.setGrade(0);
			technicien.setManager(manager);
			manager.ajoutTechnicienEquipe(technicien);
			manager.setSalaire(1000d);
			technicien.setSalaire(500d);
			Double inputSalaryMan = manager.getSalaire();
			Double inputSalaryTech = technicien.getSalaire();
			int managerTeam = manager.getEquipe().size();
			//When
	        manager.augmenterSalaire(1.1d);
	        Double increasedSalaryMan = manager.getSalaire();
	        Double increasedSalaryTech = technicien.getSalaire();
	        //Then
	        Assertions.assertThat(increasedSalaryMan).isEqualTo(inputSalaryMan*2.1d);
	        Assertions.assertThat(increasedSalaryTech).isEqualTo(inputSalaryTech*2.1d);
	        Assertions.assertThat(managerTeam).isEqualTo(1);
			}

		// We need to modify the method augmenterSalaire which didn't take into considerations the following cases: 
		// - if increase is null
		// - if increase is negative and "stronger" than -100%
		//Increase the salary of the manager by null: the salaries of both manager and technician should remain as first defined 
		@Test
		public void testIncreaseSalaryByNull() {
			//Given
			Manager manager = new Manager();
			Technicien technicien = new Technicien(); 
			// Don't forget to put at least a name OR surname OR matricule otherwise it is like the technician does not exist
			technicien.setNom("bob");
			technicien.setGrade(0);
			technicien.setManager(manager);
			manager.ajoutTechnicienEquipe(technicien);
			manager.setSalaire(1000d);
			technicien.setSalaire(500d);
			Double inputSalaryMan = manager.getSalaire();
			Double inputSalaryTech = technicien.getSalaire();
			int managerTeam = manager.getEquipe().size();
			//When
	        manager.augmenterSalaire(null);
	        Double increasedSalaryMan = manager.getSalaire();
	        Double increasedSalaryTech = technicien.getSalaire();
	        //Then
	        Assertions.assertThat(increasedSalaryMan).isEqualTo(inputSalaryMan);
	        Assertions.assertThat(increasedSalaryTech).isEqualTo(inputSalaryTech);
	        Assertions.assertThat(managerTeam).isEqualTo(1);
			}
		
		//Increase the salary of the manager by negative number between 0 and -1: the salaries of both manager and technician are decreasing
		@Test
		public void testIncreaseSalaryByNegative() {
			//Given
			Manager manager = new Manager();
			Technicien technicien = new Technicien(); 
			// Don't forget to put at least a name OR surname OR matricule otherwise it is like the technician does not exist
			technicien.setNom("bob");
			technicien.setGrade(0);
			technicien.setManager(manager);
			manager.ajoutTechnicienEquipe(technicien);
			manager.setSalaire(1000d);
			technicien.setSalaire(500d);
			Double inputSalaryMan = manager.getSalaire();
			Double inputSalaryTech = technicien.getSalaire();
			int managerTeam = manager.getEquipe().size();
			//When
	        manager.augmenterSalaire(-0.2d);
	        Double increasedSalaryMan = manager.getSalaire();
	        Double increasedSalaryTech = technicien.getSalaire();
	        //Then
	        Assertions.assertThat(increasedSalaryMan).isEqualTo(inputSalaryMan*0.8d);
	        Assertions.assertThat(increasedSalaryTech).isEqualTo(inputSalaryTech*0.8d);
	        Assertions.assertThat(managerTeam).isEqualTo(1);
			}
		
		//Increase the salary of the manager by a really negative number: the salaries of both manager and technician should be equal to 0
		@Test
		public void testIncreaseSalaryByTooNegative() {
			//Given
			Manager manager = new Manager();
			Technicien technicien = new Technicien(); 
			// Don't forget to put at least a name OR surname OR matricule otherwise it is like the technician does not exist
			technicien.setNom("bob");
			technicien.setGrade(0);
			technicien.setManager(manager);
			manager.ajoutTechnicienEquipe(technicien);
			manager.setSalaire(1000d);
			technicien.setSalaire(500d);
			int managerTeam = manager.getEquipe().size();
			//When
	        manager.augmenterSalaire(-1.2d);
	        Double increasedSalaryMan = manager.getSalaire();
	        Double increasedSalaryTech = technicien.getSalaire();
	        //Then
	        Assertions.assertThat(increasedSalaryMan).isEqualTo(0d);
	        Assertions.assertThat(increasedSalaryTech).isEqualTo(0d);
	        Assertions.assertThat(managerTeam).isEqualTo(1);
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
		
		// Set Salaire equal to null and no team mates: should be equal to 0
		@Test
		public void testSetSalaireByNull() {
			//Given
			Manager manager = new Manager();
			//When
			manager.setSalaire(null);
	        Double salaire = manager.getSalaire();
	        //Then
	        Assertions.assertThat(salaire).isEqualTo(0d);
			}
		
		// Set Salaire is negative and no team mates: should be equal to 0
		@Test
		public void testSetSalaireByNegative() {
			//Given
			Manager manager = new Manager();
			//When
			manager.setSalaire(-1000d);
	        Double salaire = manager.getSalaire();
	        //Then
	        Assertions.assertThat(salaire).isEqualTo(0d);
			}
		
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
			//When
			manager.ajoutTechnicienEquipe("Bob", "Le bricoleur", "01234", dateEmbauche, 1500d, 1);
			manager.ajoutTechnicienEquipe("Clef", "A molette", "4567", dateEmbauche, 1500d, 1);
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
			//When
			manager.ajoutTechnicienEquipe("Bob", "Le bricoleur", "01234", dateEmbauche, 1500d, 1);
			manager.ajoutTechnicienEquipe("Clef", "A molette", "4567", dateEmbauche, 1500d, 1);
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
			//When
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
			manager.setSalaire(1000d);
	        Double salaire = manager.getSalaire();
	        //Then
	        Assertions.assertThat(salaire).isEqualTo(2300d);
			}
		
		// ------------------------------------------------------------------------------------------------------------------
		
		/**
		 * 
		 * Tests about the method "getPrimeAnnuelle" (get annual bonus) 
		 * 
		 * Reminder: 
		 * 	public Double getPrimeAnnuelle() {
		return Entreprise.primeAnnuelleBase() + equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
		}
		And we also know that: 
			public static Double primeAnnuelleBase() {
		return LocalDate.now().getYear() * 0.5;
		}
		And: 
		public static final Double PRIME_MANAGER_PAR_TECHNICIEN = 250d;
		 * 
		 */
		
		// Get annual bonus with no team mates: should be equal to 2017/2 = 1009
		@Test
		public void testGetPrimeAnnuelleNoTeammate() {
			//Given
			Manager manager = new Manager();
			//When
	        Double prime = manager.getPrimeAnnuelle();
	        //Then
	        Assertions.assertThat(prime).isEqualTo(1009d);
			}
		
		// Get annual bonus with 1 team mate: should be equal to 2017/2 + 1*250 = 1259
		@Test
		public void testGetPrimeAnnuelle1Teammate() {
			//Given
			Manager manager = new Manager();
			LocalDate dateEmbauche = LocalDate.now();
			//When
			manager.ajoutTechnicienEquipe("Bob", "Le bricoleur", "01234", dateEmbauche, 1500d, 1);
	        Double prime = manager.getPrimeAnnuelle();
	        //Then
	        Assertions.assertThat(prime).isEqualTo(1259d);
			}
		
		// Get annual bonus with 10 team mate: should be equal to 2017/2 + 10*250 = 3509
		@Test
		public void testGetPrimeAnnuelle10Teammates() {
			//Given
			Manager manager = new Manager();
			LocalDate dateEmbauche = LocalDate.now();
			//When
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
	        Double prime = manager.getPrimeAnnuelle();
	        //Then
	        Assertions.assertThat(prime).isEqualTo(3509d);
			}
		
		// Get annual bonus with a team mate who does not have a name AND surname AND matricule: should be equal to 2017/2 = 1009 as we do not consider him as a teammate 
		@Test
		public void testGetPrimeAnnuelleNullTeammate() {
			//Given
			Manager manager = new Manager();
			LocalDate dateEmbauche = LocalDate.now();
			//When
			manager.ajoutTechnicienEquipe(null, null, null, dateEmbauche, 1800d, 2);
	        Double prime = manager.getPrimeAnnuelle();
	        //Then
	        Assertions.assertThat(prime).isEqualTo(1009d);
			}
		
		// Get annual bonus with 3 not null team mates (they have only one of the following information: surname, name, matricule): should be equal to 2017/2 + 3*250= 1759 as we have enough information to consider them as teammates
		@Test
		public void testGetPrimeAnnuelle3NotNullTeammates() {
			//Given
			Manager manager = new Manager();
			LocalDate dateEmbauche = LocalDate.now();
			//When
			manager.ajoutTechnicienEquipe("Bob", null, null, dateEmbauche, 1800d, 2);
			manager.ajoutTechnicienEquipe(null, "Le Bricoleur", null, dateEmbauche, 1800d, 2);
			manager.ajoutTechnicienEquipe(null, null, "01234", dateEmbauche, 1800d, 2);
	        Double prime = manager.getPrimeAnnuelle();
	        //Then
	        Assertions.assertThat(prime).isEqualTo(1759d);
			}
		
		
		}



