package com.ipiecoles.java.java340.service;

import javax.persistence.EntityNotFoundException;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.repository.EmployeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeServiceTest {
	
	@InjectMocks
	private EmployeService employeService;
	
	@Mock
	private EmployeRepository employeRepository;
	
	@Test
	public void testFindByMatricule() {
		// GIVEN
		Commercial commercial = new Commercial("mohamed", "pois", "connu", new LocalDate(), 500d, 600d, 5);
		Mockito.when(employeRepository.findByMatricule("connu")).thenReturn(commercial);
		
		// WHEN 
		Employe employe = employeService.findByMatricule("connu");	
		
		// THEN
		Assertions.assertThat(employe.getPrenom()).isEqualTo("pois");
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testFindByMatriculeWithWrongMatricule() {
		// GIVEN
		Commercial commercial = new Commercial("mohamed", "pois", "connu", new LocalDate(), 500d, 600d, 5);
		Mockito.when(employeRepository.findByMatricule("inconnu")).thenReturn(null);
		
		// WHEN THEN
		Employe employe = employeService.findByMatricule("connu");	
	}
}
