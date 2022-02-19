package com.dbc;

public class Contato {
    String descricao;
    String telefone;
    int tipo; // 1 - residencial, 2 - comercial

    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public void imprimirContato() {
        System.out.println(tipo + " " + telefone +  " " + descricao);
    }

}
