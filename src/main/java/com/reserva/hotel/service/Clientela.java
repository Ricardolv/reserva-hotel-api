package com.reserva.hotel.service;

/**
 *
 * @author richard
 */
public enum Clientela {
    
    REGULAR("Regular"),
    VIP("Vip");

    private String name;

    public String getName() {
        return name;
    }

    private Clientela(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
