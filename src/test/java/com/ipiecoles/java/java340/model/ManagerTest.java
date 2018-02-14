package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.model.model.Entreprise;
import com.ipiecoles.java.java340.model.model.Manager;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ManagerTest{

    @Test
    public void testSetSalaire(){
        //Given
        Manager manager =new Manager();
        //When
        Double salaire = 500d;
        manager.setSalaire(salaire);
        //Then
        Assertions.assertThat(manager.getSalaire()).isEqualTo(salaire * Entreprise.INDICE_MANAGER + (salaire * (double)manager.getEquipe().size() / 10));
    }

    @Test
    public void testAugmenterSalaire(){
        //Given
        Manager manager =new Manager();
        //When
        Double pourcentage = 100d;
        manager.augmenterSalaire(pourcentage);

        Double newSalaire = manager.getSalaire();
        //Then
        Assertions.assertThat(manager.getSalaire()).isEqualTo(newSalaire);
    }

    @Test
    public void testGetPrimeAnnuelleWithCANull(){
        //Given
        Manager manager =new Manager();
        //When
        Double prime = manager.getPrimeAnnuelle();
        //Then
        Assertions.assertThat(prime).isEqualTo(Entreprise.primeAnnuelleBase() + manager.getEquipe().size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN);
    }
}