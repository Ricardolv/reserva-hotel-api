package com.reserva.hotel.service;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Richard
 */
public interface Hotel {
    
    public BigDecimal obterValorTotalDiaria(Clientela clientela, LocalDate dataInicial, LocalDate dataFinal);
}   
