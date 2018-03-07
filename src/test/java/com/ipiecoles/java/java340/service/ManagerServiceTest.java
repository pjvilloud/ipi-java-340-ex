package com.ipiecoles.java.java340.service;

import java.util.HashSet;

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
    public ManagerService managerService;

    @Mock
    public TechnicienRepository technicienRepository;

    @Mock
    public ManagerRepository managerRepository;
    
    Manager goodChief; 
    Technicien goodEmployee; 
    
    @Test
    public void testAddTechniciens() {
        //Given
        final String matricule = "M12345";
        final Long ID_MANAGER = 1L;
        goodEmployee = new Technicien("Good", "Employee", matricule, new LocalDate(), 1500d, 3);
        goodChief = new Manager("Good", "Chief", "T12345", new LocalDate(), 2500d, new HashSet<>());

        // 4 things to check in addManager: 
        Mockito.when(managerRepository.findOneWithEquipeById(Mockito.anyLong())).thenReturn(goodChief);
        Mockito.when(technicienRepository.findByMatricule(Mockito.anyString())).thenReturn(goodEmployee);
        Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(AdditionalAnswers.returnsFirstArg());
        Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(AdditionalAnswers.returnsFirstArg());
        
        //When
        managerService.addTechniciens(ID_MANAGER, matricule);
        //Then

        // We check how many times the functions are called 
        Mockito.verify(managerRepository, Mockito.times(1)).findOneWithEquipeById(Mockito.anyLong());
        Mockito.verify(technicienRepository, Mockito.times(1)).findByMatricule(Mockito.anyString());

        // Making some assertions 
        Assertions.assertThat(goodChief.getEquipe()).hasSize(1);
        Assertions.assertThat(goodChief.getEquipe()).contains(goodEmployee);
        Assertions.assertThat(goodEmployee.getManager()).isEqualTo(goodChief);

        // Checking using Captor
        ArgumentCaptor<Manager> managerCaptor = ArgumentCaptor.forClass(Manager.class);
        Mockito.verify(managerRepository, Mockito.times(1)).save(managerCaptor.capture());
        Assertions.assertThat(managerCaptor.getValue().getEquipe().size()).isEqualTo(1);
        Assertions.assertThat(managerCaptor.getValue().getEquipe()).contains(goodEmployee);
        
        ArgumentCaptor<Technicien> technicienCaptor = ArgumentCaptor.forClass(Technicien.class);
        Mockito.verify(technicienRepository, Mockito.times(1)).save(technicienCaptor.capture());
        Assertions.assertThat(technicienCaptor.getValue().getManager()).isEqualTo(goodChief);
    }
}
