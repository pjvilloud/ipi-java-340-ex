package com.ipiecoles.java.java340.service;

import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;
import com.ipiecoles.java.java340.repository.ManagerRepository;
import com.ipiecoles.java.java340.repository.TechnicienRepository;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static org.mockito.AdditionalAnswers.returnsFirstArg;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {
	
	 @InjectMocks
	    public ManagerService managerService;

	    @Mock
	    public TechnicienRepository technicienRepository;

	    @Mock
	    public ManagerRepository managerRepository;
	    
	    @Test
	    public void testAddTechnicien() {
	    	//Given
	    	Manager manager = new Manager();
	        Technicien technicien = new Technicien("Durand", "Jean", MATRICULE, new LocalDate(), 1500d, 3);
	        
	        Mockito.when(managerRepository.findByMatricule("C12345")).thenReturn(technicien);
	        Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(returnsFirstArg());
	        Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(returnsFirstArg());
	        
	        //When
	        managerService.addTechnicien(12345L, "C12345");
	        
	        //then
	        Mockito.verify(technicienRepository, Mockito.times(1)).findOne(12345L);
	        Mockito.verify(managerRepository, Mockito.times(1)).findByMatricule("C12345");
	        
	        Assertions.assertThat(technicien.getManager()).isEqualTo(manager);
	        Assertions.assertThat(manager.getEquipe()).contains(technicien);

	    }

	
}