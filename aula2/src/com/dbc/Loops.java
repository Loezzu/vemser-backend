package com.dbc;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
//        for(int i = 0; i < 10 ; i++) {
//            System.out.println("index: " + i);
//        }
//
//        int[] valores = {2, 5, 8, 10, 15, 4, 18};
//
//        for(int i = 0; i < valores.length ; i+=2) {
//            System.out.println(valores[i]);
//        }
//
//        for(int valor : valores) {
//            System.out.println(valor);
//        }

//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        while(!str.equalsIgnoreCase("sair")){ //false
//            System.out.println(str);
//            str = scanner.nextLine(); //sair SAIR
//        }


//        do {
//
//            System.out.println(str);
//        } while (!str.equalsIgnoreCase("exit"));

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while(true){
            if(str.equals("sair")){ //sair
                break; //sair do while
            }
            System.out.println(str);
            str = scanner.nextLine(); //sair
        }

    }
}
