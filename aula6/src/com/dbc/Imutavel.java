package com.dbc;

public class Imutavel {
    private final String dado;

    public Imutavel(final String dado) {
        this.dado = dado;
    }

    public String getDado() {
        return dado;
    }
}
