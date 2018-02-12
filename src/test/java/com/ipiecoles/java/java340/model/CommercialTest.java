package com.ipiecoles.java.java340.model;



import org.assertj.core.api.Assertions; //Biblio d'assertions mieux que junit dnc à mettre aussi
import org.junit.Test;


public class CommercialTest {
	@Test
	//Les test sont tjs en class void
	public void testGetPrimeAnnuelleWithCANull(){
		//Given
		Commercial commercial = new Commercial();
		commercial.setCaAnnuel(null);
		
		//When
		Double prime = commercial.getPrimeAnnuelle();
		
		//Then
		Assertions.assertThat(prime).isEqualTo(500d);
		
		
	}
	
	@Test
	//Les test sont tjs en class void
	public void testGetMinimumPrimeAnnuelle(){
		//Given
		Commercial commercial = new Commercial();
		commercial.setCaAnnuel(250000d);
		
		//When
		Double prime = commercial.getPrimeAnnuelle();
		
		//Then
		Assertions.assertThat(prime).isEqualTo(1250d);
		
		
	}
}
