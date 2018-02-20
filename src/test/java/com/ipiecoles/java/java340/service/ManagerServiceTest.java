package com.ipiecoles.java.java340.service;

import java.util.HashSet;

import javax.persistence.EntityNotFoundException;

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
	public ManagerRepository managerRepository;

	@Mock
	public TechnicienRepository technicienRepository;
	
	@Test(expected = EntityNotFoundException.class)
	public void testAddTechniciens(){

		//Given
		final String MATRICULE = "T12345";
		final Long ID_MANAGER = 15420L;
		
		Manager manager = new Manager("Dupond", "Jacques", "M12345", new LocalDate(), 2500d, new HashSet<>());
		manager.setId(ID_MANAGER);

		Technicien technicien = new Technicien("Durand", "Pierre", MATRICULE, new LocalDate(), 1500d, 3);

		Mockito.when(technicienRepository.findByMatricule(MATRICULE)).thenReturn(technicien);
		Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(AdditionalAnswers.returnsFirstArg());
		Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(AdditionalAnswers.returnsFirstArg());

		//When
		managerService.addTechniciens(ID_MANAGER, MATRICULE);
		
		//then
		Assertions.assertThat(manager.getEquipe()).hasSize(1);
		Assertions.assertThat(manager.getEquipe()).isEqualTo(technicien);

		Assertions.assertThat(technicien.getManager()).isEqualTo(manager);

		ArgumentCaptor<Technicien> technicienCaptor = ArgumentCaptor.forClass(Technicien.class);
		Mockito.verify(technicienRepository).save(technicienCaptor.capture());
		Assertions.assertThat(technicienCaptor.getValue().getManager()).isEqualTo(manager);
		
		ArgumentCaptor<Integer> gradeCaptor = ArgumentCaptor.forClass(Integer.class);
		ArgumentCaptor<Integer> gradeCaptor2 = ArgumentCaptor.forClass(Integer.class);
		
		Mockito.verify(technicienRepository).findByGradeBetween(gradeCaptor.capture(), gradeCaptor2.capture());
	}
}
