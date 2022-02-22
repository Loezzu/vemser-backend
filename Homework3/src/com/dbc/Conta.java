package com.dbc;

public abstract class Conta implements Movimentacao{
    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;

    public Conta() {
    }

    public Conta(Cliente cliente, String numeroConta, int agencia, double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Não é possivel sacar valores negativos.");
            return false;
        }else if (valor > (saldo)) {
            System.out.println("voce não pode sacar mais do que tem.");
            return false;
        } else {
            saldo -= valor;
            System.out.println("Você sacou: R$ " + valor );
            return true;
        }
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Não é possivel depositar valores negativos.");
            return false;
        }
        saldo += valor;
        System.out.println("Você depositou: R$ " + valor);
        return true;
    }

    public boolean transferir(Conta cc, double valor) {
        if (valor <= 0) {
            System.out.println("Não é possivel transferir valores negativos");
            return false;
        }
        if (valor > (this.saldo)) {
            System.out.println("voce não pode transfeir mais do que tem.");
            return false;
        }
        this.saldo -= valor;
        System.out.println( this.cliente.getNome() + " transferiu R$ " + valor  + " para: " + cc.getCliente().getNome());
        cc.saldo += valor;
        return true;
    }
}
