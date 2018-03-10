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
public class TechnicienServiceTest {
	
	@InjectMocks
	public TechnicienService technicienService;
	
	@Mock
	public TechnicienRepository technicienRepository;
	
	@Mock
	public ManagerRepository managerRepository;
	
	@Test
	public void testAddManager(){
		
		//Given
		final String  MATRICULE= "M12345";
		final Long ID_TECHNICIEN = 1L;
		
		Technicien technicien = new Technicien("Pierre", "Jean", "T01234", new LocalDate(), 2500d, 3) ;
		Manager manager = new Manager("Dupond", "Jack", MATRICULE, new LocalDate(), 2500d, new HashSet<Technicien>());
		
		//On s'assure que les mocks renvoient bien les valeurs que l'on vient de définir: 
		Mockito.when(technicienRepository.findOne(ID_TECHNICIEN)).thenReturn(technicien);
		Mockito.when(managerRepository.findByMatricule(MATRICULE)).thenReturn(manager);
		
		//On dit qu'on retourne ce Manager auquel on vient d'ajouter un technicien. Si on avait mit 
		//.salve(manager) on n'est pas sur que ce soit ce Manager qu'on sauvegarde. Il n'aura peut etre pas de technicien
		Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(AdditionalAnswers.returnsFirstArg());
		Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(AdditionalAnswers.returnsFirstArg());

		//When
		technicienService.addManager(ID_TECHNICIEN, MATRICULE);
		
		//Then
		/*On verifie que le technicien a bien été ajouté au manager */
		Assertions.assertThat(manager.getEquipe()).contains(technicien);
		
		/*On verifie que le technicien fait bien partie de l'équipe du manager */
		Assertions.assertThat(manager.getEquipe()).hasSize(1);
		
		/*On verifie que le manager du technicien est bien le bon */ 
		Assertions.assertThat(technicien.getManager()).isEqualTo(manager);
		
		/* On verifie que les méthodes ont bien été appelées une fois chacunes*/
		Mockito.verify(technicienRepository, Mockito.times(1)).findOne(ID_TECHNICIEN);
		Mockito.verify(managerRepository, Mockito.times(1)).findByMatricule(MATRICULE);
		
		/* On verifie avec cette methode que ce qui est contenue dans t (cf methode add manager dans technicienService) que t contien bien le bon manager*/
		ArgumentCaptor<Technicien> technicienCaptor = ArgumentCaptor.forClass(Technicien.class);
		Mockito.verify(technicienRepository).save(technicienCaptor.capture());
		Assertions.assertThat(technicienCaptor.getValue().getManager()).isEqualTo(manager);
		
	}
	

}
