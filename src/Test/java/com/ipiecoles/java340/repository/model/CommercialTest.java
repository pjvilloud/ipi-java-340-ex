package com.ipiecoles.java340.repository.model;

import com.ipiecoles.java.java340.model.Commercial;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CommercialTest {
    @Test
    public void testGetPrimeAnnulleWithCAnnull(){
        //given
        Commercial commercial=new Commercial();
        commercial.setCaAnnuel(null);
        //when
        Double prime= commercial.getPrimeAnnuelle();
        //then
        Assertions.assertThat(prime).isEqualTo(500d);

    }
    @Test
    public void testGetPrimeAnnulleWithCAnnullZero(){
        //given
        Commercial commercial=new Commercial();
        commercial.setCaAnnuel(0d);
        //when
        Double prime= commercial.getPrimeAnnuelle();
        //then
        Assertions.assertThat(prime).isEqualTo(500d);

    }

    @Test
    public void testGetPrimeAnnulleWithCAnnull9000(){
        //given
        Commercial commercial=new Commercial();
        commercial.setCaAnnuel(9000d);
        //when
        Double prime= commercial.getPrimeAnnuelle();
        //then
        Assertions.assertThat(prime).isEqualTo(500d);

    }
    @Test
    public void testGetPrimeAnnulleWithCAnnull100000(){
        //given
        Commercial commercial=new Commercial();
        commercial.setCaAnnuel(100000d);
        //when
        Double prime= commercial.getPrimeAnnuelle();
        //then
        Assertions.assertThat(prime).isEqualTo(5000d);

    }
}
