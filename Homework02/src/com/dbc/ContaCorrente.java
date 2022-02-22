package com.dbc;

public class ContaCorrente extends Conta implements Impressao{
    private double chequeEspecial;

    public ContaCorrente() {
    }

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimir() {
        System.out.println("Nome: " + getCliente().getNome() + " - Numero da conta: " + getNumeroConta() + " - NUmero da agencia: " + getAgencia() + " - Saldo: R$ " + getSaldo() + " - Cheque especial disponivel: R$ " + chequeEspecial);
    }

    public double retornarSaldoComChequeEspecial() {
        System.out.println(getCliente().getNome());
        return getSaldo() + chequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Não é possivel sacar valores negativos.");
            return false;
        }else if (valor > (getSaldo() + chequeEspecial)) {
            System.out.println("voce não pode sacar mais do que tem.");
            return false;
        } else {
            setSaldo(getSaldo() - valor);
            System.out.println("Você sacou: R$ " + valor );
            return true;
        }
    }

}
