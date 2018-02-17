package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ManagerParameterizedTest {

	public static Technicien pierreDurand = new Technicien("Durand", "Pierre", "C12345",new LocalDate(), 1500d, 0);
	public static Technicien jeanJacques = new Technicien("Jacques", "Jean", "C12346",new LocalDate(), 1500d, 0);
	public static Technicien jacquesDupond = new Technicien("Dupond", "Jacques", "C12347",new LocalDate(), 1500d, 0);

	
	static HashSet<Technicien> equipe0 = new HashSet<>();

	static HashSet<Technicien> equipe1 = new HashSet<Technicien>() {/**
		 * equipe 1 tech
		 */
		private static final long serialVersionUID = 1L;

	{
	    add(pierreDurand);
	}};

	static HashSet<Technicien> equipe2 = new HashSet<Technicien>() {/**
		 * equipe 2 tech
		 */
		private static final long serialVersionUID = 1L;

	{
	    add(pierreDurand);
	    add(jeanJacques);
	}};

	static HashSet<Technicien> equipe3 = new HashSet<Technicien>() {/**
		 * equipe 3 tech
		 */
		private static final long serialVersionUID = 1L;

	{
	    add(pierreDurand);
	    add(jeanJacques);
	    add(jacquesDupond);
	}};

	public static Double primeInit = new LocalDate().getYear()*0.5d;
	
	@Parameter(value = 0)
	public HashSet<Technicien> equipe;
	@Parameter(value = 1)
	public Double expectedPrime;
	
	@Parameters(name = "prime pour {0} est {1}")
	public static Collection<Object[]>data(){
		return Arrays.asList(
				new Object[][]{
					{equipe0, primeInit}, 
					{equipe1, primeInit+250d}, 
					{equipe2, primeInit+500d}, 
					{equipe3, primeInit+750d}
				});
	}
	
	@Test
	public void testGetPrimeAnnuelleAvecEquipe() {
			//Given
			Manager manager =  new Manager("Dupond", "Jacques", "M12345", new LocalDate(), 2000d, new HashSet<>());

			//When
			manager.setEquipe(equipe);
			
			//Then
			Assertions.assertThat(manager.getPrimeAnnuelle()).isEqualTo(expectedPrime);
			
		}
}