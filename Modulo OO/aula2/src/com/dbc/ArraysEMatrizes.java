package com.dbc;

public class ArraysEMatrizes {
    public static void main(String[] args) {
//        int[] numeros = new int[3];
//        numeros[0] = 10;
//        numeros[1] = 20;
//        numeros[2] = 30;
//        System.out.println(numeros[1]);
//
//        int[] numerosConstantes = {80, 5, 2, 9, 8,3};
//        System.out.println(numerosConstantes[3]);

        int[][] numeros = new int[2][2];
        numeros[0][0] = 15; // 15 20
        numeros[0][1] = 20; // 30 89
        numeros[1][0] = 30;
        numeros[1][1] = 89;
        System.out.println(numeros[0][1]);

        int[][] matriz = {{15, 20, 20}
                        ,{30, 89, 88}
                        ,{8, 7, 8}};
        System.out.println(matriz[1][0]);
    }
}
