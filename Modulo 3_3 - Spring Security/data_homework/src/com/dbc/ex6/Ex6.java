package com.dbc.ex6;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Ex6 {
    public static void main(String[] args) {

        LocalDateTime show = LocalDateTime.of(2024, 9, 14, 18,30).atZone(ZoneId.of("UTC+01:00")).withZoneSameInstant(ZoneId.of("UTC-03:00")).toLocalDateTime();
        LocalDateTime hoje = LocalDateTime.now().atZone(ZoneId.of("UTC-03:00")).toLocalDateTime();

        System.out.println("Hora atual : " + hoje);
        System.out.println("Hora do show: " + show);

        LocalDateTime tempoDescontado = LocalDateTime.from(hoje);

        long anos = tempoDescontado.until(show, ChronoUnit.YEARS);
        tempoDescontado = tempoDescontado.plusYears(anos);
        long meses = tempoDescontado.until(show, ChronoUnit.MONTHS);
        tempoDescontado = tempoDescontado.plusMonths(meses);
        long dias = tempoDescontado.until(show, ChronoUnit.DAYS);
        tempoDescontado = tempoDescontado.plusDays(dias);
        long horas = tempoDescontado.until(show, ChronoUnit.HOURS);
        tempoDescontado = tempoDescontado.plusHours(horas);
        long minutos = tempoDescontado.until(show, ChronoUnit.MINUTES);
        tempoDescontado = tempoDescontado.plusMinutes(minutos);
        long segundos = tempoDescontado.until(show, ChronoUnit.SECONDS);

        System.out.println("Anos: " + anos);
        System.out.println("Meses: " + meses);
        System.out.println("Dias: " + dias);
        System.out.println("Horas: " + horas);
        System.out.println("Minutos: " + minutos);
        System.out.println("Segundos: " + segundos);

    }
}
