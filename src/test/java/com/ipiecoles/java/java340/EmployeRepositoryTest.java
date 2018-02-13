package com.ipiecoles.java.java340;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.repository.EmployeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeRepositoryTest {
	
	@Autowired
	EmployeRepository empRepository;
	
	@Before
	public void setUpMyTest() {
		employeRepository.deleteAll();
		Commercial com1 = new Commercial("yann", "Laforest","XX123", new LocalDate(), 1400d, 500d);
		Commercial com2 = new Commercial("yann", "LeBG","XX124", new LocalDate(), 1400d, 500d);
		Commercial com3 = new Commercial("YANN", "LeBG","XX125", new LocalDate(), 1400d, 500d);

		employeRepository.save(com1);
		employeRepository.save(com2);
		employeRepository.save(com3);

	}
	
	@Autowired
	public EmployeRepository employeRepository;

	@Test
	public void findByNomOrPrenomAllIgnoreCaseTest() {
		// Given
		String test = "yann";
		String test2 = "clem";
		
		// When
			List<Employe> listeEmployeYann = employeRepository.findByNomOrPrenomAllIgnoreCase(test);
			List<Employe> listeEmployeClem = employeRepository.findByNomOrPrenomAllIgnoreCase(test2);
		
		// THEN
		Assertions.assertThat(listeEmployeYann).hasSize(3);
		for(int i = 0; i< listeEmployeYann.size(); i++) {
			Employe cur_emp = listeEmployeYann.get(i);
			if(!cur_emp.getPrenom().equalsIgnoreCase("Yann")) {
				Assertions.assertThat(cur_emp.getNom()).isEqualToIgnoringCase("Yann");
			}
			else {
				Assertions.assertThat(cur_emp.getPrenom()).isEqualToIgnoringCase("Yann");

			}
		}
		Assertions.assertThat(listeEmployeClem).hasSize(0);
		
	}
}