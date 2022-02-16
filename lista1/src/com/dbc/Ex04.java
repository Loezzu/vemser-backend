package com.dbc;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Escolha um estado:\n" +
                            "1 - Rio Grande do sul\n" +
                            "2 - Santa Catarina\n" +
                            "3 - Paraná");
        int estado = scan.nextInt();

        switch (estado) {
            case 1:
                System.out.println("Escolha uma cidade:\n" +
                        "1 - Porto Alegre\n" +
                        "2 - Gravataí");
                int cidadeRS = scan.nextInt();
                switch (cidadeRS) {
                    case 1:
                        System.out.println("Porto Alegre:\n" +
                                "População -> 1.492.530\n" +
                                "IDHM -> 0,805\n" +
                                "Área Territorial -> 495,390 km²");
                    break;
                    case 2:
                        System.out.println("Gravataí\n" +
                                "População -> 285.564\n" +
                                "IDHM -> 0,736\n" +
                                "Área Territorial -> 468,288 km²");
                        break;
                }
                break;
            case 2:
                System.out.println("Escolha uma cidade:\n" +
                        "1 - Florianópolis\n" +
                        "2 - Joinville");
                int cidadeSC = scan.nextInt();
                switch (cidadeSC) {
                    case 1:
                        System.out.println("Florianópolis:\n" +
                                "População -> 516.524\n" +
                                "IDHM -> 0,847\n" +
                                "Área Territorial -> 674,844 km²");
                        break;
                    case 2:
                        System.out.println("Joinville\n" +
                                "População -> 604.708\n" +
                                "IDHM -> 0,809\n" +
                                "Área Territorial -> 1.127,946 km²");
                        break;
                }
                break;
            case 3:
                System.out.println("Escolha uma cidade:\n" +
                        "1 - Curitiba\n" +
                        "2 - Londrina");
                int cidadePR = scan.nextInt();
                switch (cidadePR) {
                    case 1:
                        System.out.println("Curitiba:\n" +
                                "População -> 1.963.726\n" +
                                "IDHM -> 0,823\n" +
                                "Área Territorial -> 434,892 km²");
                        break;
                    case 2:
                        System.out.println("Londrina\n" +
                                "População -> 580.870\n" +
                                "IDHM -> 0,778\n" +
                                "Área Territorial -> 1.652,569 km²");
                        break;
                }
                break;
        }
    }
}
