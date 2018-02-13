package com.ipiecoles.java.java340.model.maker;

import com.ipiecoles.java.java340.model.builder.CommercialBuilder;

public class CommercialMaker {
    public static CommercialBuilder aCommercial(){
        return CommercialBuilder.aCommercial()
                    .withNom("DURAND")
                    .withMatricule("C1212")
                    .withPrenom("JEAN");
    }
}
