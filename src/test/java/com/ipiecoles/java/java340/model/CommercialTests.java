package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import com.ipiecoles.java.java340.model.Commercial;


/*Un test doit etre unitaire. Pas necessaire de tester tous les cas possibles 
 * mais le plus important est de verifier au moins les cas aux limites. 
 * On peut afficher le pourcentage de couverture de la classe par les tests mais avec une version 
 * plus récente d'eclipse en faisant run as Coverage

*/

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
	  public void testPrimeAnnuelleCa0(){
		 
		 //Given = 
		 Commercial commercial = new Commercial();
		 commercial.setCaAnnuel(0d);
		 
		 //When
		Double prime = commercial.getPrimeAnnuelle();
		 		
		//Then
		Assertions.assertThat(prime).isEqualTo(500d);
	 }
	 
	 @Test //dans org.junit.Test
	  public void testPrimeAnnuelleWithCA9000(){
		 
		 //Given = 
		 Commercial commercial = new Commercial();
		 commercial.setCaAnnuel(9000d);
		 
		 //When
		Double prime = commercial.getPrimeAnnuelle();
		 		
		//Then
		Assertions.assertThat(prime).isEqualTo(500d);
	 }
	 
	 @Test //dans org.junit.Test
	  public void testPerformance(){
		 Commercial commercial = new Commercial();
		 commercial.setPerformance(1);
		  
		 //Given
		 Integer performance = commercial.getPerformance();
		 
		 //Then
		 Assertions.assertThat(performance).isNotNull();
	 }
	 
	 @Test //dans org.junit.Test
	  public void testNom(){
		 Commercial commercial = new Commercial();
		
		 //Given 
		 String nom = commercial.getNom();
		 
		 //then
		 Assertions.assertThat(nom).isNotBlank();
	 }
	 
	 
}
