package com.dbc;

public class Main {

    public static void main(String[] args) {

        Contato contato1 = new Contato("Whats", "986115458", 2);
        Contato contato2 = new Contato("Residencial", "513456789", 1);
        Endereco endereco1 = new Endereco(1, "travessa odir bonatto", 84, "Casa", "123456789", "Gravataí", "RS", "Brasil");
        Endereco endereco2 = new Endereco(2, "Avenida dos estados", 216, "Apartamento", "567894321", "Gravataí", "RS", "Brasil");

        Cliente c1 = new Cliente("Luiz", "12345678", new Contato[]{contato1,contato2}, new Endereco[]{endereco1,endereco2});
        ContaCorrente conta1 = new ContaCorrente(c1, "4444444", 4444, 200.00, 400.00);

        Contato contato3 = new Contato("Celular", "000000000", 2);
        Contato contato4 = new Contato("Residencial", "513456789", 1);
        Endereco endereco3 = new Endereco(1, "av paes de andrade", 70, "Casa", "66666666", "Cachoeirinha", "RS", "Brasil");
        Endereco endereco4 = new Endereco(2, "R. Cel. Sarmento", 90, "Apartamento", "22222222", "Gravataí", "RS", "Brasil");

        Cliente c2 = new Cliente("João", "87654321", new Contato[]{contato3,contato4}, new Endereco[]{endereco3,endereco4});
        ContaCorrente conta2 = new ContaCorrente(c2, "8888888", 2222, 300.00, 200.00);


        System.out.println("====================Testando Saque==========================");
        System.out.println("Saldo João: " + conta2.saldo);
        conta2.sacar(100.00);
        System.out.println("Saldo João: " + conta2.saldo);
        System.out.println("====================Testando Saque FIM==========================\n");

        System.out.println("====================Testando Deposito==========================");
        System.out.println("Saldo Luiz: " + conta1.saldo);
        conta1.depositar(100.00);
        System.out.println("Saldo Luiz: " + conta1.saldo);
        System.out.println("====================Testando Deposito FIM==========================\n");

        System.out.println("====================Testando Transferencias==========================");
        System.out.println("Saldo Luiz: " + conta1.saldo);
        System.out.println("Saldo João: " + conta2.saldo);
        conta1.transferir(conta2, 200);
        System.out.println("Saldo Luiz: " + conta1.saldo);
        System.out.println("Saldo João: " + conta2.saldo);

        conta2.transferir(conta1, 200);
        System.out.println("Saldo Luiz: " + conta1.saldo);
        System.out.println("Saldo João: " + conta2.saldo);
        System.out.println("====================Testando Transferencias FIM==========================\n");

        System.out.println("====================Testando Saldo+Cheque Especial==========================");
        System.out.println(conta1.retornarSaldoComChequeEspecial());
        System.out.println(conta2.retornarSaldoComChequeEspecial());
        System.out.println("====================Testando Saldo+Cheque Especial FIM==========================\n");

        System.out.println("====================Imprimindo Conta Corrente==========================");
        conta1.imprimirContaCorrente();
        conta2.imprimirContaCorrente();
        System.out.println("====================Imprimindo Conta Corrente FIM==========================");


    }
}
