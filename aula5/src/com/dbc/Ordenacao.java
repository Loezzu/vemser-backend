package com.dbc.aula5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ordenacao {
    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Carro("ford ka", 150000)); // 0
        carros.add(new Carro("mercedes Classe A", 1510)); // 1
        carros.add(new Carro("mercedes Classe A", 1502)); // 2
        carros.add(new Carro("fusca 78", 2000000)); // 3

//        System.out.println(carros);
//        carros.sort(new Comparator<Carro>() {
//            @Override
//            public int compare(Carro o1, Carro o2) {
//                return o2.getQuilometragem() - o1.getQuilometragem();
//            }
//        });
//        System.out.println(carros);

//        System.out.println(carros);
//        carros.sort(new Comparator<Carro>() {
//            @Override
//            public int compare(Carro o1, Carro o2) {
//                return o2.getModelo().compareTo(o1.getModelo());
//            }
//        });
//        System.out.println(carros);

        System.out.println(carros);
        carros.sort(new Comparator<Carro>() {
            @Override
            public int compare(Carro o1, Carro o2) {
                int comparacaoUm = o1.getModelo().compareTo(o2.getModelo());
                if(comparacaoUm != 0){
                    return comparacaoUm;
                }
                return o1.getQuilometragem() - o2.getQuilometragem();
            }
        });
        System.out.println(carros);
    }
}
