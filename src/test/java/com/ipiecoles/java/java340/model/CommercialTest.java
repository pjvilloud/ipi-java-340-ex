package com.ipiecoles.java.java340.model;
import org.assertj.core.api.*;
import org.junit.Test;

public class CommercialTest {

	@Test
	public void testGetPrimeAnnuelleWithCANull() {
		//Given
		Commercial commercial =  new Commercial();
		commercial.setCaAnnuel(null);
		
		//When
		Double prime = commercial.getPrimeAnnuelle();
		
		
		//Then
		Assertions.assertThat(prime).isEqualTo(50d);
		
	}
}
