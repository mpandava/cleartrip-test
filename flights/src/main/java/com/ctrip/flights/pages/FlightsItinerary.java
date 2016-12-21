package com.ctrip.flights.pages;

import com.ctrip.common.Utils.BrowserUtils;
import com.ctrip.flights.data.ETravellerType;
import com.ctrip.flights.data.Traveller;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by manjunath.pandava on 21/12/16.
 */
@Slf4j
public class FlightsItinerary extends BrowserUtils{

    static By itineryBtnLocator = By.cssSelector("input[id='itineraryBtn']");
    By loginContinueBtnLocator = By.cssSelector("input[id='LoginContinueBtn_1']");
    By travellerContinueBtnLocator = By.cssSelector("input[id='travellerBtn']");
    By paymentSubmitBtnLocator = By.cssSelector("input[id='paymentSubmit']");

    String titleCss = "select[id='%sTitle%d']";
    String firstNameCss = "input[id='%sFname%d']";
    String lastNameCss = "input[id='%sLname%d']";
    String dobDayCss = "select[id='%sDobDay%d']";
    String dobMonthCss = "select[id='%sDobMonth%d']";
    String dobYearCss = "select[id='%sDobYear%d']";
    String nationalityCss = "input[id='%sNationality%d']";

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

    @FindBy(how = How.CSS, using = "input[id='mobileNumber']")
    private WebElement mobileNumberTxt;

    @FindBy(how = How.CSS, using = "input[id='travellerBtn']")
    private WebElement travellerContinueBtn;


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
        waitForPage2ndStep();
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

    public void enterTravellerDetails(ETravellerType travellerType, int typeNumber, Traveller traveller){
        log.info("Filling Traveller Details of {} : {}", travellerType.value(), typeNumber);

        Select titleLst = new Select(driver.findElement(By.cssSelector(String.format(titleCss, travellerType.value(), typeNumber))));
        titleLst.selectByValue(traveller.getTravellerTitle().value());

        WebElement firstNameTxt = driver.findElement(By.cssSelector(String.format(firstNameCss, travellerType.value(), typeNumber)));
        firstNameTxt.sendKeys(traveller.getFirstName());

        WebElement lastNameTxt = driver.findElement(By.cssSelector(String.format(lastNameCss, travellerType.value(), typeNumber)));
        lastNameTxt.sendKeys(traveller.getLastName());

        By dobDayLstLoc = By.cssSelector(String.format(dobDayCss, travellerType.value(), typeNumber));
        if (isElementDisplayed(dobDayLstLoc)){
            Select dobDayLst = new Select(driver.findElement(dobDayLstLoc));
            dobDayLst.selectByValue(String.valueOf(traveller.getDobDay()));
        }

        By dobMonthLstLoc = By.cssSelector(String.format(dobMonthCss, travellerType.value(), typeNumber));
        if (isElementDisplayed(dobMonthLstLoc)){
            Select dobMonthLst = new Select(driver.findElement(dobMonthLstLoc));
            System.out.println("DOB Month : " + traveller.getDobMonth());
            dobMonthLst.selectByValue(String.valueOf(traveller.getDobMonth()));
        }

        By dobYearLstLoc = By.cssSelector(String.format(dobYearCss, travellerType.value(), typeNumber));
        if (isElementDisplayed(dobYearLstLoc)) {
            Select dobYearLst = new Select(driver.findElement(dobYearLstLoc));
            dobYearLst.selectByValue(String.valueOf(traveller.getDobYear()));
        }

        By nationalityTxtLoc = By.cssSelector(String.format(nationalityCss, travellerType.value().toLowerCase(), typeNumber));
        if (isElementDisplayed(nationalityTxtLoc)) {
            WebElement nationalityTxt = driver.findElement(nationalityTxtLoc);
            nationalityTxt.sendKeys(traveller.getNationality());
        }
    }

    public void enterPhoneNumber(String phoneNumber){
        mobileNumberTxt.clear();
        mobileNumberTxt.sendKeys(phoneNumber);
    }

    public void clickTravellerContinueBtn(){
        action.moveToElement(travellerContinueBtn).perform();
        travellerContinueBtn.click();
        waitForPage4thStep();
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
    private void waitForPage4thStep(){
        WebElement element = driver.findElement(paymentSubmitBtnLocator);
        waitForElement(element);
    }
}
