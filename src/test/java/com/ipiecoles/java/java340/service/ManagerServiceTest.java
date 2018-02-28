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

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {

    @InjectMocks
    ManagerService managerService;

    @Mock
    ManagerRepository managerRepository;
    @Mock
    TechnicienRepository technicienRepository;

    Manager kevinCostner, valKilmer; //valKilmer a une équipe, mais pas kevinCostner
    Technicien bradPitt, georgeClooney; //georgeClooney a un manager, mais pas BradPitt

    @Before
    public void setUp() throws EmployeException {
        kevinCostner = ManagerMaker.aManagerWithoutEquipe().withNom("Costner").withPrenom("Kevin").build();
        valKilmer = ManagerMaker.aManagerWithoutEquipe().withNom("Kilmer").withPrenom("Val").build();

        bradPitt = TechnicienMaker.aTechnicien().withNom("Pitt").withPrenom("Brad").build();
        georgeClooney = TechnicienMaker.aTechnicien().withNom("Clooney").withPrenom("George").build();

        HashSet<Technicien> liste = new HashSet<>();
        liste.add(georgeClooney);
        valKilmer.setEquipe(liste);
        georgeClooney.setManager(valKilmer);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testAddTechniciensManagerNotFound() {
        //Given
        Mockito.when(managerRepository.findOneWithEquipeById(Mockito.anyLong())).thenReturn(null);

        //When
        Technicien t = managerService.addTechniciens(1L, "toto");

        //Then exception
    }

    @Test(expected = EntityNotFoundException.class)
    public void testAddTechniciensTechnicienNotFound(){
        //Given
        Mockito.when(managerRepository.findOneWithEquipeById(Mockito.anyLong())).thenReturn(kevinCostner);
        Mockito.when(technicienRepository.findByMatricule(Mockito.anyString())).thenReturn(null);

        //When
        Technicien t = managerService.addTechniciens(1L, "toto");

        //Then exception
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTechniciensOneManagerAlready() {
        //Given
        Mockito.when(managerRepository.findOneWithEquipeById(Mockito.anyLong())).thenReturn(kevinCostner);
        Mockito.when(technicienRepository.findByMatricule(Mockito.anyString())).thenReturn(georgeClooney);

        //When
        Technicien t = managerService.addTechniciens(1L, "toto");

        //Then exception
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

    @Test
    public void testAddTechniciensWhenEquipeNotNull() {
        //Given
        Mockito.when(managerRepository.findOneWithEquipeById(Mockito.anyLong())).thenReturn(valKilmer);
        Mockito.when(technicienRepository.findByMatricule(Mockito.anyString())).thenReturn(bradPitt);

        //When
        Technicien res = managerService.addTechniciens(1L, "toto");

        //Then
        Assertions.assertThat(valKilmer.getEquipe().size()).isEqualTo(2);
        Assertions.assertThat(valKilmer.getEquipe()).contains(bradPitt);
        Assertions.assertThat(valKilmer.getEquipe()).contains(georgeClooney);
    }
}
