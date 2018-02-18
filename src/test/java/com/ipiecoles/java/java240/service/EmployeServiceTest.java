package com.ipiecoles.java.java240.service;

import javax.persistence.EntityNotFoundException;

import org.assertj.core.api.Assertions;
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
	  private EmployeService employeService;
	  @Mock
	  private EmployeRepository employeRepository;

	  @Test(expected = EntityNotFoundException.class)
	  public void testFindByMatriculeNotFound(){
	    //Given
	    Mockito.when(employeRepository.findByMatricule("inconnu")).thenReturn(null);
	    //When
	    employeService.findByMatricule("inconnu");
	    
	    //Then exception
	  }
	  
	  @Test
	  public void findByMatriculeFound() {
		  //Given
		  Commercial commercial= new Commercial();
		  Mockito.when(employeRepository.findByMatricule(Mockito.anyString())).thenReturn(commercial);
		  
		  //When
		  Employe employe=employeService.findByMatricule("connu");
		  Assertions.assertThat(employe).isEqualTo(commercial);
	  }
	}

