package com.ipiecoles.java.java240.model;


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
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;


@RunWith(value=Parameterized.class)
public class CommercialAnneeParameterizedTest {
	
	private static LocalDate now=LocalDate.now();
	private static LocalDate yesterday= now.minusDays(1);
	private static LocalDate tomorrow= now.plusDays(1);
	
	@Parameter(value=0)
	LocalDate dateEmbauche;
	
	@Parameter(value=1)
	LocalDate dateEmbaucheExpected;
	
	@Parameters(name="dateEmbauche {0} set {1}")
	public static Collection<Object[]> Data() {
		return Arrays.asList(new Object[][] {
			{now,now}, {yesterday,yesterday}, {tomorrow,null}
		});
	}
	
	@Test
	public void testSetDateEmbauche() {
		//Given
		Employe commercial=new Commercial();
		
		LocalDate dateEmbauche=new LocalDate();
		
		//When
	    try {
			commercial.setDateEmbauche(dateEmbauche);
			//Then
			Assertions.assertThat(commercial.getDateEmbauche()).isEqualTo(dateEmbaucheExpected);
			Assertions.assertThat(dateEmbaucheExpected).isNotNull();
		} catch (EmployeException e) {
			Assertions.assertThat(e.getMessage()).isEqualTo("La date d'embauche ne peut être postérieure à la date courante");
			Assertions.assertThat(dateEmbaucheExpected).isNull();
		}finally {
			//
		}

	}	
}
