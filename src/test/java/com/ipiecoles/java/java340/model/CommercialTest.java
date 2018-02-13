package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.model.model.Commercial;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommercialTest{
    @Test
    public void testGetPrimeAnnuelleWithCANull(){
        //Given
        Commercial commercial =new Commercial();
        commercial.setCaAnnuel(null);

        //When
        Double prime = commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(500d);
    }

    @Test
    public void testGetPrimeAnnuelleWithCA(){
        //Given
        Commercial commercial =new Commercial();
        commercial.setCaAnnuel(5000d);

        //When
        Double prime = commercial.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(Math.max(Math.ceil(prime * 0.05), 500d));
    }
}