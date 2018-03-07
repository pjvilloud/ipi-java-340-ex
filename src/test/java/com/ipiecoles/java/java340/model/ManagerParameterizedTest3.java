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
public class ManagerParameterizedTest3 {
	
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
	
	// Influencing parameter 1: the team
	@Parameterized.Parameter(value = 0)
	public Set<Technicien> team;
	// Expected parameter 1: the annual bonus
	@Parameterized.Parameter(value = 1)
	public Double annualBonus;
	// Expected parameter 2: the size of the team
	@Parameterized.Parameter(value = 2)
	public int teamSize;


    @Parameterized.Parameters(name = "The team is: {0}. Thus the expected annual bonus is {1} and the expected size of the team is: {2}")
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
                {team1, Entreprise.primeAnnuelleBase() + 0 * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN, 0},
                {team2, Entreprise.primeAnnuelleBase() + 1 * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN, 1},
                {team3, Entreprise.primeAnnuelleBase() + 2 * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN, 2},
                {team4, Entreprise.primeAnnuelleBase() + 3 * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN, 3},
                {team5, Entreprise.primeAnnuelleBase() + 0 * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN, 0}
        });
    }

    // Méthode permettant de lancer le test : 
    @Test
    public void testSetSalaire(){
		Manager manager = new Manager();
		//When
		manager.setEquipe(team);
        Double prime = manager.getPrimeAnnuelle();
        int finalTeamSize = manager.getEquipe().size();
        //Then
        Assertions.assertThat(prime).isEqualTo(annualBonus);
        Assertions.assertThat(finalTeamSize).isEqualTo(teamSize);
    }

}
