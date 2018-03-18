package com.ipiecoles.java340.repository.Service;


import java.util.HashSet;
import com.ipiecoles.java.java340.service.ManagerService;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;
import com.ipiecoles.java.java340.repository.ManagerRepository;
import com.ipiecoles.java.java340.repository.TechnicienRepository;




@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {


    @InjectMocks
    private ManagerService managerService;

    @Mock
    private TechnicienRepository technicienRepository;

    @Mock
    private ManagerRepository managerRepository;

    @Test
    public void testAddTechniciens(){

        //Given
        final String  MATRICULE_TECH= "T11234";
        final String MATRICULE_MAN = "M11234";
        final Long ID_MANAGER = 10L;

        Manager manager = new Manager("Dupond", "Pierre", MATRICULE_MAN, new LocalDate(), 2500d, new HashSet<Technicien>());
        manager.setId(ID_MANAGER);
        Technicien technicien = new Technicien("Kevin", "Jean", MATRICULE_TECH, new LocalDate(), 2500d, 3);


        Mockito.when(managerRepository.findOneWithEquipeById(ID_MANAGER)).thenReturn(manager);
        Mockito.when(technicienRepository.findByMatricule(MATRICULE_TECH)).thenReturn(technicien);

        Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(AdditionalAnswers.returnsFirstArg());
        Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(AdditionalAnswers.returnsFirstArg());

        //When
        managerService.addTechniciens(ID_MANAGER, MATRICULE_TECH);

        //Then

        Assertions.assertThat(manager.getEquipe()).contains(technicien);


        Assertions.assertThat(manager.getEquipe()).hasSize(1);

        Assertions.assertThat(technicien.getManager()).isEqualTo(manager);


        Mockito.verify(managerRepository, Mockito.times(1)).findOneWithEquipeById(ID_MANAGER);
        Mockito.verify(technicienRepository, Mockito.times(1)).findByMatricule(MATRICULE_TECH);


        ArgumentCaptor<Manager> managerCaptor = ArgumentCaptor.forClass(Manager.class);
        Mockito.verify(managerRepository).save(managerCaptor.capture());
        Assertions.assertThat(managerCaptor.getValue().getEquipe()).containsOnly(technicien);

    }




}