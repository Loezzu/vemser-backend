package com.dbc;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String nome = "";
        double altura = 0;
        int idade = 0;
        double peso = 0;

        int contador = 0;
        int contadorAltura = 0;

        System.out.println("nome: ");
        nome = scan.nextLine();
        while (!nome.equalsIgnoreCase("sair")) {

            System.out.println("altura: ");
            altura = scan.nextDouble();
            scan.nextLine();

//            System.out.println("idade: ");
//            idade = scan.nextInt();
//            scan.nextLine();
//
//            System.out.println("peso: ");
//            peso = scan.nextDouble();
//            scan.nextLine();

            contador++;

            contadorAltura++;





//            System.out.println("quantidade de jogadores cadastrados: " + contador);

            System.out.println("nome: ");
            nome = scan.nextLine();


        }

        int[] arrayAltura = new int[(int)altura];

        for (int i = 0; i < contadorAltura; i++){
            System.out.println(contadorAltura);
//                System.out.println(arrayAltura[i]);
        }


        scan.close();

//        int[] array = new int[1];
//        for (int i = 0; i < ) {
//
//        }
    }
}
