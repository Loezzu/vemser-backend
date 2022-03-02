package com.dbc;

public class Endereco {
    int tipo; // 1 - residencial, 2 - comercial
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    public Endereco(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public void imprimirEndereco() {
        System.out.println(tipo + " " + logradouro + " " + numero + " " + complemento + " " + cep + " " + cidade + " " + estado + " " + pais);
    }

}
