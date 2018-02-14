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
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class TechnicienServiceTest {
    @InjectMocks
    public TechnicienService technicienService;

    @Mock
    public TechnicienRepository technicienRepository;

    @Mock
    public ManagerRepository managerRepository;

    public Technicien employeTechnicien;
    public Manager employeManager;
    @Test
    public void testAddManager() throws EmployeException {

        //Given
        employeTechnicien = new Technicien();
        employeTechnicien.setNom("DURAND");
        employeTechnicien.setMatricule("C4321");

        employeManager = new Manager();
        employeManager.setNom("JULES");
        employeManager.setMatricule("C1234");

        Mockito.when(technicienRepository.findOne(Mockito.anyLong())).thenReturn(employeTechnicien);
        Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(returnsFirstArg());

        Mockito.when(managerRepository.findByMatricule(Mockito.anyString())).thenReturn(employeManager);
        Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(returnsFirstArg());

        //When Manager addManager(Long idTechnicien, String matricule)
        technicienService.addManager(employeTechnicien.getId(), employeManager.getMatricule());

        //Then
        ArgumentCaptor<Technicien> technicienCaptor = ArgumentCaptor.forClass(Technicien.class);
        ArgumentCaptor<Manager> managerCaptor = ArgumentCaptor.forClass(Manager.class);

        Mockito.verify(technicienRepository, Mockito.times(1)).save(technicienCaptor.capture());
        Assertions.assertThat(technicienCaptor.getValue().getManager()).isEqualTo(employeManager);

        Mockito.verify(managerRepository, Mockito.times(1)).save(managerCaptor.capture());
        Assertions.assertThat(managerCaptor.getValue().getEquipe()).contains(employeTechnicien);

    }
}
