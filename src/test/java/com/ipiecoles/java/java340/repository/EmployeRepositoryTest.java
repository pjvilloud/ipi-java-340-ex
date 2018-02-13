package com.ipiecoles.java.java340.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ipiecoles.java.java340.SpringWebApplication;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest(classes = SpringWebApplication.class)
public class EmployeRepositoryTest {
	@Autowired
	EmployeRepository employeRepository;
	
	Commercial pierreDurand, jeanJacques, jacquesDupond;
	
	@Before
	//purge
	//initialise
	public void setUp(){
		//Given
		Commercial pierreDurand = new Commercial("Durand", "Pierre", "C12345",new LocalDate(), 1500d, 0d, 0);
		Commercial jeanJacques = new Commercial("Jean", "Jacques", "C12346",new LocalDate(), 1500d, 0d, 0);
		Commercial jacquesDupond = new Commercial("Jacques", "Dupond", "C12347",new LocalDate(), 1500d, 0d, 0);

		pierreDurand = employeRepository.save(pierreDurand);
		jeanJacques = employeRepository.save(jeanJacques);
		jacquesDupond = employeRepository.save(jacquesDupond);
	}
	
	@After //n'accede pas a spring
	public void tearDown(){
		employeRepository.deleteAll();
	}
	
	@Test
	public void testFindByNomOrPrenomAllIgnoreCasePrenom(){
		//Given
		
		//When
		List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("pierre");
		
		//Then
		Assertions.assertThat(employes).hasSize(1);
		Assertions.assertThat(employes).contains(pierreDurand);
	}
	
	@Test
	public void testFindByNomOrPrenomAllIgnoreCaseNom(){
		//Given
		
		//When
		List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("durand");
		
		//Then
		Assertions.assertThat(employes).hasSize(1);
		Assertions.assertThat(employes).contains(pierreDurand);
	}
	
	@Test
	public void testFindByNomOrPrenomAllIgnoreCaseNomPrenom(){
		//Given
		
		//When
		List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("pierreDurand");
		
		//Then
		Assertions.assertThat(employes).hasSize(1);
		Assertions.assertThat(employes).contains(pierreDurand);
	}
			
}
