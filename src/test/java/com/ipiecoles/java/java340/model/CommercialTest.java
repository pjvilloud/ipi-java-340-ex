package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.model.Commercial;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommercialTest {

    @Test
    public void testPerformanceNotEquals() {
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
}
