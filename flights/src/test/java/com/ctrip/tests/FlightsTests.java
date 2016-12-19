package com.ctrip.tests;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * Created by manjunath.pandava on 19/12/16.
 */
@Slf4j
public class FlightsTests {

    @Test(description = "Test roundtrip flight booking", groups={"P0", "Regression"}, enabled = true)
    public void roundTripTest(){
        log.info("Start Test");

    }
}
