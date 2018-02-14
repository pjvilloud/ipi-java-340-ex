package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@RunWith(value = Parameterized.class)
public class ManagerParameterizedNullTest {
    @Parameterized.Parameter(value = 0)
    public HashSet<Technicien> equipe;
    @Parameterized.Parameter(value = 1)
    public Double expectedPrime;
    @Parameterized.Parameters
    public static Collection<Object> data(){
        return Arrays.asList(new Object[][]{
                {null, 1009d}
        });
    }

    @Test(expected = NullPointerException.class)
    public void testGetPrimeAnnuelle(){
        //Given
        Manager manager = new Manager();
        manager.setEquipe(equipe);

        //When
        Double prime = manager.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(expectedPrime);
    }
}
