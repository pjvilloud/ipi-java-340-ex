package service;

import com.ipiecoles.java.java340.model.model.Technicien;
import com.ipiecoles.java.java340.model.repository.TechnicienRepository;
import com.ipiecoles.java.java340.model.service.TechnicienService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import javax.persistence.EntityNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class TechnicienServiceTest {

    @InjectMocks
    private TechnicienService technicienService;

    @Mock
    private TechnicienRepository technicienRepository;

    @Test(expected = EntityNotFoundException.class)
    public void testAddManager(){
        Technicien t = new Technicien();
        //Given
        Mockito.when(technicienRepository.findByMatricule("inconnu")).thenReturn(null);
        //When
        technicienService.addManager(t.getId(), t.getMatricule());
    }
}