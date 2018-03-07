package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class ManagerParameterizedTest2 {
	
	
	/**
	 * 
	 * Tests about the method "augmenterSalaire" (increase salary) 
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
	
	// Influencing parameter 1: the percentage 
	@Parameterized.Parameter(value = 0)
	public Double percentage;
	// Expected parameter 1: the final salary of the manager
	@Parameterized.Parameter(value = 1)
	public Double expectedSalaryMan;
	// Expected parameter 2: the final salary of the technician
	@Parameterized.Parameter(value = 2)
	public Double expectedSalaryTech;



    @Parameterized.Parameters(name = "The salary of the manager is equal to: 1000, the salary of the technician: 500. The percentage used is {0}. Thus the expected salary of the manager is {1} and of the technician is: {2}")
    public static Collection<Object[]> data(){ 	
    	// Initialization 
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
    			
        return Arrays.asList(new Object[][]{
                {0d, inputSalaryMan, inputSalaryTech},
                {0.1d, inputSalaryMan*1.1d, inputSalaryTech*1.1d},
                {1.1d, inputSalaryMan*2.1d, inputSalaryTech*2.1d},
                {null, inputSalaryMan, inputSalaryTech},
                {-0.2d, inputSalaryMan*0.8d, inputSalaryTech*0.8d},
                {-1.2d, 0.d, 0.d}
        });
    }

    // Méthode permettant de lancer le test : 
    @Test
    public void testSetSalaire(){
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
        //When
        manager.augmenterSalaire(percentage);
        Double increasedSalaryMan = manager.getSalaire();
        Double increasedSalaryTech = technicien.getSalaire();

        //Then
        Assertions.assertThat(increasedSalaryMan).isEqualTo(expectedSalaryMan);
        Assertions.assertThat(increasedSalaryTech).isEqualTo(expectedSalaryTech);
    }

}
