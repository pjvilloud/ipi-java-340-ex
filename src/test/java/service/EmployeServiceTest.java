package service;

import com.ipiecoles.java.java340.model.repository.EmployeRepository;
import com.ipiecoles.java.java340.model.service.EmployeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import javax.persistence.EntityNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class EmployeServiceTest {

    @InjectMocks
    private EmployeService employeService;

    @Mock
    private EmployeRepository employeRepository;

    @Test(expected = EntityNotFoundException.class)
    public void testFindByImmatNotFound(){

        //Given
        Mockito.when(employeRepository.findByMatricule("C12345")).thenReturn(null);

        //When
        employeService.findByMatricule("C12345");

        //then on attends une exeption
    }
}