package com.dbc;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] matriz = new int[4][4];
        int maiorQue10 = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("Informe o valor da linha " + (i+1) + " e coluna " + (j+1));
                matriz[i][j] = scanner.nextInt();
            }
        }

        for (int a = 0; a < matriz.length; a++) {
            for (int b = 0; b < matriz.length; b++) {
               if (matriz[a][b] >= 10) {
                   maiorQue10++;
                   System.out.println("Maior que 10: " + matriz[a][b] + " no index [" + a + "," + b + "] da matriz");
               }
            }
        }

        if(maiorQue10 == 1){
            System.out.println("são " + maiorQue10 + " valor que dez");
        } else{
            System.out.println("são " + maiorQue10 + " maiores que dez");
        }

    }
}
