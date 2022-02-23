package com.dbc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        lista.add(new Pessoa(1, "Maicon", 50000));
        lista.add(new Pessoa(2, "Pedro", 53000));
        lista.add(new Pessoa(3, "Joel", 60000));

//        lista.forEach(System.out::println);

//        Stream<Pessoa> stream = lista.stream();
//        Stream<Pessoa> streamFiltroPessoa = stream.filter(pessoa -> pessoa.getNome().contains("e"));
//        List<Pessoa> collect = streamFiltroPessoa.collect(Collectors.toList());
//        System.out.println(collect);

        System.out.println(lista);

//        List<Pessoa> filtrada = lista.stream()
//                .filter(pessoa -> pessoa.getNome().contains("e"))
//                .collect(Collectors.toList());
//
//        System.out.println(filtrada);

        List<Integer> idsPessoasQueGanhamMaisde50000 = lista.stream()
                .filter(pessoa -> {
                    boolean condicaoSalario = pessoa.getSalario() > 50000;
                    boolean condicaoNome = pessoa.getNome().contains("e");
                    return condicaoSalario && condicaoNome;
//                    return condicaoSalario;
                })
                .map(pessoa -> pessoa.getId())
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .collect(Collectors.toList());
        System.out.println(idsPessoasQueGanhamMaisde50000);

        Map<Integer, String> collect = lista.stream()
                .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
        System.out.println(collect);

        boolean todosGanhamMaisDe50Mil = lista.stream()
                .allMatch(pessoa -> pessoa.getSalario() > 50000);
        System.out.println(todosGanhamMaisDe50Mil);

        boolean alguemGanhaMaisDe50mil = lista.stream()
                .anyMatch(pessoa -> pessoa.getSalario() > 50000);
        System.out.println("alguemGanhaMaisDe50mil=" + alguemGanhaMaisDe50mil);

        double mediaSalarial = lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average()
                .getAsDouble();
        System.out.println(mediaSalarial);
    }
}
