package com.dbc;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] array = {1,2,3,4,5,6,7,8,9,10};

        System.out.println("Informe um valor: ");
        int numeroBuscado = scan.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numeroBuscado) {
                System.out.println("Posição encontrada: " + i);
                return;
            }

        }
        System.out.println("nenhum numero foi encontrado");



    }
}
