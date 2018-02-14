package service;

import com.ipiecoles.java.java340.model.model.Manager;
import com.ipiecoles.java.java340.model.model.Technicien;
import com.ipiecoles.java.java340.model.repository.ManagerRepository;
import com.ipiecoles.java.java340.model.repository.TechnicienRepository;
import com.ipiecoles.java.java340.model.service.TechnicienService;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import org.assertj.core.api.Assertions;

@RunWith(MockitoJUnitRunner.class)
public class TechnicienServiceTest {

    @InjectMocks
    private TechnicienService technicienService;

    @Mock
    private TechnicienRepository technicienRepository;

    @Mock
    private ManagerRepository managerRepository;

    @Test
    public void testAddManager(){

        //Given
        final String MATRICULE = "M12345";
        final Long ID_TECHNICIEN = 1L;

        Technicien technicien = new Technicien("VenetT","JulienT","T12457", new LocalDate(),1500d,3);
        Manager manager =new Manager("VenetM","JulienM", MATRICULE,  new LocalDate(),1500d,new HashSet<>());

        Mockito.when(technicienRepository.findOne(ID_TECHNICIEN)).thenReturn(technicien);
        Mockito.when(managerRepository.findByMatricule(MATRICULE)).thenReturn(manager);

        Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(AdditionalAnswers.returnsFirstArg());
        Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(AdditionalAnswers.returnsFirstArg());

        //When
        manager = technicienService.addManager(ID_TECHNICIEN, MATRICULE);

        //Then
        Mockito.verify(technicienRepository, Mockito.times(1)).findOne(ID_TECHNICIEN);
        Mockito.verify(managerRepository, Mockito.times(1)).findByMatricule(MATRICULE);

        Assertions.assertThat(manager.getEquipe()).hasSize(1);
        Assertions.assertThat(manager.getEquipe()).contains(technicien);

        Assertions.assertThat(technicien.getManager()).isEqualTo(manager);

        Assertions.assertThat(manager.getEquipe()).hasSize(1);
        Assertions.assertThat(manager.getEquipe()).contains(technicien);
        Assertions.assertThat(technicien.getManager()).isEqualTo(manager);

        ArgumentCaptor<Technicien> technicienCaptor = ArgumentCaptor.forClass(Technicien.class);
        Mockito.verify(technicienRepository).save(technicienCaptor.capture());
        Assertions.assertThat(technicienCaptor.getValue().getManager()).isEqualTo(manager);
    }
}