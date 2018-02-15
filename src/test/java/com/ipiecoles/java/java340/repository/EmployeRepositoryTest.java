package com.ipiecoles.java.java340.repository;
import java.util.List;


import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import com.ipiecoles.java.java340.SpringWebApplication;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;



@RunWith(SpringRunner.class)
@DataJpaTest
/*si ca ne fonctionne pas avec l'annotation DataJpaTest mettre : */
//@SpringBootTest(classes = SpringWebApplication.class)

public class EmployeRepositoryTest {

	Commercial pierreDurand,jeanJacques,jacquesDupond;

    @Before
    public void setUp(){

        employeRepository.deleteAll();
        
        pierreDurand = new Commercial("Durand", "Pierre", "C12345", new LocalDate(), 1200d, 0d,0);
        jeanJacques = new Commercial("Jacques", "Jean", "C12346", new LocalDate(), 1500d, 0d,0);
        jacquesDupond = new Commercial("Dupond", "Jacques", "C12347", new LocalDate(), 2000d, 0d,0);
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
        //Given

        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("pierre");
        Assertions.assertThat(employes).hasSize(1);
        Assertions.assertThat(employes.get(0)).isEqualTo(pierreDurand);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNom(){
        //Given

        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("durand");
        Assertions.assertThat(employes).hasSize(1);
        Assertions.assertThat(employes.get(0)).isEqualTo(pierreDurand);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNomPrenom(){
        //Given

        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("jacques");
        Assertions.assertThat(employes).hasSize(2);
        Assertions.assertThat(employes).contains(jeanJacques, jacquesDupond);
    }
    
    @Test
    public void testfindEmployePlusRiches() {
    	//Given
    	
    	//When
    	List<Employe> employes = employeRepository.findEmployePlusRiches();
    	Assertions.assertThat(employes).hasSize(1);
    	Assertions.assertThat(employes.get(0)).isEqualTo(jacquesDupond);
    }

    @After
    public void tearDown(){
        employeRepository.deleteAll();
    }
}