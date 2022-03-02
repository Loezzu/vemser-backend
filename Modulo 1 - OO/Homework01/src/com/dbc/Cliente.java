package com.dbc;


public class Cliente {
    String nome;
    String cpf;
    Contato[] contato = new Contato[2];
    Endereco[] endereco = new Endereco[2];

    public Cliente(String nome, String cpf, Contato[] contato, Endereco[] endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.contato = contato;
        this.endereco = endereco;
    }

    public void imprimirContatos() {
        for (Contato contato : contato) {
            contato.imprimirContato();
        }
    }

    public void imprimirEnderecos() {
        for (Endereco endereco : endereco) {
            endereco.imprimirEndereco();
        }
    }

    public void imprimirCliente() {
        System.out.println("Nome: " + nome + " CPF: " + cpf);
        imprimirContatos();
        imprimirEnderecos();
    }


}
