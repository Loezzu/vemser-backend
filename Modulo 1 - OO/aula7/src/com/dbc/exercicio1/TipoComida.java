package com.dbc.exercicio1;

import java.util.Arrays;

public enum TipoComida {
    JAPONESA(50, "Japonesa"),
    FASTFOOD(30, "FastFood"),
    TRADICIONAL(20, "Tradicional");

    private double custo;
    private String comida;

    TipoComida(double custo, String comida) {
        this.custo = custo;
        this.comida = comida;
    }

    public String getComida() {
        return comida;
    }

    public double getCusto() {
        return custo;
    }

//    public static TipoComida valueOfByCusto(double custo) {
//        return Arrays.asList(values()).stream()
//                .filter(tipoComida -> tipoComida.getCusto() == custo)
//                .findFirst()
//                .get();
//    }

    public static Double valueOfByComida(String comida) {
        return Arrays.asList(values()).stream()
                .filter(tipoComida -> tipoComida.getComida().equalsIgnoreCase(comida))
                .map(tipoComida -> tipoComida.getCusto())
                .findFirst()
                .get();

    }
}
