package com.dbc;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a palavra: ");
        String str = scan.nextLine();
        while (!str.equalsIgnoreCase("fim")) {
            System.out.println("Digite a palavra: ");
            str = scan.nextLine();
        }
    }
}
