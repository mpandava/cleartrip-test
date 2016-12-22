package com.ctrip.flights.data.models;

import com.ctrip.flights.data.EAirport;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

/**
 * Created by manjunath.pandava on 20/12/16.
 */

@Getter
@Setter
@NoArgsConstructor
public class SearchFlightsInput {
    private EAirport from;
    private EAirport to;
    private Date departOn;
    private Date returnOn;
    private int adults;
    private int children;
    private int infants;
}
