package com.ipiecoles.java340.repository.model;

import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ManagerParametrized {

    @Parameterized.Parameter(value = 0)
    public Double SalaireBase;
    @Parameterized.Parameter(value = 1)
    public Double salaireManger;



    @Parameterized.Parameters(name = "SalaireBase{0} est equivalent à {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0d,0d},
                {1500d,2100d},
                {1800d,2520d},
                {2000d,2800d},

        });
    }

     @Test
    public void testSetSalaireManager2Tech(){
        //given
         Manager manager = new Manager();
         Technicien technicien1 = new Technicien("Boubacar", "Seini", "T12345", new LocalDate(), 1500d, (int) 0d);
         manager.ajoutTechnicienEquipe(technicien1);

         manager.setSalaire(SalaireBase);
         Double SalaireManager = manager.getSalaire();
        //then

        Assertions.assertThat(SalaireManager).isEqualTo(salaireManger);


    }
}