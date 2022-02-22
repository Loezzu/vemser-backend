package com.dbc.exercicio1;

public class Main {
    public static void main(String[] args) {

        Soma soma = new Soma();
        System.out.println(soma.calcula(5,5));

        Subtracao sub = new Subtracao();
        System.out.println(sub.calcula(5,5));

        Multiplicacao multi = new Multiplicacao();
        System.out.println(multi.calcula(5,5));

        Divisao div = new Divisao();
        System.out.println(div.calcula(5,5));
    }
}
