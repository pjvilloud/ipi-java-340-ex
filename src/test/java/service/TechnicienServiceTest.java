package service;

import javax.persistence.EntityNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ipiecoles.java.java340.repository.TechnicienRepository;
import com.ipiecoles.java.java340.service.TechnicienService;

@RunWith(MockitoJUnitRunner.class)
public class TechnicienServiceTest {

	
		@InjectMocks
		private TechnicienService technicienService;
		
		@Mock
		private TechnicienRepository technicienRepository;
		
		@Test(expected = EntityNotFoundException.class)
		public void testAddManagerNotFound() {
			
			//Given
			Mockito.when(technicienRepository.findByMatricule("C12345")).thenReturn(null);
			
			//When
			technicienService.addManager(10L, "C12345");
			
			//Then "On attend une exception
		}	
}