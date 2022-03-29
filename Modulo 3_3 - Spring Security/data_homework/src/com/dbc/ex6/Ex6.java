package com.dbc.ex6;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Ex6 {
    public static void main(String[] args) {

        LocalDateTime show = LocalDateTime.of(2024, 9, 14, 18,30);
        LocalDateTime hoje = LocalDateTime.now();

        //1 jeito
        Period periodo = Period.between(show.toLocalDate(), hoje.toLocalDate());
        Duration duracao = Duration.between(show, hoje);
        System.out.println(periodo);
        System.out.println(duracao);

        //2 jeito
        long anos = ChronoUnit.YEARS.between(hoje, show);
        long meses  = ChronoUnit.MONTHS.between(hoje, show);
        long dias = ChronoUnit.DAYS.between(hoje, show);
        long minutes = ChronoUnit.MINUTES.between(hoje, show);
        long hours = ChronoUnit.HOURS.between(hoje, show);
        long seconds = ChronoUnit.SECONDS.between(hoje, show);
        System.out.println(anos);
        System.out.println(meses);
        System.out.println(dias);
        System.out.println(hours);
        System.out.println(minutes);
        System.out.println(seconds);



    }
}
