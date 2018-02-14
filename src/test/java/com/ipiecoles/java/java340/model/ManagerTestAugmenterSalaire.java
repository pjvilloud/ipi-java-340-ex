package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.builder.ManagerBuilder;
import com.ipiecoles.java.java340.model.builder.TechnicienBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.HashSet;

public class ManagerTestAugmenterSalaire {
    @Test
    public void testAugmenterSalaire() throws EmployeException {
        //Given
        HashSet<Technicien> equipe = new HashSet<>();
        Technicien technicien = TechnicienBuilder.aTechnicien().withGrade(2).withSalaire(1200d).build();
        equipe.add(technicien);
        Manager manager = ManagerBuilder.aManager().build();
        manager.setEquipe(equipe);
        manager.setSalaire(1000d);
        Double pourcentage = 0.2d;
        Double expectedSalaire = 1680d;
        //When
        manager.augmenterSalaire(pourcentage);

        //Then
        Assertions.assertThat(manager.getSalaire()).isEqualTo(expectedSalaire);
    }
}
