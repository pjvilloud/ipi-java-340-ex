package com.ipiecoles.java.java340.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import javax.persistence.EntityNotFoundException;
import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;
import com.ipiecoles.java.java340.repository.ManagerRepository;
import com.ipiecoles.java.java340.repository.TechnicienRepository;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {
	
	  @InjectMocks
	  private ManagerService managerService;
	  @Mock
	  private ManagerRepository managerRepository;
	  @Mock
	  private TechnicienRepository technicienRepository;
	  
	  @Test(expected = EntityNotFoundException.class)
	  public void addTechniciensManagerNull() {
			Mockito.when(managerRepository.findOneWithEquipeById(Mockito.anyLong())).thenReturn(null);
			managerService.addTechniciens(5l, "Manull");
	  }
	  
	  @Test(expected = EntityNotFoundException.class)
	  public void addTechniciensTechnicienNull() {
		  Mockito.when(technicienRepository.findByMatricule(Mockito.anyString())).thenReturn(null);
		  managerService.addTechniciens(5l, "Technull");
	  }
	  
	  @Test(expected = EntityNotFoundException.class)
	  public void addTechniciensManagerExist() {
		  Technicien tech = new Technicien();
		  Manager man = tech.getManager();
		  
		  Mockito.when(managerRepository.findOneWithEquipeById(Mockito.anyLong())).thenReturn(man);
		  Mockito.when(technicienRepository.findByMatricule(Mockito.anyString())).thenReturn(tech);
		  
		  managerService.addTechniciens(5l, "manager");
	  }
	  
	  @Test(expected = EntityNotFoundException.class)
	  public void addTechniciens() {
		  Technicien tech = new Technicien();
		  Manager man = tech.getManager();
		  
		  Mockito.when(managerRepository.findOneWithEquipeById(Mockito.anyLong())).thenReturn(man);
		  Mockito.when(technicienRepository.findByMatricule(Mockito.anyString())).thenReturn(tech);
		  
		  managerService.addTechniciens(5l, "manager");
	  }
	  
}