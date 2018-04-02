package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)

public class ManagerParameterizedTest {
	
	
	    @Parameterized.Parameter(0) public Double salaire;
	    @Parameterized.Parameter(1) public Integer tailleEquipe;
	    @Parameterized.Parameter(2) public Double expectedSalaire;

	    @Parameterized.Parameters(name ="pour taille équipe {1} et salaire {0}, le résultat est : {2}")
	    public static Collection<Object[]> data(){
	        return Arrays.asList(new Object[][]{
	                {2000d, 5, 3600d}

	        });
	    }
	    @Test
	    public void testSetSalaire(){
	        //Given
	        Manager manager = new Manager();
	        for (int i = 0; i<tailleEquipe; i++) {
	            manager.ajoutTechnicienEquipe(new Technicien("tech"+i, null, null, null, null, null));
	        }


	        manager.setSalaire(salaire);


	        // When
	        Double sal = manager.getSalaire();
	        // Then

	        Assertions.assertThat(sal).isEqualTo(expectedSalaire);
	    }

	}



