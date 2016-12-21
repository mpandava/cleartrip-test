package com.ctrip.flights.pages;

import com.ctrip.common.Utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by manjunath.pandava on 21/12/16.
 */
public class FlightsItinerary extends BrowserUtils{

    static By itineryBtnLocator = By.cssSelector("input[id='itineraryBtn']");
    By loginContinueBtnLocator = By.cssSelector("input[id='LoginContinueBtn_1']");
    By travellerContinueBtnLocator = By.cssSelector("input[id='travellerBtn']");

    @FindBy(how = How.CSS, using = "input[id='insurance_confirm']")
    private WebElement acceptTermsCBox;

    @FindBy(how = How.CSS, using = "input[id='itineraryBtn']")
    private WebElement itineryBtn;

    @FindBy(how = How.CSS, using = "input[id='username']")
    private WebElement userEmailTxt;

    @FindBy(how = How.CSS, using = "input[id='signinLabel']")
    private WebElement iHavePwdCBox;

    @FindBy(how = How.CSS, using = "input[id='password_1']")
    private WebElement userPwdTxt;

    @FindBy(how = How.CSS, using = "input[id='LoginContinueBtn_1']")
    private WebElement loginContinueBtn;


    public FlightsItinerary(WebDriver newDriver) {
        super(newDriver);
    }


    public void acceptTermsAndConditions(){
        action.moveToElement(acceptTermsCBox).perform();
        acceptTermsCBox.click();
        waitForPageLoad();
    }

    public void clickContinueBooking(){
        action.moveToElement(itineryBtn).perform();
        itineryBtn.click();
    }

    public void userLogIn(String userEmail, String userPwd){
        userEmailTxt.clear();
        userEmailTxt.sendKeys(userEmail);
        if (userPwd != null){
            iHavePwdCBox.click();
            userPwdTxt.clear();
            userPwdTxt.sendKeys(userPwd);
        }
    }

    public void clickUserLoginContinue(){
        action.moveToElement(loginContinueBtn).perform();
        loginContinueBtn.click();
        waitForPage3rdStep();
    }

    public static void waitForPage1stStep(){
        WebElement element = driver.findElement(itineryBtnLocator);
        waitForElement(element);
    }

    private void waitForPage2ndStep(){
        WebElement element = driver.findElement(loginContinueBtnLocator);
        waitForElement(element);
    }

    private void waitForPage3rdStep(){
        WebElement element = driver.findElement(travellerContinueBtnLocator);
        waitForElement(element);
    }
}
