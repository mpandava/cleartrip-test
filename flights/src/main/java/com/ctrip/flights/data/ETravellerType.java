package com.ctrip.flights.data;

/**
 * Created by manjunath.pandava on 21/12/16.
 */
public enum ETravellerType {
    ADULT("Adult"),
    CHILD("Child"),
    INFANT("Infant");

    private String value;

    ETravellerType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
