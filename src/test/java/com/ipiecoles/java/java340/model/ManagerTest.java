package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.maker.TechnicienMaker;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RunWith(value = Parameterized.class)
public class ManagerTest {

    //Je ne savais pas trop quel salaire de base choisir pour un manager
    //J'ai hésité avec Entreprise.SALAIRE_BASE * Entreprise.INDICE_MANAGER
    //Finalement j'ai choisi le salaire de base, car la classe Manager ne change pas le salaire de base de sa classe mère Employé
    private Double salaireDeBaseEmploye = 1480.27d;
    Technicien tech1, tech2, tech3;

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
        //When
        manager.augmenterSalaire(0.1d);
        Double salaireResultat = manager.getSalaire();
        //Then
        Assertions.assertThat(salaireResultat).isEqualTo(salaireDeBaseEmploye *1.1d);
    }

    @Test
    public void testAugmenterSalaireAvecPourcentageZero(){
        //Given
        Manager manager = new Manager();
        //When
        manager.augmenterSalaire(0d);
        Double salaireResultat = manager.getSalaire();
        //Then
        Assertions.assertThat(salaireResultat).isEqualTo(salaireDeBaseEmploye);
    }

    @Test
    public void testAugmenterSalaireAvecPourcentageNull(){
        //Given
        Manager manager = new Manager();
        //When
        manager.augmenterSalaire(null);
        Double salaireResultat = manager.getSalaire();
        //Then
        Assertions.assertThat(salaireResultat).isEqualTo(salaireDeBaseEmploye);
    }

    @Test
    public void testAugmenterSalaireAvecPourcentageNegatif(){
        //Given
        Manager manager = new Manager();
        //When
        manager.augmenterSalaire(-.1d);
        Double salaireResultat = manager.getSalaire();
        //Then
        Assertions.assertThat(salaireResultat).isEqualTo(salaireDeBaseEmploye);
    }

    @Test
    public void testAugmenterSalaireAvecPourcentageSup1(){
        //Given
        Manager manager = new Manager();
        //When
        manager.augmenterSalaire(1.1d);
        Double salaireResultat = manager.getSalaire();
        //Then
        Assertions.assertThat(salaireResultat).isEqualTo(salaireDeBaseEmploye);
    }

    /*
     *
     *  Tests avec paramètres
     *
     *
     */

    @Parameterized.Parameter(value = 0)
    public Double salaireEnParametre;
    @Parameterized.Parameter(value = 1)
    public HashSet<Technicien> equipe;
    @Parameterized.Parameter(value = 2)
    public Integer sizeEquipe;
    @Parameterized.Parameter(value = 3)
    public Double salaireAttendu;
    @Parameterized.Parameters(name = "Salaire {0} ; sizeEquipe {2}")
    public static Collection<Object[]> data() throws EmployeException {
        Set<Technicien> set1 = new HashSet<>();

        Set<Technicien> set2 = new HashSet<>();
        set2.add(TechnicienMaker.aTechnicien().build());
        set2.add(TechnicienMaker.aTechnicien().withNom("Toto").build());
        set2.add(TechnicienMaker.aTechnicien().withNom("Tata").build());

        return Arrays.asList(new Object[][]{
                {null,null,0,Entreprise.SALAIRE_BASE},
                {1500d,null,0,1950d},
                {1500d, set1, 0, 1950d},
                {1500d, set2, 3, 2400d}
        });
    }

    @Test
    public void testSetSalaire(){
        //Given
        Manager manager = new Manager();
        manager.setEquipe(equipe);
        //When
        manager.setSalaire(salaireEnParametre);
        Double salaire = manager.getSalaire();
        //Then
        Assertions.assertThat(salaire).isEqualTo(salaireAttendu);
    }
}
