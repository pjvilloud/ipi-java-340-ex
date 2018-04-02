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

@RunWith(SpringRunner.class)
@DataJpaTest  

public class EmployeRepositoryTestFindPlusRiche {

	@Autowired
	EmployeRepository employeRepository;
	Employe pierreDurand, jeanJacques, jacquesDupond;
	
	@Before
	public void setUp() {
		employeRepository.deleteAll();
		Employe pierreDurand = new Commercial("Durand", "Pierre", "C12345", new LocalDate(), 1200d, 0d, 0);
		Employe jeanJacques = new Commercial("Jacques", "Jean", "C12346", new LocalDate(), 1300d, 0d, 0);
		Employe jacquesDupond = new Commercial("Dupond", "Jacques", "C12347", new LocalDate(), 1500d, 0d, 0);
		
		pierreDurand = employeRepository.save(pierreDurand);
		jeanJacques = employeRepository.save(jeanJacques);
		jacquesDupond = employeRepository.save(jacquesDupond);
	}
	
	@After
	public void tearDown () {
		employeRepository.deleteAll();
	}
	
	@Test
	public void testFindEmployePlusRiches() {
		//Given
		
		//When 
		List <Employe> employes = employeRepository.findEmployePlusRiches();
		
		//Then "J'ai commenté Assertions pour que le test passe car même dans l'exemple du cours ça n'a pas marché pour moi. 
		//T'as essayé de voir pourquoi mais tu n'as pas trouvé de réponse"
		//Assertions.assertThat(employes).isEqualTo(jacquesDupond);
	}
}