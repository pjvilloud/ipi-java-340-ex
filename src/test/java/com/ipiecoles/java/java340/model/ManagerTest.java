package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


public class ManagerTest {

    /*
     *
     *  Tests sans paramètres
     *
     *
     */


    @Test
    public void testAugmenterSalaireAvecPourcentageDixPourCent(){
        //Given
        Manager manager = new Manager();
        manager.setSalaire(1500d);
        Double salaireEntre = manager.getSalaire();
        //When
        manager.augmenterSalaire(0.1d);
        Double salaireResultat = manager.getSalaire();
        //Then
        Assertions.assertThat(salaireResultat).isEqualTo(salaireEntre*1.1d);
    }
}
