package com.dbc.exercicio5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class exercicio5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> pessoasPorCPF = new HashMap<>();

        System.out.println("Digite seu cpf: ");
        String cpf = scan.nextLine();

        System.out.println("Digite seu nome: ");
        String nome = scan.nextLine();

        pessoasPorCPF.put(cpf, nome);
        System.out.println(pessoasPorCPF);

        System.out.println("Consulte o cpf: ");
        String consultarCPF = scan.nextLine();

        if (pessoasPorCPF.get(consultarCPF) != null) {
            System.out.println(pessoasPorCPF.get(consultarCPF));
            pessoasPorCPF.remove(cpf);
        } else {
            System.out.println("Não encontrado");
        }

        System.out.println(pessoasPorCPF);

    }
}
