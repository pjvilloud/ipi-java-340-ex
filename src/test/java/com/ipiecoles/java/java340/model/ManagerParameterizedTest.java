package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.model.model.Entreprise;
import com.ipiecoles.java.java340.model.model.Manager;
import com.ipiecoles.java.java340.model.model.Technicien;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@RunWith(value = Parameterized.class)
public class ManagerParameterizedTest{

    @Parameterized.Parameter(value = 0)
    public Double pourcentage;

    @Parameterized.Parameter(value = 1)
    public Double managerSalaire;

    @Parameterized.Parameter(value = 2)
    public Double technicienSalaire;

    @Parameterized.Parameter(value = 3)
    public Double expectedSalaireManager;

    @Parameterized.Parameter(value = 4)
    public Double expectedSalaireTechnicien;

    @Parameterized.Parameters(name = "{index}: pourcentage {0} salaire manager {1} après augmentation {3} // salaire tech {2} apres augmentation {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0.05d, 2000d, 1500d, 2730d, 3150d},
                {0.1d, 2000d, 1500d, 2860.0000000000005d, 3300.0000000000005d},
                {0.2d, 2000d, 1500d, 3120d, 3600d}
        });
    }

    @Test
    public void testAugmenterSalaire() {
        //Given
        Manager manager = new Manager();
        manager.setSalaire(managerSalaire);

        Technicien technicien = new Technicien();
        technicien.setGrade(10);
        technicien.setSalaire(technicienSalaire);

        HashSet<Technicien> equipe = new HashSet<Technicien>();
        equipe.add(technicien);

        manager.setEquipe(equipe);

        //When
        manager.augmenterSalaire(pourcentage);

        //Then
        Assertions.assertThat(manager.getSalaire()).isEqualTo(expectedSalaireManager);
        Assertions.assertThat(technicien.getSalaire()).isEqualTo(expectedSalaireTechnicien);

    }
}