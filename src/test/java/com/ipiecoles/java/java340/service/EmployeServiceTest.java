package com.ipiecoles.java.java340.service;
import org.assertj.core.api.Assertions;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.Mockito;
        import org.mockito.runners.MockitoJUnitRunner;
        import javax.persistence.EntityNotFoundException;
        import com.ipiecoles.java.java340.model.Commercial;
        import com.ipiecoles.java.java340.model.Employe;
        import com.ipiecoles.java.java340.repository.EmployeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeServiceTest {
    @InjectMocks
    private EmployeService employeService;
    @Mock
    private EmployeRepository employeRepository;

    @Test(expected = EntityNotFoundException.class)

    public void testFindByMatriculeNotFound(){
        //Given
        Mockito.when(employeRepository.findByMatricule(Mockito.anyString())).thenReturn(null);
        //When
        employeService.findByMatricule("C12345");
        //Then exception
    }

    @Test
    public void testFindByMatriculeFound(){
        //Given
        Commercial commercial = new Commercial();
        Mockito.when(employeRepository.findByMatricule(Mockito.anyString())).thenReturn(commercial);
        //When
        Employe employe= employeService.findByMatricule("connu");
        //Then
        Assertions.assertThat(employe).isEqualTo(commercial);
    }

}

