package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)//org.junit.runners.Parameterized
public class CommercialParameterizedTest {

    @Parameterized.Parameter(value = 0)//org.junit.runners.Parameterized.Parameter
    public Integer perf;

    @Parameterized.Parameter(value = 1)//org.junit.runners.Parameterized.Parameter
    public Note ExNote;

    //org.junit.runners.Parameterized.Parameters
    @Parameterized.Parameters(name = "equi {0} {1} ")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {null,null}, {0,Note.INSUFFISANT},{100,Note.PASSABLE}
        });
    }

    @Test
    public void testEqui(){
        //Given
        Commercial commercial = new Commercial();
        commercial.setPerformance(perf);

        //when
        Note note = commercial.equivalenceNote();

        //then
        Assertions.assertThat(note).isEqualTo(ExNote);
    }
}
