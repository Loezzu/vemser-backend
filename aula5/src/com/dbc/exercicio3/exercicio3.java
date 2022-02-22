package com.dbc.exercicio3;

import java.util.LinkedList;
import java.util.Queue;

public class exercicio3 {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        fila.add("senha1");
        fila.add("senha2");
        fila.add("senha3");
        fila.add("senha4");
        fila.add("senha5");

        fila.poll();
        fila.poll();
        System.out.println(fila);
        fila.poll();
        System.out.println(fila);

        fila.add("nova senha1");
        fila.add("nova senha2");
        fila.add("nova senha3");
        System.out.println(fila);

        fila.poll();
        fila.poll();
        fila.poll();
        System.out.println(fila);

    }
}
