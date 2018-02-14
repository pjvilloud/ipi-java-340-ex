package com.ipiecoles.java.java340.model;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;



@RunWith(value = Parameterized.class)
public class ManagerParameterisedTests {
	
	@Parameter(value = 0) 
	public Double primeAnnuelleBase; 

	@Parameter(value = 1) 
	public Double size;
	
	@Parameter(value = 2) 
	public Double primeManager;
	
	@Parameters (name = "PrimeAnnuelleManager est équivalent à : {1}")
	public static Collection<Object[]> data () {
		return Arrays.asList(new Object[][]{
				{null,null,null} 
	}
	
	
	
	public Double getPrimeAnnuelle() {
		return Entreprise.primeAnnuelleBase() + equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
	}
	
}
