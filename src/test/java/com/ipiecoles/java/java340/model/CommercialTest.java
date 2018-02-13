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

    @Test
    public void testGetPrimeAnnuelleWithCA0() {
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(0d);
        //When
        Double primeAnnuelle = commercial.getPrimeAnnuelle();
        //then
        Assertions.assertThat(primeAnnuelle).isEqualTo(500D);


    }

    @Test
    public void testGetPrimeAnnuelleWithCA9000() {
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(9000d);
        //When
        Double primeAnnuelle = commercial.getPrimeAnnuelle();
        //then
        Assertions.assertThat(primeAnnuelle).isEqualTo(500D);


    }
    @Test
    public void testGetPrimeAnnuelleWithCA100000() {
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(100000d);
        //When
        Double primeAnnuelle = commercial.getPrimeAnnuelle();
        //then
        Assertions.assertThat(primeAnnuelle).isEqualTo(5000D);

    }




}