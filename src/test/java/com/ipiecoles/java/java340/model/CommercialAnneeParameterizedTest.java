package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.ipiecoles.java.java340.exception.EmployeException;

@RunWith(Parameterized.calss)
public class CommercialAnneeParameterizedTest {
	private static LocalDate now = LocalDate.now();
	private static LocalDate yesterday = now.minusDays(1);
	private static LocalDate tomorrow = now.plusDays(1);

	@Parameterized.Parameter(value = 0)
	LocalDate dateEmbaucheIn;
	
	@Parameterized.Parameter(value = 1)
	LocalDate dateEmbaucheExpected;
	
	@Parameterized.Parameters(name = "dateEmbaucheIn {0} set {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{now, now}, {yesterday, yesterday}, {tomorrow, null}
		});
	}
	
	@Test
	public void testSetDateEmbauche() throws EmployeException {
		//Given
		Employe commercial = CommercialMaker.aCommercial().build();
		
		//When
		try {
		commercial.setDateEmbauche(dateEmbaucheIn);
		//Then
		Assertions.assertThat(commercial.getDateEmbauche()).isEqualTo("La date d'embauche ne peut être postérieure à la date courante");
		} catch (EmployeException e) {
			Assertions.assertThat(dateEmbaucheExpected).isNull();
		}
			
	}
	
}
