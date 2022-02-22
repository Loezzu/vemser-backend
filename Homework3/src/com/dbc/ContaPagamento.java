package com.dbc;

public class ContaPagamento extends Conta implements Impressao {
    private final static double TAXA_SAQUE = 4.25;

    public ContaPagamento() {
    }

    public ContaPagamento(Cliente cliente, String numeroConta, int agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Não é possivel sacar valores negativos.");
            return false;
        }else if (valor > (super.getSaldo() - TAXA_SAQUE)) {
            System.out.println("voce não pode sacar mais do que tem.");
            return false;
        } else {
            setSaldo(getSaldo() - valor);
            setSaldo(getSaldo() - TAXA_SAQUE);
            System.out.println("Você sacou: R$ " + valor +"\n" +
                              "Com uma taxa de: R$ " + TAXA_SAQUE + "\n" +
                                "Total reduzido: R$ " + (valor+TAXA_SAQUE));
            return true;
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Nome: " + getCliente().getNome() + " - Numero da conta: " + getNumeroConta() + " - Numero da agencia: " + getAgencia() + " - Saldo: R$ " + getSaldo() + " - Taxa de saque: R$ " + TAXA_SAQUE);

    }

}
