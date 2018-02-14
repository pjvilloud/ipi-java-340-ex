package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.ipiecoles.java.java340.exception.EmployeException;

@RunWith(value = Parameterized.class)
public class CommercialAnneeParameterizedTest {

	private static LocalDate now = LocalDate.now();
	private static LocalDate yesderday = now.minusDays(1);
	private static LocalDate tomorrow = now.plusDays(1);
	
	@Parameterized.Parameter(value = 0)
	public LocalDate dateEmbaucheIn;
	
	@Parameterized.Parameter(value = 1)
	public LocalDate dateEmbaucheExpected;
	
	
	@Parameterized.Parameters(name = "dateEmbaucheIn {0} set {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{now,now}, 
			{yesderday, yesderday}, 
			{tomorrow, null}
			});
		}
	
	
	@Test
	public void testSetDateEmbauche() throws EmployeException{
		
		//Given
		Employe commercial = new Commercial();
		commercial.setDateEmbauche(LocalDate.now().minusMonths(3));
		
		//When
		try {
			
			commercial.setDateEmbauche(dateEmbaucheIn);
			
		//Then
			Assertions.assertThat(commercial.getDateEmbauche()).isEqualTo(dateEmbaucheExpected);
			Assertions.assertThat(dateEmbaucheExpected).isNotNull();
		}catch(EmployeException e) {
			Assertions.assertThat(e.getMessage()).isEqualTo("La date d'embauche est bidon");
		}finally {
			//yolo
		}
			
		}
		
		
	}
	
	

