package com.ipiecoles.java.java340.model;

import java.util.HashSet;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;

public class ManagerTest {
	
	// Pour raison de lisibilité, je préfère ne pas instancier les equipes des managers comme suit:
	// Manager manager = new Manager("clement", "bey", "00AB", null, 1000d, 
	// new HashSet(Arrays.asList({new Technicien(param1, param2),new Technicien(param1, param2)})));
	public void setManagerTeamWithXTechniciens(Manager manager, Integer nombreDeTechnicien) {
		Integer i = Integer.valueOf(nombreDeTechnicien);
		HashSet<Technicien> equipeToSet = new HashSet<>();
		while(i > 0) {
			equipeToSet.add(new Technicien(""+i, null, null, null, null, null));
			i--;
		}
		manager.setEquipe(equipeToSet);
	}
	
	@Test
	public void getPrimeAnnuelleTestWithNormalValues() {
		Manager managerWith0Tech = new Manager("clement", "bey", "00AB", null, 1000d, null);
		this.setManagerTeamWithXTechniciens(managerWith0Tech, 0);
		Manager managerWith1Tech = new Manager("clem", "bey", "00AB", null, 1000d, null);
		this.setManagerTeamWithXTechniciens(managerWith1Tech, 1);
				
		Assertions.assertThat(managerWith0Tech.getPrimeAnnuelle()).isEqualTo(1009d);
		Assertions.assertThat(managerWith1Tech.getPrimeAnnuelle()).isEqualTo(1259d);
	}
	
	@Test(expected = NullPointerException.class)
	public void getPrimeAnnuelleTestWithNullValues() {
		Manager managerWithNullTeam = new Manager("test", "aha", "ohoh", LocalDate.now(), 1000d, null);
		managerWithNullTeam.getPrimeAnnuelle();
	}
}
