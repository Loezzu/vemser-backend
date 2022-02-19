package com.dbc;

public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;


    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimirContaCorrente() {
        System.out.println("Nome: " + cliente.nome + " - Numero da conta: " + numeroConta + " - NUmero da agencia: " + agencia + " - Saldo: R$ " + saldo + " - Cheque especial disponivel: R$ " + chequeEspecial);
    }

    public boolean sacar(double valor) {
        if (valor > (saldo+chequeEspecial)) {
            System.out.println("voce não pode sacar mais do que tem.");
            return false;
        }
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        if (saldo+chequeEspecial >= valor) {
            valor -= saldo;
            saldo = 0;
            chequeEspecial -= valor;
            return true;
        }

        System.out.println("Você sacou: R$ " + valor );
        return true;
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

    public double retornarSaldoComChequeEspecial() {
        return saldo + chequeEspecial;
    }

    public boolean transferir(ContaCorrente cc, double valor) {
        if (valor <= 0) {
            System.out.println("Não é possivel transferir valores negativos");
            return false;
        }
        if (valor > (this.saldo+this.chequeEspecial)) {
            System.out.println("voce não pode transfeir mais do que tem.");
            return false;
        }
        if (this.saldo >= valor) { //caso seja possivel retirar apenas do saldo
            this.saldo -= valor;
            System.out.println("Vocẽ transferiu: R$ " + valor  + " para: " + cc.cliente.nome);
            cc.saldo += valor;
            return true;
        }
        if (saldo+chequeEspecial >= valor) { // caso tenha que retirar do saldo e tambem do cheque especial
            cc.saldo += valor;
            valor -= saldo;
            saldo = 0;
            chequeEspecial -= valor;
            System.out.println("Vocẽ transferiu: R$ " + valor  + " para: " + cc.cliente.nome);
            return true;
        }

        cc.saldo += valor;
        System.out.println("Vocẽ transferiu: R$ " + valor  + " para: " + cc.cliente.nome);
        return true;
    }

}
