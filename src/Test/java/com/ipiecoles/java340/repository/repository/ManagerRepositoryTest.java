package com.ipiecoles.java340.repository.repository;

import com.ipiecoles.java.java340.SpringWebApplication;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringWebApplication.class)
@DataJpaTest
public class ManagerRepositoryTest {

    Commercial Boubacar;
    Commercial Yves;
    Commercial Dupond;
    @Autowired
    EmployeRepository employeRepository;

    @Before
    public void setUp() {
        employeRepository.deleteAll();
        Boubacar=new Commercial("Boubacar", "SEIN", "C12345", new LocalDate(), 7000d, 7000d, 5);
        Yves=new Commercial("Yves", "jean", "C12346", new LocalDate(), 4500d, 6000d, 5);
        Dupond=new Commercial("Dupond", "Jacques", "C12347", new LocalDate(), 1500d, 0d, 0);
        Boubacar=employeRepository.save(Boubacar);
        Yves=employeRepository.save(Yves);
        Dupond=employeRepository.save(Dupond);
    }
   @After
    public void tearDown(){
        employeRepository.deleteAll();
    }

    @Test
 public void findEmployesPlusRichesTest(){
              //given


               //when
        		List<Employe> listeEmp = employeRepository.findEmployePlusRiches();
                //then
                Assertions.assertThat(listeEmp).hasSize(2);
        	    Assertions.assertThat(listeEmp).contains(Boubacar);
                Assertions.assertThat(listeEmp).contains(Yves);

        	}

    @Test
 	public void findEmployesPlusRichesTestWithNoResults(){
        	//
             employeRepository.deleteAll();
        	 Commercial seini = new Commercial("seini", "bouba", "000VB", new LocalDate(), 2500d, 3000d, 3);
        	employeRepository.save(seini);

                List<Employe> listeEmp = employeRepository.findEmployePlusRiches();
        		/*Assertions.assertThat(listeEmp).contains(seini); ne marche pas car la requette nous donne le les salaire strictement superieur ,
        		donc en  mettant un seul salarie ds la base de donnée , nous auront aucun resultat au dessus de la moyenne(vu que le salaire sera forcement egale au salaire)
        		 */
        		//celle ci desous marche par contre
        		Assertions.assertThat(listeEmp).isEmpty();
        	}
}