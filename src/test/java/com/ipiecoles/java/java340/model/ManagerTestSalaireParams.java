package com.ipiecoles.java.java340.model;
import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.builder.ManagerBuilder;
import com.ipiecoles.java.java340.model.builder.TechnicienBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.lang.Double;

@RunWith(value = Parameterized.class)//org.junit.runners.Parameterized
public class ManagerTestSalaireParams {

    @Parameterized.Parameter(value = 0)//org.junit.runners.Parameterized.Parameter
    public Double salaire;

    @Parameterized.Parameter(value = 1)//org.junit.runners.Parameterized.Parameter
    public Double expectedSalaire;

    //org.junit.runners.Parameterized.Parameters
    @Parameterized.Parameters(name = "Salaire {0} calcul {1} ")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1000d,1400d},{1200d,1680d},{0d,0d}
        });
    }

    @Test
    public void testSalaireOkParams() throws EmployeException {
        //Given
        HashSet<Technicien> equipe = new HashSet<>();
        Technicien technicien = TechnicienBuilder.aTechnicien().withGrade(2).withSalaire(salaire).build();
        equipe.add(technicien);
        Manager manager = ManagerBuilder.aManager().build();
        manager.setEquipe(equipe);

        //When
        manager.setSalaire(salaire);

        //Then
        Assertions.assertThat(manager.getSalaire()).isEqualTo(expectedSalaire);
    }
}
