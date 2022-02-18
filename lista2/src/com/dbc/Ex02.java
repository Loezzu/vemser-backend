package com.dbc;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Escolha um numero para ser adivinhado: ");
        int numeroEscolhido = scan.nextInt();

        System.out.println("Adivinhe o numero: ");
        int numero = scan.nextInt();

        if ( numero == numeroEscolhido ) {
            System.out.println("Você acertou!");
        } else if( numero > numeroEscolhido) {
            System.out.println("Errou ;-;");
            System.out.println("O numero a ser encontrado é menor do que você digitou!");
        } else {
            System.out.println("Errou ;-;");
            System.out.println("O numero a ser encontrado é maior do que você digitou!");
        }
    }
}
