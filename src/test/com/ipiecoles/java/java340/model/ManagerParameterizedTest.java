package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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
                {null, null} //on part du principe que s'il n'y a pas d'équipe, la prime n'est pas calculée
        });
    }

    @Test
    public void testGetPrimeAnnuelle(){
        Manager manager = new Manager();

        try {
            manager.setEquipe(equipe);
            Double prime = manager.getPrimeAnnuelle();
            Assertions.assertThat(prime).isEqualTo(expectedPrime);

        } catch (NullPointerException e){
            Assertions.assertThat(e.getMessage()).isEqualTo(expectedPrime);
            Assertions.assertThat(expectedPrime).isNull();
        }
    }
}
