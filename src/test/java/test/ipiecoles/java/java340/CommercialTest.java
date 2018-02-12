package test.ipiecoles.java.java340;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.ipiecoles.java.java340.model.Commercial;

public class CommercialTest {
	
	@Test
	public void testGetPrimeAnnuelleWithCaNull() {
		//Given
		Commercial com = new Commercial();
		
		//When
		Double prime = com.getPrimeAnnuelle();
		
		//Then
		Assertions.assertThat(prime).isEqualTo(500.0);
	}
	
	@Test
	public void testGetPrimeAnnuelleWithCASup0Inf500() {
		//Given
		Commercial com = new Commercial();
		com.setCaAnnuel(499d);
		
		//When
		Double prime = com.getPrimeAnnuelle();
		
		//Then
		Assertions.assertThat(prime).isEqualTo(500d);;
	}
	

}
