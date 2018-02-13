package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommercialTest {

	@Test
	public void testGetPrimaAnnuelleWithCANull() {
		
		//Given
		Commercial commercial = new Commercial();
		commercial.setCaAnnuel(null);
		
		//When
		Double prime = commercial.getPrimeAnnuelle();
		
		//Then
		Assertions.assertThat(prime).isEqualTo(500d);
	}
	
	
	@Test
	public void testGetPrimeAnnuellePositive() {
		
		//Given
		Commercial commercial = new Commercial();
		commercial.setCaAnnuel(Math.random()*1000d);
		
		//When
		Double prime = commercial.getPrimeAnnuelle();
		
		//Then
		Assertions.assertThat(prime).isGreaterThan(0d);
	}
	
	
	@Test
	public void testGetPrimeAnnuelleMathMax() {
		
		//Si la prime supérieure à la prime minimale (500)
		//Given
		Commercial commercial = new Commercial();
		commercial.setCaAnnuel(1000000d);
		
		//When
		Double primeSup = commercial.getPrimeAnnuelle();
		
		//Then
		Assertions.assertThat(primeSup).isEqualTo(50000d);
		
		// Si la prime inférieure à la prime minimale (500)
		//Given
		commercial.setCaAnnuel(1d);
		
		//When
		Double prime500 = commercial.getPrimeAnnuelle();
		
		//Then
		Assertions.assertThat(prime500).isEqualTo(500d);
	}
	
	
	@Test
	public void equivalenceNoteTestUnique() {
		
		
		//Given
		Commercial commercial = new Commercial();
		commercial.setPerformance(100);
		
		//When
		Note performance = commercial.equivalenceNote();
		
		//Then
		Assertions.assertThat(performance).isEqualTo(Note.PASSABLE);
		
	}
}
