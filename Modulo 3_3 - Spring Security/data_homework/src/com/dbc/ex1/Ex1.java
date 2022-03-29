package com.dbc.ex1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a data do seu aniversário no formato dd/mm/aaaa");
        String data = scanner.nextLine();
        DateTimeFormatter aniversario = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate aniversarioDate = LocalDate.parse(data, aniversario);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.forLanguageTag("pt-BR"));
        String aniversarioFormatado = aniversarioDate.format(formatter);
        System.out.println("Seu aniversário é: " + aniversarioFormatado);
        LocalDate hoje = LocalDate.now();
        long dias = aniversarioDate.toEpochDay() - hoje.toEpochDay();
        long meses = dias / 30;
        System.out.println("Faltam " + dias + " dias para o seu aniversário");
        System.out.println("Faltam " + meses + " meses para o seu aniversário");

    }
}
