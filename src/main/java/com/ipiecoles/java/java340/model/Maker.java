package com.ipiecoles.java.java340.model;

import com.ipiecoles.java.java340.model.model.Commercial;
import com.ipiecoles.java.java340.model.model.Manager;
import com.ipiecoles.java.java340.model.model.Technicien;
import org.joda.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Maker {

    public static Technicien makeTechnicien(Integer i){
        String nom = "Venet" + i;
        String prenom = "Julien" + i;
        String matricule = "T9999"+i;
        LocalDate dateEbauche = new LocalDate();
        Double salaire = 1500d;
        Integer grade = 1;

        Technicien tech = new Technicien(nom,prenom, matricule, dateEbauche,salaire,grade);
        return tech;
    }

    public static Manager makeManager(Integer i){
        String nom = "Venet" + i;
        String prenom = "Julien" + i;
        String matricule = "M9999"+i;
        LocalDate dateEbauche = new LocalDate();
        Double salaire = 1500d;

        Technicien tech1 = Maker.makeTechnicien(1);
        Technicien tech2 = Maker.makeTechnicien(2);
        Set<Technicien> equipe = new HashSet<>(Arrays.asList(tech1, tech2));//creation de l'equipe en ajoutant les tech

        Manager mng = new Manager(nom, prenom, matricule, dateEbauche, salaire, (HashSet<Technicien>) equipe);
        return mng;
    }

    public static Commercial makeCommercial(Integer i){
        String nom = "Venet" + i;
        String prenom = "Julien" + i;
        String matricule = "M9999"+i;
        LocalDate dateEbauche = new LocalDate();
        Double salaire = 1500d;
        Double CAannuel = 700000d;

        Commercial comm = new Commercial(nom,prenom,matricule,dateEbauche,salaire,CAannuel);
        return comm;
    }
}
