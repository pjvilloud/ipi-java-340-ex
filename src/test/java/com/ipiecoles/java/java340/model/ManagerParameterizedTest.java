package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ManagerParameterizedTest {
	
	public Manager manager = new Manager("Berners Lee", "Tim", "00WWW", LocalDate.now(), 1000d, null);
	
	public Double technicianBaseSalary = 1000d;
	
	@Parameter(value = 0)
	public Double pourcentage;
	
	@Parameter(value = 1)
	public Integer equipSize;
	
	@Parameter(value = 2)
	public Double expectedSalary;
	
	@Parameters
	public static Collection<Object[]> data() {
	    return Arrays.asList(new Object[][]{
	    // Pourcentage / taille equipe / pourcentage 
	      {0.3d, 3, 1300d}, 
	      {0.5d, 2, 1500d},
	      {-0.3d, 1, 700d},
	      {-0.5d, 20, 500d}
	    });
	}
	
	@Test
	public void augmenterSalaireTestWithNormalValues() {
		setManagerTeamWithXTechniciens();
		
		manager.augmenterSalaire(pourcentage);
		
		Assertions.assertThat(manager.getSalaire()).isEqualTo(expectedSalary);
		for(Technicien technicien : manager.getEquipe()) {
			Assertions.assertThat(technicien.getSalaire()).isEqualTo(expectedSalary);
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void augmenterSalaireTestWithNullValues() {
		manager.setSalaire(null);
		manager.augmenterSalaire(pourcentage);
	}
	
	// Pour raison de lisibilité, je préfère ne pas instancier les equipes des managers comme suit :
	// Manager manager = new Manager("clement", "bey", "00AB", null, 1000d, 
	// new HashSet(Arrays.asList({new Technicien(param1, param2),new Technicien(param1, param2)})));
	public void setManagerTeamWithXTechniciens() {
		Integer i = Integer.valueOf(equipSize);
		HashSet<Technicien> equipeToSet = new HashSet<>();
		while(i > 0) {
			equipeToSet.add(new Technicien(""+i, null, null, null, technicianBaseSalary, null));
			i--;
		}
		manager.setEquipe(equipeToSet);
	}
}
