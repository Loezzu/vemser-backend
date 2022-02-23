package com.dbc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
//        Funcao funcao = new Funcao() {
//            @Override
//            public String gerar(String valor) {
//                return "Sr. " + valor;
//            }
//        };
//
//        Funcao funcaoSra = new Funcao() {
//            @Override
//            public String gerar(String valor) {
//                return "Sr. " + valor;
//            }
//        };

//        Funcao funcaoLambda = (String vr, Integer idade) -> "Sr. " + vr + " idade: " + idade;
//        Funcao funcaoLambdaSra = (vr, idade) -> "Sra. " + vr + " idade: " + idade;
//
////        System.out.println(funcao.gerar("Lucas"));
//        System.out.println(funcaoLambda.gerar("Lucas", 18));
//        System.out.println(funcaoLambdaSra.gerar("Ana", 19));
        //        //funcoes de primeira classe e de ordem superior
//        List<Carro> carros = new ArrayList<>();
//        carros.add(new Carro("ford ka", 150000));
//        carros.add(new Carro("mercedes Classe A", 1500));
//        carros.add(new Carro("mercedes Classe C", 1500));
//        carros.add(new Carro("fusca 78", 2000000));
//
//
//        System.out.println(carros);
////        carros.sort((o1, o2) -> o2.getQuilometragem() - o1.getQuilometragem());
//        carros.sort(Comparator.comparing(Carro::getQuilometragem).reversed());
//        System.out.println(carros);

//        Imutavel imutavel = new Imutavel("Valor Imutável");
//        System.out.println(imutavel.getDado());

//        Function<Double, Double> log = (value) -> Math.log(value);
//        Function<Double, Double> sqrt = (value) -> Math.sqrt(value);
//        Function<Double, Double> soma = (value1) -> value1 + value1;
//        Function<Double, Double> logThenSqrt = sqrt.compose(log);

//        Double passo1 = log.apply(3.14);
//        Double passo2 = sqrt.apply(passo1);
//        System.out.println(passo2);
//        System.out.println(logThenSqrt.apply(3.14));
//        System.out.println(log.apply(3.0));
//        System.out.println(sqrt.apply(16.0));
//        System.out.println(logThenSqrt.apply(3.14));

//        Function<Double, Double> sqrtThenLog = sqrt.andThen(log);
//        Double passo11 = sqrt.apply(3.14);
//        System.out.println(passo11);
//        Double passo22 = log.apply(passo11);
//        System.out.println(passo22);
//        System.out.println(sqrtThenLog.apply(3.14));
//        // Output: 0.57

        System.out.println(factorial(3));

    }

    public static Integer factorial(Integer number) {
        if (number == 1) {
            return 1;
        }
         // 3 * 2 * 1 = 6
         //
        int valor = number * factorial(number - 1);
        System.out.println(valor);
        return valor;
    }
}
