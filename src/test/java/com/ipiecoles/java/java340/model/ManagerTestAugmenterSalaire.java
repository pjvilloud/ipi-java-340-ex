package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.builder.ManagerBuilder;
import com.ipiecoles.java.java340.model.builder.TechnicienBuilder;
import com.ipiecoles.java.java340.model.maker.TechnicienMaker;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

public class ManagerTestAugmenterSalaire {


    Double salaireTechnicien = 1200d;
    Double expectedSalaireTechnicien = 2160d;// = grade : 5, 1728 = grade : 2
    Double salaireManager = 1000d;
    Double expectedSalaireManager = 1680d;
    Double pourcentage = 0.2d;
    public Manager manager;
    public Technicien technicien;

    @Before
    public void before() throws EmployeException {//Nom before arbitraire
        HashSet<Technicien> equipe = new HashSet<>();
        technicien = TechnicienMaker.aTechnicien().withSalaire(salaireTechnicien).build();
        equipe.add(technicien);
        manager = ManagerBuilder.aManager().build();
        manager.setEquipe(equipe);
        manager.setSalaire(salaireManager);
    }

    @Test
    public void testAugmenterSalaireManager() throws EmployeException {
        //Given
        //When
        manager.augmenterSalaire(pourcentage);

        //Then
        Assertions.assertThat(manager.getSalaire()).isEqualTo(expectedSalaireManager);
    }

    @Test
    public void testAugmenterSalaireTechnicien() throws EmployeException {
        //Given
        //When
        manager.augmenterSalaire(pourcentage);

        //Then
        Assertions.assertThat(technicien.getSalaire()).isEqualTo(expectedSalaireTechnicien);
    }
}
