package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;

import com.ipiecoles.java.java340.exception.EmployeException;

public class TechnicienTest {

	@Test
	public void testGradeTechnicien() {
				
		//Given
		Technicien technicien = new Technicien();
		
		Integer chiffreEntreUnEtDix = (int) Math.ceil(Math.random()*10);
		technicien.setGrade(chiffreEntreUnEtDix);
		
		//When
		Integer grade = technicien.getGrade();
		
		//Then
		Assertions.assertThat(grade).isEqualTo(chiffreEntreUnEtDix);
	
	}

	@Test
	public void testNbCongesTechnicienEtAnneesAnciennete() throws EmployeException {
		
		//Given
		Technicien technicien = new Technicien();
		LocalDate anneesAnciennete = LocalDate.now().minusYears((int)Math.ceil(Math.random()*3+1));
		
		technicien.setDateEmbauche(anneesAnciennete);
		
		//When
		Integer nbConges = technicien.getNbConges();
		Integer nbCongesCalculMain = Entreprise.NB_CONGES_BASE + technicien.getNombreAnneeAnciennete();
		
		//Then
		Assertions.assertThat(nbCongesCalculMain).isEqualTo(nbConges);
		
	}
	
	@Test
	public void testAffectationManager() {
		
		//Given
		Technicien Shingo = new Technicien();
		Manager Shizuma = new Manager();
		Shingo.setPrenom("Shingo");
		Shingo.setNom("Uryuu");
		Shizuma.setNom("Hanazono");
		Shizuma.setPrenom("Shizuma");
		
		//When
		Shingo.setManager(Shizuma);
		
		//Then
		Assertions.assertThat(Shingo.getManager().getNom()).isEqualTo("Hanazono");	
	}
	
	
	
	
}
