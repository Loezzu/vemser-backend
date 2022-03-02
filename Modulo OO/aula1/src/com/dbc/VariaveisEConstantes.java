package com.dbc;

public class VariaveisEConstantes {
    public static void main(String[] args) {
        // minhas variaveis

        String meuNome = "Luiz";
        int idade = 19;
        float altura = 1.70f;
        double alturaDouble = 1.70;
        boolean ehSolteiro = false;

        final String NOME_EH = "O nome dele é ";
        final String COM = " com ";
        final String ANOS = " anos.";

        meuNome = "Lucas";
//        NOME_EH = "O apelido dele é ";

        System.out.println(NOME_EH + meuNome + COM + idade + ANOS);
        System.out.println(altura + " " + alturaDouble + " " + ehSolteiro);

    }
}
