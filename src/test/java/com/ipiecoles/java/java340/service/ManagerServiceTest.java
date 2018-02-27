package com.ipiecoles.java.java340.service;

import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;
import com.ipiecoles.java.java340.model.maker.ManagerMaker;
import com.ipiecoles.java.java340.model.maker.TechnicienMaker;
import com.ipiecoles.java.java340.repository.ManagerRepository;
import com.ipiecoles.java.java340.repository.TechnicienRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {

    @InjectMocks
    ManagerService managerService;

    @Mock
    ManagerRepository managerRepository;
    @Mock
    TechnicienRepository technicienRepository;

    Manager kevinCostner;
    Technicien bradPitt;

    @Before
    public void setUp() throws EmployeException {
        kevinCostner = ManagerMaker.aManagerWithoutEquipe().withNom("Costner").withPrenom("Kevin").build();
        bradPitt = TechnicienMaker.aTechnicien().withNom("Pitt").withPrenom("Brad").build();
    }

    @Test
    public void testAddTechniciensWhenEquipeNull() {
        //Given
        Mockito.when(managerRepository.findOneWithEquipeById(Mockito.anyLong())).thenReturn(kevinCostner);
        Mockito.when(technicienRepository.findByMatricule(Mockito.anyString())).thenReturn(bradPitt);

        //When
        Technicien res = managerService.addTechniciens(1L, "I123");

        //Then
        Assertions.assertThat(kevinCostner.getEquipe().size()).isEqualTo(1);
        Assertions.assertThat(kevinCostner.getEquipe()).contains(res);
    }
}
