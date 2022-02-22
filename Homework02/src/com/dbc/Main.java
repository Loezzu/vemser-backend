package com.dbc;

public class Main {

    public static void main(String[] args) {

        Contato contato1 = new Contato("Whats", "986115458", 2);
        Contato contato2 = new Contato("Residencial", "513456789", 1);
        Endereco endereco1 = new Endereco(1, "travessa odir bonatto", 84, "Casa", "123456789", "Gravataí", "RS", "Brasil");
        Endereco endereco2 = new Endereco(2, "Avenida dos estados", 216, "Apartamento", "567894321", "Gravataí", "RS", "Brasil");

        Cliente c1 = new Cliente("Luiz", "12345678");
        c1.getContato()[0] = contato1;
        c1.getContato()[1] = contato2;
        c1.getEndereco()[0] = endereco1;
        c1.getEndereco()[1] = endereco2;
        ContaCorrente cc1 = new ContaCorrente(c1, "4444444", 4444, 300.00, 400.00);

        Contato contato3 = new Contato("Celular", "000000000", 2);
        Contato contato4 = new Contato("Residencial", "513456789", 1);
        Endereco endereco3 = new Endereco(1, "av paes de andrade", 70, "Casa", "66666666", "Cachoeirinha", "RS", "Brasil");
        Endereco endereco4 = new Endereco(2, "R. Cel. Sarmento", 90, "Apartamento", "22222222", "Gravataí", "RS", "Brasil");

        Cliente c2 = new Cliente("João", "87654321");
        c2.getContato()[0] = contato3;
        c2.getContato()[1] = contato4;
        c2.getEndereco()[0] = endereco3;
        c2.getEndereco()[1] = endereco4;
//        ContaCorrente conta2 = new ContaCorrente(c2, "8888888", 2222, 300.00, 200.00);
        ContaPoupanca cp1 = new ContaPoupanca(c2, "111111", 9999, 200);


        System.out.println("====================Testando Saque==========================");
        System.out.println("Saldo Luiz: " + cc1.getSaldo());
        if (cc1.sacar(400.00)) {
            System.out.println("Funcionou");
        }
        System.out.println("Saldo Luiz: " + cc1.getSaldo());

        System.out.println("Saldo da Conta Poupança do João: " + cp1.getSaldo());
        if (cp1.sacar(400.00)) {
            System.out.println("Funcionou");
        }
        System.out.println("Saldo da Conta Poupança do João: " + cp1.getSaldo());
        System.out.println("====================Testando Saque FIM==========================\n");

        System.out.println("====================Testando Deposito==========================");
        System.out.println("Saldo Luiz: " + cc1.getSaldo());
        if (cc1.depositar(300)) {
            System.out.println("Funcionou");
        }
        System.out.println("Saldo Luiz: " + cc1.getSaldo());
        System.out.println("Saldo da Conta Poupança do João: " + cp1.getSaldo());
        if (cp1.depositar(200)) {
            System.out.println("Funcionou");
        }
        System.out.println("Saldo da Conta Poupança do João: " + cp1.getSaldo());
        System.out.println("====================Testando Deposito FIM==========================\n");

        System.out.println("====================Testando Transferencias==========================");
        System.out.println("Saldo Luiz: " + cc1.getSaldo());
        System.out.println("Saldo da Conta Poupança do João: " + cp1.getSaldo());
        if (cc1.transferir(cp1, 100)) {
            System.out.println("Funcionou");
        }
        System.out.println("Saldo Luiz: " + cc1.getSaldo());
        System.out.println("Saldo da Conta Poupança do João: " + cp1.getSaldo());

        cp1.transferir(cc1, 200);
        System.out.println("Saldo Luiz: " + cc1.getSaldo());
        System.out.println("Saldo da Conta Poupança do João: " + cp1.getSaldo());

        System.out.println("====================Testando Transferencias FIM==========================\n");

        System.out.println("====================Testando Saldo+Cheque Especial==========================");
        System.out.println(cc1.retornarSaldoComChequeEspecial());
        System.out.println("====================Testando Saldo+Cheque Especial FIM==========================\n");

        System.out.println("====================Testando Creditar Taxa na Conta Poupança==========================");
        System.out.println("Saldo da Conta Poupança do João: " + cp1.getSaldo());
        cp1.creditarTaxa();
        System.out.println("Saldo da Conta Poupança do João: " + cp1.getSaldo());
        System.out.println("====================Testando Creditar Taxa na Conta Poupança FIM==========================\n");

        System.out.println("====================Imprimindo Conta Corrente==========================");
        cc1.imprimir();
        System.out.println("====================Imprimindo Conta Corrente FIM==========================\n");

        System.out.println("====================Imprimindo Conta Poupança==========================");
        cp1.imprimir();
        System.out.println("====================Imprimindo Conta Poupança FIM==========================\n");

        System.out.println("====================Imprimindo Clientes==========================");
        cc1.getCliente().imprimirCliente();
        cp1.getCliente().imprimirCliente();
        System.out.println("====================Imprimindo Clientes FIM==========================\n");

    }
}
