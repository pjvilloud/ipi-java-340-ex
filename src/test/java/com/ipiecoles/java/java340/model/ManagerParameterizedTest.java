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
public class ManagerParameterizedTest {
	
	// Je choisis de refaire sur setSalaire parce que c'est la méthode sur laquelle j'ai le plus de Junit Test (7) donc c'est celle qui me semble la plus intéressante à gérer 
	
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
	
	// Influencing parameter 1: the salary 
	@Parameterized.Parameter(value = 0)
	public Double inputSalary;
	// Influencing parameter 2: the team
	@Parameterized.Parameter(value = 1)
	public Set<Technicien> team;
	// Expected parameter 1: the final salary
	@Parameterized.Parameter(value = 2)
	public Double expectedSalary;
	// Expected parameter 2: the size of the team
	@Parameterized.Parameter(value = 3)
	public int expectedTeamSize;

    @Parameterized.Parameters(name = "The salary is equal to: {0}, the team is: {1}. Thus the expected salary is {2} and the expected size of the team is: {4}")
    public static Collection<Object[]> data(){ 	
    	// Initialization 
    	LocalDate dateEmbauche = LocalDate.now();
    	Technicien tech1 = new Technicien("Bob", "Le bricoleur", "01234", dateEmbauche, 1500d, 1);
    	Technicien tech2 = new Technicien("Clef", "A molette", "4567", dateEmbauche, 1500d, 1);
    	Technicien tech3 = new Technicien("Bob", null, null, dateEmbauche, 1800d, 2);
    	Technicien tech4 = new Technicien(null, "Le Bricoleur", null, dateEmbauche, 1800d, 2);
    	Technicien tech5 = new Technicien(null, null, "01234", dateEmbauche, 1800d, 2);
    	Technicien tech6 = new Technicien(null, null, null, dateEmbauche, 1800d, 2);
    	
    	Manager manager = new Manager(); 
    		
    	// team1: empty team
    	Set<Technicien> team1 = new HashSet<>();
    	manager.setEquipe(team1);
    	
    	// team2: team with one member
    	Set<Technicien> team2 = new HashSet<>();
    	manager.setEquipe(team2);
    	manager.ajoutTechnicienEquipe(tech1);
    	
    	// team3: team with two members
    	Set<Technicien> team3 = new HashSet<>();
    	manager.setEquipe(team3);
    	manager.ajoutTechnicienEquipe(tech1);
    	manager.ajoutTechnicienEquipe(tech2);
    	
    	// team4: team with three members who each one has just enough information to be considered as a technician
    	Set<Technicien> team4 = new HashSet<>();
    	manager.setEquipe(team4);
    	manager.ajoutTechnicienEquipe(tech3);
    	manager.ajoutTechnicienEquipe(tech4);
    	manager.ajoutTechnicienEquipe(tech5);
    	
    	// team5: team with one member BUT who is not recognized as a member so the team is in fact empty
    	Set<Technicien> team5 = new HashSet<>();
    	manager.setEquipe(team5);
    	manager.ajoutTechnicienEquipe(tech6);
 	
        return Arrays.asList(new Object[][]{
                {null, team1, 0d, 0},
                {null, team2, 0d, 1},
                {null, team3, 0d, 2},
                {null, team4, 0d, 3},
                {null, team5, 0d, 0},
                {-1000d, team1, 0d, 0},
                {-1000d, team2, 0d, 1},
                {-1000d, team3, 0d, 2},
                {-1000d, team4, 0d, 3},
                {-1000d, team5, 0d, 0},
                {0d, team1, 0d, 0},
                {0d, team2, 0d, 1},
                {0d, team3, 0d, 2},
                {0d, team4, 0d, 3},
                {0d, team5, 0d, 0},
                {1000d, team1, 1300d, 0},
                {1000d, team2, 1400d, 1},
                {1000d, team3, 1500d, 2},
                {1000d, team4, 1600d, 3},
                {1000d, team5, 1300d, 0},
        });
    }

    // Méthode permettant de lancer le test : 
    @Test
    public void testSetSalaire(){
        //Given
        Manager manager = new Manager();   
        //When
        manager.setEquipe(team);
        manager.setSalaire(inputSalary);
        Double resultSalary = manager.getSalaire();
        int resultTeamSize = manager.getEquipe().size();

        //Then
        Assertions.assertThat(resultSalary).isEqualTo(expectedSalary);
        Assertions.assertThat(resultTeamSize).isEqualTo(expectedTeamSize);
    }

}
