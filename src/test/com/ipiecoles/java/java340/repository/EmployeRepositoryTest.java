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
    Commercial peterParker, tonyStark;

    @Before
    public void setUp(){
        employeRepository.deleteAll();

        // créa des objets + save de ces objets
        peterParker = new Commercial("Parker","Peter", "C12345", new LocalDate(),1500d, 0d, 0);
        tonyStark = new Commercial("Stark","Tony", "C12345", new LocalDate(),2000d, 0d, 0);

        peterParker = employeRepository.save(peterParker);
        tonyStark = employeRepository.save(tonyStark);
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCase(){

        //When
        List<Employe> result = employeRepository.findByNomOrPrenomAllIgnoreCase("Parker");

        //Then
        Assertions.assertThat(result).hasSize(1); // on vérifie que la liste à un seul élément
        Assertions.assertThat(result).contains(peterParker); // on vérifie qu'il contient bien l'objet
    }

    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNotFound(){

        //When
        List<Employe> result = employeRepository.findByNomOrPrenomAllIgnoreCase(null);

        //Then
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void testFindEmployePlusRiche(){

        //When
        List<Employe> result = employeRepository.findEmployePlusRiches();

        //Then
        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result).contains(tonyStark);
    }

    @Test
    public void testFindEmployePlusRicheNotFound(){
        //Given
        peterParker.setSalaire(1500d);
        tonyStark.setSalaire(1500d);

        peterParker = employeRepository.save(peterParker);
        tonyStark = employeRepository.save(tonyStark);

        //When
        List<Employe> result = employeRepository.findEmployePlusRiches();
        //Boolean isSalaireEqual = peterParker.getSalaire().equals(tonyStark.getSalaire());

        //Then
        Assertions.assertThat(result).isEmpty();
        //Assertions.assertThat(isSalaireEqual).isTrue();
    }

    @Test
    public void testFindEmployePlusRicheNull(){
        //Given
        peterParker.setSalaire(null);
        tonyStark.setSalaire(null);

        peterParker = employeRepository.save(peterParker);
        tonyStark = employeRepository.save(tonyStark);

        //When
        List<Employe> result = employeRepository.findEmployePlusRiches();

        //Then
        Assertions.assertThat(result).isEmpty();
    }
}
