package service;

        import com.ipiecoles.java.java340.model.Maker;
        import com.ipiecoles.java.java340.model.model.Manager;
        import com.ipiecoles.java.java340.model.model.Technicien;
        import com.ipiecoles.java.java340.model.repository.ManagerRepository;
        import com.ipiecoles.java.java340.model.repository.TechnicienRepository;
        import com.ipiecoles.java.java340.model.service.ManagerService;
        import org.assertj.core.api.Assertions;
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
    public void testAddTechniciens() {
        //Given
        Manager manager = Maker.makeManager(1);
        manager.setId(15420L);
        Technicien technicien = (Technicien) manager.getEquipe().toArray()[0];

        Mockito.when(technicienRepository.findByMatricule("C12346")).thenReturn(technicien);
        Mockito.when(technicienRepository.save(Mockito.any(Technicien.class))).then(AdditionalAnswers.returnsFirstArg());
        Mockito.when(managerRepository.save(Mockito.any(Manager.class))).then(AdditionalAnswers.returnsFirstArg());

        //When
        managerService.addTechniciens(15420L, "C12346");

        //then
        Assertions.assertThat(technicien.getManager()).isEqualTo(manager);
        Assertions.assertThat(manager.getEquipe()).isEqualTo(technicien);
    }
}