package com.ctrip.flights.data;

/**
 * Created by manjunath.pandava on 20/12/16.
 */
public class FlightsEnums {
    public enum TripType {
        ONE_WAY("OneWay"),
        ROUND_TRIP("RoundTrip"),
        MULTI_CITY("MultiCity"),
        FLIGHT_HOTEL("Packages");

        private String value;

        TripType(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
        public static TripType fromValue(String value) {
            if (value != null) {
                for (TripType tripType : TripType.values()) {
                    if (value.equalsIgnoreCase(tripType.value)) {
                        return tripType;
                    }
                }
            }
            return null;
        }
    }

    public enum Airports {
        BLR("Bangalore, IN - Kempegowda International Airport (BLR)"),
        DEL("New Delhi, IN - Indira Gandhi Airport (DEL)"),
        CCU("Kolkata, IN - Netaji Subhas Chandra Bose Airport (CCU)"),
        BOM("Mumbai, IN - Chatrapati Shivaji Airport (BOM)");

        private String value;

        Airports(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
        public static TripType fromValue(String value) {
            if (value != null) {
                for (TripType tripType : TripType.values()) {
                    if (value.equalsIgnoreCase(tripType.value)) {
                        return tripType;
                    }
                }
            }
            return null;
        }
    }
}
