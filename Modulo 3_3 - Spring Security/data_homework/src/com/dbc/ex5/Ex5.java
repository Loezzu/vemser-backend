package com.dbc.ex5;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Ex5 {
    public static void main(String[] args) {
        Calendar data = Calendar.getInstance();
        data.set(Calendar.YEAR, 2021);
        data.set(Calendar.MONTH, 11);
        data.set(Calendar.DAY_OF_MONTH, 12);

        Locale brasil = new Locale("pt", "br");
        DateFormat formatBr = DateFormat.getDateInstance(DateFormat.FULL, brasil);
        System.out.println(formatBr.format(data.getTime()));

        Locale eua = Locale.US;
        DateFormat formatEua = DateFormat.getDateInstance(DateFormat.FULL, eua);
        System.out.println(formatEua.format(data.getTime()));

        Locale frances = Locale.FRANCE;
        DateFormat formatFrance = DateFormat.getDateInstance(DateFormat.FULL, frances);
        System.out.println(formatFrance.format(data.getTime()));

    }
}
