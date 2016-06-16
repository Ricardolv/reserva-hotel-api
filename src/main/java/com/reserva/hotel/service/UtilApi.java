package com.reserva.hotel.service;

import static com.reserva.hotel.service.ConstanteApp.PATTER_DATA;
import static com.reserva.hotel.service.ConstanteApp.REGEX_APENAS_CARACTERES;
import static com.reserva.hotel.service.ConstanteApp.REGEX_APENAS_NUMEROS;
import static com.reserva.hotel.service.Hoteleiro.ROYAL_HOTEL;
import static com.reserva.hotel.service.Hoteleiro.THE_CARLYLE;
import static com.reserva.hotel.service.Hoteleiro.THE_PLAZA;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author richard
 */
public class UtilApi {

    public static List<LocalDate> obterPeriodo(LocalDate dataInicio, LocalDate dataFim) {

        List<LocalDate> retorno = new ArrayList<>();
        while (dataInicio.isBefore(dataFim) || dataInicio.equals(dataFim)) {
            retorno.add(dataInicio);
            dataInicio = dataInicio.plusDays(1);
        }

        return retorno;
    }

    public static boolean isFimSemana(LocalDate inputData) {
        return inputData.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                || inputData.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }

    public static LocalDate convertStringToLocalDate(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTER_DATA);
        LocalDate date = LocalDate.parse(data, formatter);
        return date;
    }

    public static Tarifa obterMelhorTarifa(Clientela clientela, LocalDate dataInicio, LocalDate dataFim) {

        Hotel theCarlyle = THE_CARLYLE.obterHotel();
        Tarifa tarifaTheCarlyle = new Tarifa(THE_CARLYLE, theCarlyle.obterValorTotalDiaria(clientela, dataInicio, dataFim));

        Hotel thePLaza = THE_PLAZA.obterHotel();
        Tarifa tarifaThePlaza = new Tarifa(THE_PLAZA, thePLaza.obterValorTotalDiaria(clientela, dataInicio, dataFim));

        Hotel royal = ROYAL_HOTEL.obterHotel();
        Tarifa tarifaTheRyal = new Tarifa(ROYAL_HOTEL, royal.obterValorTotalDiaria(clientela, dataInicio, dataFim));

        List<Tarifa> tarifas = Arrays.asList(tarifaTheCarlyle, tarifaThePlaza, tarifaTheRyal);
        
        Tarifa menoTarifa = obterMenorTarifa(tarifas);

        return menoTarifa;
    }

    private static Tarifa obterMenorTarifa(List<Tarifa> tarifas) {

        Tarifa menorTarifa = null;

        for (Tarifa tarifa : tarifas) {

            if (menorTarifa == null || tarifa.getPreco().compareTo(menorTarifa.getPreco()) != 1) {
                menorTarifa = tarifa;

            } else if (tarifa.getPreco().compareTo(menorTarifa.getPreco()) == 0
                    && tarifa.getHoteleiro().getEstrela() > menorTarifa.getHoteleiro().getEstrela()) {
                menorTarifa = tarifa;
            }
        }

        return menorTarifa;
    }

    public static LocalDate obterDataInico(List<LocalDate> datas) {
        datas.sort((LocalDate l1, LocalDate l2) -> l1.compareTo(l2));
        return datas.get(0);
    }

    public static LocalDate obterDataFim(List<LocalDate> datas) {
        datas.sort((LocalDate l1, LocalDate l2) -> l2.compareTo(l1));
        return datas.get(0);
    }
    
    public static int obterDia(String input) {
        return Integer.valueOf(input.replaceAll(REGEX_APENAS_NUMEROS, "").substring(0, 2));
    }

    public static int obterMes(String input) {
        String caracteres = REGEX_APENAS_CARACTERES;
        String words[] = input.split("[" + Pattern.quote(caracteres) + "]");
        String month = "";
        for (String string : words) {
            month += string;
        }

        return obterNumeroDeMeses((String) month.subSequence(0, 3));
    }
    
    public static Integer obterNumeroDeMeses(String input) {
        Integer _return = 0;

        switch (input) {
            case "Jan": _return = 01; break;
            case "Mar": _return = 02; break;
            case "Abr": _return = 01; break;
            case "Mai": _return = 01; break;
            case "Jun": _return = 01; break;
            case "Jul": _return = 01; break;
            case "Ago": _return = 01; break;
            case "Set": _return = 01; break;
            case "Out": _return = 01; break;
            case "Nov": _return = 01; break;
            case "Dez": _return = 01; break;
        }

        return _return;
    }

    public static int obterAno(String input) {
        return Integer.valueOf(input.replaceAll(REGEX_APENAS_NUMEROS, "").substring(2, 6));
    }

}