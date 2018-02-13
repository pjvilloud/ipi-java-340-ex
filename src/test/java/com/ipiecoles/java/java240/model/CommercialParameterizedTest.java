package com.ipiecoles.java.java240.model;


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
import com.mysql.fabric.xmlrpc.base.Array;
import com.mysql.fabric.xmlrpc.base.Data;

@RunWith(value=Parameterized.class)
public class CommercialParameterizedTest {
	
	@Parameter(value=0)
	public Integer perf;
	@Parameter(value=1)
	public Note expectedNote;
	
//
	//Jeu de données
	@Parameters(name="performance {0} équivalent à {1}")
	public static Collection<Object[]> Data() {
		return Arrays.asList(new Object[][] {
			{0, Note.INSUFFISANT},  
			{50, Note.INSUFFISANT},
			{100, Note.PASSABLE},
			{150, Note.BIEN},
			{200, Note.TRES_BIEN},
			{null,null},
			{600,null}
			
		});
	}
	
	
	//Test	
	@Test
	public void testEquivalenceNote() {
		
		//Given
		Commercial commercial=new Commercial();
		commercial.setPerformance(perf);
		//When
		Note note=commercial.equivalenceNote();
		//Then
		Assertions.assertThat(note).isEqualTo(expectedNote);
		
	}
	}
	
	
