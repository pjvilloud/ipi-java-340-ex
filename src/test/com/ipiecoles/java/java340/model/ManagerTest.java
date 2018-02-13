package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;

public class ManagerTest {
    @Test //sans équipe
    public void testSetSalaire(){
        //Given
        //Je crée un manager avec salaire de base à 1000 et pas d'équipe
        Manager manager = new Manager("John", "Doe", "M12345", new LocalDate(), 1000d, new HashSet<>());

        //When
        manager.setSalaire(1000d);

        //Then
        Double sal = manager.getSalaire();
        Assertions.assertThat(sal).isEqualTo(1300);
    }

    @Test // salaire = 0
    public void testSetSalaireZero(){
        //Given
        Manager manager = new Manager("John", "Doe", "M12345", new LocalDate(), 0d, new HashSet<>());

        //When
        manager.setSalaire(0d);

        //Then
        Double sal = manager.getSalaire();
        Assertions.assertThat(sal).isEqualTo(0);
    }

    @Test(expected = NullPointerException.class) // équipe null
    public void testSetSalaireSansEquipe(){
        //Given
        Manager manager = new Manager("John", "Doe", "M12345", new LocalDate(), 1000d, null);

        //When
        manager.setSalaire(1000d);

        //Then
        Double sal = manager.getSalaire();
        Assertions.assertThat(sal).isEqualTo(null);
    }

    @Test(expected = NullPointerException.class) // salaire null
    public void testSetSalaireSalaireNull(){
        //Given
        Manager manager = new Manager("John", "Doe", "M12345", new LocalDate(), null, new HashSet<>());

        //When
        manager.setSalaire(null);

        //Then
        Double sal = manager.getSalaire();
        Assertions.assertThat(sal).isEqualTo(null);
    }

}
