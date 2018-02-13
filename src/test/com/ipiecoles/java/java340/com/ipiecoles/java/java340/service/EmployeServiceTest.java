package com.ipiecoles.java.java340.com.ipiecoles.java.java340.service;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.repository.EmployeRepository;
import com.ipiecoles.java.java340.service.EmployeService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class EmployeServiceTest {
    @InjectMocks // celui qu'on teste
    public EmployeService employeService;
    @Mock // le mock d'employeRepo
    public EmployeRepository employeRepository;

    @Test(expected = EntityNotFoundException.class)
    public void  testFindByMatricule(){
        //Given
        Mockito.when(employeRepository.findByMatricule("C12345")).thenReturn(null);

        //When
        employeService.findByMatricule("C12345");

        //Then exception
    }

    @Test
    public void  testFindByMatriculeFound(){
        //Given
        Commercial c  = new Commercial();
        Mockito.when(employeRepository.findByMatricule(Mockito.anyString())).thenReturn(c);

        //When
        Employe e = employeService.findByMatricule("connu");
        Assertions.assertThat(e).isEqualTo(c);

        //Then exception
    }

    /*
    exemple du restaurant: pour tester la cuisson faite par le cuisinier, avec mock, on apporte la viande au cuisinier.
     */



}