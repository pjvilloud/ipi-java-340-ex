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
    EmployeService employeService;

    @Mock
    EmployeRepository employeRepository;

    Commercial pierreDurand, jacquesDupont;

    @Before
    public void setUp() throws EmployeException{
        pierreDurand = CommercialMaker.aCommercial().withMatricule("C12345").build();
        jacquesDupont = CommercialMaker.aCommercial().withMatricule("C56789").build();
    }

    @Test(expected = EntityNotFoundException.class)
    public void testFindByMatriculeNotFound() {
        //Given
        Mockito.when(employeRepository.findByMatricule("C12345")).thenReturn(null);
        //When
        employeService.findByMatricule("inconnu");
        //Then
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
