package com.dbc;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        System.out.println(tipo);
//        System.out.println(tipo.ordinal());
//
//        TipoCarro tipoSedan = TipoCarro.valueOf("SEDAN");
//        System.out.println(tipoSedan);
//        switch (tipoSedan) {
//            case HATCH -> System.out.println("meu carro é hatch");
//            case SUV -> System.out.println("meu carro é SUV");
//            case ESPORTIVO -> System.out.println("meu carro é esportivo");
//            case SEDAN -> System.out.println("meu carro é sedan");
//        }

        TipoCarro[] values = TipoCarro.values();
        for (TipoCarro value : values) {
            System.out.println(value);
            System.out.println(value.ordinal());
            System.out.println(value.getDescricao());
        }


        TipoCarro hatch = TipoCarro.valueOfByDescricao("hatch");
        System.out.println(hatch);


    }
}
