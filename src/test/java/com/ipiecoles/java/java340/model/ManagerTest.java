package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ManagerTest {
	
	//(salaire * Entreprise.INDICE_MANAGER + (salaire * (double)equipe.size() / 10))
	//(100*1.3+(100*1/10))
	
	@Test
	public void testsetSalaireWith100() {
		//Given
		Manager mng = new Manager();
		Technicien tec = new Technicien();
		mng.ajoutTechnicienEquipe(tec);
		mng.setSalaire(100d);
		
		//When
		Double salaire = mng.getSalaire();
		Integer sizeEquipe = mng.getEquipe().size();
		
		//Then
		Assertions.assertThat(sizeEquipe).isEqualTo(1);
		Assertions.assertThat(salaire).isEqualTo(140d);
	}
	
	
}
