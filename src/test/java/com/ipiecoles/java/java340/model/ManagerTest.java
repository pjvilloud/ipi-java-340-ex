package com.ipiecoles.java.java340.model;

import java.util.HashSet;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;

public class ManagerTest {
@Test
public void testSetSalaireNominal() {
		//Given
		Manager manager =  new Manager("Dupond", "Jacques", "M12345", new LocalDate(), 2500d, new HashSet<>());
		
		//When
		manager.setSalaire(1500d);
		
		
		//Then
		Assertions.assertThat(manager.getSalaire()).isEqualTo(1950d);
		
	}

@Test
public void testSetSalaireNegatif() {
		//Given
		Manager manager =  new Manager("Dupond", "Jacques", "M12345", new LocalDate(), 2500d, new HashSet<>());
		
		//When
		manager.setSalaire(-1250d);
		
		
		//Then
		Assertions.assertThat(manager.getSalaire()).isEqualTo(-1625d);
		
	}

//TODO
public void testSetSalaireNull() {
		//Given
		Manager manager =  new Manager("Dupond", "Jacques", "M12345", new LocalDate(), 2500d, new HashSet<>());
		
		//When
		manager.setSalaire(-1250d);
		
		
		//Then
		Assertions.assertThat(manager.getSalaire()).isEqualTo(null);
		
	}

@Test
public void testGetPrimeAnnuelleNominal() {
		//Given
		Manager manager =  new Manager("Dupond", "Jacques", "M12345", new LocalDate(), 2000d, new HashSet<>());
		
		//When
		manager.getPrimeAnnuelle();
		
		//Then
		Assertions.assertThat(manager.getPrimeAnnuelle()).isEqualTo(new LocalDate().getYear()*0.5d);
		
	}

@Test
public void testGetPrimeAnnuelleAvecEquipe() {
		//Given
		Technicien pierreDurand = new Technicien("Durand", "Pierre", "C12345",new LocalDate(), 1500d, 0);
		Technicien jeanJacques = new Technicien("Jacques", "Jean", "C12346",new LocalDate(), 1500d, 0);
		Technicien jacquesDupond = new Technicien("Dupond", "Jacques", "C12347",new LocalDate(), 1500d, 0);
	
		Manager manager =  new Manager("Dupond", "Jacques", "M12345", new LocalDate(), 2000d, new HashSet<>());
		
		//When
		pierreDurand.setManager(manager);
		jeanJacques.setManager(manager);
		jacquesDupond.setManager(manager);
		HashSet<Technicien> equipe = new HashSet<Technicien>() {{
		    add(pierreDurand);
		    add(jeanJacques);
		    add(jacquesDupond);
		}};
		manager.setEquipe(equipe);
		//Then
		Assertions.assertThat(manager.getPrimeAnnuelle()).isEqualTo(new LocalDate().getYear()*0.5d+750d);
		
	}


@Test
public void testAugmenterSalaireNominal() {
		//Given
		Manager manager =  new Manager("Dupond", "Jacques", "M12345", new LocalDate(), 2500d, new HashSet<>());
		
		//When
		manager.augmenterSalaire(1d);
		
		//Then
		Assertions.assertThat(manager.getSalaire()).isEqualTo(5000d);
		
	}

@Test
public void testAugmenterSalaireManagerAvecEquipe() {
		//Given
		Technicien pierreDurand = new Technicien("Durand", "Pierre", "C12345",new LocalDate(), 1500d, 0);
		Manager manager =  new Manager("Dupond", "Jacques", "M12345", new LocalDate(), 2500d, new HashSet<>());
		
		//When
		HashSet<Technicien> equipe = new HashSet<Technicien>() {{
		    add(pierreDurand);
		}};
		manager.setEquipe(equipe);
		manager.augmenterSalaire(1d);
		
		//Then
		Assertions.assertThat(manager.getSalaire()).isEqualTo(5000d);
		
	}

@Test
public void testAugmenterSalaireTechnicienAvecEquipe() {
		//Given
		Technicien pierreDurand = new Technicien("Durand", "Pierre", "C12345",new LocalDate(), 1500d, 0);
		Manager manager =  new Manager("Dupond", "Jacques", "M12345", new LocalDate(), 2500d, new HashSet<>());
		
		//When
		HashSet<Technicien> equipe = new HashSet<Technicien>() {{
		    add(pierreDurand);
		}};
		manager.setEquipe(equipe);
		manager.augmenterSalaire(1d);
		
		//Then
		Assertions.assertThat(pierreDurand.getSalaire()).isEqualTo(3000d);
		
	}
}
