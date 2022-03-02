package com.dbc;

public class Cliente {
    private String nome;
    private String cpf;
    private Contato[] contato = new Contato[2];
    private Endereco[] endereco = new Endereco[2];

    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContato() {
        return contato;
    }

    public void setContato(Contato[] contato) {
        this.contato = contato;
    }

    public Endereco[] getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco[] endereco) {
        this.endereco = endereco;
    }

    public void imprimirContatos() {
        for (Contato contato : contato) {
            if (contato != null) {
                contato.imprimirContato();
            }
        }
    }

    public void imprimirEnderecos() {
        for (Endereco endereco : endereco) {
            if (endereco != null) {
                endereco.imprimirEndereco();
            }
        }
    }

    public void imprimirCliente() {
        System.out.println("Nome: " + nome + " CPF: " + cpf);
        imprimirContatos();
        imprimirEnderecos();
    }

}
