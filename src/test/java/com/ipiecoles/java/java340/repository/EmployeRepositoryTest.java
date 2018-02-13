package com.ipiecoles.java.java340.repository;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.Note;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeRepositoryTest {
    @Autowired
    EmployeRepository employeRepository;

    Commercial pierreDurand, jeanJacques, jacquesDupont;

    @Before
    public void setUp() {
        employeRepository.deleteAll();

        pierreDurand = new Commercial();
        jeanJacques = new Commercial();
        jacquesDupont = new Commercial();

        pierreDurand.setPrenom("Pierre");
        pierreDurand.setNom("Durand");
        jeanJacques.setPrenom("Jean");
        jeanJacques.setNom("Jacques");
        jacquesDupont.setPrenom("Jacques");
        jacquesDupont.setNom("Dupont");

        pierreDurand = employeRepository.save(pierreDurand);
        jeanJacques = employeRepository.save(jeanJacques);
        jacquesDupont = employeRepository.save(jacquesDupont);
    }

    @Test
    public void findByNomOrPrenomAllIgnoreCasePrenom(){
        //Given

        //When
        List<Employe> liste = employeRepository.findByNomOrPrenomAllIgnoreCase("jAcqueS");
        //Then
        Assertions.assertThat(liste).hasSize(2);
        Assertions.assertThat(liste).contains(jeanJacques,jacquesDupont);


//        //Given
//
//        //When
//        List<Employe> liste = employeRepository.findByNomOrPrenomAllIgnoreCase("piErRe");
//        //Then
//        Assertions.assertThat(liste).hasSize(1);
//        Assertions.assertThat(liste).contains(pierreDurand);
    }

    @Test
    public void findByNomOrPrenomAllIgnoreCaseNotFound(){
        //Given

        //When
        List<Employe> liste = employeRepository.findByNomOrPrenomAllIgnoreCase("toto");
        //Then
        Assertions.assertThat(liste).hasSize(0);
    }
}
