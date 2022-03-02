package com.dbc;

import java.util.Stack;

public class Pilhas {
    public static void main(String[] args) {
        Stack<String> pilha = new Stack<>();

        pilha.add("Luiz");
        pilha.add("Thiago");
        pilha.add("Rafael");

        System.out.println(pilha);
        System.out.println(pilha.pop());
        System.out.println(pilha);
        pilha.add("Gabriel");
        System.out.println(pilha);
    }
}
