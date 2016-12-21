package com.ctrip.flights.pages;

import com.ctrip.common.browser.BrowserFactory;
import com.ctrip.common.data.ELeftMenu;
import com.ctrip.common.pages.Home;
import com.ctrip.flights.data.EAirport;
import com.ctrip.flights.data.ETripType;
import com.ctrip.flights.data.SearchFlightsInput;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by manjunath.pandava on 19/12/16.
 */
@Slf4j
public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        log.info("test");

        Calendar dd = Calendar.getInstance();
        dd.setTime(new Date());
        dd.add(Calendar.DATE, 15);

        System.out.println(new SimpleDateFormat("EEE, dd MMM, YYYY").format(dd.getTime()));

        WebDriver driver = BrowserFactory.launchApplication("firefox", "https://www.cleartrip.com/");
        Home home = PageFactory.initElements(driver, Home.class);
        home.gotoLeftMenuItem(ELeftMenu.FLIGHTS);
        FlightsHome flightsHome = PageFactory.initElements(driver, FlightsHome.class);
        System.out.println(flightsHome.getSelectedTripType());
        flightsHome.selectTripType(ETripType.ROUND_TRIP);

        SearchFlightsInput searchFlightsInput = new SearchFlightsInput();
        searchFlightsInput.setFrom(EAirport.BLR);
        searchFlightsInput.setTo(EAirport.CCU);
        Calendar depDate = Calendar.getInstance();
        depDate.setTime(new Date());
        depDate.add(Calendar.DATE, 10);
        searchFlightsInput.setDepartOn(depDate.getTime());
        Calendar retDate = Calendar.getInstance();
        retDate.setTime(new Date());
        retDate.add(Calendar.DATE, 15);
        searchFlightsInput.setReturnOn(retDate.getTime());

        searchFlightsInput.setAdults(2);
        searchFlightsInput.setChildren(1);
        searchFlightsInput.setInfants(0);

        flightsHome.searchForFlights(searchFlightsInput);

    }
}
