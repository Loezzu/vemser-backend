package com.dbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Date date = new Date(1995-1900, 11, 30, 10, 15, 00);
        System.out.println(date);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite uma data no formato dd/MM/yyyy");
        String scan = scanner.nextLine();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date dataFormatada = simpleDateFormat.parse(scan);
        System.out.println(dataFormatada);
        System.out.println(simpleDateFormat.format(dataFormatada));

    }
}
