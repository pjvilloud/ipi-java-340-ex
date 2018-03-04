package com.ipiecoles.java.java340.repository;

import com.ipiecoles.java.java340.SpringWebApplication;
import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.Technicien;
import com.ipiecoles.java.java340.model.builder.CommercialBuilder;
import com.ipiecoles.java.java340.model.builder.TechnicienBuilder;
import com.ipiecoles.java.java340.model.maker.CommercialMaker;
import com.ipiecoles.java.java340.model.maker.TechnicienMaker;

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
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest(classes = SpringWebApplication.class)
public class EmployeRepositoryTest {

    @Autowired
    EmployeRepository employeRepository;

    Commercial pierreDurand, jeanJacques, jacquesDupond;
      

    @Before
    public void setUp() throws EmployeException {
        employeRepository.deleteAll();
        
        try{
        	pierreDurand = CommercialBuilder.aCommercial().withNom("Durand").withPrenom("Pierre").withSalaire(5000d).build();
        	jeanJacques = CommercialBuilder.aCommercial().withNom("Jacques").withPrenom("Jean").withSalaire(3000d).build();
        	jacquesDupond = CommercialBuilder.aCommercial().withNom("Dupond").withPrenom("Jacques").withSalaire(3000d).build();
        }catch (EmployeException e){};
        
        // Persistence
        pierreDurand = employeRepository.save(pierreDurand);
        jeanJacques = employeRepository.save(jeanJacques);
        jacquesDupond = employeRepository.save(jacquesDupond);
    }
  
    @After
    public void tearDown(){
        employeRepository.deleteAll();
    }
    
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
 
    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNom(){
        //Given

        //When
    	// ON recherche un durand en ignorant la case
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("durand");
        // on doit en trouver un
        Assertions.assertThat(employes).hasSize(1);
        // qui est contenu dans pierreDurand
        Assertions.assertThat(employes).contains(pierreDurand);
    }


    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNotFound(){
        //Given

        //When
    	// On recherche un toto
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("toto");
        // Normalement la liste de résultats doit etre vide
        Assertions.assertThat(employes).isEmpty();
    }
    
    
    /**
     * ----------------------------------------------------------------------------------------------------------------------
     * Partie evaluation 
     * ----------------------------------------------------------------------------------------------------------------------
     */
    
    /**
     *  Dans EmployeRepository on ne trouve pas findEmployePlusRiches() mais cependant EmployeRepository étend BaseEmployeRepository
     *  et c'est dans celui-ci que l'on trouve la méthode. 
     *  
     *  La méthode est donc: 
     *      @Query(value = "SELECT * FROM Employe WHERE salaire > (SELECT avg(e2.salaire) FROM Employe e2)", nativeQuery = true)
     *      List<T> findEmployePlusRiches();
     *  Il nous faut donc une liste de techniciens pour ce test. On va également utiliser un builder comme on l'avait fait pour Commercial
     *  
     */
    
      
}
