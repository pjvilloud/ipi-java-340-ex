package service;

import com.ipiecoles.java.java340.model.model.Manager;
import com.ipiecoles.java.java340.model.repository.ManagerRepository;
import com.ipiecoles.java.java340.model.service.ManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Test(expected = EntityNotFoundException.class)
    public void testFindByImmatNotFound(){

        //Given
        Mockito.when(managerRepository.findByMatricule("C12345")).thenReturn(null);
        Manager m = new Manager();

        //When
        managerService.addTechniciens(m.getId(), m.getMatricule());

        //then on attends une exeption
    }
}