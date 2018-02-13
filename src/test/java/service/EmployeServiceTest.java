package service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.repository.EmployeRepository;
import com.ipiecoles.java.java340.service.EmployeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeServiceTest {

	@InjectMocks
	private EmployeService employeService;
	
	@Mock
	private EmployeRepository employeRepository;
	
	@Test
	public void  testFindByMatriculeNotFound() {
		//Given
		Commercial c = new Commercial(); //CommercialMaker.aCommercial().build();
		Mockito.when(employeRepository.findByMatricule(Mockito.anyString())).thenReturn(c);
		
		//When
		Employe e = employeService.findByMatricule("C12345");
		Assertions.assertThat(e).isEqualTo(c);
		
		//Then Exception
	}
}
