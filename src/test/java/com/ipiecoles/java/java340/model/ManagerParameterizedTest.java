package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class ManagerParameterizedTest {
	
    @Parameterized.Parameter(value = 0)
    public Double pourcentage;

    @Parameterized.Parameter(value = 1)
    public Double salaire;

    @Parameterized.Parameters(name = "pourcentage {0} équivalent à {1}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {0.3d, 1690d},
                {0.5d, 1950d}
        });
    }
    
    @Test
    public void testAugmenterSalaire(){
        //Given
        Manager manager = new Manager();
        manager.setSalaire(1000d);
        manager.augmenterSalaire(pourcentage);

        //When
        Double RepSalaire = manager.getSalaire();

        //Then
        Assertions.assertThat(RepSalaire).isEqualTo(salaire);
    }
}