package com.dbc;

public class ContaPoupanca extends Conta implements Impressao{
    private static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca() {
    }

    public ContaPoupanca(Cliente cliente, String numeroConta, int agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa() {
        System.out.println("Aplicado Juros Mensal no Saldo");
        setSaldo(getSaldo() * JUROS_MENSAL);
    }

    public void imprimir() {
        System.out.println("Nome: " + getCliente().getNome() + " - Numero da conta: " + getNumeroConta() + " - Numero da agencia: " + getAgencia() + " - Saldo: R$ " + getSaldo() + " - Juros Mensal: R$ " + JUROS_MENSAL);
    }
}
