package com.ipiecoles.java.java340.repository;

import com.ipiecoles.java.java340.SpringWebApplication;
import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.builder.CommercialBuilder;
import com.ipiecoles.java.java340.model.maker.CommercialMaker;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest(classes = SpringWebApplication.class)
public class EmployeRepositoryTest {

    @Autowired
    EmployeRepository employeRepository;

    Commercial pierreDurand, jeanJacques, jacquesDupond;

    @Before
    public void setUp() {//throws EmployeException {
        employeRepository.deleteAll();
        //pierreDurand = new Commercial("Durand", "Pierre", "C12345", new LocalDate(), 1500d, 0d,0);
        //jeanJacques = new Commercial("Jean-Jacques", "Jean", "C12346", new LocalDate(), 1500d, 0d,0);
        //jacquesDupond = new Commercial("Dupond", "Jean-Jacques", "C12347", new LocalDate(), 1500d, 0d,0);

        pierreDurand = new Commercial();
        jeanJacques = new Commercial();
        jacquesDupond = new Commercial();
        
        pierreDurand.setPrenom("Pierre");
        pierreDurand.setNom("Durand");
        jeanJacques.setPrenom("Jean");
        jeanJacques.setNom("Jacques");
        jacquesDupond.setPrenom("Jacques");
        jacquesDupond.setNom("Dupont");
        
        pierreDurand = employeRepository.save(pierreDurand);
        jeanJacques = employeRepository.save(jeanJacques);
        jacquesDupond = employeRepository.save(jacquesDupond);
    }

    /***
    @After
    public void tearDown(){
        employeRepository.deleteAll();
    }
    */

    @Test
    public void testFindByNomOrPrenomAllIgnoreCasePrenom(){
        //Given

        //When
        //List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("pierre");
    	// On cherche comme nom OU prenom un jAcqueS mais on ignore la case
    	List<Employe> liste = employeRepository.findByNomOrPrenomAllIgnoreCase("jAcqueS");

        //Then
        //Assertions.assertThat(employes).hasSize(1);
        //Assertions.assertThat(employes).contains(pierreDurand);
    	// techniquement on doit donc trouver 2 réponses
    	Assertions.assertThat(liste).hasSize(2);
    	// Les deux réponses sont normalement les suivantes : 
    	Assertions.assertThat(liste).contains(jeanJacques,jacquesDupond);

    }

    /**
    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNom(){
        //Given

        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("durand");
        Assertions.assertThat(employes).hasSize(1);
        Assertions.assertThat(employes).contains(pierreDurand);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNomPrenom(){
        //Given

        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("Jean-jacques");
        Assertions.assertThat(employes).hasSize(2);
        Assertions.assertThat(employes).contains(jeanJacques, jacquesDupond);
    }
    **/

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNotFound(){
        //Given

        //When
    	// On recherche un toto
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("toto");
        // Normalement la liste de résultats doit etre vide
        Assertions.assertThat(employes).isEmpty();
    }
}
