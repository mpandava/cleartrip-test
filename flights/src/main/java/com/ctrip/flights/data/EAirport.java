package com.ctrip.flights.data;

/**
 * Created by manjunath.pandava on 20/12/16.
 */
public enum EAirport {

    BLR("Bangalore, IN - Kempegowda International Airport (BLR)"),
    DEL("New Delhi, IN - Indira Gandhi Airport (DEL)"),
    CCU("Kolkata, IN - Netaji Subhas Chandra Bose Airport (CCU)"),
    BOM("Mumbai, IN - Chatrapati Shivaji Airport (BOM)");

    private String value;

    EAirport(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static EAirport fromValue(String value) {
        if (value != null) {
            for (EAirport airport : EAirport.values()) {
                if (value.equalsIgnoreCase(airport.value)) {
                    return airport;
                }
            }
        }
        return null;
    }
}
