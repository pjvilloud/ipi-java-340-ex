package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value=Parameterized.class)
public class CommercialParameterizedTest {
	
	 @Parameter(value = 0)//org.junit.runners.Parameterized.Parameter
	  public Integer comparateur;
	  @Parameter(value = 1)
	  public Note noteAcomparer;
//	  @Parameter(value = 2)//org.junit.runners.Parameterized.Parameter
//	  public Double caAnnuel;
//	  @Parameter(value = 3)
//	  public Double expectedPrime;
	  //org.junit.runners.Parameterized.Parameters
	  @Parameters(name = "{0} est equivalent à : {1}")
	  public static Collection<Object[]> data() {
	      return Arrays.asList(new Object[][]{
	        {0, Note.INSUFFISANT}, 
	        {50, Note.INSUFFISANT}, 
	        {100, Note.PASSABLE}, 
	        {150, Note.BIEN}, 
	        {200, Note.TRES_BIEN},
	        {null, null}
//	        {0, Note.INSUFFISANT, 0d, 500d}, 
//	        {50, Note.INSUFFISANT, null, 500d}, 
//	        {100, Note.PASSABLE, 9000d, 500d}, 
//	        {150, Note.BIEN, 100000d, 5000d}, 
//	        {200, Note.TRES_BIEN, null, null},
//	        {null, null, null, null}
	      });
	  }

	  @Test
	  public void testEquivalenceNote(){
		//GIVEN
		    Commercial commercial = new Commercial();
	        commercial.setPerformance(comparateur);
			//WHEN
			 Note note = commercial.equivalenceNote();
			//THEN
			Assertions.assertThat(note).isEqualTo(noteAcomparer);	

	  }
//	  @Test
//	  public void testPrimeAnnuelle(){
//		//GIVEN
//		  Assume.assumeTrue(b:expectedPrime);
//		    Commercial commercial = new Commercial();
//	        commercial.setPerformance(caAnnuel);
//			//WHEN
//			 Note note = commercial.equivalenceNote();
//			//THEN
//			Assertions.assertThat(note).isEqualTo(note);	
//
//	  }
}
	