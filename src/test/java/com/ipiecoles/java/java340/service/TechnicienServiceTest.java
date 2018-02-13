package com.ipiecoles.java.java340.service;

import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.Technicien;
import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.maker.CommercialMaker;
import com.ipiecoles.java.java340.repository.EmployeRepository;
import com.ipiecoles.java.java340.repository.ManagerRepository;
import com.ipiecoles.java.java340.repository.TechnicienRepository;
import org.apache.taglibs.standard.lang.jstl.EmptyOperator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TechnicienServiceTest {
    @InjectMocks
    public TechnicienService technicienService;
    @Mock
    public EmployeRepository employeRepository;
    @Mock
    public ManagerRepository managerRepository;
    @Mock
    public TechnicienRepository technicienRepository;

    public Technicien employeTechnicien;
    public Manager employeManager;
    @Test
    public void testAddProprietaire() throws EmployeException {
/*
        //Given
        employeTechnicien = new Technicien();
        employeTechnicien.setNom("DURAND");
        employeTechnicien.setMatricule("C4321");
        employeManager = new Manager();
        employeManager.setNom("JULES");
        employeManager.setMatricule("C1234");
        Mockito.when(technicienRepository.findOne(Mockito.anyLong())).thenReturn(employeTechnicien);
        Mockito.when(managerRepository.findByMatricule(Mockito.anyString())).thenReturn(employeManager);
        Mockito.when(technicienRepository.save(Mockito.any(Employe.class))).then(Mockito.returnsFirstArg());
        //When Manager addManager(Long idTechnicien, String matricule)
        technicienService.addManager(employeTechnicien.getId(), employeManager.getMatricule());
        //Then
        ArgumentCaptor<Employe> vehiculeCaptor = ArgumentCaptor.forClass(Employe.class);
        Mockito.verify(employeRepository, Mockito.times(1)).save(vehiculeCaptor.capture());
        Assertions.assertThat(vehiculeCaptor.getValue().getProprietaireId()).isEqualTo(2L);
        */
    }
}
