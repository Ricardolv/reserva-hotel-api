package com.reserva.hotel.test;

import com.reserva.hotel.service.Clientela;
import com.reserva.hotel.service.Hotel;
import com.reserva.hotel.service.Hoteleiro;
import com.reserva.hotel.service.Tarifa;
import com.reserva.hotel.service.UtilApi;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.*;

/**
 *
 * @author richard
 */
public class UtilTest {
    
    @Test
    public void fimSemanaTest() {
        LocalDate dataAtual = LocalDate.now().of(2016, 6, 18);
        Assert.assertEquals(UtilApi.isFimSemana(dataAtual), true);
    }
    
    @Test
    public void diaUtilTest() {
        LocalDate dataAtual = LocalDate.now().of(2016, 6, 14);
        Assert.assertEquals(UtilApi.isFimSemana(dataAtual), false);
    }
    
    @Test
    public void obterPeriodoDatas() {
        LocalDate dataInicio = LocalDate.now().of(2016, 6, 13);
        LocalDate dataFim = LocalDate.now().of(2016, 6, 15);
        List<LocalDate> list = UtilApi.obterPeriodo(dataInicio, dataFim);
        Assert.assertEquals(UtilApi.obterPeriodo(dataInicio, dataFim).size(), list.size());
    }
    
    @Test
    public void obterDataInicio() {
        LocalDate a = LocalDate.of(2016, 6, 15);
        LocalDate b = LocalDate.of(2016, 6, 16);
        LocalDate c = LocalDate.of(2016, 6, 18);

        List<LocalDate> datas = Arrays.asList(a, b, c);
        
        LocalDate retorno = UtilApi.obterDataInico(datas);
        
        Assert.assertEquals(retorno, a);
    }
    
    @Test
    public void obterDataFim() {
        LocalDate a = LocalDate.of(2016, 6, 15);
        LocalDate b = LocalDate.of(2016, 6, 16);
        LocalDate c = LocalDate.of(2016, 6, 18);

        List<LocalDate> datas = Arrays.asList(a, b, c);
        
        LocalDate retorno = UtilApi.obterDataFim(datas);
        
        Assert.assertEquals(retorno, c);
    }
    
    @Test
    public void obterMelhorTarifaCarlyleTest() {
        LocalDate dataInicio = LocalDate.now().of(2015, 3, 16);
        LocalDate dataFim = LocalDate.now().of(2015, 3, 18);
        Clientela clientela = Clientela.REGULAR;
        Hotel theCarlyle = Hoteleiro.THE_CARLYLE.obterHotel();
        Tarifa result = new Tarifa(Hoteleiro.THE_CARLYLE, theCarlyle.obterValorTotalDiaria(clientela, dataInicio, dataFim) );
        
        Tarifa tarifa = UtilApi.obterMelhorTarifa(clientela, dataInicio, dataFim);
    
        Assert.assertEquals(tarifa, result);
    }
    
    @Test
    public void obterMelhorTarifaPlazaTest() {
        LocalDate dataInicio = LocalDate.now().of(2015, 3, 20);
        LocalDate dataFim = LocalDate.now().of(2015, 3, 22);
        Clientela clientela = Clientela.REGULAR;
        
        Hotel thePlaza = Hoteleiro.THE_PLAZA.obterHotel();
        Tarifa result = new Tarifa(Hoteleiro.THE_PLAZA, thePlaza.obterValorTotalDiaria(clientela, dataInicio, dataFim) );
        
        Tarifa tarifa = UtilApi.obterMelhorTarifa(clientela, dataInicio, dataFim);
    
        Assert.assertEquals(tarifa, result);
    }
    
    @Test
    public void obterMelhorTarifaRoyalTest() {
        LocalDate dataInicio = LocalDate.now().of(2015, 3, 26);
        LocalDate dataFim = LocalDate.now().of(2015, 3, 28);
        Clientela clientela = Clientela.VIP;
        
        Hotel royal = Hoteleiro.ROYAL_HOTEL.obterHotel();
        Tarifa result = new Tarifa(Hoteleiro.ROYAL_HOTEL, royal.obterValorTotalDiaria(clientela, dataInicio, dataFim) );
        
        Tarifa tarifa = UtilApi.obterMelhorTarifa(clientela, dataInicio, dataFim);
    
        Assert.assertEquals(tarifa, result);
    }
    
    
    
    
}
