package com.reserva.hotel;

/**
 *
 * @author richard
 */
public class Main {

    public static void main(String[] args) {
        
        if (args.length > 0) {
            
            new UtilMainApi().readFileNew(args[0]);
        } else {
            new UtilMainApi().questions();
        }
    }
    
}
