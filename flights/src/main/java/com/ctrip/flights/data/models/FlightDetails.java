package com.ctrip.flights.data.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by manjunath.pandava on 22/12/16.
 */
@Setter
@Getter
@NoArgsConstructor
public class FlightDetails {
    private String airlinesName;
    private String flightId;
    private String flightTimings;
    private String flightDuration;
    private String flightNoOfStops;
}
