package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.model.model.Manager;
import com.ipiecoles.java.java340.model.model.Technicien;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

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

    @Parameterized.Parameters(name = "{index}: pourcentage {0} salaire manager {1}  // salaire tech {2} // après augmentation {3} // apres augmentation {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0.05d, 1900d, 1600d,2992.5d, 1848.0000000000002d},
                {0.1d, 1900d, 1600d,3135.0000000000005d, 1936.0000000000005d},
                {0.2d, 1900d, 1600d,3420.0d, 2112.0d},
                {0.3d, 1900d, 1600d,3705.0d, 2288.0000000000005d}
        });
    }

    @Test
    public void testAugmenterSalaire() {
        //Given
        Manager m = Maker.makeManager(1);
        m.setSalaire(managerSalaire);

        Technicien tech1 = (Technicien) m.getEquipe().toArray()[0];
        //Technicien tech2 = (Technicien) m.getEquipe().toArray()[1];

        tech1.setSalaire(technicienSalaire);

        //When
        m.augmenterSalaire(pourcentage);

        //Then
        Assertions.assertThat(m.getSalaire()).isEqualTo(expectedSalaireManager);
        Assertions.assertThat(tech1.getSalaire()).isEqualTo(expectedSalaireTechnicien);
    }
}