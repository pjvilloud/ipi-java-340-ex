package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ManagerTest {
	
	
	@Test
	public void testAugmenterSalaire() {
		
		
		//Given
		Manager manager = new Manager();
		
		manager.setSalaire(1000d);
		manager.augmenterSalaire(10d);
		
		
		//When
		Double salaire = manager.getSalaire();
		
		//Then
		Assertions.assertThat(salaire).isEqualTo(1100d);
	}
	
}
