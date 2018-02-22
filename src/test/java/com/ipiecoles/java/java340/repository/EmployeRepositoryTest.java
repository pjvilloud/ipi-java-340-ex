package com.ipiecoles.java.java340.repository;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.After;
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

	 @Autowired
	    CommercialRepository commercialRepository;
	 

    Commercial pierreDurand = new Commercial("Durand", "Pierre", "C12345", new LocalDate(), 1500d, 0d,0);

    Commercial jeanJacques = new Commercial("Jacques", "Jean", "C12346", new LocalDate(), 1500d, 0d,0);

    Commercial jacquesDupond = new Commercial("Dupond", "Jacques", "C12347", new LocalDate(), 1500d, 0d,0);

    @Before
    public void setUp(){
        commercialRepository.deleteAll();
        employeRepository.deleteAll();
        employeRepository.save(pierreDurand);
        employeRepository.save(jeanJacques);
        employeRepository.save(jacquesDupond);
    }

   

    @Test
    public void testFindByNomOrPrenomAllIgnoreCasePrenom(){
        //Given

        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("pierre");
        //Then
        Assertions.assertThat(employes).hasSize(1);
        Assertions.assertThat(employes.get(0)).isEqualTo(pierreDurand);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNom(){
        //Given

        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("durand");
        //Then
        Assertions.assertThat(employes).hasSize(1);
        Assertions.assertThat(employes.get(0)).isEqualTo(pierreDurand);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNomPrenom(){
        //Given

        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("jacques");
        //Then
        Assertions.assertThat(employes).hasSize(2);
        Assertions.assertThat(employes).contains(jeanJacques, jacquesDupond);
    }
	

//Test de la méthode FindEmployesPlusRiches
	
    @Test
    public void testfindEmployesPlusRiches() {
    	//Given
    	
    	//When
    	List<Employe> liste = employeRepository.findEmployePlusRiches();
    	//Then
    	Assertions.assertThat(liste).contains(pierreDurand);
    	Assertions.assertThat(liste).contains(jeanJacques);
    	Assertions.assertThat(liste).hasSize(2);
    	
    }
    
    @Test
    public void testfindEmployesPlusRichesNull() {
    	//Given
    	
    	//When
    	List<Employe> liste = employeRepository.findEmployePlusRiches();
    	//Then
    	Assertions.assertThat(liste).isEmpty();
    	
    }

    @After
    public void tearDown(){
        employeRepository.deleteAll();
    }
}
