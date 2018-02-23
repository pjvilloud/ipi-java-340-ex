package com.ipiecoles.java.java340.repository;

import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.Technicien;
import com.ipiecoles.java.java340.model.builder.CommercialBuilder;
import com.ipiecoles.java.java340.model.builder.TechnicienBuilder;
import com.ipiecoles.java.java340.model.maker.TechnicienMaker;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeRepositoryTest {
    @Autowired
    EmployeRepository employeRepository;

    Commercial pierreDurandC, jeanJacquesC, jacquesDupontC;
    Technicien charlesXavierT, thomasPesquetT;

    @Before
    public void setUp() throws EmployeException{
        employeRepository.deleteAll();

        pierreDurandC = CommercialBuilder.aCommercial().withNom("Durand").withPrenom("Pierre").withSalaire(2600d).build();
        jeanJacquesC = CommercialBuilder.aCommercial().withNom("Jacques").withPrenom("Jean").withSalaire(1900d).build();
        jacquesDupontC = CommercialBuilder.aCommercial().withNom("Dupont").withPrenom("Jacques").withSalaire(1950d).build();
        charlesXavierT = TechnicienMaker.aTechnicien().withNom("Charles").withPrenom("Xavier").withSalaire(1650d).build();
        thomasPesquetT = TechnicienMaker.aTechnicien().withNom("Thomas").withPrenom("Pesquet").withSalaire(1500d).build();

        pierreDurandC = employeRepository.save(pierreDurandC);
        jeanJacquesC = employeRepository.save(jeanJacquesC);
        jacquesDupontC = employeRepository.save(jacquesDupontC);
        charlesXavierT = employeRepository.save(charlesXavierT);
        thomasPesquetT = employeRepository.save(thomasPesquetT);
    }

    @Test
    public void findByNomOrPrenomAllIgnoreCasePrenom(){
        //Given

        //When
        List<Employe> liste = employeRepository.findByNomOrPrenomAllIgnoreCase("jAcqueS");
        //Then
        Assertions.assertThat(liste).hasSize(2);
        Assertions.assertThat(liste).contains(jeanJacquesC, jacquesDupontC);
    }

    @Test
    public void findByNomOrPrenomAllIgnoreCaseNotFound(){
        //Given

        //When
        List<Employe> liste = employeRepository.findByNomOrPrenomAllIgnoreCase("toto");
        //Then
        Assertions.assertThat(liste).hasSize(0);
    }

    @Test
    public void findEmployePlusRichesWithFiveEmployees() {
        //Given

        //When
        List<Employe> liste = employeRepository.findEmployePlusRiches();
        //Then
        Assertions.assertThat(liste).hasSize(2);
        Assertions.assertThat(liste).contains(pierreDurandC,jacquesDupontC);
    }

    /*
        Etant donné que la méthode findEmployePlusRiches ne prend pas de paramètres,
        le seul moyen que j'ai trouvé de faire plus de 1 test, est de réinitiliaser la base
        de données dans les tests suivants
     */
    @Test
    public void findEmployePlusRichesWithNoEmployees() {
        //Given
        employeRepository.deleteAll();
        //When
        List<Employe> liste = employeRepository.findEmployePlusRiches();
        //Then
        Assertions.assertThat(liste).hasSize(0);
    }

    @Test
    public void findEmployePlusRichesWithOneEmployees() throws EmployeException{
        //Given
        employeRepository.deleteAll();
        thomasPesquetT = TechnicienMaker.aTechnicien().withNom("Thomas").withPrenom("Pesquet").withSalaire(1500d).build();
        thomasPesquetT = employeRepository.save(thomasPesquetT);
        //When
        List<Employe> liste = employeRepository.findEmployePlusRiches();
        //Then
        Assertions.assertThat(liste).hasSize(0);

        /*
            Au début, j'avais mis :
                Assertions.assertThat(liste).hasSize(1);
                Assertions.assertThat(liste).contains(thomasPesquetT);
            Mais le résultat attendu était une liste vide.
            Du coup je me suis dis que la raison était la logique métier :
            non pas >= moyenne comme je le pensais, mais > moyenne

         */
    }
}
