package com.ctrip.common.Utils;

import com.ctrip.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

/**
 * Created by manjunath.pandava on 19/12/16.
 */
@Slf4j
public class BrowserUtils {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions action;
    public static JavascriptExecutor javascriptExecutor;

    public BrowserUtils(WebDriver newDriver){
        try {
            this.driver = newDriver;
            action = new Actions(newDriver);
            wait = new WebDriverWait(driver, Constants.DEFAULT_TIMEOUT_SEC);
            javascriptExecutor = (JavascriptExecutor) driver;
        }catch (Exception e){
            log.error("Exception while Initialising browser : {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public static void setDriverImplicitWaitTo(int noOfSeconds){
        log.info("Set Driver implicit wait timeout to : {}", noOfSeconds);
        driver.manage().timeouts().implicitlyWait(noOfSeconds, TimeUnit.SECONDS);
    }
    public static void resetDriverImplicitWaitToDefault(){
        log.info("Reset Driver implicit wait timeout");
        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT_SEC, TimeUnit.SECONDS);
    }

    public static void waitForPageLoad() {
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver webDriver) {
                    return javascriptExecutor.executeScript("return document.readyState").equals("complete");
                }
            });
        }catch (Exception e){
            log.error("Exception : {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public static void waitForElement(WebElement element) {
        try {
            setDriverImplicitWaitTo(60);
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            log.error("Exception : {}", e.getMessage());
            e.printStackTrace();
        }finally {
            resetDriverImplicitWaitToDefault();
        }
    }

    public static boolean isElementDisplayed(By locator){
        try{
            setDriverImplicitWaitTo(2);
            WebElement element = driver.findElement(locator);
            if(element.isDisplayed()){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            log.info("No Element found with Locator : {}", locator);
            log.info("Exception : {}", e.getMessage());
            e.printStackTrace();
            return false;
        }finally {
            resetDriverImplicitWaitToDefault();
        }
    }

    public void sleepForTime(int seconds){
        try {
            log.info("Sleep for {} seconds", seconds);
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
