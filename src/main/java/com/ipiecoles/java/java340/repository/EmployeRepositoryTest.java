package com.ipiecoles.java.java340.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeRepositoryTest {
	
	@Before
	public void setUpMyTest() {
		Commercial commercial = new Commercial("kayn", "rhaast", "000VB", new LocalDate(), 500d, 5000d, 5);
		Commercial commercialDeux = new Commercial("poppy", "lux", "000VB", new LocalDate(), 500d, 5000d, 5);
		employeRepository.save(commercial);
		employeRepository.save(commercialDeux);
	}
	
	public void After() {
		employeRepository.deleteAll();
	}
	
	@Autowired
	public EmployeRepository employeRepository;

	@Test
	public void findByNomOrPrenomAllIgnoreCaseTest() {
		// GIVEN
		String testOk = "kayn";
		String testNotOk = "urgot";
		
		// WHEN 
			List<Employe> listeEmploye = employeRepository.findByNomOrPrenomAllIgnoreCase(testOk);
			List<Employe> listeEmployeDeux = employeRepository.findByNomOrPrenomAllIgnoreCase(testNotOk);
		
		// THEN
		Assertions.assertThat(listeEmploye).hasSize(2);
		Assertions.assertThat(listeEmployeDeux).hasSize(0);
		
	}
}