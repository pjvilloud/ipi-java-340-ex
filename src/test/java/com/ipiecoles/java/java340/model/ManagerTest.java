package com.ipiecoles.java.java340.model;
import org.assertj.core.api.Assertions;
import org.junit.Test;



public class ManagerTest {
	
	@Test
	public void testSetSalaireNull() {
		//GIVEN
		Manager manager= new Manager();
	    manager.setEquipe(equipe);
		//WHEN
		Double salaire = manager.setSalaire(0d);
		//THEN
		Assertions.assertThat(salaire).isEqualTo(2000d);
	}
	@Test
	public void testSetSalaireHaut() {
		//GIVEN
		Manager manager= new Manager();
	    manager.setEquipe(equipe);
		//WHEN
		Double salaire = manager.setSalaire(10000d);
		//THEN
		Assertions.assertThat(salaire).isEqualTo(2000d);
	}
	