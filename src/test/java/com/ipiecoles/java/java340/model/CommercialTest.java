package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.model.Commercial;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommercialTest {

    @Test
    public void testGetPrimAnnuelleWithZeroCaAnnuel(){

        Commercial commercial = new Commercial();

        Double result = commercial.getPrimeAnnuelle();

        Assertions.assertThat(result).isEqualTo(500d);
    }

    @Test
    public void testgetPrimeAnnuellewithCaAnnuel(){
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(250000d);

        Double result = commercial.getPrimeAnnuelle();

        Assertions.assertThat(result).isEqualTo(12500d);
    }

}