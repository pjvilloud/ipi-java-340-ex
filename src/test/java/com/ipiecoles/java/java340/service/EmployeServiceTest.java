package com.ipiecoles.java.java340.service;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ipiecoles.java.java340.repository.EmployeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeServiceTest {

	  @InjectMocks
	  private EmployeService employeService;
	  
	  @Mock
	  private EmployeRepository employeRepository;
	  
	  @Test(expected = EntityNotFoundException.class)
	  
	  public void testFindByMatriculeNotFound(){
	    //Given
	    Mockito.when(employeRepository.findByMatricule(Mockito.anyString())).thenReturn(null);
	    //When
	    employeService.findByMatricule("C12345");
	  }

}
