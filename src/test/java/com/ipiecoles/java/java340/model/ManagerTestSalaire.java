package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.builder.ManagerBuilder;
import com.ipiecoles.java.java340.model.builder.TechnicienBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import java.util.HashSet;
import java.lang.Double;

public class ManagerTestSalaire {
    @Test
    public void testSalaireOk() throws EmployeException {
        //Given
        HashSet<Technicien> equipe = new HashSet<>();
        Technicien technicien = TechnicienBuilder.aTechnicien().withGrade(2).withSalaire(1000d).build();
        equipe.add(technicien);
        Manager manager = ManagerBuilder.aManager().build();
        manager.setEquipe(equipe);
        Double salaire = 1000d;
        Double expectedSalaire = 1400d;

        //When
        manager.setSalaire(salaire);

        //Then
        Assertions.assertThat(manager.getSalaire()).isEqualTo(expectedSalaire);
    }

}
