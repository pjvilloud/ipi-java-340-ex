package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.ipiecoles.java.java340.exception.EmployeException;


@RunWith(value = Parameterized.class)
public class ManagerAugmenterSalaireParameterizedTest {
	
	 @Parameter(value = 0)
	 public Double pourcentage;
	 
	 @Parameter(value = 1)
	 public Double managerSalaire;
	 
	 @Parameter(value= 2)
	 public Double expectedManagerSalaire;
	 
	 @Parameters(name="{index}:pourcentage {0} salaire manager {1} attendu {2}")
	 public static Collection<Object[]> data() {
	      return Arrays.asList(new Object[][]{
	    	  {0.01d, 2000d, 2200d}, 
	    	  {0.1d, 2200d, 2440d}, 
	    	  {0.9d, 2500d, 4750d}
	      });
	      } 
	 
	 @Test
	 public void testAugmenterSalaire() {
		//GIVEN
		 Manager manager= new Manager();
		 manager.setSalaire(managerSalaire);
		 
		//WHEN
		 manager.augmenterSalaire(pourcentage);
		//THEN
		 Assertions.assertThat(manager.getSalaire()).isEqualTo(expectedSalaireManager);

		 
	 }
	 	
}