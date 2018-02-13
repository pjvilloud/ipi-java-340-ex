package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.model.Commercial;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class CommercialTest {

    @Parameter(value = 0)
    public Integer performance;
    @Parameter(value = 1)
    public Note note;
    @Parameters(name = "performance {0} ; note {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {null,null},
            {0, Note.INSUFFISANT},
            {50, Note.INSUFFISANT},
            {100, Note.PASSABLE},
            {150, Note.BIEN},
            {200, Note.TRES_BIEN},
            {199, null}
        });
    }
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
        Assertions.assertThat(prime).isEqualTo(1000d);
    }

    @Test
    public void testGetPrimeAnnuelleWithCA9000() {
        //Given
        Commercial commercial = new Commercial();
        commercial.setCaAnnuel(9000d);
        //When
        Double prime = commercial.getPrimeAnnuelle();
        //Then
        Assertions.assertThat(prime).isEqualTo(500d);
    }

    @Test
    public void testEquivalenceNote() {
        //Given
        Commercial commercial = new Commercial();
        // When
        commercial.setPerformance(performance);
        //Then
        Assertions.assertThat(commercial.equivalenceNote()).isEqualTo(note);
    }
}
