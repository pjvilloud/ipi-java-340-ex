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
		@Test
		public void testAddTechniciens() {
			
			
			// Given
			final Long ID_MANAGER = 1L; 
			Technicien julien = new Technicien("Julien", "Pierre", "T11223", new LocalDate(), 1500d, 3);
			Technicien marc = new Technicien("Marc", "Arnaud", "T36251", new LocalDate(), 1500d, 2);
			Manager sophie = new Manager("Sophie", "Alain", "M22335", new LocalDate(), 2500d, new HashSet<>()); 
			sophie.setId(ID_MANAGER);
			Mockito.when(managerRepository.findOne(ID_MANAGER)).thenReturn(sophie);
			Mockito.when(technicienRepository.findByMatricule(julien.getMatricule())).thenReturn(julien);
			Mockito.when(technicienRepository.findByMatricule(marc.getMatricule())).thenReturn(marc);
			Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(AdditionalAnswers.returnsFirstArg());
			Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(AdditionalAnswers.returnsFirstArg());
			
			// When 
			managerService.addTechniciens(ID_MANAGER, julien.getMatricule());
			managerService.addTechniciens(ID_MANAGER, marc.getMatricule());
			
			// Then 
			Mockito.verify(managerRepository, Mockito.times(1)).findOne(ID_MANAGER);
			Mockito.verify(technicienRepository, Mockito.times(1)).findByMatricule(julien.getMatricule());
			Mockito.verify(technicienRepository, Mockito.times(1)).findByMatricule(marc.getMatricule());
			Assertions.assertThat(sophie.getEquipe()).hasSize(2); 
			Assertions.assertThat(sophie.getEquipe()).contains(julien, marc); 
			Assertions.assertThat(julien.getManager()).isEqualTo(sophie); 
			Assertions.assertThat(marc.getManager()).isEqualTo(sophie); 
			ArgumentCaptor<Manager> managerCaptor = ArgumentCaptor.forClass(Manager.class); 
			Mockito.verify(managerRepository).save(managerCaptor.capture()); 
			Assertions.assertThat(managerCaptor.getValue().getEquipe()).contains(julien,marc);
		}
}
