package com.ipiecoles.java.java340;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import com.ipiecoles.java.java340.model.Commercial;


public class CommercialTests {

	 @Test //dans org.junit.Test
	  public void testPrimeAnnuelle(){
		 
		 //Given = 
		 Commercial commercial = new Commercial();
		 commercial.setCaAnnuel(null);
		 
		 //When
		Double prime = commercial.getPrimeAnnuelle();
		 		
		//Then
		Assertions.assertThat(prime).isEqualTo(500d);
	 }
	 
	 @Test //dans org.junit.Test
	  public void testPerformance(){
		 Commercial commercial = new Commercial();
		  
		 //Given
		 Integer performance = commercial.getPerformance();
		 
		 //Then
		 Assertions.assertThat(performance).isNull();
	 }
}
