package com.dbc.exercicio4;

import java.util.Scanner;
import java.util.Stack;

public class exercicio4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Integer> pilha = new Stack<>();

        System.out.println("Informe um valor: ");
        int valor = scan.nextInt();
        if (valor % 2 == 0) {
            pilha.add(valor);
        }

        do {
            System.out.println("Informe outro valor: ");
            valor = scan.nextInt();
            if (valor % 2 == 0) {
                pilha.add(valor);
            }
        } while (valor < 15);


        while (!pilha.isEmpty()) {
            System.out.println(pilha.pop());

        }


    }
}
