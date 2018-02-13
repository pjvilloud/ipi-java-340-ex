package com.ipiecoles.java.java340.service;

import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.builder.CommercialBuilder;
import com.ipiecoles.java.java340.model.maker.CommercialMaker;
import com.ipiecoles.java.java340.repository.EmployeRepository;
import cucumber.runtime.junit.Assertions;
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
    private EmployeRepository employeRepository;

    public Commercial employe;
    @Test(expected = EntityNotFoundException.class)
    public void TestFindByMatriculeExistePas(){
        Mockito.when(employeRepository.findByMatricule("C00000")).thenReturn(null);

        employeService.findByMatricule("C00000");
    }

    @Test
    public void TestFindByMatriculeExiste() throws EmployeException {
        employe = CommercialMaker.aCommercial().withMatricule("C1234").build();

        Mockito.when(employeRepository.findByMatricule(Mockito.anyString())).thenReturn(employe);

        Employe emp = employeService.findByMatricule("C1234");
        org.assertj.core.api.Assertions.assertThat(emp).isEqualTo(employe);
    }
}
