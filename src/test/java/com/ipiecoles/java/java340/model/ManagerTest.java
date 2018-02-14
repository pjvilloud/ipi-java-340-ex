package com.ipiecoles.java.java340.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class ManagerTest {

    @Test
    public void testSetSalaire() {
        //given
        Manager manager = new Manager();

        Technicien technicien = new Technicien();

        HashSet<Technicien> equipe = new HashSet<Technicien>();
        equipe.add(technicien);

        manager.setEquipe(equipe);
        //when
        manager.setSalaire(2000d);
        //then

        Assertions.assertThat(manager.getSalaire()).isEqualTo(2800d);
    }





}
