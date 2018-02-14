package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.SpringWebApplication;
import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.builder.CommercialBuilder;
import com.ipiecoles.java.java340.repository.EmployeRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
//@SpringBootTest(Classes = SpringWebApplication.class) //Marche dans tous les cas !
@DataJpaTest
public class ManagerTestFindEmployePlusRiches {
    @Autowired
    EmployeRepository employeRepository;

    Employe emp,emp2,emp3;

    @Before
    public void before() throws EmployeException {//Nom before arbitraire
        //Appelé avant chaque test

        employeRepository.deleteAll();
        emp = CommercialBuilder.aCommercial().withSalaire(1500d).build();
        emp2 = CommercialBuilder.aCommercial().withSalaire(3500d).build();
        emp3 = CommercialBuilder.aCommercial().withSalaire(3500d).build();

        employeRepository.save(emp);
        employeRepository.save(emp2);
        employeRepository.save(emp3);
    }


    @Test
    public void testFindEmployePlusRiches() {

        //When
        List<Employe> employePlusRiches = employeRepository.findEmployePlusRiches();

        //Then
        Assertions.assertThat(employePlusRiches).hasSize(2);
        Assertions.assertThat(employePlusRiches).contains(emp2,emp3);

    }
}
