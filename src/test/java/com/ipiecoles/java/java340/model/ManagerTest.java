package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ManagerTest {
	
	@Test
	public void testSetSalaire1000() {
		//Given
		Manager manager = new Manager();
		Double salaire = 0d;
		
		//When
		manager.setSalaire(salaire);
		Double repSalaire = manager.getSalaire();
		
		//Then
		Assertions.assertThat(repSalaire).isEqualTo(salaire);
	}
}