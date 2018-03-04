package com.ipiecoles.java.java340.repository;

import com.ipiecoles.java.java340.SpringWebApplication;
import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.Technicien;
import com.ipiecoles.java.java340.model.builder.CommercialBuilder;
import com.ipiecoles.java.java340.model.maker.TechnicienMaker;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest(classes = SpringWebApplication.class)
public class EmployeRepositoryTest {

    @Autowired
    EmployeRepository employeRepository;

    Commercial pierreDurand, jeanJacques, jacquesDupond;
    // Partie evaluation 
    Technicien bobBrico, scieSauteuse, tourneVis;
      

    @Before
    public void setUp() throws EmployeException {
        employeRepository.deleteAll();
        
        try{
        	pierreDurand = CommercialBuilder.aCommercial().withNom("Durand").withPrenom("Pierre").withSalaire(5000d).build();
        	jeanJacques = CommercialBuilder.aCommercial().withNom("Jacques").withPrenom("Jean").withSalaire(3000d).build();
        	jacquesDupond = CommercialBuilder.aCommercial().withNom("Dupond").withPrenom("Jacques").withSalaire(3000d).build();
        	// If I use a TechnicienBuilder, I got a null pointer exception so I have to use the maker 
        	bobBrico = TechnicienMaker.aTechnicien().withNom("Bob").withPrenom("Le Bricoleur").withSalaire(1650d).build();
            scieSauteuse = TechnicienMaker.aTechnicien().withNom("Thomas").withPrenom("Pesquet").withSalaire(1500d).build();
            tourneVis = TechnicienMaker.aTechnicien().withNom("Charles").withPrenom("Xavier").withSalaire(1650d).build();
        }catch (EmployeException e){};
        
        // Persistence
        pierreDurand = employeRepository.save(pierreDurand);
        jeanJacques = employeRepository.save(jeanJacques);
        jacquesDupond = employeRepository.save(jacquesDupond);
        bobBrico = employeRepository.save(bobBrico);
        scieSauteuse = employeRepository.save(scieSauteuse);
        tourneVis = employeRepository.save(tourneVis);
    }
  
    @After
    public void tearDown(){
        employeRepository.deleteAll();
    }
    
    @Test
    public void testFindByNomOrPrenomAllIgnoreCasePrenom(){
        //Given

        //When
        //List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("pierre");
    	// On cherche comme nom OU prenom un jAcqueS mais on ignore la case
    	List<Employe> liste = employeRepository.findByNomOrPrenomAllIgnoreCase("jAcqueS");

        //Then
        //Assertions.assertThat(employes).hasSize(1);
        //Assertions.assertThat(employes).contains(pierreDurand);
    	// techniquement on doit donc trouver 2 réponses
    	Assertions.assertThat(liste).hasSize(2);
    	// Les deux réponses sont normalement les suivantes : 
    	Assertions.assertThat(liste).contains(jeanJacques,jacquesDupond);

    }
 
    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNom(){
        //Given

        //When
    	// ON recherche un durand en ignorant la case
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("durand");
        // on doit en trouver un
        Assertions.assertThat(employes).hasSize(1);
        // qui est contenu dans pierreDurand
        Assertions.assertThat(employes).contains(pierreDurand);
    }


    @Test
    public void testFindByNomOrPrenomAllIgnoreCaseNotFound(){
        //Given

        //When
    	// On recherche un toto
        List<Employe> employes = employeRepository.findByNomOrPrenomAllIgnoreCase("toto");
        // Normalement la liste de résultats doit etre vide
        Assertions.assertThat(employes).isEmpty();
    }
    
    
    /**
     * ----------------------------------------------------------------------------------------------------------------------
     * Partie evaluation 
     * ----------------------------------------------------------------------------------------------------------------------
     */
    
    /**
     *  Dans EmployeRepository on ne trouve pas findEmployePlusRiches() mais cependant EmployeRepository étend BaseEmployeRepository
     *  et c'est dans celui-ci que l'on trouve la méthode. 
     *  
     *  La méthode est donc: 
     *      @Query(value = "SELECT * FROM Employe WHERE salaire > (SELECT avg(e2.salaire) FROM Employe e2)", nativeQuery = true)
     *      List<T> findEmployePlusRiches();
     *  Il nous faut donc une liste de techniciens pour ce test. On va également utiliser un builder comme on l'avait fait pour Commercial
     *  
     */
    
    
    @Test
    public void testfindEmployePlusRichesWithEmployeesManyResults(){
        //Given

        //When
    	List<Employe> employees = employeRepository.findEmployePlusRiches();

        //Then
    	// Should find 3 people 
    	Assertions.assertThat(employees).hasSize(3);
    	// Should find the following people: 
    	Assertions.assertThat(employees).contains(pierreDurand, jeanJacques, jacquesDupond);
    }
    
    @Test
    public void testfindEmployePlusRichesWithNoEmployees(){
        //Given
    	employeRepository.deleteAll();
    	
        //When
    	List<Employe> employees = employeRepository.findEmployePlusRiches();

        //Then
    	// Should find nobody
    	Assertions.assertThat(employees).hasSize(0);
    	// So the result should be empty
    	Assertions.assertThat(employees).isEmpty();
    }
    
    @Test
    public void testfindEmployePlusRichesWithSalaryEqualToMean() throws EmployeException{
        //Given
    	employeRepository.deleteAll();
    	bobBrico = TechnicienMaker.aTechnicien().withNom("Bob").withPrenom("Le Bricoleur").withSalaire(1650d).build();
    	bobBrico = employeRepository.save(bobBrico);	
    	
        //When
    	List<Employe> employees = employeRepository.findEmployePlusRiches();

        //Then
    	// Should find nobody as the query is > and not >=
    	Assertions.assertThat(employees).hasSize(0);
    	// So the result should be empty
    	Assertions.assertThat(employees).isEmpty();
    }
    
    @Test
    public void testfindEmployePlusRichesWithEmployeesOneResult() throws EmployeException{
        //Given
    	employeRepository.deleteAll();
    	bobBrico = TechnicienMaker.aTechnicien().withNom("Bob").withPrenom("Le Bricoleur").withSalaire(1650d).build();
        scieSauteuse = TechnicienMaker.aTechnicien().withNom("Thomas").withPrenom("Pesquet").withSalaire(1500d).build();
        tourneVis = TechnicienMaker.aTechnicien().withNom("Charles").withPrenom("Xavier").withSalaire(1650d).build();
    	pierreDurand = CommercialBuilder.aCommercial().withNom("Durand").withPrenom("Pierre").withSalaire(5000d).build();
    	bobBrico = employeRepository.save(bobBrico);	
    	scieSauteuse = employeRepository.save(scieSauteuse);
    	tourneVis = employeRepository.save(tourneVis);
    	pierreDurand = employeRepository.save(pierreDurand);
    	
        //When
    	List<Employe> employees = employeRepository.findEmployePlusRiches();

        //Then
    	// Only one guy is rich
    	Assertions.assertThat(employees).hasSize(1);
    	// So the result should have only this guy
    	Assertions.assertThat(employees).contains(pierreDurand);
    }
    
      
}
