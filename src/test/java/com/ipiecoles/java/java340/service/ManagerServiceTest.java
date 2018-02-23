package com.ipiecoles.java.java340.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
	public TechnicienRepository technicienRepository;
	
	@Mock
	public ManagerRepository managerRepository; 
	
	final Long ID_MANAGER = 44L;
	final String MATRICULE_ROUVE = "T56789"; 
	final String MATRICULE_DAHAN = "T34567";
	
	Technicien rouve, dahan; 
	Manager martin; 
	
	@Test
	public void testAddTechniciensMock() {
		
		// Test consiste à ajouter un ou plusieurs techniciens dans la base de données 
		
		// Méthode pour ajouter des techniciens : addTechniciens(Long idManager, String matricule)
		// Récupère un idManager et un matricule de technicien
		// Création d'un nouveau manager 
		// Création des nouveaux techniciens (plusieurs)
		
		
		// Given

		
		rouve = new Technicien("Rouve", "Jean-Paul", MATRICULE_ROUVE, new LocalDate(), 1500d, 2);
		dahan = new Technicien("Dahan", "Luc", MATRICULE_DAHAN, new LocalDate(), 1500d, 3);
		
		martin = new Manager("Martin", "Alain", "M99998", new LocalDate(), 2500d, new HashSet<>()); 
		
		Mockito.when(managerRepository.findOneWithEquipeById(ID_MANAGER)).thenReturn(martin);
		Mockito.when(technicienRepository.findByMatricule(MATRICULE_ROUVE)).thenReturn(rouve);
		Mockito.when(technicienRepository.findByMatricule(MATRICULE_DAHAN)).thenReturn(dahan);
		Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(AdditionalAnswers.returnsFirstArg());
		Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(AdditionalAnswers.returnsFirstArg());
		
		// When 
		managerService.addTechniciens(ID_MANAGER, MATRICULE_ROUVE);
		managerService.addTechniciens(ID_MANAGER, MATRICULE_DAHAN);
	
		
		// Then 
		Mockito.verify(managerRepository, Mockito.times(2)).findOneWithEquipeById(ID_MANAGER);
		Mockito.verify(technicienRepository, Mockito.times(1)).findByMatricule(MATRICULE_ROUVE);
		Mockito.verify(technicienRepository, Mockito.times(1)).findByMatricule(MATRICULE_DAHAN);
		

		Assertions.assertThat(martin.getEquipe()).hasSize(2); 
		Assertions.assertThat(martin.getEquipe()).contains(rouve, dahan); 
		Assertions.assertThat(rouve.getManager()).isEqualTo(martin); 
		Assertions.assertThat(dahan.getManager()).isEqualTo(martin); 
	}
	
	/* méthode qui ne fonctionne pas : 
	 * 
	 * Problème de duplication au niveau de la méthode "save"
	 * 
	 */
	
	/*@Test
	public void testAddTechniciensMockCaptor() {
		
		// Given 
		rouve = new Technicien("Rouve", "Jean-Paul", MATRICULE_ROUVE, new LocalDate(), 1500d, 2);
		dahan = new Technicien("Dahan", "Luc", MATRICULE_DAHAN, new LocalDate(), 1500d, 3);
		
		martin = new Manager("Martin", "Alain", "M99998", new LocalDate(), 2500d, new HashSet<>()); 
		
		Mockito.when(managerRepository.findOneWithEquipeById(ID_MANAGER)).thenReturn(martin);
		Mockito.when(technicienRepository.findByMatricule(MATRICULE_ROUVE)).thenReturn(rouve);
		Mockito.when(technicienRepository.findByMatricule(MATRICULE_DAHAN)).thenReturn(dahan);
		Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(AdditionalAnswers.returnsFirstArg());
		Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(AdditionalAnswers.returnsFirstArg());
		
		// When
		
		managerService.addTechniciens(ID_MANAGER, MATRICULE_ROUVE);
		managerService.addTechniciens(ID_MANAGER, MATRICULE_DAHAN);
		
		
		// Then 
		
		ArgumentCaptor<Manager> managerCaptor = ArgumentCaptor.forClass(Manager.class); 
		Mockito.verify(managerRepository, Mockito.times(1)).save(managerCaptor.capture()); 
		Assertions.assertThat(managerCaptor.getValue().getEquipe()).isEqualTo(rouve);
		Assertions.assertThat(managerCaptor.getValue().getEquipe()).isEqualTo(dahan);
	}*/
	

}
