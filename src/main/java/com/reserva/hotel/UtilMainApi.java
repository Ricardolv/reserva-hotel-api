package com.reserva.hotel;

import com.reserva.hotel.service.Clientela;
import static com.reserva.hotel.service.UtilApi.convertStringToLocalDate;
import static com.reserva.hotel.service.UtilApi.obterAno;
import static com.reserva.hotel.service.UtilApi.obterDataFim;
import static com.reserva.hotel.service.UtilApi.obterDataInico;
import static com.reserva.hotel.service.UtilApi.obterDia;
import static com.reserva.hotel.service.UtilApi.obterMelhorTarifa;
import static com.reserva.hotel.service.UtilApi.obterMes;
import com.reserva.hotel.service.Tarifa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author richard
 */
public class UtilMainApi {
    
    public void readFileNew(String path) {
        
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.ISO_8859_1)) {
            
            list = stream.collect(Collectors.toList());
            list.forEach((String line) -> {

                String[] optionClientele = line.split(":");
                String[] dates = optionClientele[1].split(",");
                Clientela clientela = null;
                
                for (Clientela c : Clientela.values()) {
                    if (c.getName().equals(optionClientele[0])) {
                        clientela = c;
                    }
                }
                
                List<LocalDate> listLocalDates = Arrays.asList(formatLocalDate(dates[0]), formatLocalDate(dates[1]), formatLocalDate(dates[2]));
                
                Tarifa result = obterMelhorTarifa(clientela, obterDataInico(listLocalDates), obterDataFim(listLocalDates));
                
                System.out.println("==============================================================");
                System.out.println("Melhor Hotel para se hospedar " + result.getHoteleiro().getNome());
                System.out.println("Valor total das diárias: R$" + result.getPreco());
                System.out.println("==============================================================");
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public LocalDate formatLocalDate(String input) {

        int dia = obterDia(input);
        int mes = obterMes(input);
        int ano = obterAno(input);
        LocalDate data = LocalDate.of(ano, mes, dia);
        
        return data;
    }

    public void questions() {
        
        int optionClientele = Integer.valueOf(entrada("Qual é o tipo de cliente (1) Regular, (2) Vip)"));
        Clientela clientela = Clientela.values()[optionClientele - 1];

        String inputDataInicio = entrada("Quando você iniciará a estadia? (DD/MM/YYYY)");
        LocalDate dataInicio = convertStringToLocalDate(inputDataInicio);

        String inputDataFim = entrada("Até quando pretende ficar? (DD/MM/YYYY)");
        LocalDate dataFim = convertStringToLocalDate(inputDataFim);

        Tarifa result = obterMelhorTarifa(clientela, dataInicio, dataFim);

        System.out.println("");
        System.out.println("Melhor Hotel para se hospedar " + result.getHoteleiro().getNome());
        System.out.println("Valor total das diárias: R$" + result.getPreco());
    }
    
    private static String entrada(String info) {
        System.out.print(info + " ");
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferRead.readLine();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
