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
public class TechnicienServiceTest
{
	@InjectMocks
	
	public TechnicienService technicienService;
	
	@Mock
	public TechnicienRepository technicienRepository;
	
	@Mock
	public ManagerRepository managerRepository;
	
	@Test
	public void testAddManager()
	{
		//Given
		final String MATRICULE = "M12345";
		final Long ID_TECHNICIEN = 1L;
		Technicien technicien = new Technicien("Dure", "jacques", "C12353", new LocalDate(), 1600d, 3);
		Manager manager = new Manager("Rond", "jo", MATRICULE, new LocalDate(), 1600d, new HashSet<>());
		//On passe par les Mocks pour renvoyer les valeurs qui se subsistent au managerRepository et TechnicienRepository
		Mockito.when(technicienRepository.findOne(ID_TECHNICIEN)).thenReturn(technicien);
		Mockito.when(managerRepository.findByMatricule(MATRICULE)).thenReturn(manager);
		//Dans ce cas la ligne suivante dit 
		Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(AdditionalAnswers.returnsFirstArg());
		Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(AdditionalAnswers.returnsFirstArg());
		//When
		manager = technicienService.addManager(ID_TECHNICIEN, MATRICULE);
		//Then
		//le .times() est un .count().Comme on a un seul technicien, on s'assure qu'on est passé qu'une seule fois
		Mockito.verify(technicienRepository, Mockito.times(1)).findOne(ID_TECHNICIEN);
		Mockito.verify(managerRepository, Mockito.times(1)).findByMatricule(MATRICULE);
		
		Assertions.assertThat(manager.getEquipe()).hasSize(1);
		Assertions.assertThat(manager.getEquipe()).contains(technicien);
		
		Assertions.assertThat(technicien.getManager()).isEqualTo(manager);
		
		//Argument captor recupere la valeur demandée. Ici le technicien de technicienService.java methode addManager
		ArgumentCaptor<Technicien>technicienCaptor = ArgumentCaptor.forClass(Technicien.class);
		Mockito.verify(technicienRepository).save(technicienCaptor.capture());
		//On verifie qu'on a bien recuperé la valeur
		Assertions.assertThat(technicienCaptor.getValue().getManager()).isEqualTo(manager);

	}
	
}
