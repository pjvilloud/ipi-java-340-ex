package com.ipiecoles.java.java340.model.maker;

import com.ipiecoles.java.java340.exception.EmployeException;
import com.ipiecoles.java.java340.model.Employe;
import com.ipiecoles.java.java340.model.Technicien;
import com.ipiecoles.java.java340.model.builder.ManagerBuilder;
import org.joda.time.LocalDate;

import java.util.HashSet;

public class ManagerMaker {

    //création d'un manager sans équipe
    public static ManagerBuilder aManagerWithoutEquipe() throws EmployeException {
        return ManagerBuilder.aManager()
                .withNom("Durand")
                .withPrenom("Pierre")
                .withMatricule("M12345")
                .withDateEmbauche(new LocalDate())
                .withSalaire(2000d);
    }

    //création d'un manager avec deux techniciens
    public static ManagerBuilder bManagerWithTwoTechnicians() throws EmployeException {
        Technicien ericDumas = TechnicienMaker.aTechnicien().withNom("Dumas")
                .withPrenom("Eric").build();
        Technicien adrienCasejuane = TechnicienMaker.aTechnicien().withNom("Casejuane")
                .withPrenom("Adrien").build();

        HashSet<Technicien> liste = new HashSet<>();
        liste.add(ericDumas);
        liste.add(adrienCasejuane);

        return ManagerBuilder.aManager()
                .withNom("Durand")
                .withPrenom("Pierre")
                .withMatricule("M12345")
                .withDateEmbauche(new LocalDate())
                .withSalaire(2000d)
                .withEquipe(liste);
    }
}
