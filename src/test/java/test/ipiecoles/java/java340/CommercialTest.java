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
	public void testGetPrimeAnnuelleWithCASup10000() {
		//Given
		Commercial com = new Commercial();
		com.setCaAnnuel(10001d);
		
		//When
		Double prime = com.getPrimeAnnuelle();
		
		//Then
		Assertions.assertThat(prime).isNotEqualTo(500d);
	}
	
	@Test
	public void testGetPrimeAnnuelleWithCAInf0() {
		//Given
		Commercial com = new Commercial();
		com.setCaAnnuel(-100d);
		
		//When
		Double prime = com.getPrimeAnnuelle();
		
		//Then
		Assertions.assertThat(prime).isEqualTo(500d);
	}
	
	@Test
	public void testGetPrimeAnnuelleWithCABetween0And10000() {
		//Given
		Commercial com = new Commercial();
		com.setCaAnnuel(100d);
		
		//When
		Double prime = com.getPrimeAnnuelle();
		
		//Then
		Assertions.assertThat(prime).isEqualTo(500d);
	}
	
	@Test
	public void testGetPrimeAnnuelleWithCATooBig() {
		//Given
		Commercial com = new Commercial();
		com.setCaAnnuel(Double.MAX_VALUE*2);
		
		//When
		Double prime = com.getPrimeAnnuelle();
		
		//Then
		Assertions.assertThat(prime).isEqualTo(Double.MAX_VALUE*2*0.05);
	}
	

}
