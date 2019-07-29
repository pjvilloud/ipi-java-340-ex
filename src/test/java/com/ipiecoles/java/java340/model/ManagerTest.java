package com.ipiecoles.java.java340.model;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;

public class ManagerTest {

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
	
	@Test
	public void TestManagerPourCommercialEtTechnicien() {
	
		//Given
		Manager manager = new Manager();
		Commercial commercial = new Commercial();
		Technicien technicien = new Technicien();
		
		manager.setNom("Mr Werewolf");
		manager.setPrenom("Huge Jackmann");
		commercial.setNom("Hanazono");
		commercial.setPrenom("Shizuma");
		technicien.setNom("Shingo");
		technicien.setPrenom("Uryuu");
		technicien.setGrade(1);
		
		Double salaireShingo = Math.ceil(1000d+Math.random()*1000d);
		Double salaireShizuma= Math.ceil(1000d+Math.random()*1000d+ Entreprise.PRIME_ANCIENNETE);

		
		
		technicien.setSalaire(salaireShingo);
		commercial.setSalaire(salaireShizuma);
		manager.setSalaire(salaireShingo + salaireShizuma);
		
		
		//When
		technicien.setManager(manager);
		commercial.setManager(manager);
		
		//Then
		Assertions.assertThat(technicien.getManager().getNom()).isEqualTo("Mr Werewolf");		
		Assertions.assertThat(technicien.getManager().getPrenom()).isEqualTo("Huge Jackmann");
		
		Assertions.assertThat(commercial.getManager().getPrenom()).isEqualTo("Huge Jackmann");
		Assertions.assertThat(commercial.getManager().getNom()).isEqualTo("Mr Werewolf");
		
		Assertions.assertThat(commercial.getManager()).isEqualTo(technicien.getManager());
		
		Assertions.assertThat(manager.getSalaire()).isGreaterThan(commercial.getSalaire()+technicien.getSalaire());
		
	}
	
	@Test
	public void TestManagerMalinCommeNabilla() {
	
		//Given
		Manager manager = new Manager();
		Commercial commercial = new Commercial();
		Technicien technicien = new Technicien();
		
		manager.setNom("Kardashiante");
		manager.setPrenom("Kim");
		commercial.setNom("Hanazono");
		commercial.setPrenom("Shizuma");
		technicien.setNom("Shingo");
		technicien.setPrenom("Uryuu");
		technicien.setGrade(1);
		
		
		
		
		
		
		
	}
	

}
