import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Note;

@RunWith(value = Parameterized.class)//org.junit.runners.Parameterized
	public class CommercialParameterizedTest {
	  /*@Parameter(value = 0)//org.junit.runners.Parameterized.Parameter
	  public double caAnnuel;
	  @Parameter(value = 1) 
	  public double resultat; 
	  
	  //org.junit.runners.Parameterized.Parameters
	  @Parameters(name = "caAnnuel {0} est égal à une prime de {1}")
	  public static Collection<Object[]> data() {
	      return Arrays.asList(new Object[][]{
	        {null, 500d}, {0d, 500d}, {10000d, 500d}, {100000d, 500d}
	      });
	  }*/
	  
	  
	  @Parameter(value = 0)
	  public Integer perf; 
	  @Parameter(value = 1)
	  public Note expectedNote;
	  
	  //org.junit.runners.Parameterized.Parameters
	  @Parameters(name = "la performance {2} équivaut à une note de {3}")
	  public static Collection<Object[]> data2() {
	      return Arrays.asList(new Object[][]{
	        {0, Note.INSUFFISANT}, 
	        {50, Note.INSUFFISANT}, 
	        {100, Note.PASSABLE},
	        {150, Note.BIEN},
	        {200, Note.TRES_BIEN}
	      });
	  }
	  
	  @Test
	  public void testEquivalenceNote() {
		  Commercial commercial = new Commercial(); 
		  commercial.setPerformance(perf);
		  Note note = commercial.equivalenceNote(); 
		  Assertions.assertThat(note).isEqualTo(expectedNote);
	  }

	  /*@Test
	  public void testerPrimeAnnuelleWithCA(){
	      //Given, When, Then
			Commercial commercial = new Commercial();
			commercial.setCaAnnuel(caAnnuel);
			Double prime = commercial.getPrimeAnnuelle(); 
	      Assertions.assertThat(prime).isEqualTo(resultat);
	      
	  }*/

}
