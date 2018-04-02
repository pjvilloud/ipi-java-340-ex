package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;



public class EmployeTest {

	@Test
	public void testAugmenterSalaireWithPourcentageNull () {
		//Given
		Employe com = new Commercial();
		com.augmenterSalaire(0d); 
		
		//When
		Double salaire = com.getSalaire();
				
		//Then 
		Assertions.assertThat(salaire).isEqualTo(1480.27);
	}
	
	@Test
	public void testAugmenterSalaireWithPourcentage100 () {
		//Given
		Employe com = new Commercial();
		com.augmenterSalaire(1d); 
		
		//When
		Double salaire = com.getSalaire();
				
		//Then 
		Assertions.assertThat(salaire).isEqualTo(2960.54);
	}
	
	@Test
	public void testSetSalaireNull () {
		//Given
		Employe com = new Commercial();
		com.setSalaire(0d); 
		
		//When
		Double salaire = com.getSalaire();
				
		//Then 
		Assertions.assertThat(salaire).isEqualTo(0d);
	}
		
	@Test
	public void testSetSalaireSup () {
		//Given
		Employe com = new Commercial();
		com.setSalaire(1500d); 
		
		//When
		Double salaire = com.getSalaire();
				
		//Then 
		Assertions.assertThat(salaire).isEqualTo(1500d);
	}
	
}
