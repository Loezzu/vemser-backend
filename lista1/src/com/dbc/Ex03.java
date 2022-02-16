package com.dbc;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe o valor total consumido: ");
        double valorConsumido = scan.nextDouble();

        System.out.println("Informe o valor pago pelo cliente: ");
        double valorPago = scan.nextDouble();

        if (valorPago < valorConsumido) {
            System.out.println("o valor pago deve ser maior ou igual ao valor consumido");
        } else if (valorPago >= valorConsumido) {
            double troco = valorPago - valorConsumido;
            System.out.println("Seu troco: " + troco);
        }


    }
}
