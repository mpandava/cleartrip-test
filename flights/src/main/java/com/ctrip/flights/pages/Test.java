package com.ctrip.flights.pages;

import com.ctrip.common.browser.BrowserFactory;
import com.ctrip.common.data.ELeftMenu;
import com.ctrip.common.pages.Home;
import com.ctrip.flights.data.*;
import com.ctrip.flights.data.models.FlightDetails;
import com.ctrip.flights.data.models.SearchFlightsInput;
import com.ctrip.flights.data.models.Traveller;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by manjunath.pandava on 19/12/16.
 */
@Slf4j
public class Test {
    public static void main(String[] args) {


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
        searchFlightsInput.setInfants(1);

        FlightsResults flightsResults = flightsHome.searchForFlights(searchFlightsInput);
        List<FlightDetails> selectedFlightDetails = flightsResults.getSelectedFlightDetails();

        FlightsItinerary flightsItinerary = flightsResults.bookFlight();
        flightsItinerary.acceptTermsAndConditions();
        flightsItinerary.clickContinueBooking();
        flightsItinerary.userLogIn("test@gmail.com", null);
        flightsItinerary.clickUserLoginContinue();

        Traveller traveller = new Traveller();
        traveller.setTravellerTitle(ETravellerTitle.MR);
        traveller.setFirstName("AAAA");
        traveller.setLastName("AAA1");
        traveller.setDobDay(6);
        traveller.setDobMonth(4);
        traveller.setDobYear(1984);
        traveller.setNationality("Indian");

        flightsItinerary.enterTravellerDetails(ETravellerType.ADULT, 1, traveller);
        traveller.setLastName("AAA2");
        traveller.setDobYear(1988);
        flightsItinerary.enterTravellerDetails(ETravellerType.ADULT, 2, traveller);

        traveller.setTravellerTitle(ETravellerTitle.MISS);
        traveller.setFirstName("CCCCC");
        traveller.setLastName("CCC1");
        traveller.setDobYear(2009);
        flightsItinerary.enterTravellerDetails(ETravellerType.CHILD, 1, traveller);
        traveller.setFirstName("IIIII");
        traveller.setLastName("III1");
        traveller.setDobYear(2015);
        flightsItinerary.enterTravellerDetails(ETravellerType.INFANT, 1, traveller);

        flightsItinerary.enterPhoneNumber("9876543210");
        flightsItinerary.clickTravellerContinueBtn();
    }
}
