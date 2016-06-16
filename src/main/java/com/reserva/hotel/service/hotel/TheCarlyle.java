package com.reserva.hotel.service.hotel;

import com.reserva.hotel.service.Clientela;
import com.reserva.hotel.service.Hotel;
import com.reserva.hotel.service.Hoteleiro;
import com.reserva.hotel.service.UtilApi;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author richard
 */
public class TheCarlyle implements Hotel {

    @Override
    public BigDecimal obterValorTotalDiaria(Clientela clientela, LocalDate dataInicial, LocalDate dataFinal) {

        BigDecimal retorno = BigDecimal.ZERO;
        BigDecimal fimSemanaRegular = Hoteleiro.THE_CARLYLE.getFimSemanaRegular();
        BigDecimal diaUtilRegular = Hoteleiro.THE_CARLYLE.getDiaUtilRegular();
        BigDecimal fimSemanaVip = Hoteleiro.THE_CARLYLE.getFimSemanaVip();
        BigDecimal diaUtilVip = Hoteleiro.THE_CARLYLE.getDiaUtilVip();

        List<LocalDate> list = UtilApi.obterPeriodo(dataInicial, dataFinal);

        for (LocalDate data : list) {

            if (Clientela.REGULAR.equals(clientela)) {

                if (UtilApi.isFimSemana(data)) {
                    retorno = retorno.add(fimSemanaRegular);
                } else {
                    retorno = retorno.add(diaUtilRegular);
                }

            } else if (Clientela.VIP.equals(clientela)) {

                if (UtilApi.isFimSemana(data)) {
                    retorno = retorno.add(fimSemanaVip);
                } else {
                    retorno = retorno.add(diaUtilVip);
                }
            }
        }

        return retorno;
    }

}
