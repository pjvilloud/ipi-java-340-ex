package com.ipiecoles.java.java340.model.maker;

import com.ipiecoles.java.java340.model.builder.CommercialBuilder;
import com.ipiecoles.java.java340.model.builder.TechnicienBuilder;

public class TechnicienMaker {
    public static TechnicienBuilder aTechnicien(){
        return TechnicienBuilder.aTechnicien()
                .withNom("DURAND")
                .withMatricule("C1212")
                .withGrade(5)
                .withPrenom("JEAN");
    }
}
