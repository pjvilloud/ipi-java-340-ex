package com.ipiecoles.java.java240.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.Module.SetupContext;
import com.ipiecoles.java.java340.SpringWebApplication;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Note;
import com.ipiecoles.java.java340.model.Technicien;
import com.ipiecoles.java.java340.repository.CommercialRepository;
import com.ipiecoles.java.java340.repository.EmployeRepository;




@RunWith(SpringRunner.class)
//@DataJpaTest : ne fonctionne pas à chaque fois
@SpringBootTest(classes=SpringWebApplication.class) //fonctionne à chaque fois.
public class EvalEmployeRepositoryEmployesPlusRichesTest {
		
	
	@Autowired
	EmployeRepository employeRepository;
	
	Manager pierreDurand,patrickDupont,jeanJacques,jacquesDupont;
	
	@Before
	public void SetupContext() {
		employeRepository.deleteAll();
		
		pierreDurand = employeRepository.save(new Manager("Durand", "Pierre","C12347",new LocalDate(), 2000d, new HashSet<Technicien>()));
		patrickDupont= employeRepository.save(new Manager("Dupont", "Patrick","C12345", new LocalDate(), 2500d, new HashSet<Technicien>()));
		jeanJacques = employeRepository.save(new Manager("Jacques", "Jean","C22345", new LocalDate(), 2400d, new HashSet<Technicien>()));
		jacquesDupont = employeRepository.save(new Manager("Dupont", "Jacques","C32345", new LocalDate(), 3000d, new HashSet<Technicien>()));
	}
	
	@After
	public void tearDown() {
		employeRepository.deleteAll();
	}
	
	@Test
	public void TestfindEmployePlusRichesAvec2SalaireSupMoy() {
		
		//Given , When
		List<Employe> employesTotal = (List<Employe>) employeRepository.findAll();
		Double avgSal = 0d;
		for (int i = 0; i<employesTotal.size();i++) {
			avgSal += employesTotal.get(i).getSalaire(); //sommation
			
		}
	  Double nb = employesTotal.size()*1d;
		
	  avgSal = avgSal/nb;
		
		List <Employe> expectedEmployes = new ArrayList<Employe>();
		
		for (int i = 0; i<employesTotal.size();i++) {
			if (employesTotal.get(i).getSalaire() > avgSal) {
				expectedEmployes.add(employesTotal.get(i));
				
			}
			
		}
		
		List<Employe> employes = employeRepository.findEmployePlusRiches();
		
		
		
		
		//Then
		Assertions.assertThat(employes).hasSize(expectedEmployes.size());
		Assertions.assertThat(employes).isEqualTo(expectedEmployes);
	}
	
	
	@Test
	public void TestfindEmployePlusRichesAvec1SalaireSupMoy() {
		
		//Given , When
		List<Employe> employesTotal = (List<Employe>) employeRepository.findAll();
		patrickDupont.setSalaire(1500d);
		Double avgSal = 0d;
		for (int i = 0; i<employesTotal.size();i++) {
			avgSal += employesTotal.get(i).getSalaire(); //sommation
			
		}
	  Double nb = employesTotal.size()*1d;
		
	  avgSal = avgSal/nb;
		
		List <Employe> expectedEmployes = new ArrayList<Employe>();
		
		for (int i = 0; i<employesTotal.size();i++) {
			if (employesTotal.get(i).getSalaire() > avgSal) {
				expectedEmployes.add(employesTotal.get(i));
				
			}
			
		}
		
		List<Employe> employes = employeRepository.findEmployePlusRiches();
		
		
		
		
		//Then
		Assertions.assertThat(employes).hasSize(expectedEmployes.size());
		Assertions.assertThat(employes).isEqualTo(expectedEmployes);
	}
	
	@Test
	public void TestfindEmployePlusRichesTousSalairesSupMoy() {
		
		//Given , When
		List<Employe> employesTotal = (List<Employe>) employeRepository.findAll();
		pierreDurand.setSalaire(4500d);
		jeanJacques.setSalaire(4000d);
		Double avgSal = 0d;
		for (int i = 0; i<employesTotal.size();i++) {
			avgSal += employesTotal.get(i).getSalaire(); //sommation
			
		}
	  Double nb = employesTotal.size()*1d;
		
	  avgSal = avgSal/nb;
		
		List <Employe> expectedEmployes = new ArrayList<Employe>();
		
		for (int i = 0; i<employesTotal.size();i++) {
			if (employesTotal.get(i).getSalaire() > avgSal) {
				expectedEmployes.add(employesTotal.get(i));
				
			}
			
		}
		
		List<Employe> employes = employeRepository.findEmployePlusRiches();
		
		
		
		
		//Then
		Assertions.assertThat(employes).hasSize(expectedEmployes.size());
		Assertions.assertThat(employes).isEqualTo(expectedEmployes);
	}
	
	@Test
	public void TestfindEmployePlusRichesTousSalairesInfMoy() {
		
		//Given , When
		List<Employe> employesTotal = (List<Employe>) employeRepository.findAll();
		jacquesDupont.setSalaire(1500d);
		pierreDurand.setSalaire(2000d);
		Double avgSal = 0d;
		for (int i = 0; i<employesTotal.size();i++) {
			avgSal += employesTotal.get(i).getSalaire(); //sommation
			
		}
	  Double nb = employesTotal.size()*1d;
		
	  avgSal = avgSal/nb;
		
		List <Employe> expectedEmployes = new ArrayList<Employe>();
		
		for (int i = 0; i<employesTotal.size();i++) {
			if (employesTotal.get(i).getSalaire() > avgSal) {
				expectedEmployes.add(employesTotal.get(i));
				
			}
			
		}
		
		List<Employe> employes = employeRepository.findEmployePlusRiches();
		
		
		
		
		//Then
		Assertions.assertThat(employes).hasSize(expectedEmployes.size());
		Assertions.assertThat(employes).isEqualTo(expectedEmployes);
	}
		
	
	
}