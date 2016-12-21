package com.ctrip.flights.data;

/**
 * Created by manjunath.pandava on 21/12/16.
 */
public enum ETripType {
    ONE_WAY("OneWay"),
    ROUND_TRIP("RoundTrip"),
    MULTI_CITY("MultiCity"),
    FLIGHT_HOTEL("Packages");

    private String value;

    ETripType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
    public static ETripType fromValue(String value) {
        if (value != null) {
            for (ETripType tripType : ETripType.values()) {
                if (value.equalsIgnoreCase(tripType.value)) {
                    return tripType;
                }
            }
        }
        return null;
    }
}
