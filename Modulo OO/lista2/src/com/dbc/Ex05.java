package com.dbc;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int valor = 20;
        int[] array = new int[valor];
        for (int i = 0; i < valor; i++) {
            System.out.println("Digite algo: ");
            array[i] = scan.nextInt();

        }

        printarArray(inverterArray(array));
    }

     private static int[] inverterArray(int[] arrayInicial) {
        int[] resultado = new int[arrayInicial.length];
        int indexResultado = 0;
        for (int i = arrayInicial.length -1; i >= 0 ; i--) {
            resultado[indexResultado] = arrayInicial[i];
            indexResultado++;
        }
        return resultado;
    }

    private static void printarArray(int[] array) {
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
