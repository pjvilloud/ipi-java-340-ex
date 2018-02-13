package com.ipiecoles.java.java340;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

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
	    Mockito.when(empRepository.findByMatricule("olol")).thenReturn(null);
	    	
	    //When
	    empService.findByMatricule("olol");
	}

}
