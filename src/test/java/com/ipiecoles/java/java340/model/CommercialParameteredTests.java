package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Note;

@RunWith(value = Parameterized.class)
public class CommercialParameteredTests {

		/* L'annotation parameter permet d'identifier le numero de parametre. 
		 * Quand on a plusieurs couples de données a tester on numerote chaque parametre utilisé 
		 * Les numéros commencent tjrs par 0
		 */
		/*Il existe une librairie Junit qui permet de faciliter l'écriture des tests pour un JUNIT supérieur à 4.6. Il
		 * faut ajouter la dépendance dans le pom.xml : cf Git JUNITParams de Pragmatists */
		//Test de l'Equivalence Note
		@Parameter(value = 0) 
		public Integer performance; 
	
		@Parameter(value = 1) 
		public Note result;
		
		@Parameters (name = "performance {0} est équivalent à : {1}")
		public static Collection<Object[]> data () {
			return Arrays.asList(new Object[][]{
				{0, Note.INSUFFISANT}, 
				{50,Note.INSUFFISANT},
				{100, Note.PASSABLE},
				{150, Note.BIEN},
				{200, Note.TRES_BIEN},
				{null,null},
				{600, null}
			});
		}
		
		@Test
		public void testEquivalenceNote(){
			//Given
			Commercial commercial = new Commercial();
			commercial.setPerformance(performance);
			
			//When
			Note Notefinale = commercial.equivalenceNote();
			
			//Then
			Assertions.assertThat(Notefinale).isEqualTo(result);
		}
		
}
