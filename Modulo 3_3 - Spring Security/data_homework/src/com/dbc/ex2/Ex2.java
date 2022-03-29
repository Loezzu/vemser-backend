package com.dbc.ex2;

import java.time.LocalDate;
import java.time.Period;

public class Ex2 {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2022,12,12);
        LocalDate date2 = LocalDate.of(2024,10,19);

        Period period = Period.between(date1, date2);
        System.out.println("Dias entre as duas datas: " + period.getDays());
        System.out.println("Anos entre as duas datas: " + period.getYears());
        System.out.println("Meses entre as duas datas: " + period.getMonths());

    }
}
