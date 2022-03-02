package com.dbc.exercicio1;

import com.dbc.TipoCarro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        Tipo
        System.out.println("Informe o tipo de comida desejado: \n" +
                "Japonesa \n" +
                "FastFood \n" +
                "Tradicional \n");
        String comida = scan.nextLine();

        Double comidaEscolhida = TipoComida.valueOfByComida(comida);
        System.out.println("R$ " + comidaEscolhida);


    }
}
