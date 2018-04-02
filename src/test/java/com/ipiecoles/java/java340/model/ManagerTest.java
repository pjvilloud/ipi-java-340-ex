package com.ipiecoles.java.java340.model;

import org.junit.Test;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;

public class ManagerTest {
	
	@Test
    public void testGetPrimeAnnuelleWithEquipeSize0() {
        //Given = Initialisation des données d'entrée
        Manager manager = new Manager();

        //When = Exécution de la méthode à tester
        Double primeAnnuelle = manager.getPrimeAnnuelle();

        //Then = Vérifications de ce qu'a fait la méthode

        Assertions.assertThat(primeAnnuelle).isEqualTo(LocalDate.now().getYear() * 0.5);
}


    @Test
    public void testGetPrimeAnnuelleWithEquipeSize1() {
        //Given = Initialisation des données d'entrée
        Manager manager = new Manager();
        manager.ajoutTechnicienEquipe("Technicien", null,null,null,null,null);
        

        //When = Exécution de la méthode à tester
        Double primeAnnuelle = manager.getPrimeAnnuelle();

        //Then = Vérifications de ce qu'a fait la méthode

        Assertions.assertThat(primeAnnuelle).isEqualTo((LocalDate.now().getYear() * 0.5)+250d);
    }

    @Test
    public void testGetPrimeAnnuelleWithEquipeSize5() {
        //Given = Initialisation des données d'entrée
        Manager manager = new Manager();
        
        for (int i = 0; i<5; i++) {
            manager.ajoutTechnicienEquipe(new Technicien("tech"+i, null, null, null, null, null));
        }
        
        //equipe.size(1);

        //When = Exécution de la méthode à tester
        Double primeAnnuelle = manager.getPrimeAnnuelle();

        //Then = Vérifications de ce qu'a fait la méthode

        Assertions.assertThat(primeAnnuelle).isEqualTo((LocalDate.now().getYear() * 0.5d) +1250d);
    }








}
