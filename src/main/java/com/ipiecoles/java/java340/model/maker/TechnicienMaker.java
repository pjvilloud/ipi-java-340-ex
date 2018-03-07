package com.ipiecoles.java.java340.model.maker;

import org.joda.time.LocalDate;

import com.ipiecoles.java.java340.model.builder.CommercialBuilder;
import com.ipiecoles.java.java340.model.builder.TechnicienBuilder;

public class TechnicienMaker {
	
    public static TechnicienBuilder aTechnicien(){
        return TechnicienBuilder.aTechnicien()
            .withNom("Durand")
            .withPrenom("Pierre")
            .withMatricule("C12345")
            .withDateEmbauche(new LocalDate())
            .withGrade(1)
        	.withSalaire(1500d);
    }

}
