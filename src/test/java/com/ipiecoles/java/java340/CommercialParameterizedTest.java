package com.ipiecoles.java.java340;

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

@RunWith(value= Parameterized.class)
public class CommercialParameterizedTest {
	
	@Parameter(value = 0)
	public Integer performance;
	
	@Parameter(value = 1)
	public Note note;
	
	@Parameters(name="With performance {0} - note = {1}")
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
			{null,null}, {0,Note.INSUFFISANT}, {50,Note.INSUFFISANT}, {47, null}, {100,Note.PASSABLE}, 
			{150,Note.BIEN}, {200,Note.TRES_BIEN}
		});
	}
	
	@Test
	public void testEquivalence() {
		//Given
		Commercial com = new Commercial();
		com.setPerformance(performance);
		
		// When Then
		if(performance == null) {
			Assertions.assertThat(com.equivalenceNote()).isNull();
		}
		else {
		Assertions.assertThat(com.equivalenceNote()).isEqualTo(note);
		}
	}
}