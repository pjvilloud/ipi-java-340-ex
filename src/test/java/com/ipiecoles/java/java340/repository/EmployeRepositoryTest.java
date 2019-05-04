<<<<<<< HEAD
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
import org.springframework.test.context.junit4.SpringRunner;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.Manager;

@RunWith(SpringRunner.class)
@DataJpaTest  //Si ça marche pas, utiliser @SpringBootTest(classes = SpringWebApplication.class)
public class EmployeRepositoryTest {

	@Autowired
	EmployeRepository employeRepository;
	Commercial pierreDurand, jeanJacques, jacquesDupond;
	
	@Before
	public void setUp() {
		employeRepository.deleteAll();
		Commercial pierreDurand = new Commercial("Durand", "Pierre", "C12345", new LocalDate(), 1500d, 0d, 0);
		Commercial jeanJacques = new Commercial("Jacques", "Jean", "C12346", new LocalDate(), 1500d, 0d, 0);
		Commercial jacquesDupond = new Commercial("Dupond", "Jacques", "C12347", new LocalDate(), 1500d, 0d, 0);
		
		pierreDurand = employeRepository.save(pierreDurand);
		jeanJacques = employeRepository.save(jeanJacques);
		jacquesDupond = employeRepository.save(jacquesDupond);
	}
	
	@After
	public void tearDown () {
		employeRepository.deleteAll();
	}
	
	@Test
	public void testFindByNomOrPrenomAllIgnoreCasePrenom() {
		//Given
		
		//When
		List <Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("pierre");
		
		//Then
		Assertions.assertThat(employes).hasSize(1);
		Assertions.assertThat(employes).contains(pierreDurand);
	}
	
	
	@Test
	public void testFindByNomOrPrenomAllIgnoreCaseNom() {
		//Given
		 
		//When
		List <Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("Durand");
		
		//Then
		Assertions.assertThat(employes).hasSize(1);
		Assertions.assertThat(employes).contains(pierreDurand);
	}
	
	@Test
	public void testFindByNomOrPrenomAllIgnoreCaseNomPrenom() {
		//Given
		
		//When
		List <Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("jacques");
		
		//Then
		Assertions.assertThat(employes).hasSize(2);
		Assertions.assertThat(employes).contains(jeanJacques, jacquesDupond);
	}
	
	
	@Test
	public void testFindByNomOrPrenomAllIgnoreCaseNotFound() {
		//Given
		
		//When
		List <Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("toto");
		
		//Then
		Assertions.assertThat(employes).isEmpty();
	}
	
	@Test
	public void findEmployesPlusRichesHasSize() {
		//Given
		
		//When
		List <Employe> employes = employeRepository.findEmployePlusRiches();
		
		//Then
		Assertions.assertThat(employes).hasSize(1);
	}
	
	@Test
	public void findEmployesPlusRichesContains() {
		Commercial commercial = new Commercial();
		
		//When
		List <Employe> employes = employeRepository.findEmployePlusRiches();
		
		//Then
		Assertions.assertThat(employes).contains(commercial);
	}
}


=======
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
import org.springframework.test.context.junit4.SpringRunner;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.Manager;

@RunWith(SpringRunner.class)
@DataJpaTest  //Si ça marche pas, utiliser @SpringBootTest(classes = SpringWebApplication.class)
public class EmployeRepositoryTest {

	@Autowired
	EmployeRepository employeRepository;
	Commercial pierreDurand, jeanJacques, jacquesDupond;
	
	@Before
	public void setUp() {
		employeRepository.deleteAll();
		Commercial pierreDurand = new Commercial("Durand", "Pierre", "C12345", new LocalDate(), 1500d, 0d, 0);
		Commercial jeanJacques = new Commercial("Jacques", "Jean", "C12346", new LocalDate(), 1500d, 0d, 0);
		Commercial jacquesDupond = new Commercial("Dupond", "Jacques", "C12347", new LocalDate(), 1500d, 0d, 0);
		
		pierreDurand = employeRepository.save(pierreDurand);
		jeanJacques = employeRepository.save(jeanJacques);
		jacquesDupond = employeRepository.save(jacquesDupond);
	}
	
	@After
	public void tearDown () {
		employeRepository.deleteAll();
	}
	
	@Test
	public void testFindByNomOrPrenomAllIgnoreCasePrenom() {
		//Given
		
		//When
		List <Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("pierre");
		
		//Then
		Assertions.assertThat(employes).hasSize(1);
		Assertions.assertThat(employes).contains(pierreDurand);
	}
	
	
	@Test
	public void testFindByNomOrPrenomAllIgnoreCaseNom() {
		//Given
		 
		//When
		List <Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("Durand");
		
		//Then
		Assertions.assertThat(employes).hasSize(1);
		Assertions.assertThat(employes).contains(pierreDurand);
	}
	
	@Test
	public void testFindByNomOrPrenomAllIgnoreCaseNomPrenom() {
		//Given
		
		//When
		List <Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("jacques");
		
		//Then
		Assertions.assertThat(employes).hasSize(2);
		Assertions.assertThat(employes).contains(jeanJacques, jacquesDupond);
	}
	
	
	@Test
	public void testFindByNomOrPrenomAllIgnoreCaseNotFound() {
		//Given
		
		//When
		List <Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("toto");
		
		//Then
		Assertions.assertThat(employes).isEmpty();
	}
	
	@Test
	public void findEmployesPlusRichesHasSize() {
		//Given
		
		//When
		List <Employe> employes = employeRepository.findEmployePlusRiches();
		
		//Then
		Assertions.assertThat(employes).hasSize(1);
	}
	
	@Test
	public void findEmployesPlusRichesContains() {
		Commercial commercial = new Commercial();
		
		//When
		List <Employe> employes = employeRepository.findEmployePlusRiches();
		
		//Then
		Assertions.assertThat(employes).contains(commercial);
	}
}


>>>>>>> bd251691c61aa5f0344fb47d05e6fd989810c39b
