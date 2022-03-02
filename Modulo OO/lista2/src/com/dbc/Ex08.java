package com.dbc;


public class Ex08 {
    public static void main(String[] args) {
        int matriz[][] = {{1, 5, 9, 0}, {2, 9, 4, 0}, {3, 4, 8, 0}, {4, 7, 3, 0}, {5, 6, 7, 0}};

        double melhor = 0;
        double pessoaMelhor = 0;
        double media = 0;

       for (int i=0; i<5; i++) {
            do {
                int mediaDeProvas = matriz[(i)][1];
                int mediaDeTrabalhos = matriz[(i)][2];

                double trabalhoFinal = (double) mediaDeProvas * 0.6 + (double) mediaDeTrabalhos * 0.4;
                media += trabalhoFinal;

                if (trabalhoFinal > melhor) {
                    melhor = trabalhoFinal;
                    pessoaMelhor = i;
                }

                i++;
            } while (i<5);
        }
        System.out.println("Numero da matricula: " + ((int) pessoaMelhor+1));
        System.out.println("Nota final: " + melhor);

        media /= 5;
        System.out.println("Média das notas finais: " + media );

    }
}
