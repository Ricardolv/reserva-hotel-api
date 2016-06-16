package com.reserva.hotel.service;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author richard
 */
public class Tarifa {
    
    private Hoteleiro hoteleiro;
    private BigDecimal preco;

    public Tarifa(Hoteleiro hoteleiro, BigDecimal preco) {
        this.hoteleiro = hoteleiro;
        this.preco = preco;
    }

    public Hoteleiro getHoteleiro() {
        return hoteleiro;
    }

    public void setHoteleiro(Hoteleiro hoteleiro) {
        this.hoteleiro = hoteleiro;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.hoteleiro);
        hash = 23 * hash + Objects.hashCode(this.preco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarifa other = (Tarifa) obj;
        if (this.hoteleiro != other.hoteleiro) {
            return false;
        }
        if (!Objects.equals(this.preco, other.preco)) {
            return false;
        }
        return true;
    }
}
