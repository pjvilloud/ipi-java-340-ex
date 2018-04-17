package com.ipiecoles.java.java340.repository;

import org.joda.time.LocalDate;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ipiecoles.java.java340.SpringWebApplication;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.repository.CommercialRepository;
import com.ipiecoles.java.java340.repository.EmployeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringWebApplication.class)
public class EmployeRepositoryTest {
	
	@Autowired
	EmployeRepository employeRepository;
	
	// Déclaration des attributs 
	Commercial commercial, commercial1, commercial2;
	
	/*@Before
	public void setUp() {
		employeRepository.deleteAll(); 
		commercial = new Commercial("Jeanbouin", "Luc", "C12346", new LocalDate(), 1500d, 0d, 0);
		commercial1 = new Commercial("Jeanton", "Louis", "C12347", new LocalDate(), 1200d, 0d, 0);
		commercial2 = new Commercial("Hourran", "Alain", "C12348", new LocalDate(), 1300d, 0d, 0);
		// Sauvegarde dans la base de données
		commercial = employeRepository.save(commercial);
		commercial1 = employeRepository.save(commercial1);
		commercial2 = employeRepository.save(commercial2);
	}
	
	
	@Test
	public void findByNomOrPrenomAllIgnoreCaseNom() {
		
		List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("jeanbouin");
		Assertions.assertThat(employes).hasSize(1); 
		Assertions.assertThat(employes).contains(commercial); 
	}
	
	@Test
	public void findByNomOrPrenomAllIgnoreCaseNomPrenom() {
		
		List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("louis");
		Assertions.assertThat(employes).hasSize(1); 
		Assertions.assertThat(employes).contains(commercial1); 
	}
	
	@Test
	public void findByNomOrPrenomAllIgnoreCaseNotFound() {
		
		List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("toto");
		Assertions.assertThat(employes).isEmpty();
	}
	
	@Test
	public void findEmployesPlusRichesHasSize() {
		List<Employe> employes = employeRepository.findEmployePlusRiches();
		Assertions.assertThat(employes).hasSize(1); 
	}
	
	public void findEmployesPlusRichesContains() {
		List<Employe> employes = employeRepository.findEmployePlusRiches();
		Assertions.assertThat(employes).contains(commercial); 
	}*/

}