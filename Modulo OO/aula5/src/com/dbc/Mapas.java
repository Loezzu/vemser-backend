package com.dbc;

import java.util.HashMap;
import java.util.Map;

public class Mapas {
    public static void main(String[] args) {
        Map<String, String> pessoasPorCPF = new HashMap<>();
        pessoasPorCPF.put("12345678910", "Luiz Souza");
        pessoasPorCPF.put("09876543212", "Pedro Rodrigues");
        pessoasPorCPF.put("02020202143", "João Gonçalves");

        System.out.println(pessoasPorCPF);
        System.out.println(pessoasPorCPF.get("09876543212"));
        System.out.println(pessoasPorCPF.remove("02020202143"));
        System.out.println(pessoasPorCPF);
        System.out.println(pessoasPorCPF.size());
        System.out.println(pessoasPorCPF.keySet());
        System.out.println(pessoasPorCPF.values());

    }
}
