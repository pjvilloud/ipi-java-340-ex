package service;

import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;
import com.ipiecoles.java.java340.repository.ManagerRepository;
import com.ipiecoles.java.java340.repository.TechnicienRepository;
import com.ipiecoles.java.java340.service.ManagerService;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {

    @InjectMocks
    private ManagerService managerService;

    @Mock
    private ManagerRepository managerRepository;

    @Mock
    private TechnicienRepository technicienRepository;



    @Test(expected = EntityNotFoundException.class)
    public void testAddTechniciens (){
        //Given
        Manager manager = new Manager();
        manager.setId(15420L);
        Technicien technicien = new Technicien("John", "Jeanne", "T12345", new LocalDate(), 1600d, 2);

        Mockito.when(technicienRepository.findByMatricule("T12345")).thenReturn(technicien); 
        Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(AdditionalAnswers.returnsFirstArg());
        
        Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(AdditionalAnswers.returnsFirstArg());

        //When
        managerService.addTechniciens(1L,"T12345");


        //then
        
        Assertions.assertThat(manager.getEquipe()).isEqualTo(technicien);
        Assertions.assertThat(technicien.getManager()).isEqualTo(manager);
        

    }


}
