package com.dbc.exercicio3;

public class Main {
    public static void main(String[] args) {

        System.out.println(somatoria(5));
    }

    public static Integer somatoria(Integer number) {
        if (number == 1) {
            return 1;
        }
        return number + somatoria(number -1);

    }
}
