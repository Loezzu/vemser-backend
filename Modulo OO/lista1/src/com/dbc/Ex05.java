package com.dbc;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Valor Hora: ");
        double valorHora = scan.nextDouble();

        System.out.println("Numero de horas normais trabalhadas: ");
        double horasTrabalhadas = scan.nextDouble();

        System.out.println("numero de horas extras 50%");
        double horasExtras50 = scan.nextDouble();

        System.out.println("numero de horas extras 100%");
        double horasExtras100 = scan.nextDouble();

        double salarioBruto = (horasTrabalhadas * valorHora) + (horasExtras50 * valorHora * 1.5) + (horasExtras100 * valorHora * 2);
        System.out.println("Salário bruto: " + salarioBruto);

    }
}
