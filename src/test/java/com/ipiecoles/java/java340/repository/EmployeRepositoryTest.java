package com.ipiecoles.java.java340.repository;

import com.ipiecoles.java.java340.SpringWebApplication;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.Manager;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.joda.time.LocalDate;

import java.util.List;

@RunWith(SpringRunner.class)
//@DataJpaTest
//(Repository)
@SpringBootTest(classes = SpringWebApplication.class)
//marche dans tous las cas (Repository)
public class EmployeRepositoryTest {

        @Autowired
        EmployeRepository employeRepository;
        @Autowired
        CommercialRepository commercialRepository;
        Commercial pierreDurand = new Commercial("Durand","Pierre","C12345", new LocalDate(),1500d, 0d,0);
        Commercial jeanJacques = new Commercial("Jacques","Jean","C12346", new LocalDate(),1500d, 0d,0);
        Commercial jacquesDupond = new Commercial("Dupond","Jacques", "C12347", new LocalDate(),1500d, 0d,0);
        @Before
        public void setUp() {
            employeRepository.deleteAll();
            employeRepository.deleteAll();
            employeRepository.save(pierreDurand);
            employeRepository.save(jeanJacques);
            employeRepository.save(jacquesDupond);
        }
        @Test
        public void findByNomOrPrenomAllIgnoreCasePrenom(){
            //Given

            //When

            List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("pierre");

            //Then
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

    @After
    public void tearDown(){
        employeRepository.deleteAll();
    }

   
   
   
    
    
    
    	  @Test
    	  	public void testFindEmployePlusRiches() {
    	      //Given = Initialisation des données d'entrée
    		  
    		  final Double salaire;
    	      final Double moyenne ;
    	      Commercial empl1 = employeRepository.save(new Commercial("toto","tata", "C14800",null,5000d, 0d));
    	      Commercial empl2 = employeRepository.save(new Commercial("soso","sasa", "C14801",null,6000d, 0d));
    	      Commercial empl3 = employeRepository.save(new Commercial("popo","papa", "C14802",null,1000d, 0d));
    	      Commercial empl4 = employeRepository.save(new Commercial("lolo","lala", "C14803",null,2000d, 0d));
    	      //ctrl+alt+bas
    	      Commercial empl5 = employeRepository.save(new Commercial("toto","tata", "C14800",null,3000d, 0d));
    	      
    	      //When = Exécution de la méthode à tester
    	      
    	      List<Employe> liste = employeRepository.findEmployePlusRiches();

    	      //Then = Vérifications de ce qu'a fait la méthode
    	      Assertions.assertThat(liste).contains(empl1,empl2);
    	}

    
    
    
    
    
    
    
}













