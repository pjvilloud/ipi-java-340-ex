package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value= Parameterized.class)
public class CommercialParameterizedTest {
	
	@Parameter(value=0)
	public Integer perf;
	
	
	@Parameter(value = 1)
	public Note result;
	
	@Parameters(name = "")
	  public static Collection<Object[]> data() {
	      return Arrays.asList(new Object[][]{
	        {0,Note.INSUFFISANT},{50,Note.INSUFFISANT},{100,Note.PASSABLE},{150,Note.BIEN},{200,Note.TRES_BIEN},{null,null},{600, null}
	      });
	  }
	
	
	
	
	
	@Test 
	public void TestEquivalenceNote() {
		Commercial commercial= new Commercial();
		commercial.setPerformance(perf);
		
		Note note =commercial.equivalenceNote();
		
		Assertions.assertThat(commercial.equivalenceNote()).isEqualTo(result);
		
	}

}
