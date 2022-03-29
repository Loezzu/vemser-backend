package com.dbc.ex3;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Ex3 {
    public static void main(String[] args) {
//        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);

        ZoneId zoneIdBrasilia = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime dataHoraBrasilia = ZonedDateTime.now(zoneIdBrasilia);
        System.out.println(dataHoraBrasilia.format(DateTimeFormatter.RFC_1123_DATE_TIME) + dataHoraBrasilia.getZone());

        ZoneId zoneIdAustralia = ZoneId.of("Australia/Sydney");
        ZonedDateTime dataHoraAustralia = ZonedDateTime.now(zoneIdAustralia);
        System.out.println(dataHoraAustralia.format(DateTimeFormatter.RFC_1123_DATE_TIME) + dataHoraAustralia.getZone());

        ZoneId zoneIdJapao = ZoneId.of("Japan");
        ZonedDateTime dataHorajapao = ZonedDateTime.now(zoneIdJapao);
        System.out.println(dataHorajapao.format(DateTimeFormatter.RFC_1123_DATE_TIME) + dataHorajapao.getZone());

        ZoneId zoneIdRussia = ZoneId.of("Asia/Irkutsk");
        ZonedDateTime dataHoraRussian = ZonedDateTime.now(zoneIdRussia);
        System.out.println(dataHoraRussian.format(DateTimeFormatter.RFC_1123_DATE_TIME) + dataHoraRussian.getZone());

        ZoneId zoneIdDubai = ZoneId.of("Asia/Dubai");
        ZonedDateTime dataHoraDubai = ZonedDateTime.now(zoneIdDubai);
        System.out.println(dataHoraDubai.format(DateTimeFormatter.RFC_1123_DATE_TIME) + dataHoraDubai.getZone());

        ZoneId zoneIdEstadosUnidos = ZoneId.of("America/New_York");
        ZonedDateTime dataHoraEstadosUnidos= ZonedDateTime.now(zoneIdEstadosUnidos);
        System.out.println(dataHoraEstadosUnidos.format(DateTimeFormatter.RFC_1123_DATE_TIME) + dataHoraEstadosUnidos.getZone());




    }
}
