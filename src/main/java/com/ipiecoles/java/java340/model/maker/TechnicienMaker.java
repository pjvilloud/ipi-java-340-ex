package com.ipiecoles.java.java340.model.maker;

import com.ipiecoles.java.java340.model.builder.TechnicienBuilder;
import org.joda.time.LocalDate;

public class TechnicienMaker {

    public static TechnicienBuilder aTechnicien(){
        return TechnicienBuilder.aTechnicien()
                .withNom("Durand")
                .withPrenom("Pierre")
                .withMatricule("C12345")
                .withDateEmbauche(new LocalDate())
                .withSalaire(1500d)
                .withGrade(0);
    }
}
