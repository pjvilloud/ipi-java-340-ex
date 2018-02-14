package com.ipiecoles.java.java240.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.ipiecoles.java.java340.model.Commercial;



public class CommercialTest {
	
	//Cas au limites et cas "dans la norme"
	
	@Test
	public void testGetPrimeAnnuelleWithCANull() {
		
		//Given
		
		Commercial commercial = new Commercial();
		commercial.setCaAnnuel(null);
		
		//When
		
		Double prime = commercial.getPrimeAnnuelle();
		
		
		
		//Then
		
		Assertions.assertThat(prime).isEqualTo(500d);
	}
	
	@Test
	public void testGetPrimeAnnuelleWithCA0() {
		
		//Given
		
		Commercial commercial = new Commercial();
		commercial.setCaAnnuel(0d);
		
		//When
		
		Double prime = commercial.getPrimeAnnuelle();
		
		
		
		//Then
		
		Assertions.assertThat(prime).isEqualTo(500d);
	} 
	
	
	@Test
	public void testGetPrimeAnnuelleWithCA100000() {
		
		//Given
		
		Commercial commercial = new Commercial();
		commercial.setCaAnnuel(100000d);
		
		//When
		
		Double prime = commercial.getPrimeAnnuelle();
		
		
		
		//Then
		
		Assertions.assertThat(prime).isEqualTo(500d);
	} 
	
	
	@Test
	public void testGetPrimeAnnuelleWithCA9000() {
		
		//Given
		
		Commercial commercial = new Commercial();
		commercial.setCaAnnuel(9000d);
		
		//When
		
		Double prime = commercial.getPrimeAnnuelle();
		
		
		
		//Then
		
		Assertions.assertThat(prime).isEqualTo(5000d);
	}
	
	
	
	

}
