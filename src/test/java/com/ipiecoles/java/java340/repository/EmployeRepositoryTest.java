package com.ipiecoles.java.java340.repository;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.repository.EmployeRepository;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeRepositoryTest {

    @Autowired
    EmployeRepository employeRepository;
    @Autowired
            CommercialRepository commercialRepository;


    Commercial pierreDurand = new Commercial("Durand", "Pierre", "C12345", new LocalDate(), 1500d, 0d, 0);

    Commercial jeanJacques = new Commercial("Jacques", "Jean", "C12346", new LocalDate(), 1900d, 0d, 0);

    Commercial jacquesDupond = new Commercial("Dupond", "Jacques", "C12347", new LocalDate(), 1500d, 0d, 0);

    @Before
    public void setUp() {
        commercialRepository.deleteAll();
        employeRepository.deleteAll();
        employeRepository.save(pierreDurand);
        employeRepository.save(jeanJacques);
        employeRepository.save(jacquesDupond);
    }



    @Test
    public void testfindEmployesPlusRiches() {
        //Given

        //When
        Assertions.assertThat(employeRepository.findEmployePlusRiches().get(0)).isEqualTo(jeanJacques);
    }

}