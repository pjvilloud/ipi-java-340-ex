package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import com.ipiecoles.java.java340.model.Manager;

public class ManagerTest {
	
	 @Test  
	  public void setSalaireTest(){
		//Given   
		Manager manager = new Manager();
		Double salaire = 0.00;
		//When
		manager.setSalaire(salaire);
		Double newSalaire = manager.getSalaire(); 		
		//Then
		Assertions.assertThat(newSalaire).isEqualTo(salaire);
	 }
		
	
}
