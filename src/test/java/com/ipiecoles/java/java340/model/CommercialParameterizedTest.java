package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions; //Biblio d'assertions mieux que junit donc à mettre aussi
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

public class CommercialParameterizedTest
{
	
	/*@RunWith(value = Parameterized.class)//org.junit.runners.Parameterized
	public class CommercialTest
	{
	  @Parameter(value = 0)//org.junit.runners.Parameterized.Parameter
	  public Double primeAnnuelle;
	  @Parameter(value = 1)
	  public Boolean calculePrimeOK;
	  //org.junit.runners.Parameterized.Parameters
	  @Parameters(name = "primeAnnuelle {0} est valide : {1}")
	  public Collection<Object[]> data()
	  {
	      return Arrays.asList(new Object[][]
	    		  {
	        {"0d", false}, {"500", true}, {"null", false}
	      });
	  }
	  
	  @Test
	  public void testCheckPrime()
	  {
	  	//Given, when, Then
	  	 * Assertions.assertThat(Commercial.checkPrime(primeAnnuelle).isEqualTo(calculePrimeOK);
	  }
	}*/
	
	@RunWith(value = Parameterized.class)//org.junit.runners.Parameterized
	public class CommercialTest
	{
	  @Parameter(value = 0)//org.junit.runners.Parameterized.Parameter
	  public Integer performance;
	  @Parameter(value = 1)
	  public Note quelleNote;
	  //org.junit.runners.Parameterized.Parameters
	  @Parameters(name = "performance {0} est valide : {1}")
	  public Collection<Object[]> data()
	  {
	      return Arrays.asList(new Object[][]
	    		  {
	        {null, "Absent"}, {50, Note.INSUFFISANT}, {100, Note.PASSABLE}, {150, Note.BIEN}, {200, Note.TRES_BIEN}
	      });
	  }
	}
}
