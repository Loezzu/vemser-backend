package com.dbc;

import java.util.Arrays;

public enum TipoCarro {
    SEDAN("sedan"),
    ESPORTIVO("esportivo"),
    HATCH("hatch"),
    SUV("SUV");

    private String descricao;

     TipoCarro(String descricao) {
        this.descricao = descricao;

    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCarro valueOfByDescricao(String descricao) {
         return Arrays.asList(values()).stream()
                 .filter(tipoCarro -> tipoCarro.getDescricao().equalsIgnoreCase(descricao))
                 .findFirst()
                 .get();
    }

}
