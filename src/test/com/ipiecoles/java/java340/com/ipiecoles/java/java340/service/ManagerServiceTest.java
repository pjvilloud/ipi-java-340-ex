package com.ipiecoles.java.java340.com.ipiecoles.java.java340.service;

import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;
import com.ipiecoles.java.java340.repository.ManagerRepository;
import com.ipiecoles.java.java340.repository.TechnicienRepository;
import com.ipiecoles.java.java340.service.ManagerService;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
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
    public ManagerService managerService;

    @Mock
    public ManagerRepository managerRepository;
    @Mock
    public TechnicienRepository technicienRepository;

    @Test
    public void testAddTechnicien(){
        //Given
        Manager m = new Manager("Cooper","Sheldon","M12345", new LocalDate(),1000d, new HashSet<>());
        Technicien t = new Technicien("White", "Walter", "T12345", new LocalDate(), 1000d, 3);

        Mockito.when(managerRepository.findOneWithEquipeById(Mockito.anyLong())).thenReturn(m);
        Mockito.when(technicienRepository.findByMatricule(Mockito.anyString())).thenReturn(t);

        //When
        Technicien ajout = managerService.addTechniciens(Long.valueOf(1), "T12345");

        //Then
        Assertions.assertThat(ajout).isEqualTo(t);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testAddTechnicienWithManagerNotFound(){
        //Given
        Technicien t = new Technicien("White", "Walter", "T12345", new LocalDate(), 1000d, 3);

        Mockito.when(managerRepository.findOneWithEquipeById(Mockito.anyLong())).thenReturn(null);

        //When
        managerService.addTechniciens(null, t.getMatricule());

    }

    @Test(expected = EntityNotFoundException.class)
    public void testAddTechnicienWithTechnicienNotFound(){
        //Given
        Manager m = new Manager();
        Mockito.when(managerRepository.findOneWithEquipeById(Mockito.anyLong())).thenReturn(m);
        Mockito.when(technicienRepository.findByMatricule(Mockito.anyString())).thenReturn(null);

        //When
        managerService.addTechniciens(m.getId(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTechnicienWithTechnicienAlreadyHasManager(){
        //Given
        Manager m = new Manager("Cooper","Sheldon","M12345", new LocalDate(),1000d, new HashSet<>());
        Technicien t = new Technicien("White", "Walter", "T12345", new LocalDate(), 1000d, 3);

        Mockito.when(managerRepository.findOneWithEquipeById(Mockito.anyLong())).thenReturn(m);
        Mockito.when(technicienRepository.findByMatricule(Mockito.anyString())).thenReturn(t);

        Manager manager = new Manager("Wayne", "Bruce", "M12365", new LocalDate(), 2000d, new HashSet<>());
        t.setManager(manager);

        //When
        managerService.addTechniciens(m.getId(), t.getMatricule());
    }

}
