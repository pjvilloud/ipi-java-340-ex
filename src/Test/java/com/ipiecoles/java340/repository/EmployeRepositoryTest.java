package com.ipiecoles.java340.repository;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.repository.EmployeRepository;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeRepositoryTest {

Commercial  pierreDurand;
Commercial jeanJacques;
Commercial jacquesDupond;
        @Autowired
        EmployeRepository employeRepository;
        @Before
        public void setUp() {
            employeRepository.deleteAll();
             pierreDurand=new Commercial("Durand","Pierre","C12345",new LocalDate(),1500d,0d,0);
             jeanJacques=new Commercial("Jean-Jacques","Jean","C12346",new LocalDate(),1500d,0d,0);
             jacquesDupond=new Commercial("Dupond","Jean-Jacques","C12347",new LocalDate(),1500d,0d,0);
            pierreDurand=employeRepository.save(pierreDurand);
            jeanJacques=employeRepository.save(jeanJacques);
            jacquesDupond=employeRepository.save(jacquesDupond);

        }
        @After
        public void tearDown(){
            employeRepository.deleteAll();
        }
        @Test
        public void testFindByNomOrPrenomAllIgnorCasePrenom(){
            //given


            //when
            List<Employe> emp=employeRepository.findByNomOrPrenomAllIgnoreCase("pierre");
            //then
            Assertions.assertThat(emp).hasSize(1);
            Assertions.assertThat(emp).contains(pierreDurand);
        }

        @Test
        public void testFindByNomOrPrenomAllIgnorCaseNomPrenom(){
            //given


            //when
            List<Employe> emp=employeRepository.findByNomOrPrenomAllIgnoreCase("Jacques");
            //then
            Assertions.assertThat(emp).hasSize(2);
            Assertions.assertThat(emp).contains(jeanJacques,jacquesDupond);
        }

    }



