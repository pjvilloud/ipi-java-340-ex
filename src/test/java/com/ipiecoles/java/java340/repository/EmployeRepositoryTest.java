package com.ipiecoles.java.java340.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.service.EmployeService;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeRepositoryTest {
	
	
	@Autowired
    EmployeRepository employe;

    @Test
    public void TestfindByNomOrPrenomAllIgnoreCase(){
        //Given
    	Commercial pierre= new Commercial("charlet","pierre","C12345", new LocalDate(), 1500d, 0d, 0);
        //When
        List<Employe> result = employe.findByNomOrPrenomAllIgnoreCase(pierre.getNom());
        //Then
        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result).contains(pierre);
    }
	
	
}
