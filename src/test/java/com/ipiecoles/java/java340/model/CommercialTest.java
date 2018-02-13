package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class CommercialTest {

	@Test
	public void TestGetPrimeAnnuel() {
		//given 
		Commercial commercial= new Commercial();
		commercial.setCaAnnuel(null);
		//when 
		Double prime = commercial.getPrimeAnnuelle();
		
		//then
		Assertions.assertThat(prime).isEqualTo(500d);
		
	}
	
}
