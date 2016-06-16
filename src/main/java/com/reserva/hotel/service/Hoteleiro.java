package com.reserva.hotel.service;

import static com.reserva.hotel.service.ConstanteApp.ESTRELA_3;
import static com.reserva.hotel.service.ConstanteApp.ESTRELA_4;
import static com.reserva.hotel.service.ConstanteApp.ESTRELA_5;
import static com.reserva.hotel.service.ConstanteApp.NOME_RHOTEL;
import static com.reserva.hotel.service.ConstanteApp.NOME_TCARLYLE;
import static com.reserva.hotel.service.ConstanteApp.NOME_TPLAZA;
import static com.reserva.hotel.service.ConstanteApp.REAIS_100;
import static com.reserva.hotel.service.ConstanteApp.REAIS_110;
import static com.reserva.hotel.service.ConstanteApp.REAIS_150;
import static com.reserva.hotel.service.ConstanteApp.REAIS_160;
import static com.reserva.hotel.service.ConstanteApp.REAIS_220;
import static com.reserva.hotel.service.ConstanteApp.REAIS_40;
import static com.reserva.hotel.service.ConstanteApp.REAIS_50;
import static com.reserva.hotel.service.ConstanteApp.REAIS_60;
import static com.reserva.hotel.service.ConstanteApp.REAIS_80;
import static com.reserva.hotel.service.ConstanteApp.REAIS_90;
import com.reserva.hotel.service.hotel.RoyalHotel;
import com.reserva.hotel.service.hotel.TheCarlyle;
import com.reserva.hotel.service.hotel.ThePlaza;
import java.math.BigDecimal;

/**
 *
 * @author richard
 */
public enum Hoteleiro {

    THE_CARLYLE(NOME_TCARLYLE, ESTRELA_3, REAIS_110, 
                REAIS_80, REAIS_90, REAIS_80
    ) {
        @Override
        public Hotel obterHotel() {
            return new TheCarlyle();
        }
    },
    THE_PLAZA(NOME_TPLAZA, ESTRELA_4, REAIS_160, 
              REAIS_110, REAIS_60, REAIS_50
    ) {
        @Override
        public Hotel obterHotel() {
            return new ThePlaza();
        }
    },
    ROYAL_HOTEL(NOME_RHOTEL, ESTRELA_5, REAIS_220, 
                REAIS_100, REAIS_150, REAIS_40
    ) {
        @Override
        public Hotel obterHotel() {
            return new RoyalHotel();
        }
    };

    private String nome;
    private Integer estrela;
    private BigDecimal diaUtilRegular;
    private BigDecimal diaUtilVip;
    private BigDecimal fimSemanaRegular;
    private BigDecimal fimSemanaVip;

    private Hoteleiro() {
    }

    private Hoteleiro(String nome, Integer estrela, BigDecimal diaUtilRegular,
            BigDecimal diaUtilVip, BigDecimal fimSemanaRegular, BigDecimal fimSemanaVip) {
        this.nome = nome;
        this.estrela = estrela;
        this.diaUtilRegular = diaUtilRegular;
        this.diaUtilVip = diaUtilVip;
        this.fimSemanaRegular = fimSemanaRegular;
        this.fimSemanaVip = fimSemanaVip;
    }

    public abstract Hotel obterHotel();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEstrela() {
        return estrela;
    }

    public void setEstrela(Integer estrela) {
        this.estrela = estrela;
    }

    public BigDecimal getDiaUtilVip() {
        return diaUtilVip;
    }

    public void setDiaUtilVip(BigDecimal diaUtilVip) {
        this.diaUtilVip = diaUtilVip;
    }

    public BigDecimal getDiaUtilRegular() {
        return diaUtilRegular;
    }

    public void setDiaUtilRegular(BigDecimal diaUtilRegular) {
        this.diaUtilRegular = diaUtilRegular;
    }

    public BigDecimal getFimSemanaVip() {
        return fimSemanaVip;
    }

    public void setFimSemanaVip(BigDecimal fimSemanaVip) {
        this.fimSemanaVip = fimSemanaVip;
    }

    public BigDecimal getFimSemanaRegular() {
        return fimSemanaRegular;
    }

    public void setFimSemanaRegular(BigDecimal fimSemanaRegular) {
        this.fimSemanaRegular = fimSemanaRegular;
    }

}
