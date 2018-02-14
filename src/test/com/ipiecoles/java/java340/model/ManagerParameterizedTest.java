package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.*;

import org.joda.time.LocalDate;

@RunWith(value = Parameterized.class)
public class ManagerParameterizedTest {
    @Parameterized.Parameter(value = 0)
    public HashSet<Technicien> equipe;
    @Parameterized.Parameter(value = 1)
    public Double expectedPrime;
    @Parameterized.Parameters
    public static Collection<Object> data(){
        return Arrays.asList(new Object[][]{
                {new HashSet<>(), 1009d},
                {new HashSet<>(Arrays.asList(new Technicien("Wayne", "Bruce", "T12345", new LocalDate(), 1000d, 1))), 1259d},
                {null, 1009d}
        });
    }

    @Test
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
