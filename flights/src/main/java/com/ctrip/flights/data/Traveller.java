package com.ctrip.flights.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by manjunath.pandava on 21/12/16.
 */
@Setter
@Getter
@NoArgsConstructor
public class Traveller {
    private ETravellerTitle travellerTitle;
    private String firstName;
    private String lastName;
    private int dobDay;
    private int dobMonth;
    private int dobYear;
    private String nationality;

}
