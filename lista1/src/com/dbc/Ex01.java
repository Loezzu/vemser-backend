package com.dbc;

import java.util.Scanner;

public class Ex01 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = scan.nextLine();

        System.out.println("Digite sua idade: ");
        int idade = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite sua cidade: ");
        String cidade = scan.nextLine();

        System.out.println("Digite seu estado: ");
        String estado = scan.nextLine();

        System.out.println("Olá, seu nome é " + nome + ", você tem " + idade + " anos, é da cidade de " + cidade + ", situada no estado de " + estado + ".");
    }
}
