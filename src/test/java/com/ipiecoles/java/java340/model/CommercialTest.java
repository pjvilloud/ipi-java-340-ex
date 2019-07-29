
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
	
	
	@Tes
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
  
  @Test
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
    public void getPrimeAnnuelleWithCA0(){
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(0d);

        //When
        Double prime = commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(500d);

    }

    @Test
    public void getPrimeAnnuelleWithCA9000(){
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(9000d);

        //When
        Double prime = commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(500d);

    }

    @Test
    public void getPrimeAnnuelleWithCA100000(){
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(100000d);

        //When
        Double prime = commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(5000d);

    }
}
