package com.dbc;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Numero de elementos: ");
        int numero = scan.nextInt();

        double media = 0;
        double soma = 0;
        int[] vetor = new int[numero];

        for (int i = 0; i < numero; i++) {
            System.out.println("valor: ");
            vetor[i] = scan.nextInt();
            soma += vetor[i];
            media = soma/numero;
        }

        System.out.println(media);
    }
}
