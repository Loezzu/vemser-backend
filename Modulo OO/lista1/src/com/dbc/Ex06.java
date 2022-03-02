package com.dbc;

import java.util.Locale;
import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Informe a palavra: ");
        String palavra = scan.nextLine();
        palavra = palavra.toLowerCase();

        switch (palavra) {
            // pt > en
            case "cachorro" -> System.out.println("Dog");
            case "tempo" -> System.out.println("Time");
            case "amor" -> System.out.println("Love");
            case "cidade" -> System.out.println("City");
            case "feliz" -> System.out.println("Happy");
            // en > pt
            case "dog" -> System.out.println("Cachorro");
            case "time" -> System.out.println("Tempo");
            case "love" -> System.out.println("Amor");
            case "city" -> System.out.println("Cidade");
            case "happy" -> System.out.println("Feliz");
            default -> System.out.println("Essa palavra não é válida");
        }

    }
}
