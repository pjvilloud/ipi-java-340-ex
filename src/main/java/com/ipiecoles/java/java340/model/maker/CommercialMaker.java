package com.ipiecoles.java.java340.model.maker;

import com.ipiecoles.java.java340.model.builder.CommercialBuilder;

public class CommercialMaker {
    public  CommercialBuilder aCommercial(){
        return CommercialBuilder.aCommercial()
                .withNom("pierre");
    }
}
