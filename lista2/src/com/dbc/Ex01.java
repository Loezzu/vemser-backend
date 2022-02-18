package com.dbc;

import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Nome do produto: ");
        String produto = scan.nextLine();

        System.out.println("valor do produto: ");
        double valor = scan.nextDouble();

        double[] vetor = new double[(int)valor];

        for (int i = 0 ; i < 10; i++) {
            double porcentagem = 0.05 * (i+1);
            float desconto = (float) (valor - (porcentagem * valor));
            float valorComDesconto = (i+1) * desconto;
            System.out.printf((i+1) + " x R$ %.2f = R$ %.2f\n", desconto, valorComDesconto);
        }

    }
}
