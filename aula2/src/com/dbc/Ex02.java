package com.dbc;

public class Ex02 {
    public static void main(String[] args) {
        int[][] matriz = new int[2][2];
        matriz[0][0] = 10;
        matriz[0][1] = 20;
        matriz[1][0] = 30;
        matriz[1][1] = 40;

        int somaTudo = matriz[0][0] + matriz[0][1] + matriz[1][0] + matriz[1][1];
        int somaPrimeiraLinha = matriz[0][0] + matriz[0][1];
        int somaSegundaLinha = matriz[1][0] + matriz[1][1];
        int diferenca = somaPrimeiraLinha - somaSegundaLinha;

        System.out.println("Soma de tudo: " + somaTudo);
        System.out.println("Soma da primeira linha: " + somaPrimeiraLinha);
        System.out.println("Soma de segunda linha: " + somaSegundaLinha);
        System.out.println("Diferença: " + diferenca);
    }
}
