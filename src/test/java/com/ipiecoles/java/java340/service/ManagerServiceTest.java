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
import com.ipiecoles.java.java340.repository.EmployeRepository;
import com.ipiecoles.java.java340.repository.ManagerRepository;
import com.ipiecoles.java.java340.repository.TechnicienRepository;


//Tester de manière mockée la méthode addTechniciens de ManagerService. 
//Simplement en utilisant les éléments du premier slide sur les mocks

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {
	
			/*InjectMock permet de tester unitairement ManagerService en s'affranchissant de la dépendance 
			au repository EmployeRepository. Permet de vérifier que la logique du service est correcte
			*/
		
		  @InjectMocks
		  private ManagerService managerService;  
		  
		  @Mock
		  private TechnicienRepository technicienRepository;
		  
		  @Mock
		  private ManagerRepository managerRepository;
				  
		  @Test
			public void testAddTechniciens(){
				
				//Given
				final String  MATRICULE_TECH= "T01234";
				final String MATRICULE_MAN = "M01234";
				final Long ID_MANAGER = 10L;
									
				Manager manager = new Manager("Dupond", "Jack", MATRICULE_MAN, new LocalDate(), 2500d, new HashSet<Technicien>());
				manager.setId(ID_MANAGER);
				Technicien technicien = new Technicien("Pierre", "Jean", MATRICULE_TECH, new LocalDate(), 2500d, 3);
				
				//On s'assure que les mocks renvoient bien les valeurs que l'on vient de définir: 
				Mockito.when(managerRepository.findOneWithEquipeById(ID_MANAGER)).thenReturn(manager);
				Mockito.when(technicienRepository.findByMatricule(MATRICULE_TECH)).thenReturn(technicien);
				
				//On dit qu'on retourne ce Manager auquel on vient d'ajouter un technicien. Si on avait mit 
				//.save(manager) on n'est pas sur que ce soit ce Manager qu'on sauvegarde. Il n'aura peut etre pas de technicien
				Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(AdditionalAnswers.returnsFirstArg());
				Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(AdditionalAnswers.returnsFirstArg());

				//When
				managerService.addTechniciens(ID_MANAGER, MATRICULE_TECH);
				
				//Then
				/*On verifie que le technicien a bien été ajouté au manager */
				Assertions.assertThat(manager.getEquipe()).contains(technicien);
				
				/*On verifie que le technicien fait bien partie de l'équipe du manager */
				Assertions.assertThat(manager.getEquipe()).hasSize(1);
				
				/*On verifie que le manager du technicien est bien le bon */ 
				Assertions.assertThat(technicien.getManager()).isEqualTo(manager);
				
				/* On verifie que les méthodes ont bien été appelées une fois chacunes*/
				Mockito.verify(managerRepository, Mockito.times(1)).findOneWithEquipeById(ID_MANAGER);
				Mockito.verify(technicienRepository, Mockito.times(1)).findByMatricule(MATRICULE_TECH);
				
				/* On verifie avec cette methode que le manager contient bien le bon technicien*/
				ArgumentCaptor<Manager> managerCaptor = ArgumentCaptor.forClass(Manager.class);
				Mockito.verify(managerRepository).save(managerCaptor.capture());
				Assertions.assertThat(managerCaptor.getValue().getEquipe()).containsOnly(technicien);
				
			}
		  
	
	
	
}
