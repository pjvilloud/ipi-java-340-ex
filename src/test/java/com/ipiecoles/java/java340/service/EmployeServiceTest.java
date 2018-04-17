package com.ipiecoles.java.java340.service;

import javax.persistence.EntityNotFoundException;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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
		Commercial commercial = new Commercial("azir", "ahri", "known", new LocalDate(), 500d, 600d, 5);
		Mockito.when(employeRepository.findByMatricule("connu")).thenReturn(commercial);
		
		// WHEN THEN
		Employe employe = employeService.findByMatricule("known");	
		Assertions.assertThat(employe.getPrenom()).isEqualTo("ahri");
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testFindByMatriculeWithWrongMatricule() {
		// GIVEN
		Commercial commercial = new Commercial("azir", "ahri", "known", new LocalDate(), 500d, 600d, 5);
		Mockito.when(employeRepository.findByMatricule("unknown")).thenReturn(null);
		
		// WHEN THEN
		Employe employe = employeService.findByMatricule("kown");	
	}
	
}