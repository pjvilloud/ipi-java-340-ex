package com.ipiecoles.java.java340.repository;
import java.util.List;


import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.ipiecoles.java.java340.SpringWebApplication;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;



@RunWith(SpringRunner.class)
//@DataJpaTest
/*si ca ne fonctionne pas avec l'annotation DataJpaTest mettre : */
@SpringBootTest(classes = SpringWebApplication.class)

public class EmployeRepositoryTest {


    Commercial pierreDurand = new Commercial("Durand", "Pierre", "C12345", new LocalDate(), 1500d, 1.5d,1);
    Commercial jeanJacques = new Commercial("Jacques", "Jean", "C12346", new LocalDate(), 2500d, 2.5d,2);
    Commercial jacquesDupond = new Commercial("Dupond", "Jacques", "C12347", new LocalDate(), 3500d, 3.5d,3);

    @Before
    public void setUp(){
        commercialRepository.deleteAll();
        employeRepository.deleteAll();
        employeRepository.save(pierreDurand);
        employeRepository.save(jeanJacques);
        employeRepository.save(jacquesDupond);
    }

    @Autowired
    EmployeRepository employeRepository;

    @Autowired
    CommercialRepository commercialRepository;

    @Test
    public void testFindByNomOrPrenomAllIgnoreCasePrenom(){

        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("pierre");
        Assertions.assertThat(employes).hasSize(1);
        Assertions.assertThat(employes.get(0)).isEqualTo(pierreDurand);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNom(){
    	
        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("durand");
        Assertions.assertThat(employes).hasSize(1);
        Assertions.assertThat(employes.get(0)).isEqualTo(pierreDurand);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNomPrenom(){

        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("jacques");
        Assertions.assertThat(employes).hasSize(2);
        Assertions.assertThat(employes).contains(jeanJacques, jacquesDupond);
    }

    @After
    public void tearDown(){
        employeRepository.deleteAll();
    }
    
    
    @Test
    public void findEmployesPlusRiches(){
    	
    	//Given
    	
    	//When
    	 Assertions.assertThat(employeRepository.findEmployePlusRiches().get(0)).isEqualTo(jacquesDupond);
    	
    	//Then
    }
}