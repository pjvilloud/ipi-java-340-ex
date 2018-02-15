package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.model.model.Entreprise;
import com.ipiecoles.java.java340.model.model.Manager;
import com.ipiecoles.java.java340.model.model.Technicien;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ManagerTest{


    @Test
    public void testSetSalaire(){
        //Given
        Manager manager = Maker.makeManager(1);
        Double salaire = 1500d;

        manager.setSalaire(salaire);//set le salaire
        //When
        Double salaireManager = manager.getSalaire();

        //salaire * Entreprise.INDICE_MANAGER + (salaire * (double)equipe.size() / 10)
        Double result = (salaire * Entreprise.INDICE_MANAGER) + (salaire * (double)manager.getEquipe().size() /10);//resultat de ce qu'on doit trouver en fonction de nos données crees
        //Then
        Assertions.assertThat(salaireManager).isEqualTo(result);
    }
}