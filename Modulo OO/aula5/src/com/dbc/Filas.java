package com.dbc;

import java.util.LinkedList;
import java.util.Queue;

public class Filas {
    public static void main(String[] args) {

        Queue<String> fila = new LinkedList<>();
        fila.add("Marcelo");
        fila.add("Pedro");
        fila.add("João");
        System.out.println(fila);
        String proximo = fila.poll();
        System.out.println(proximo);
        System.out.println(fila);
        System.out.println(fila.size());
        String verificar = fila.peek();
        System.out.println(verificar);
        System.out.println(fila);



    }
}
