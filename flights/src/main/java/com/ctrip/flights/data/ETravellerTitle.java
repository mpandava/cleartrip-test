package com.ctrip.flights.data;

/**
 * Created by manjunath.pandava on 21/12/16.
 */
public enum ETravellerTitle {
    MR("Mr"),
    MS("Ms"),
    MRS("Mrs"),
    MISS("Miss"),
    MSTR("Mstr");

    private String value;

    ETravellerTitle(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
