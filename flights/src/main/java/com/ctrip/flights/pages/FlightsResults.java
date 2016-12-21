package com.ctrip.flights.pages;

import com.ctrip.common.Utils.BrowserUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by manjunath.pandava on 21/12/16.
 */
@Slf4j
public class FlightsResults extends BrowserUtils{
    static By bookBtnLocator = By.xpath("//div[@id='ResultContainer_1_1']//button[@type='submit']");

    @FindBy(how = How.CSS, using = "div[id='ResultContainer_1_1']")
    WebElement resultContainerDiv;

    @FindBy(how = How.XPATH, using = "//div[@id='ResultContainer_1_1']//button[@type='submit']")
    WebElement bookBtn;


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
}
