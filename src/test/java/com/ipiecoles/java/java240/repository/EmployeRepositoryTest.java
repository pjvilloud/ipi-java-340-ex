package com.ipiecoles.java.java240.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.Module.SetupContext;
import com.ipiecoles.java.java340.SpringWebApplication;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.Note;
import com.ipiecoles.java.java340.repository.CommercialRepository;
import com.ipiecoles.java.java340.repository.EmployeRepository;




@RunWith(SpringRunner.class)
//@DataJpaTest : ne fonctionne pas à chaque fois
@SpringBootTest(classes=SpringWebApplication.class) //fonctionne à chaque fois.
public class EmployeRepositoryTest {
	
	
	
	//Test de findByNomOrPrenomAllIgnoreCase
	
	@Autowired
	EmployeRepository employeRepository;
	
	Commercial patrickDupont,jeanJacques,jacquesDupont,pierreDurand;
	
	@Before
	public void SetupContext() {
		employeRepository.deleteAll();
		
		pierreDurand = new Commercial("Durand", "Pierre","C12347",new LocalDate(), 2000d, 10000d);
		pierreDurand=employeRepository.save(pierreDurand);
		patrickDupont = employeRepository.save(new Commercial("Dupont", "Patrick","C12345", new LocalDate(), 2000d, 10000d));
		jeanJacques = employeRepository.save(new Commercial("Jacques", "Jean","C22345", new LocalDate(), 2000d, 10000d));
		jacquesDupont = employeRepository.save(new Commercial("Dupont", "Jacques","C32345", new LocalDate(), 2000d, 10000d));
		//Commercial commercial4 = employeRepository.save(new Commercial("Dupuis", "Paul",null, null, null, null));
		//Commercial commercial5 = employeRepository.save(new Commercial("Dupuis", "Patrick",null, null, null, null));
	}
	
	@After
	public void tearDown() {
		employeRepository.deleteAll();
	}
	
	@Test
	public void TestfindByNomOrPrenomIgnoreCasePrenom() {
		
		//Given , When
		
		List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("pierre");
		
		//Then
		Assertions.assertThat(employes).hasSize(1);
		Assertions.assertThat(employes).contains(pierreDurand);
	}
		
	@Test
	public void TestfindByNomOrPrenomIgnoreCaseNom() {
		
		//Given
		
		
		
		//List <Employe> commercialExpected = 
		
		//When
		
		List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("Durand");
		
		//Then
		Assertions.assertThat(employes).hasSize(1);
		Assertions.assertThat(employes).contains(pierreDurand);
	}
		
	@Test
	public void TestfindByNomOrPrenomIgnoreCaseNomOrPrenom() {
		  
		//Given
		
		
		
		//List <Employe> commercialExpected = 
		
		//When
		
		List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("jacques");
		
		//Then
		Assertions.assertThat(employes).hasSize(2);
		Assertions.assertThat(employes).contains(jeanJacques,jacquesDupont);
	}
	
}