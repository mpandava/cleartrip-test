package com.ctrip.flights.pages;

import com.ctrip.common.Utils.BrowserUtils;
import com.ctrip.flights.data.models.FlightDetails;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manjunath.pandava on 21/12/16.
 */
@Slf4j
public class FlightsResults extends BrowserUtils{
    static By bookBtnLocator = By.xpath("//div[@id='ResultContainer_1_1']//button[@type='submit']");

    By selectedFlightContainerLocator = By.cssSelector("div[class*='legInfo']");
    By selectedFlightAirlinesNameLocator = By.cssSelector("strong");
    By selectedFlightIdLocator = By.xpath("//small[1]");
    By selectedFlightTimeLocator = By.cssSelector("span");
    By selectedFlightDurationLocator = By.xpath("//small[3]");

    @FindBy(how = How.CSS, using = "div[id='ResultContainer_1_1']")
    WebElement resultContainerDiv;

    @FindBy(how = How.XPATH, using = "//div[@id='ResultContainer_1_1']//button[@type='submit']")
    WebElement bookBtn;

    @FindBy(how = How.CSS, using = "div[class='legInfo']")
    WebElement toFlightDetailsDiv;

    @FindBy(how = How.CSS, using = "div[class='legInfo ']")
    WebElement returnFlightDetailsDiv;


    public FlightsResults(WebDriver newDriver) {
        super(newDriver);
    }

    public static void waitForPage(){
        WebElement bookBtn = driver.findElement(bookBtnLocator);
        waitForElement(bookBtn);
    }

    public FlightsItinerary bookFlight(){
        bookBtn.click();
        waitForPageLoad();
        FlightsItinerary.waitForPage1stStep();
        return PageFactory.initElements(driver, FlightsItinerary.class);
    }

    public List<FlightDetails> getSelectedFlightDetails(){
        List<FlightDetails> flightDetailsList = new ArrayList<>();

        List<WebElement> flightDetailsContainers = driver.findElements(selectedFlightContainerLocator);
        for (WebElement flightDetailsContainer : flightDetailsContainers) {
            FlightDetails flightDetails = new FlightDetails();
            WebElement name = flightDetailsContainer.findElement(selectedFlightAirlinesNameLocator);
            log.info("Airlines Name : {}", name.getText());
            flightDetails.setAirlinesName(name.getText());
            WebElement id = flightDetailsContainer.findElement(selectedFlightIdLocator);
            log.info("Flight ID : {}", id.getText());
            flightDetails.setFlightId(id.getText());
            WebElement time = flightDetailsContainer.findElement(selectedFlightTimeLocator);
            log.info("Flight Time : {}", time.getText());
            flightDetails.setFlightTimings(time.getText());
            WebElement duration = flightDetailsContainer.findElement(selectedFlightDurationLocator);
            String[] vals = duration.getText().split(" | ");
            log.info("Flight duration : {}", vals[0]);
            log.info("Flight Stops : {}", vals[1]);
            flightDetails.setFlightDuration(vals[0]);
            flightDetails.setFlightNoOfStops(vals[1]);
        }

        return flightDetailsList;
    }
}
