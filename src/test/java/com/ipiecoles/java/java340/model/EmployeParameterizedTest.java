package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class EmployeParameterizedTest {

	@Parameter(value = 0)
	public Double pourcentage;
	@Parameter(value = 1)
	public Double  expectedAugmentation;
	
	@Parameters(name = "pourcentage {0} est valide : {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{0d, 1480.27}, 
			{1d, 2960.54},
			{2d, 5921.08},
		});
	}
	
	@Test
	public void testAugmenterSalaire() {
		//Given
		Employe emp = new Commercial();
		emp.setSalaire(expectedAugmentation);
		
		//When
		Double salaire = emp.getSalaire();
		
		//Then
		Assertions.assertThat(salaire).isEqualTo(expectedAugmentation);	
	} 
}

