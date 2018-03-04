package com.ipiecoles.java.java340.service;

import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;
import com.ipiecoles.java.java340.repository.ManagerRepository;
import com.ipiecoles.java.java340.repository.TechnicienRepository;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

@RunWith(MockitoJUnitRunner.class)
public class TechnicienServiceTest {

    @InjectMocks
    public TechnicienService technicienService;

    @Mock
    public TechnicienRepository technicienRepository;

    @Mock
    public ManagerRepository managerRepository;

    @Test
    public void testAddManager() {
        //Given
        final String matricule = "M12345";
        final Long ID_TECHNICIEN = 1L;
        Technicien technicien = new Technicien("Durand", "Jean", "T12345", new LocalDate(), 1500d, 3);
        Manager manager = new Manager("Dupond", "Jacques", matricule, new LocalDate(), 2500d, new HashSet<>());

        //On regarde dans le service TechnicienService toutes les dépendances, il faut donc les mocker. Il y en a 4
        Mockito.when(technicienRepository.findOne(Mockito.anyLong())).thenReturn(technicien);
        Mockito.when(managerRepository.findByMatricule(Mockito.anyString())).thenReturn(manager);
        Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(AdditionalAnswers.returnsFirstArg());
        Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(AdditionalAnswers.returnsFirstArg());
        //When
        technicienService.addManager(ID_TECHNICIEN, matricule);
        //Then

        //On vérifie que les méthodes appelées dans TechnicienService sont bien appelées un bon nombre de fois (dans ce cas-ci, 1 fois)
        Mockito.verify(technicienRepository, Mockito.times(1)).findOne(Mockito.anyLong());
        Mockito.verify(managerRepository, Mockito.times(1)).findByMatricule(Mockito.anyString());

        //On fait les assertions qu'il faut
        Assertions.assertThat(manager.getEquipe()).hasSize(1);
        Assertions.assertThat(manager.getEquipe()).contains(technicien);
        Assertions.assertThat(technicien.getManager()).isEqualTo(manager);

        //On fait d'autres vérifications avec argument captor
        ArgumentCaptor<Technicien> technicienCaptor = ArgumentCaptor.forClass(Technicien.class);
        Mockito.verify(technicienRepository).save(technicienCaptor.capture());
        Assertions.assertThat(technicienCaptor.getValue().getManager()).isEqualTo(manager);
    }
}