import java.util.Arrays;


import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value = Parameterized.class)
public class CommercialAnneeParameterisedTest {
	
	private static LocalDate now = LocalDate.now();
	private static LocalDate yesterday = now.minusDays(1);
	private static LocalDate tomorrow = now.plusDays(1);
	
	@Parameterized.Parameter(value = 0)
	LocalDate dateEmbaucheIn;
	/* C'est la date d'embauche qu'on met en point d'entrée */
	
	
	@Parameterized.Parameter(value = 1)
	LocalDate dateEmbaucheExpected;
	/*C'est la date d'sembauche qu'on attend */
	
	@Parameterized.Parameters(name = "dateEmbaucheIn {0} set {1}")
	public static Collection<Object[]> data() {
	 return Arrays.asList(new Object[][] {
			 {now,now}, {yesterday, yesterday}, {tomorrow, null}
	 });
	}
	
	/* Ici on teste que la fonction SetDateEmbauche effectue bien la verification que la date d'embauche est postérieure à la date du jour
	 * sinon on leve une exception */
	@Test
	public void testSetDateEmbauche() throws EmployeException {
		//Given
		Employe commercial = new Commercial();	
		/*On crée un nouveau commercial auquel on affecte une nouvelle date d'embauche en utilisant les paramètres */
		
		//When
		try {
			commercial.setDateEmbauche(dateEmbaucheIn);
		//Then
			Assertions.assertThat(commercial.getDateEmbauche()).isEqualTo(dateEmbaucheIn);
			Assertions.assertThat(dateEmbaucheExpected).isNotNull();
			
		} catch (EmployeException e) {
			Assertions.assertThat(e.getMessage()).isEqualTo("La date d'embauche ne peut être postérieure à la date courante");
			Assertions.assertThat(dateEmbaucheExpected).isNull();
		}
	}
}


