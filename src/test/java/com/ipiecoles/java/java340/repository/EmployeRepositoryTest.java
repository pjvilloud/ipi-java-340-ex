package com.ipiecoles.java.java340.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeRepositoryTest {
	
	@Autowired
    EmployeRepository employeRepository;
	
	Commercial pierreDurand, jeanJacques, jacquesDupond;
	
	@Before
	  public void before(){//Nom before arbitraire
		pierreDurand = new Commercial("Durand", "pierre", "b", null, null, null);
		pierreDurand = employeRepository.save(pierreDurand);
	    employeRepository.deleteAll();
	  }

    @Test
    public void testfindByNomOrPrenomAllIgnoreCase(){
        //Given
        
        //When
        List<Employe> result = employeRepository.findByNomOrPrenomAllIgnoreCase("durand");
        //Then
        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result).contains(pierreDurand);
    }
    
    @Test
    public void testFindByNomOrPrenomAllIgnoreCasePrenom(){
        //Given

        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("pierre");
        Assertions.assertThat(employes).hasSize(1);
        Assertions.assertThat(employes.get(0)).isEqualTo(pierreDurand);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNom(){
        //Given

        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("durand");
        Assertions.assertThat(employes).hasSize(1);
        Assertions.assertThat(employes.get(0)).isEqualTo(pierreDurand);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNomPrenom(){
        //Given

        //When
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("jacques");
        Assertions.assertThat(employes).hasSize(2);
        Assertions.assertThat(employes).contains(jeanJacques, jacquesDupond);
    }
}
