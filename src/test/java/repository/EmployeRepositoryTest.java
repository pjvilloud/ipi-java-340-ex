package repository;


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
import com.ipiecoles.java.java340.repository.CommercialRepository;
import com.ipiecoles.java.java340.repository.EmployeRepository;


	@RunWith(SpringRunner.class)
	@SpringBootTest(classes = SpringWebApplication.class)
	public class EmployeRepositoryTest {
		
		@Autowired
		EmployeRepository employeRepository;
		
		@Autowired
		CommercialRepository commercialRepository;
		
		//Given
		Commercial pierreDurand = new Commercial("Durand", "Pierre", "C12345", new LocalDate(), 1504d, 500d, 50);
		Commercial jeanJacques = new Commercial("Jacques", "Jean", "C12346", new LocalDate(), 5400d, 500d, 100);
		Commercial jacquesDupont = new Commercial("Dupont", "Jacques", "C12347", new LocalDate(), 2345d, 500d, 200);
	
		@Before
		public void setUp() {
		commercialRepository.deleteAll();
		employeRepository.deleteAll();
		employeRepository.save(pierreDurand);
		employeRepository.save(jeanJacques);
		employeRepository.save(jacquesDupont);
		
		}
		
		@Test
		public void testFindByNomOrPrenomAllIgnoreCase() {
		
		//When
		List <Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("Jacques");
			
		//Then
		Assertions.assertThat(employes).hasSize(2);
		Assertions.assertThat(employes).contains(jacquesDupont);
		
		}
		
		@Test
	    public void testfindEmployesPlusRiches() {
	       
	        Assertions.assertThat(employeRepository.findEmployePlusRiches().get(0)).isEqualTo(jeanJacques);
	     }
		
		@After
		public void tearDown() {
			
			employeRepository.deleteAll();
			
		}
		
		
	}