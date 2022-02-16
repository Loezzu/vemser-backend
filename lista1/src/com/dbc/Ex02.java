package com.dbc;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe a primeira nota: ");
        double n1 = scan.nextDouble();
        System.out.println("Informe a segunda nota: ");
        double n2 = scan.nextDouble();
        System.out.println("Informe a terceira nota: ");
        double n3 = scan.nextDouble();
        System.out.println("Informe a quarta nota: ");
        double n4 = scan.nextDouble();

        double media = (n1 + n2 + n3 + n4) / 4;

        if (media >= 0 && media <= 5) {
            System.out.println("Reprovado");
        } else if(media >= 5.1 && media <= 6.9) {
            System.out.println("Em exame");
        } else if (media >= 7 && media <= 10) {
            System.out.println("Aprovado");
        } else {
            System.out.println("média inválida");
        }

        System.out.println(media);
    }
}
