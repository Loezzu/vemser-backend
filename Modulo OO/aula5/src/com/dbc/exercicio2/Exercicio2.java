package com.dbc.exercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> lista = new ArrayList<>();

        System.out.println("Digite um nome: ");
        String nome = scan.next();
        lista.add(nome);

        while (!nome.equalsIgnoreCase("sair")) {
            System.out.println("Digite um nome: ");
            nome = scan.next();
            lista.add(nome);
        }

        lista.remove(lista.size() -1);
        System.out.println("Pegando penúltimo nome da lista: " + lista.get(lista.size() -2));
        System.out.println("Pegando primeiro nome: " + lista.get(0));
        System.out.println("Ultimo nome removido: " + lista.remove(lista.size() -1));
        System.out.println("Nomes da lista: " + lista);
        System.out.println("Quantidade de nomes: " + lista.size());

        scan.close();
    }
}
