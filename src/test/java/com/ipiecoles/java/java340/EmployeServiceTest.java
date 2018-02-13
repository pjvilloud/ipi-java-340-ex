package com.ipiecoles.java.java340;

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
import com.ipiecoles.java.java340.service.EmployeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeServiceTest {
	
	@InjectMocks
	private EmployeService empService;
	
	@Mock
	private EmployeRepository empRepository;
	
	@Test(expected = EntityNotFoundException.class)
	public void testFindByMatriculeNotFOund() {
		//Given
	    Mockito.when(empRepository.findByMatricule("UNKNO")).thenReturn(null);
	    	
	    //When
	    empService.findByMatricule("UNKNO");
	}
	
	@Test
	public void testFindByMatriculeFound() {
		//Given
		Commercial com = new Commercial("yann", "Laforest","XX123", new LocalDate(), 1400d, 500d);
	    Mockito.when(empRepository.findByMatricule("KNOWN")).thenReturn(com);
	    	
	    //When
	    Employe emp = empService.findByMatricule("KNOWN");
	    
	    //Then
	    Assertions.assertThat(com).isEqualTo(emp);
	}

}
