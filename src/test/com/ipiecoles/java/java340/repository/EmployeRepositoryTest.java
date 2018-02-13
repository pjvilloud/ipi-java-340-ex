package com.ipiecoles.java.java340.repository;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest(classes = SpringWebAppApplication.class)
public class EmployeRepositoryTest {
    @Autowired
    EmployeRepository employeRepository;

    // init var
    Commercial Toto, Titi;

    @Before
    public void setUp(){
        employeRepository.deleteAll();
        // créa des objets + save
        Toto = new Commercial("Toto","Toto", "C12345", new LocalDate(),1500d, 0d, 0);
        Titi = new Commercial("Titi","Titi", "C12345", new LocalDate(),1500d, 0d, 0);

        Toto = employeRepository.save(Toto);
        Titi = employeRepository.save(Titi);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCase(){
        //Given

        //When
        List<Employe> result = employeRepository.findByNomOrPrenomAllIgnoreCase("Toto");

        //Then
        Assertions.assertThat(result).hasSize(1); // on vérifie que la liste à un seul élément
        Assertions.assertThat(result).contains(Toto);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNotFound(){

        //When
        List<Employe> result = employeRepository.findByNomOrPrenomAllIgnoreCase(null);

        //Then
        Assertions.assertThat(result).isEmpty();
    }
}
