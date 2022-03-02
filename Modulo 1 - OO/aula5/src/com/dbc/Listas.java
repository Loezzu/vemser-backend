package com.dbc;

import java.util.ArrayList;

public class Listas {
    public static void main(String[] args) {
        ArrayList<String> minhaLista = new ArrayList<>();
        minhaLista.add("Luiz");
        minhaLista.add("Gabriel");
        minhaLista.add("Guilherme");
        minhaLista.add("João");
//        minhaLista.add(1122);
        System.out.println(minhaLista);
        System.out.println(minhaLista.size());
        System.out.println(minhaLista.get(2)); // começa por zero
        System.out.println(minhaLista.indexOf("Guilherme"));
        System.out.println(minhaLista.remove(0));
        System.out.println(minhaLista);
        System.out.println(minhaLista.contains("João"));
        minhaLista.set(2, "João Victor");
        System.out.println(minhaLista);
        minhaLista.add(0, "Teste");
        System.out.println(minhaLista);

    }
}
