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
    public void findEmployePlusRichesWith5Employees() {
        //Given

        //When
        List<Employe> liste = employeRepository.findEmployePlusRiches();
        //Then
        Assertions.assertThat(liste).hasSize(2);
        Assertions.assertThat(liste).contains(pierreDurandC,jacquesDupontC);

    }
}
