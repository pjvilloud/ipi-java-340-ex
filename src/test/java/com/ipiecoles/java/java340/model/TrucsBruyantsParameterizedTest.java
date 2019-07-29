package com.ipiecoles.java.java340.model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.JFrame;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class TrucsBruyantsParameterizedTest {
	

		@Parameter(value=0)
		public Integer bruitEnDecibels;
	
		@Parameter(value=1)
		public Bruit ObjetOuPhenomene;

		@Parameters(name="La valeur {0} decibels correspong au bruit : {1}")
		public static Collection<Object[]> data(){
			
			return Arrays.asList(new Object[][]{
					
					{10, Bruit.VentDansLesArbres},
					{30, Bruit.Chuchotement},
					{55, Bruit.ConversationNormale},
					{65, Bruit.AspirateurDomestique},
					{92, Bruit.TondeuseGazonEssence},
					{95, Bruit.RotativeJournaux},
					{115, Bruit.MarteauPneumatique},
					{120, Bruit.SeuilDeDouleur},
					{125, Bruit.AvionAReactionAuDecollage}	
			});
		}
		
		@Test
		public void testAugmenterSalaire() {
			
			//Given
			TrucsBruyants trucsBruyants = new TrucsBruyants();
			
			trucsBruyants.setDB(bruitEnDecibels);
			
			//When
			Bruit bruit = trucsBruyants.equivalenceDecibels();
			
			//Then
			Assertions.assertThat(bruit).isEqualTo(ObjetOuPhenomene);
			
		
		}
			
}