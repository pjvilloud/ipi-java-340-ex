package com.ipiecoles.java.java340.service;
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

@RunWith(MockitoJUnitRunner.class)
public class EmployeServiceTest {

		/*InjectMock permet de tester unitairement employeService en s'affranchissant de la dépendance 
		au repository EmployeRepository. Permet de vérifier que la logique du service est correcte
		*/
	
	  @InjectMocks
	  private EmployeService employeService;  
	  
	  @Mock
	  private EmployeRepository employeRepository;

	  @Test(expected = EntityNotFoundException.class)
	  public void testFindByMatriculeNotFound(){
	    
		//Given
	    Mockito.when(employeRepository.findByMatricule("M00016")).thenReturn(null);
	   
	    //When
	    employeService.findByMatricule("M00016");
	  }
	  
	  
	  @Test
	  public void testFindByMatriculeFound(){
		  //Given
		  Commercial c = new Commercial();
		  Mockito.when(employeRepository.findByMatricule(Mockito.anyString())).thenReturn(c);
		  
		  //When
		  Employe e = employeService.findByMatricule("connu");
		  Assertions.assertThat(e).isEqualTo(c);
		  
	  }
	}
	
	
	
	

