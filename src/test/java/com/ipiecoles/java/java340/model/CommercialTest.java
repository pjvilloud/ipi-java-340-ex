package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommercialTest {

    @Test
    public void testGetPrimeAnnuelleWithCANull() {
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(null);
        //When
        Double primeAnnuelle = commercial.getPrimeAnnuelle();
        //then
        Assertions.assertThat(primeAnnuelle).isEqualTo(500D);

    }
}