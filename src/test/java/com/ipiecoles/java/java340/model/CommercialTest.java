package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommercialTest {
	
	@Test
	public void testPerformanceEquality() {
		//Given
		Integer perf = new Integer(3);
		Commercial commercial = new Commercial();
		commercial.setPerformance(2);
		//When
		Boolean test = commercial.performanceEgale(3);
		//Then
		Assertions.assertThat(test).isFalse();
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

    /**
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
    */
}
