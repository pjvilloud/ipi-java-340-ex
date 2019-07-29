package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ConditionsDeTravail {


	@Test
	public void testConditionsDeTravail() {
		
		//Given
		
		Manager manager = new Manager();
		Commercial commercial = new Commercial();
		Technicien technicien = new Technicien();
		
		//Les conditions de travail sont Set dans les classes des gens
		manager.setPrenom("Robert");
		manager.setConditionsDeTravail();
		commercial.setPrenom("Shizuma");
		commercial.setConditionsDeTravail();
		technicien.setPrenom("Shingo");
		technicien.setConditionsDeTravail();
		
		
		//When
		
		//Then
		Assertions.assertThat(commercial.getConditionsDeTravail()).isEqualTo(Bruit.ConversationNormale);
		Assertions.assertThat(technicien.getConditionsDeTravail()).isEqualTo(Bruit.MarteauPneumatique);
		Assertions.assertThat(manager.getConditionsDeTravail()).isEqualTo(Bruit.Glandeur);		
		
		Assertions.assertThat(commercial.getPrenom()).isEqualTo("Shizuma");		
		Assertions.assertThat(manager.getPrenom()).isEqualTo("Robert");	
		Assertions.assertThat(technicien.getPrenom()).isEqualTo("Shingo");	

	
	}
	
}
