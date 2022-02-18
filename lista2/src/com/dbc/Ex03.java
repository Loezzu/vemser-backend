package com.dbc;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int contadorDeJogadores = 0;

        double maiorAltura = 0;
        double mediaAlturas = 0;
        int maiorIdade = 0;
        double maiorPeso = 0;

        System.out.println("nome do jogador: ");
        String nome = scan.next();

        while (!nome.equalsIgnoreCase("sair")) {
            System.out.println("altura do jogador: ");
            double altura = scan.nextDouble();
            mediaAlturas += altura;
            if (altura > maiorAltura) {
                maiorAltura = altura;
            }

            System.out.println("idade do jogador: ");
            int idade = scan.nextInt();
            if (idade > maiorIdade) {
                maiorIdade = idade;
            }

            System.out.println("peso do jogador: ");
            double peso = scan.nextDouble();
            if (peso > maiorPeso) {
                maiorPeso = peso;
            }

            contadorDeJogadores++;

            System.out.println("nome: ");
            nome = scan.next();
        }

        double mediaAlturaFinal = mediaAlturas / contadorDeJogadores;

        System.out.println("Jogadores Cadastrados: " + contadorDeJogadores);
        System.out.println("Altura do maior jogador: " + maiorAltura);
        System.out.println("Jogador mais velho: " + maiorIdade);
        System.out.println("Jogador mais pesado: " + maiorPeso);
        System.out.println("Média de altura: " + mediaAlturaFinal);

        scan.close();

    }
}
