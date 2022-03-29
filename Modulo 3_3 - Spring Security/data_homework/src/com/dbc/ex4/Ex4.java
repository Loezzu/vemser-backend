package com.dbc.ex4;

import java.time.LocalDateTime;

public class Ex4 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now2 = now.plusDays(15).plusHours(10);

        System.out.println("Dia da semana: " + now2.getDayOfWeek());
        System.out.println("Dia do ano (corrido): " + now2.getDayOfYear());
    }
}
