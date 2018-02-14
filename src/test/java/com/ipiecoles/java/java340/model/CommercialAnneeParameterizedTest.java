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
public class CommercialAnneeParameterizedTest {
	
	public static LocalDate now= LocalDate.now();
	public static LocalDate yesterday= now.minusDays(1);
	public static LocalDate tomorrow= now.plusDays(1);

	@Parameter(value=0)
	public LocalDate dateEmbauche;
	
	@Parameter(value=1)
	public LocalDate dateEmbaucheExpected;
	
	@Parameters (name= "dateEmbauche {0} set {1}")
	public static Collection<Object[]> data() {
	      return Arrays.asList(new Object[][]{
	    	  {now, now}, {yesterday, yesterday}, {tomorrow, tomorrow}
	      });
	      }
	
	@Test
	public void testSetDateEmbauche() {
		//GIVEN
	    Commercial commercial = new Commercial();
		//WHEN
	    try {
		 commercial.setDateEmbauche(dateEmbauche);
		//THEN
		Assertions.assertThat(commercial.getDateEmbauche()).isEqualTo(dateEmbauche);	
	    }
	    catch (EmployeException e) {
	    	Assertions.assertThat(e.getMessage()).isEqualTo("la date d'embauche peut être posterieurs");
	    	Assertions.assertThat(dateEmbaucheExpected).isNull();
	    }
	}
	

}
