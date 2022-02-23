package com.dbc.exercicio1;

public class Main {
    public static void main(String[] args) {

        Calculo somar = (valor1, valor2) -> valor1 + valor2;
        Calculo multiplicar = (valor1, valor2) -> valor1 * valor2;

        System.out.println(somar.calcular(2, 3));
        System.out.println(multiplicar.calcular(2, 3));

    }
}
