package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommercialTest {
	
	// Pour vérifier que 2 performances sont différentes
	@Test
	public void testPerformanceNotEquals() {
		//Given
		Commercial commercial = new Commercial();
		commercial.setPerformance(2);
		//When
		Boolean test = commercial.performanceEgale(3);
		//Then
		Assertions.assertThat(test).isFalse();
		}

	// Si le chiffre d'affaire (CA) est nul alors la prime annuelle doit être égale à 500 euro
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
    
    // Si le chiffre d'affaire (CA) est non nul alors la prime annuelle doit être égale à 5% du chiffre d'affaire OU à 500 euro minimum
    @Test
    public void testGetPrimeAnnuelleWithBigCA() {
    	//Given
    	Commercial commercial = new Commercial();
    	commercial.setCaAnnuel(20000d);
    	//When
    	Double prime = commercial.getPrimeAnnuelle();
    	//Then
    	Assertions.assertThat(prime).isEqualTo(commercial.getCaAnnuel() * 0.05);
    	}
    

 // Si le chiffre d'affaire (CA) est non nul alors la prime annuelle doit être égale à 5% du chiffre d'affaire OU à 500 euro minimum = comme 0 est non nul et 0*5%=0, on obtient bien 500 euro
    @Test
    public void testgetPrimeAnnuelleWithCA0(){
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(0d);

        //When
        Double prime = commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(500d);

    }

 // Si le chiffre d'affaire (CA) est non nul alors la prime annuelle doit être égale à 5% du chiffre d'affaire OU à 500 euro minimum = 9000*5% = 450 euro donc on doit avoir 500 euro finalement
    @Test
    public void testgetPrimeAnnuelleWithCA9000(){
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(9000d);

        //When
        Double prime = commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(500d);

    }

 // Si le chiffre d'affaire (CA) est non nul alors la prime annuelle doit être égale à 5% du chiffre d'affaire OU à 500 euro minimum (5% de 100,000 = 5,000)
    @Test
    public void testgetPrimeAnnuelleWithCA100000(){
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(100000d);

        //When
        Double prime = commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(5000d);

    }
    
}
