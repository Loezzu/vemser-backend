package com.dbc;

import java.util.Scanner;

public class exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro valor: ");
        int num1 = scanner.nextInt();
        System.out.println("Digite o segundo valor: ");
        int num2 = scanner.nextInt();

        System.out.println("informe a operação desejada: ");
        String operador = scanner.next();

        int resposta = switch (operador) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };

        System.out.println("A resposta é: " + resposta);

    }
}
