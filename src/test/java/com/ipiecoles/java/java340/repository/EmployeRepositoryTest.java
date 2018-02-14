package com.ipiecoles.java.java340.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ipiecoles.java.java340.model.Commercial;
import com.ipiecoles.java.java340.model.Employe;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeRepositoryTest {
	
	public Commercial commercial, commercialDeux, commercialTrois;
	
	@Before
	public void setUp() {
		employeRepository.deleteAll();
		 commercial = new Commercial("mama", "opla", "000VB", new LocalDate(), 5000d, 5000d, 5);
		 commercialDeux = new Commercial("olala", "mama", "000VB", new LocalDate(), 3000d, 3000d, 5);
		 commercialTrois = new Commercial("introuvable", "introuvable", "000VB", new LocalDate(), 1d, 1d, 5); // salaire < moyenne des salaires
		employeRepository.save(commercial);
		employeRepository.save(commercialDeux);
		employeRepository.save(commercialTrois);
	}
	
	@Autowired
	public EmployeRepository employeRepository;

	@Test
	public void findEmployesPlusRichesTest() {
		List<Employe> liste = employeRepository.findEmployePlusRiches();
		Assertions.assertThat(liste).contains(commercial);
		Assertions.assertThat(liste).contains(commercialDeux);
		Assertions.assertThat(liste).hasSize(2);
	}
	
	@Test
	public void findEmployesPlusRichesTestWithNoResults(){
		// On met un seul salarie dans la base donc aucun resultat au dessus de la moyenne
		employeRepository.deleteAll();
		commercial = new Commercial("mama", "opla", "000VB", new LocalDate(), 5000d, 5000d, 5);
		employeRepository.save(commercial);
		
		List<Employe> liste = employeRepository.findEmployePlusRiches();
		Assertions.assertThat(liste).isEmpty();
	}
	
	@Test
	public void findEmployesPlusRichesTestWithNullValues(){
		employeRepository.deleteAll();
		
		// On met tous les salaires a NULL pour verifier qu'on ne leve pas d exception
		commercial = new Commercial("mama", "opla", "000VB", new LocalDate(), null, null, 5);
		commercialDeux = new Commercial("olala", "mama", "000VB", new LocalDate(), null, null, 5);
		commercialTrois = new Commercial("introuvable", "introuvable", "000VB", new LocalDate(), null, null, 5);
		
		employeRepository.save(commercial);
		employeRepository.save(commercialDeux);
		employeRepository.save(commercialTrois);
		List<Employe> liste = employeRepository.findEmployePlusRiches();
		
		Assertions.assertThat(liste).isEmpty();
	}
	
	@Test
	public void findByNomOrPrenomAllIgnoreCaseTest() {
		// GIVEN
		String essai = "mama";
		String essaiMarchePas = "papa";
		
		// WHEN 
		List<Employe> listeEmploye = employeRepository.findByNomOrPrenomAllIgnoreCase(essai);
		List<Employe> listeEmployeDeux = employeRepository.findByNomOrPrenomAllIgnoreCase(essaiMarchePas);
		
		// THEN
		Assertions.assertThat(listeEmploye).hasSize(2);
		Assertions.assertThat(listeEmployeDeux).hasSize(0);
		
	}
}
