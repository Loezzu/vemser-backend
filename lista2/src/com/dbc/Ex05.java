package com.dbc;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int valor = 10;
        int[] array = new int[valor];
        int numeros = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite algo: ");
            array[i] = scan.nextInt();

            numeros = array[i];
        }




    }
}
