package com.ipiecoles.java.java340.model;
import org.assertj.core.api.Assertions;
import org.junit.Test;


public class CommercialTest {
	
	@Test
	public void testGetPrimeAnnuelleWithCANull() {
		//GIVEN
		Commercial commercial  = new Commercial();
		commercial.setCaAnnuel(null);
		//WHEN
		Double prime = commercial.getPrimeAnnuelle();
		//THEN
		Assertions.assertThat(prime).isEqualTo(500d);
	}
	
	@Test
	public void testGetPrimeAnnuelleWithCA0() {
		//GIVEN
		Commercial commercial  = new Commercial();
		commercial.setCaAnnuel(0d);
		//WHEN
		Double prime = commercial.getPrimeAnnuelle();
		//THEN
		Assertions.assertThat(prime).isEqualTo(500d);
	}
	
	
	@Test
	public void testGetPrimeAnnuelleWithCA9000() {
		//GIVEN
		Commercial commercial  = new Commercial();
		commercial.setCaAnnuel(9000d);
		//WHEN
		Double prime = commercial.getPrimeAnnuelle();
		//THEN
		Assertions.assertThat(prime).isEqualTo(500d);
	}
	


}
