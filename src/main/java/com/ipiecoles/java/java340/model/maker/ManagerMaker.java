package com.ipiecoles.java.java340.model.maker;

import com.ipiecoles.java.java340.model.builder.ManagerBuilder;

public class ManagerMaker {
    public static ManagerBuilder aManager(){
        return ManagerBuilder.aManager().withNom("TESTMANAGER");
    }

    //public static ManagerBuilder aManagerWithEquipe(){};
}
