package com.dbc.exercicio6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> p1 = new ArrayList<>();

        p1.add(new Pessoa("Luiz", 20));
        p1.add(new Pessoa("Pedro", 24));
        p1.add(new Pessoa("Guilherme", 20));
        p1.add(new Pessoa("Luiz", 19));

        System.out.println(p1);

        p1.sort(new Comparator<Pessoa>() { // ordem crescente por nome
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        System.out.println("Ordem crescente por nome -> " + p1);

        p1.sort(new Comparator<Pessoa>() { //ordem do mais velho pro mais novo
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o2.getIdade() - o1.getIdade();
            }
        });
        System.out.println("Ordem do mais velho pro mais novo -> " + p1);

        p1.sort(new Comparator<Pessoa>() { //ordem crescente por nome e se nome for igual ordenar por idade do mais velho ao mais novo
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                int comparandoNome = o1.getNome().compareTo(o2.getNome());
                if (comparandoNome != 0) {
                    return comparandoNome;
                }
                return o1.getIdade() - o2.getIdade();
            }
        });
        System.out.println("Ordem crescente por nome + idade -> " + p1);
    }
}
