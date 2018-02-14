package com.ipiecoles.java.java340.model;
import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.builder.CommercialBuilder;

import com.ipiecoles.java.java340.repository.EmployeRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
//SpringBootTest(Classes = SpringWebApplication.class) //Marche dans tous les cas !
@DataJpaTest
public class EmployeRepositoryTest {

    @Autowired
    EmployeRepository employeRepository;

    Commercial com, v, v2, v3;
    @Before
    public void before() throws EmployeException {//Nom before arbitraire
        //Appelé avant chaque test

        com = CommercialBuilder.aCommercial().withPrenom("REMI").build();

        employeRepository.deleteAll();

        v = new Commercial();
        v.setPrenom("REMI");
        v.setNom("TEST");
        employeRepository.save(v);

        v2 = new Commercial();
        v2.setPrenom("CEDRIC");
        v2.setNom("JEAN");
        employeRepository.save(v2);

        v3 = new Commercial();
        v3.setPrenom("PIERRE");
        v3.setNom("REMI");
        employeRepository.save(v3);

    }

    @Test
    public void testfindByNomOrPrenomAllIgnoreCaseNom(){

        //Given

        //When
        List<Employe> result = employeRepository.findByNomOrPrenomAllIgnoreCase("TEST");

        //Then
        //Assertions.assertThat(result).hasSize(1);
        //Assertions.assertThat(result).contains(v);
    }

    @Test
    public void testfindByNomOrPrenomAllIgnoreCaseNomPrenom(){

        //Given

        //When
        List<Employe> result2 = employeRepository.findByNomOrPrenomAllIgnoreCase("REmI");

        //Then
        //Assertions.assertThat(result2).hasSize(2);
        //Assertions.assertThat(result2).contains(v);
    }

    @Test
    public void testfindByNomOrPrenomAllIgnoreCaseEmpty(){

        //Given

        //When
        List<Employe> result2 = employeRepository.findByNomOrPrenomAllIgnoreCase("toto");

        //Then
        //Assertions.assertThat(result2).isEmpty();
    }

}
