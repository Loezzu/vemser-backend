package com.dbc.exercicio2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
//        BiFunction<Double, Double, Double> sub = (val1, val2) -> val1 - val2;
//
//        System.out.println(sub.apply(5.0, 2.0));

        Function<Double, Double> cos = (valor) -> Math.cos(valor);
        Function<Double, Double> sqrt = (valor) -> Math.sqrt(valor);

        System.out.println(cos.apply(1.00));
        System.out.println(sqrt.apply(16.00));

        Function<Double, Double> sqrtThenCos = sqrt.andThen(cos);

        System.out.println(sqrtThenCos.apply(1.00));
    }
}
