package com.dbc;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("informe o primeiro valor: ");
        int valor1 = scan.nextInt();

        System.out.println("informe o segundo valor: ");
        int valor2 = scan.nextInt();

        System.out.println("informe o terceiro valor: ");
        int valor3 = scan.nextInt();

        //               0        1       2
        int[] array = {valor1, valor2, valor3};


        if (valor1 < valor2 && valor1 < valor3) {
            System.out.println(array[0]);
        } else if ( valor2 < valor1 && valor2 < valor3) {
            System.out.println(array[1]);
        } else if (valor3 < valor1 && valor3 < valor2) {
            System.out.println(array[2]);
        }

    }
}
