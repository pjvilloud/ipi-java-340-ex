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


public class MangerTest{
    @Test
    public void testSetSalaireManagerPasTec(){
        //given
        Manager manager = new Manager();
        Double Salaire=1500d;

        manager.setSalaire(Salaire);
        //when

        Double  SalaireBase=manager.getSalaire();

        //then

        Assertions.assertThat(SalaireBase).isEqualTo(1950d);

    }
    @Test
    public void testSetSalaireManagerAvecTech1(){
        //given
        Manager manager = new Manager();
        Technicien technicien1=new Technicien("Boubacar","Seini","T12345",new LocalDate(),1500d, (int) 0d);

        manager.ajoutTechnicienEquipe(technicien1);
        Double Salaire=1500d;

        manager.setSalaire(Salaire);
        //when

        Double  SalaireManager=manager.getSalaire();

        //then
        Assertions.assertThat(SalaireManager).isGreaterThan(1950d);
        //Assertions.assertThat(SalaireManager).isEqualTo(2100d);
    }
    @Test
    public void testSetSalaireManagerAvecTech2(){
        //given
        Manager manager = new Manager();
        Technicien technicien1=new Technicien("Boubacar","Seini","T12345",new LocalDate(),1500d, (int) 0d);
        Technicien technicien2=new Technicien("RAZAK","Slimani","T12346",new LocalDate(),1500d, (int) 0d);

        manager.ajoutTechnicienEquipe(technicien1);
        manager.ajoutTechnicienEquipe(technicien2);

        Double Salaire=1500d;
        manager.setSalaire(Salaire);
        //when

        Double  SalaireManager=manager.getSalaire();


        //then
        Assertions.assertThat(SalaireManager).isGreaterThan(1950d);
        //Assertions.assertThat(SalaireManager).isEqualTo(2250d);
    }

}