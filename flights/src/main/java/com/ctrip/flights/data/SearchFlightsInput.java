package com.ctrip.flights.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

/**
 * Created by manjunath.pandava on 20/12/16.
 */

public @NoArgsConstructor class SearchFlightsInput {
    private @Getter @Setter FlightsEnums.Airports from;
    private @Getter @Setter FlightsEnums.Airports to;
    private @Getter @Setter Date departOn;
    private @Getter @Setter Date returnOn;
    private @Getter @Setter int adults;
    private @Getter @Setter int children;
    private @Getter @Setter int infants;
}
