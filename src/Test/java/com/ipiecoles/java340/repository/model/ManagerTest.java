package com.ipiecoles.java340.repository.model;

import com.ipiecoles.java.java340.model.Entreprise;
import com.ipiecoles.java.java340.model.Manager;
import com.ipiecoles.java.java340.model.Technicien;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Compatibility;
import org.joda.time.LocalDate;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


public class ManagerTest{
    @Test
    public void testGetPrimeAnnuelManagerPasTec(){
        //given
        Manager manager = new Manager();


        Entreprise.primeAnnuelleBase();
        //when

        Double  ManagerSalaire=manager.getPrimeAnnuelle();

        //then

        Assertions.assertThat(ManagerSalaire).isEqualTo(1009d);

    }
    @Test
    public void testSetSalaireManagerAvecTech1(){
        //given
        Manager manager = new Manager();
        Technicien technicien1=new Technicien("Boubacar","Seini","T12345",new LocalDate(),1500d, (int) 0d);

        manager.ajoutTechnicienEquipe(technicien1);
        Entreprise.primeAnnuelleBase();


        //when

        Double  SalaireManager=manager.getPrimeAnnuelle();

        //then

        Assertions.assertThat(SalaireManager).isEqualTo(1259d);
    }
    @Test
    public void testSetSalaireManagerAvecTech2(){
        //given
        Manager manager = new Manager();
        Technicien technicien1=new Technicien("Boubacar","Seini","T12345",new LocalDate(),1500d, (int) 0d);
        Technicien technicien2=new Technicien("Razak","Slimani","T12346",new LocalDate(),1500d, (int) 0d);

        manager.ajoutTechnicienEquipe(technicien1);
        manager.ajoutTechnicienEquipe(technicien2);

        Entreprise.primeAnnuelleBase();
        //when

        Double  SalaireManager=manager.getPrimeAnnuelle();


        //then

        Assertions.assertThat(SalaireManager).isEqualTo(1509d);
    }

}