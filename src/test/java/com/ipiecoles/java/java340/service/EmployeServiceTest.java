package com.ipiecoles.java.java340.service;

import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.maker.CommercialMaker;
import com.ipiecoles.java.java340.repository.EmployeRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class EmployeServiceTest {

    @InjectMocks
    private EmployeService employeService;

    @Mock
    //private EmployeRepository employeRepository;
    EmployeRepository employeRepository;
    
    Commercial pierreDurand, jacquesDupont;

    @Before
    public void setUp() throws EmployeException{
    	pierreDurand = CommercialMaker.aCommercial().withMatricule("C12345").build();
    	jacquesDupont = CommercialMaker.aCommercial().withMatricule("C56789").build();
    }
    
    @Test(expected = EntityNotFoundException.class)
    public void testFindByMatriculeNotFound(){
        //Given
        Mockito.when(employeRepository.findByMatricule("C12345")).thenReturn(null);

        //When
        //employeService.findByMatricule("C12345");
        employeService.findByMatricule("inconnu");
        
        //Then exception
    }

    
    @Test
    public void test() {
        //Given
        Mockito.when(employeRepository.test()).thenReturn(5);

        //When
        Integer integer = employeService.testService();
        Assertions.assertThat(integer).isEqualTo(5);
    }
	

    @Test
    public void testFindByMatriculeFound2() throws EmployeException {
        //Given
        Commercial c = CommercialMaker.aCommercial().build();
        Mockito.when(employeRepository.findByMatricule(Mockito.anyString())).thenReturn(c);

        //When
        Employe e = employeService.findByMatricule("connu");
        Assertions.assertThat(e).isEqualTo(c);
    }
    
    
    
    @Test
    public void testFindByMatriculeFound() {
    	//Given
    	Mockito.when(employeRepository.findByMatricule("C12345")).thenReturn(pierreDurand);
    	Mockito.when(employeRepository.findByMatricule("C56789")).thenReturn(jacquesDupont);
    
    	//when
    	Employe e1 = employeService.findByMatricule("C12345");
    	Employe e2 = employeService.findByMatricule("C56789");
    	Assertions.assertThat(e1).isEqualTo(pierreDurand);
    	Assertions.assertThat(e2).isEqualTo(jacquesDupont);
    }
    
    
    
}
