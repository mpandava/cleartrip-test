package com.ctrip.flights.pages;

import com.ctrip.common.Utils.BrowserUtils;
import com.ctrip.common.data.DataUtils;
import com.ctrip.flights.data.ETripType;
import com.ctrip.flights.data.SearchFlightsInput;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by manjunath.pandava on 20/12/16.
 */
@Slf4j
public class FlightsHome extends BrowserUtils{

    String pageH1 = "Search flights";
    String aTripTypeCss = "input[name='trip_type'][id='%s']";
    String tripTypesCss = "input[name='trip_type']";

    @FindBy(how = How.CSS, using = "h1")
    WebElement headingH1;

    @FindBy(how = How.CSS, using = "input[id='FromTag']")
    WebElement fromTxt;
    @FindBy(how = How.CSS, using = "input[id='ToTag']")
    WebElement toTxt;

    @FindBy(how = How.CSS, using = "input[id='DepartDate']")
    WebElement departDateDt;
    @FindBy(how = How.CSS, using = "input[id='ReturnDate']")
    WebElement returnDateDt;

    @FindBy(how = How.CSS, using = "select[id='Adults']")
    WebElement adultsLst;

    @FindBy(how = How.CSS, using = "select[id='Childrens']")
    WebElement childrenLst;

    @FindBy(how = How.CSS, using = "select[id='Infants']")
    WebElement infantsLst;

    @FindBy(how = How.CSS, using = "input[id='SearchBtn']")
    WebElement searchFlightsBtn;




    public FlightsHome(WebDriver newDriver) {
        super(newDriver);
    }

    public void selectTripType(ETripType tripType){
        log.info("Select Trip Type : {}", tripType);
        By locator = By.cssSelector(String.format(aTripTypeCss,tripType.value()));
        WebElement element = driver.findElement(locator);
        if(!element.isSelected()){
            element.click();
        }
        waitForPageLoad();
    }

    public ETripType getSelectedTripType(){
        log.info("Get Selected Trip Type");
        String tripType = null;
        By locator = By.cssSelector(String.format(tripTypesCss));
        List<WebElement> tripTypes = driver.findElements(locator);
        for (WebElement type : tripTypes) {
            if (type.isSelected()){
                tripType = type.getAttribute("id");
            }
        }
        log.info("Selected Trip Type : {}", ETripType.fromValue(tripType));
        return ETripType.fromValue(tripType);
    }

    public FlightsResults searchForFlights(SearchFlightsInput input){
        log.info("Search for Flights");
        if (input.getFrom() != null){
            log.info("From : {}", input.getFrom());
            fromTxt.clear();
            fromTxt.sendKeys(input.getFrom().value());
            fromTxt.sendKeys(Keys.LEFT);
            waitForPageLoad();
        }
        if (input.getTo() != null){
            log.info("To : {}", input.getTo());
            toTxt.clear();
            toTxt.sendKeys(input.getTo().value());
            toTxt.sendKeys(Keys.LEFT);
            waitForPageLoad();
        }
        if (input.getDepartOn()!= null){
            String dt = DataUtils.getDateInSearchStringFormat(input.getDepartOn());
            log.info("Depart On : {}", dt);
            departDateDt.clear();
            departDateDt.sendKeys(dt);
            departDateDt.sendKeys(Keys.RETURN);
            waitForPageLoad();
        }
        if (input.getReturnOn()!= null){
            String dt = DataUtils.getDateInSearchStringFormat(input.getReturnOn());
            log.info("Return On : {}", dt);
            returnDateDt.clear();
            returnDateDt.sendKeys(dt);
            toTxt.click();
            waitForPageLoad();
        }
        if (input.getAdults() != 0){
            log.info("Adults : {}", input.getAdults());
            Select elm = new Select(adultsLst);
            elm.selectByValue(String.valueOf(input.getAdults()));
            waitForPageLoad();
        }
        if (input.getChildren() != 0){
            log.info("Children : {}", input.getChildren());
            Select elm = new Select(childrenLst);
            elm.selectByValue(String.valueOf(input.getChildren()));
            waitForPageLoad();
        }
        if (input.getInfants() != 0){
            log.info("Infants : {}", input.getInfants());
            Select elm = new Select(infantsLst);
            elm.selectByValue(String.valueOf(input.getInfants()));
            waitForPageLoad();
        }
        log.info("Click search");
        searchFlightsBtn.click();
        waitForPageLoad();
        FlightsResults.waitForPage();
        return PageFactory.initElements(driver, FlightsResults.class);
    }

}
