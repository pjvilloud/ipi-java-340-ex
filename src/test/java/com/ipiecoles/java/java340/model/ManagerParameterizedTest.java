package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ManagerParameterizedTest {
	
	public Manager manager = new Manager("momo", "ohoh", "aha", LocalDate.now(), null, null);
	
	@Parameter(value=0)
	public Integer nombreEmployes;
	
	@Parameter(value=1)
	public Double salaireBase;
	
	@Parameter(value=2)
	public Double salaireAttendu;
	
	@Parameter(value=3)
	public Double primeAttendue;
	
	@Parameters
	  public static Collection<Object[]> data() {
	      return Arrays.asList(new Object[][]{
	    	// MODELE DONNEES 
	    	// nombreEmployes / salaireBase / salaireAttendu / PrimeAttendue
	        {null, 1000d, 1300d ,null},	 // cas equipe null
	        {1, null, null ,1259d},		 // cas salaire null
	        {0, 1000d, 1300d ,1009d},     // cas régulier 1
	        {1, 1000d, 1400d ,1259d}     // cas régulier 2
	      });
	  }
	  
	  @Test
	  public void SetSalaireTestWithNormalAndNullValues() {
		  // GIVEN  
		  // Definition de l'équipe du Manager
		  this.setEquipeSelonParametreTest(manager);
		  
		  // WHEN
		  try {manager.setSalaire(salaireBase);}
		  catch(Exception e) {
			  if( nombreEmployes == null) {
				  // THEN 
				  // Gestion des exceptions 
				  Assertions.assertThat(e).isExactlyInstanceOf(NullPointerException.class);
			  }
		  }
		  
		// THEN
		if(nombreEmployes != null) {
			Assertions.assertThat(manager.getSalaire()).isEqualTo(salaireAttendu);
		}
	}
	  
	  @Test
	  public void getPrimeAnuelleTestWithNormalAndNullValues() {
		  // GIVEN  
		  // Definition de l'équipe du Manager
		  Double prime = null;
		  this.setEquipeSelonParametreTest(manager);
		  
		  // WHEN
		  try {prime = manager.getPrimeAnnuelle();}
		  catch(Exception e) {
			  if( nombreEmployes == null) {
				  // THEN 
				  // Gestion des exceptions 
				  Assertions.assertThat(e).isExactlyInstanceOf(NullPointerException.class);
			  }
		  }
		  
		  // THEN
		  if(prime != null) {
		  Assertions.assertThat(prime).isEqualTo(primeAttendue);
		  }
	  }
	  
	  @Test 
	  public void augmenterSalaireTestWithNormalAndNullValues() {
		  // GIVEN  
		  // Definition de l'équipe du Manager
		  this.setEquipeSelonParametreTest(manager);
		  Double ancienSalaire = manager.getSalaire();
		  
		  // WHEN
		  try {manager.augmenterSalaire(10d);}
		  catch(Exception e) {
			  if( nombreEmployes == null) {
				  // THEN 
				  // Gestion des exceptions 
				  Assertions.assertThat(e).isExactlyInstanceOf(NullPointerException.class);
			  }
		  }
		  
		  // THEN
		  if(nombreEmployes != null) {
			  Assertions.assertThat(manager.getSalaire()).isEqualTo(ancienSalaire * 1.1);
			  Set<Technicien> equipeManager = manager.getEquipe();
			  for (Technicien technicien : equipeManager) {
				  Assertions.assertThat(technicien.getSalaire()).isEqualTo(1100);
			  }
		  }
	  }
	  
	  // Methode mutualisée pour mes 3 tests, qui definit l'equipe du manager
	  // Pour des soucis de lisibilité, j'ai préféré ne pas instancier de pramètre Hashet de type comme suit :
	  // {new HashSet<>(Arrays.asList(new Technicien("Wayne", "Bruce", "T12345", new LocalDate(), 1000d, 1,
	  //  new Technicien("Wayne", "Bruce", "T12345", new LocalDate(), 1000d, 1))), 1259d}
	  public Manager setEquipeSelonParametreTest(Manager manager) {
		  if(nombreEmployes != null) {
			  Integer i = Integer.valueOf(nombreEmployes);
			  HashSet<Technicien> equipe = new HashSet<>();
			  
			  while (i > 0) {
				  equipe.add(new Technicien(""+i, null, null, null, 1000d, null));
				  i--;
			  }
			  manager.setEquipe(equipe);
		  }
		  return manager;
	  }
}
